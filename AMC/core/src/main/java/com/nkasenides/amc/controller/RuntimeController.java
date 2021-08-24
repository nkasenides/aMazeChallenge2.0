package com.nkasenides.amc.controller;

import com.nkasenides.amc.algorithms.MazeSolver;
import com.nkasenides.amc.algorithms.PlayerMove;
import com.nkasenides.amc.model.*;
import com.nkasenides.amc.proto.Bias;
import com.nkasenides.amc.proto.Direction4;
import com.nkasenides.amc.proto.PickableType;
import com.nkasenides.amc.proto.Rotation;

import java.util.*;

import static com.nkasenides.amc.generation.AMCTerrainGenerator.*;

/**
 * @author Nearchos
 *         Created: 11-Dec-17
 */

public class RuntimeController {

    private static HashMap<String, Integer> doubleTurnsMap = new HashMap<>();
    private static HashMap<String, Integer> lostTurnsMap = new HashMap<>();

    public static void makeMove(final Challenge challenge, final Game game, final Map<String, MazeSolver> playerIdsToMazeSolvers) {
        final Grid grid = challenge.getGrid();

        // apply next move to active players
        final List<String> playerToMoveIDs = new ArrayList<>(game.getAllPlayers().keySet());

        // the adjusted list will contain the player IDs, possibly two or zero times according to the num of turns they get/lose from pickables
        final List<String> adjustedPlayerToMoveIDs = new Vector<>(playerToMoveIDs);

        for (final String playerToMoveId : playerToMoveIDs) {

            // check if player lost a move
            if (playerHasLostTurnsById(playerToMoveId)) {
                decreasePlayerLostTurnsRemainingById(playerToMoveId);
                adjustedPlayerToMoveIDs.remove(playerToMoveId); // remove first entry it finds
            }

            // check if a second move is needed
            if (playerHasDoubleTurnsById(playerToMoveId)) {
                decreasePlayerDoubleTurnsRemainingById(playerToMoveId);
                adjustedPlayerToMoveIDs.add(playerToMoveId); // add another entry at the end
            }
        }

        for (final String playerToMoveId : adjustedPlayerToMoveIDs) {
            final AMCPlayer player = game.getPlayerByID(playerToMoveId);
            final MazeSolver mazeSolver = playerIdsToMazeSolvers.get(playerToMoveId);
            final AMCWorldSession worldSession = game.getPlayerWorldSessions().get(playerToMoveId);
            final PlayerEntity playerEntity = game.getPlayerEntities().get(playerToMoveId);

            // the player might have been deactivated (for instance if he had 2 moves and this one is the second)
            if(game.getActivePlayers().contains(playerToMoveId)) {
                final PlayerMove nextPlayerMove = mazeSolver == null ? PlayerMove.NO_MOVE : mazeSolver.getNextMove(game);
                applyPlayerMove(grid, game, playerToMoveId, worldSession, playerEntity, nextPlayerMove);

                // check the player's health and finalize if needed
                if (worldSession.getHealth().getHealth() <= 0) {
                    playerEntity.setDirection(Direction4.NORTH);
                    playerEntity.setPosition(grid.getStartingPosition());
                    game.resetPlayerById(playerToMoveId);
                    resetTurnEffects();
                    final AudioEventListener audioEventListener = game.getAudioEventListener();
                    if(audioEventListener != null) {
                        audioEventListener.onGameEndAudioEvent(false);
                    }
                }
            }

            generateItems(game, challenge, grid); // generate pickables etc.
            handlePickableState(game); // handle stateful pickables
        }
    }

    private static void applyPlayerMove(final Grid grid, final Game game, final String playerId, final AMCWorldSession worldSession, final PlayerEntity playerEntity, final PlayerMove playerMove) {
        Direction4 direction = playerEntity.getDirection();
        MatrixPosition position = playerEntity.getPosition();
        AudioEventListener audioEventListener = game.getAudioEventListener();

        switch (playerMove) {
            case TURN_CLOCKWISE:
                direction = playerEntity.getDirection().shift(Rotation.CLOCKWISE);
                break;
            case TURN_COUNTERCLOCKWISE:
                direction = direction.shift(Rotation.COUNTER_CLOCKWISE);
                break;
            case MOVE_FORWARD:
                if (canMoveForward(grid, playerEntity.getPosition(), playerEntity.getDirection())) {
                    position = movePlayerForward(playerEntity);
                    // handle pickables and rewards (i.e. add/substract health etc.)
                    for(int i = 0; i < game.getPickables().size(); i++) {
                        PickableEntity pickable = game.getPickables().get(i);

                        if(pickable.getPosition().equals(position)) {

                            //Health-related pickables:
                            if (pickable.getPickableType() == PickableType.BOMB_PickableType) {
                                if (pickable.getState() == 1 || pickable.getState() == 2) {
                                    worldSession.getHealth().changeBy(pickable.getPickableType().getHealthChange());
                                }
                            }
                            else worldSession.getHealth().changeBy(pickable.getPickableType().getHealthChange());

                            //Apply effects of point-related pickables:
                            worldSession.changePointsBy(pickable.getPickableType().getPointsChange());

                            //Apply effects of speed-related pickables:
                            if (pickable.getPickableType() == PickableType.SPEEDHACK_PickableType) {
                                addPlayerDoubleTurnsById(playerId, PickableType.SPEEDHACK_TURNS_AMOUNT);
                            } else if (pickable.getPickableType() == PickableType.TRAP_PickableType) {
                                addPlayerLostTurnsById(playerId, PickableType.TRAP_TURNS_AMOUNT);
                            }

                            // if audio event listener set, notify with event
                            if(audioEventListener != null && pickable.getPickableType() != PickableType.BOMB_PickableType) audioEventListener.onAudioEvent(pickable);
                            if (pickable.getPickableType() != PickableType.BOMB_PickableType) game.removePickupItem(i);
                        }

                    }
                }
                break;
            case NO_MOVE:
                // Log.d("grid-challenge", "move: " + playerMove);
                break;
            default:
                throw new RuntimeException("Invalid PlayerMove: " + playerMove);
        }
        playerEntity.setDirection(direction);
        playerEntity.setPosition(position);
        game.getPlayerEntities().put(playerId, playerEntity); //TODO - Perhaps not necessary to update this as it is a reference.
    }

    public static boolean hasSomeoneReachedTheTargetPosition(final Game game, final Grid grid) {
        final MatrixPosition targetPosition = grid.getTargetPosition();
        boolean someoneHasReachedTheTargetPosition = false;
        for (final String playerId : game.getActivePlayers()) {
            final PlayerEntity playerEntity = game.getPlayerEntities().get(playerId);
            if (targetPosition.equals(playerEntity.getPosition())) {
                if (grid.getTargetPosition().equals(playerEntity.getPosition())) {
//                    game.getAudioEventListener().onGameEndAudioEvent(true); //TODO Remove, make for each player individually.
                    game.getGameEndListener().onPlayerHasWon(playerId);
                }
                someoneHasReachedTheTargetPosition = true;
                resetTurnEffects();
            }
        }
        return someoneHasReachedTheTargetPosition;
    }

    public static boolean canMoveForward(final Grid grid, final MatrixPosition position, final Direction4 direction) {
        return !RuntimeController.hasWall(grid, position, direction);
    }

    public static boolean canMoveBackward(final Grid grid, final MatrixPosition position, final Direction4 direction) {
        final Direction4 oppositeDirection = direction.opposite();
        if (oppositeDirection == null) return false;
        return !hasWall(grid, position, oppositeDirection);
    }

    public static boolean canMoveLeft(final Grid grid, final MatrixPosition position, final Direction4 direction) {
        final Direction4 leftDirection = direction.shift(Rotation.COUNTER_CLOCKWISE);
        if (leftDirection == null) return false;
        return !hasWall(grid, position, leftDirection);
    }

    public static boolean canMoveRight(final Grid grid, final MatrixPosition position, final Direction4 direction) {
        final Direction4 rightDirection = direction.shift(Rotation.CLOCKWISE);
        if (rightDirection == null) return false;
        return !hasWall(grid, position, rightDirection);
    }

    public static Bias look(final Game game, final Grid grid, final MatrixPosition position, final Direction4 direction) {

        switch (direction) {
            case NORTH:
                if (position.getRow() - 1 > 0) {
                    for (PickableEntity i : game.getPickables()) {
                        if (i.getPosition().getRow() == position.getRow()-1 && i.getPosition().getCol() == position.getCol())
                            return i.getPickableType().getBias();
                    }
                }
                break;
            case SOUTH:
                if (position.getRow() + 1 < grid.getHeight()) {
                    for (PickableEntity i : game.getPickables()) {
                        if (i.getPosition().getRow() == position.getRow()+1 && i.getPosition().getCol() == position.getCol())
                            return i.getPickableType().getBias();
                    }
                }
                break;
            case EAST:
                if (position.getCol() + 1 < grid.getWidth()) {
                    for (PickableEntity i : game.getPickables()) {
                        if (i.getPosition().getCol() == position.getCol()+1 && i.getPosition().getRow() == position.getRow())
                            return i.getPickableType().getBias();
                    }
                }
                break;
            case WEST:
                if (position.getCol() - 1 > 0) {
                    for (PickableEntity i : game.getPickables()) {
                        if (i.getPosition().getCol() == position.getCol()-1 && i.getPosition().getRow() == position.getRow())
                            return i.getPickableType().getBias();
                    }
                }
                break;
        }
        return Bias.NONE_Bias;
    }

    public static Direction4 compass(final MatrixPosition targetPosition, final MatrixPosition playerPosition) {
        int rowDifference = playerPosition.getRow() - targetPosition.getRow();
        int colDifference = playerPosition.getCol() - targetPosition.getCol();

        /*
            NOTE:

                Positive rowDifference => Exit is toward NORTH.
                Negative rowDifference => Exit is toward SOUTH.

                Positive colDifference => Exit is toward WEST.
                Negative rowDifference => Exit is toward EAST.
         */

        Direction4 predominantEastWestDirection;
        Direction4 predominantNorthSouthDirection;

        if (rowDifference >= 0) predominantNorthSouthDirection = Direction4.NORTH;
        else predominantNorthSouthDirection = Direction4.SOUTH;

        if (colDifference >= 0) predominantEastWestDirection = Direction4.WEST;
        else predominantEastWestDirection = Direction4.EAST;

        if (Math.max(Math.abs(rowDifference), Math.abs(colDifference)) == Math.abs(rowDifference)) {
            return predominantNorthSouthDirection;
        } else {
            return predominantEastWestDirection;
        }
    }

    public static int getGridCell(final Grid grid, final int row, final int col) throws IndexOutOfBoundsException {
        if(col < 0 || col > grid.getWidth()) throw new IndexOutOfBoundsException("col not in bounds [0, " + grid.getWidth() + ")");
        if(row < 0 || row > grid.getHeight()) throw new IndexOutOfBoundsException("row not in bounds [0, " + grid.getHeight() + ")");
        final char c = grid.getData().charAt(row * grid.getWidth() + col);
        return Integer.parseInt(Character.toString(c), 16);
    }

    private static boolean hasWall(final Grid grid, final MatrixPosition position, final Direction4 direction) {
        final int shape = getGridCell(grid, position.getRow(), position.getCol());
        switch (direction) {
            case NORTH:
                return (shape & SHAPE_ONLY_UPPER_SIDE) != 0;
            case SOUTH:
                return (shape & SHAPE_ONLY_LOWER_SIDE) != 0;
            case WEST:
                return (shape & SHAPE_ONLY_LEFT_SIDE) != 0;
            case EAST:
                return (shape & SHAPE_ONLY_RIGHT_SIDE) != 0;
            default:
                throw new RuntimeException("Invalid direction: " + direction);
        }
    }

    private static MatrixPosition movePlayerForward(final PlayerEntity playerEntity) {
        switch (playerEntity.getDirection()) {
            case NORTH:
                return playerEntity.getPosition().moveNorth();
            case SOUTH:
                return playerEntity.getPosition().moveSouth();
            case WEST:
                return playerEntity.getPosition().moveWest();
            case EAST:
                return playerEntity.getPosition().moveEast();
            default: throw new RuntimeException("Invalid direction: " + playerEntity.getDirection());
        }
    }

    public static boolean allPlayersHaveLost(final Game game) {
        return game.getActivePlayers().isEmpty();
    }

    private static void generateItems(Game game, Challenge challenge, Grid grid) {

        final Random random = new Random();

        //Generate rewards:
        if (game.getNumOfBiasType(Bias.REWARD_Bias) < challenge.getRewards().getNumber()) {
            int row = random.nextInt(grid.getHeight());
            int col = random.nextInt(grid.getWidth());
            final MatrixPosition position = new MatrixPosition(row, col);

            final PickableType type = PickableType.getRandomReward();

            boolean exists = false;
            for (PickableEntity pickable : game.getPickables()) {
                if (pickable.getPosition().equals(position)) {
                    exists = true;
                    break;
                }
            }

            if (!exists && !grid.getTargetPosition().equals(position) && !grid.getStartingPosition().equals(position)) {
                PickableEntity pickableEntity = new PickableEntity();
                pickableEntity.setPickableType(type);
                pickableEntity.setPosition(position);
                game.addPickableItem(pickableEntity);
            }
        }

        //Generate penalties:
        if (game.getNumOfBiasType(Bias.PENALTY_Bias) < challenge.getPenalties().getNumber()) {
            int row = random.nextInt(grid.getHeight());
            int col = random.nextInt(grid.getWidth());
            final MatrixPosition position = new MatrixPosition(row, col);

            final PickableType type = PickableType.getRandomPenalty();

            boolean exists = false;
            for (PickableEntity pickable : game.getPickables()) {
                if (pickable.getPosition().equals(position)) {
                    exists = true;
                    break;
                }
            }

            if (!exists && !grid.getTargetPosition().equals(position) && !grid.getStartingPosition().equals(position)) {
                PickableEntity pickableEntity = new PickableEntity();
                pickableEntity.setPickableType(type);
                pickableEntity.setPosition(position);
                game.addPickableItem(pickableEntity);
            }
        }
    }

    public static void handlePickableState(Game game) {
        for (int i = 0; i < game.getPickables().size(); i++) {
            game.getPickables().get(i).reduceState();
            if (game.getPickables().get(i).getState() <= 0) game.removePickupItem(i);
        }
    }

    public static int getPlayerDoubleTurnsRemainingById(String playerId) {
        if (!doubleTurnsMap.containsKey(playerId)) return 0;
        return doubleTurnsMap.get(playerId);
    }

    public static int getPlayerLostTurnsRemainingById(String playerId) {
        if (!lostTurnsMap.containsKey(playerId)) return 0;
        return lostTurnsMap.get(playerId);
    }

    public static boolean playerHasDoubleTurnsById(String playerId) {
        return doubleTurnsMap.containsKey(playerId);
    }

    public static boolean playerHasLostTurnsById(String playerId) {
        return lostTurnsMap.containsKey(playerId);
    }

    public static void decreasePlayerDoubleTurnsRemainingById(String playerId) {
        if (playerHasDoubleTurnsById(playerId)) {
            Integer turnsLeft = doubleTurnsMap.get(playerId);
            doubleTurnsMap.remove(playerId);
            turnsLeft--;
            if (turnsLeft > 0) doubleTurnsMap.put(playerId, turnsLeft);
        }
    }

    public static void decreasePlayerLostTurnsRemainingById(String playerId) {
        if (playerHasLostTurnsById(playerId)) {
            Integer turnsLeft = lostTurnsMap.get(playerId);
            lostTurnsMap.remove(playerId);
            turnsLeft--;
            if (turnsLeft > 0) lostTurnsMap.put(playerId, turnsLeft);
        }
    }

    public static void addPlayerDoubleTurnsById(String playerId, Integer doubleTurnsAmount) {
        doubleTurnsMap.put(playerId, doubleTurnsAmount);
    }

    public static void addPlayerLostTurnsById(String playerId, Integer lostTurnsAmount) {
        lostTurnsMap.put(playerId, lostTurnsAmount);
    }

    public static void resetTurnEffects() {
        lostTurnsMap = new HashMap<>();
        doubleTurnsMap = new HashMap<>();
    }

}