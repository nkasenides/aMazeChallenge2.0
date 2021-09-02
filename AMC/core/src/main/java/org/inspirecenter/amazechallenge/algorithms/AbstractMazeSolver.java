package org.inspirecenter.amazechallenge.algorithms;

import org.inspirecenter.amazechallenge.controller.RuntimeController;
import org.inspirecenter.amazechallenge.model.Challenge;
import org.inspirecenter.amazechallenge.model.Game;
import org.inspirecenter.amazechallenge.model.Grid;
import org.inspirecenter.amazechallenge.model.MatrixPosition;
import org.inspirecenter.amazechallenge.proto.Bias;
import org.inspirecenter.amazechallenge.proto.Direction4;

/**
 * @author Nearchos
 *         Created: 19-Aug-17
 */
public abstract class AbstractMazeSolver implements MazeSolver {

    protected transient Challenge challenge;
    protected transient Game game;
    final String playerID;

    AbstractMazeSolver(final Challenge challenge, final Game game, final String playerID) {
        super();
        init(challenge, game);
        this.playerID = playerID;
    }

    @Override
    public void init(Challenge challenge, Game game) {
        this.challenge = challenge;
        this.game = game;
    }

    abstract Grid getGrid();
    abstract Direction4 getDirection();
    abstract MatrixPosition getPosition();

    public final boolean canMoveForward() {
        return RuntimeController.canMoveForward(getGrid(), getPosition(), getDirection());
    }

    public final boolean canMoveBackward() {
        return RuntimeController.canMoveBackward(getGrid(), getPosition(), getDirection());
    }

    public final boolean canMoveLeft() {
        return RuntimeController.canMoveLeft(getGrid(), getPosition(), getDirection());
    }

    public final boolean canMoveRight() {
        return RuntimeController.canMoveRight(getGrid(), getPosition(), getDirection());
    }

    public final Bias look(Direction4 direction) {
        return RuntimeController.look(game, getGrid(), getPosition(), direction);
    }

    public final Direction4 compass() {
        return RuntimeController.compass(getGrid().getTargetPosition(), getPosition());
    }

    public final Direction4 onMove(PlayerMove playerMove) {
        switch (getDirection()) {
            case NORTH:
                switch (playerMove) {
                    case TURN_CLOCKWISE:
                        return Direction4.EAST;
                    case TURN_COUNTERCLOCKWISE:
                        return Direction4.WEST;
                    case MOVE_FORWARD:
                    case NO_MOVE:
                        return getDirection();
                }
                break;
            case SOUTH:
                switch (playerMove) {
                    case TURN_CLOCKWISE:
                        return Direction4.WEST;
                    case TURN_COUNTERCLOCKWISE:
                        return Direction4.EAST;
                    case MOVE_FORWARD:
                    case NO_MOVE:
                        return getDirection();
                }
                break;
            case WEST:
                switch (playerMove) {
                    case TURN_CLOCKWISE:
                        return Direction4.NORTH;
                    case TURN_COUNTERCLOCKWISE:
                        return Direction4.SOUTH;
                    case MOVE_FORWARD:
                    case NO_MOVE:
                        return getDirection();
                }
                break;
            case EAST:
                switch (playerMove) {
                    case TURN_CLOCKWISE:
                        return Direction4.SOUTH;
                    case TURN_COUNTERCLOCKWISE:
                        return Direction4.NORTH;
                    case MOVE_FORWARD:
                    case NO_MOVE:
                        return getDirection();
                }
                break;
        }
        return Direction4.NORTH;
    }

}