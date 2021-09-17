/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 31-08-2021 16:49:49
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.service;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.nkasenides.athlos.backend.AthlosService;
import org.inspirecenter.amazechallenge.algorithms.InterpretedMazeSolver;
import org.inspirecenter.amazechallenge.algorithms.MazeSolver;
import org.inspirecenter.amazechallenge.controller.RuntimeController;
import org.inspirecenter.amazechallenge.model.*;
import org.inspirecenter.amazechallenge.persistence.DBManager;
import org.inspirecenter.amazechallenge.persistence.KeyUtils;
import org.inspirecenter.amazechallenge.proto.RuntimeRequest;
import org.inspirecenter.amazechallenge.auth.*;
import org.inspirecenter.amazechallenge.proto.RuntimeResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Runtime implements AthlosService<RuntimeRequest, RuntimeResponse> {

    private static final long ONE_SECOND = 1000L;

    private final MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();

    @Override
    public RuntimeResponse serve(RuntimeRequest request, Object... additionalParams) {

        System.out.println("~~~~~ Runtime exec ~~~~~");

        final String adminKey = request.getAdminKey();
        final String challengeID = request.getChallengeID();
        final String gameID = request.getGameID();

        //Validate admin key:
        final AdminKey key = DBManager.adminKey.get();
        if (key == null) {
            System.err.println("INVALID_ADMIN_KEY");
            return RuntimeResponse.newBuilder()
                    .setStatus(RuntimeResponse.Status.INVALID_ADMIN_KEY)
                    .setMessage("INVALID_ADMIN_KEY")
                    .build();
        }

        if (!key.getId().equals(adminKey)) {
            System.err.println("INVALID_ADMIN_KEY");
            return RuntimeResponse.newBuilder()
                    .setStatus(RuntimeResponse.Status.INVALID_ADMIN_KEY)
                    .setMessage("INVALID_ADMIN_KEY")
                    .build();
        }

        final Challenge challenge = DBManager.challenge.get(challengeID);
        if (challenge == null) {
            System.err.println("INVALID_CHALLENGE");
            return RuntimeResponse.newBuilder()
                    .setStatus(RuntimeResponse.Status.INVALID_CHALLENGE)
                    .setMessage("INVALID_CHALLENGE")
                    .build();
        }

        final Object o = memcache.get(gameID);
        if (o == null) {
            System.err.println("INVALID_GAME");
            return RuntimeResponse.newBuilder()
                    .setStatus(RuntimeResponse.Status.INVALID_GAME)
                    .setMessage("INVALID_GAME")
                    .build();
        }

        Game game = (Game) o;

        //TODO - Ensure consistency with other servlets and across instances by locking on a memcache object?
        //Lock start?

        //Implement game logic:
        implementGameLogic(challenge, game);

        //Update the game state:
        memcache.put(gameID, game);

        //Lock end?

        //Schedule the next task for running, only if there are active players:
        if (game.getQueuedPlayers().size() != 0 || game.getWaitingPlayers().size() != 0 || game.getActivePlayers().size() != 0) {
            final Queue queue = QueueFactory.getDefaultQueue();
            RuntimeRequest runtimeRequest = RuntimeRequest.newBuilder()
                    .setChallengeID(challengeID)
                    .setGameID(game.getId())
                    .setAdminKey(DBManager.adminKey.get().getId())
                    .build();

            TaskOptions taskOptions = TaskOptions.Builder
                    .withUrl("/admin/runtime")
                    .payload(runtimeRequest.toByteArray())
                    .countdownMillis(ONE_SECOND)
                    .method(TaskOptions.Method.POST);
            queue.add(taskOptions);
        }


        System.out.println("OK");
        return RuntimeResponse.newBuilder()
                .setStatus(RuntimeResponse.Status.OK)
                .setMessage("OK")
                .build();
    }

    private void implementGameLogic(final Challenge challenge, final Game game) {
        final long startTime = System.currentTimeMillis();

//        System.out.println("game.getQueuedPlayers() = " + game.getQueuedPlayers());
//        System.out.println("game.getActivePlayers() = " + game.getActivePlayers());
//        System.out.println("game.getWaitingPlayers() = " + game.getWaitingPlayers());

        final Grid grid = challenge.getGrid();

        // check if we can upgrade any players from 'waiting' to 'queued'
        final Vector<String> waitingPlayerIDs = new Vector<>(game.getWaitingPlayers());
        for(final String waitingPlayerId : waitingPlayerIDs) {
            final String code = (String) memcache.get(KeyUtils.getCodeKey(challenge.getId(), waitingPlayerId));
            if (code != null) {
                game.queuePlayerById(waitingPlayerId);
            }
        }

        // now check if we can upgrade any players from 'queued' to 'active'
        while(game.getActivePlayers().size() < challenge.getMaxActivePlayers() && !game.getQueuedPlayers().isEmpty()) {
            // activate players as needed
            game.activateNextPlayer(grid);
        }

        // prepare active players
        final Map<String, MazeSolver> playerIDsToMazeSolvers = new HashMap<>();
        final List<String> activePlayerIDs = game.getActivePlayers();

        for(final String activePlayerId : activePlayerIDs) {
            final String code = (String) memcache.get(KeyUtils.getCodeKey(challenge.getId(), activePlayerId));

//            System.out.println("code = " + code);

            final MazeSolver mazeSolver = new InterpretedMazeSolver(challenge, game, activePlayerId, code);
            mazeSolver.init(challenge, game);
            final byte [] state = (byte[]) memcache.get(getMazeSolverStateKey(game.getId(), activePlayerId));
            mazeSolver.setState(state);
            playerIDsToMazeSolvers.put(activePlayerId, mazeSolver);
        }

        // todo ... consider revising to make multi-threaded and with deadlines? [e.g. check out: com.google.appengine.api.ThreadManager]
        RuntimeController.makeMove(challenge, game, playerIDsToMazeSolvers);

        // store maze solvers' state to memcache
        for(final String activePlayerId : activePlayerIDs) {
            final MazeSolver mazeSolver = playerIDsToMazeSolvers.get(activePlayerId);
            memcache.put(getMazeSolverStateKey(game.getId(), activePlayerId), mazeSolver.getState());
        }

        // remove completed players (move from 'active' to 'finished')
        final MatrixPosition targetPosition = challenge.getGrid().getTargetPosition();
        Vector<String> playersToDeactivate = new Vector<>();

        for(final String activePlayerId : activePlayerIDs) {
            final MatrixPosition playerPosition = game.getPlayerEntities().get(activePlayerId + "_" + game.getPlayerWorldSessions().get(activePlayerId).getWorldID()).getPosition();
            // for any players that were moved in 'inactive' status, reset their state and code so they are not restarted automatically
            if(playerPosition != null && playerPosition.equals(targetPosition)) {
                playersToDeactivate.add(activePlayerId);
            }
        }

        for (String playerID : playersToDeactivate) {
            memcache.delete(getMazeSolverStateKey(game.getId(), playerID)); // reset algorithm's state
            memcache.delete(KeyUtils.getCodeKey(challenge.getId(), playerID)); // reset submitted code
            game.resetPlayerById(playerID);
            System.out.println("Player reset: " + playerID);
        }

        //For players who have finished, remove their entity from the player entities and update their data:
        for (String finishedPlayerID : game.getFinishedPlayers()) {
            game.getPlayerEntities().remove(finishedPlayerID + "_" + challenge.getId());
            memcache.delete(getMazeSolverStateKey(game.getId(), finishedPlayerID));
            memcache.delete(KeyUtils.getCodeKey(challenge.getId(), finishedPlayerID)); // reset submitted code
        }

        // update game with number of rounds executed
        game.touch(System.currentTimeMillis() - startTime);
        System.out.println("Game: " + game.getId() + "\nRound: " + game.getCounter());
    }

    public static String getMazeSolverStateKey(final String gameId, final String playerId) {
        return "cached-maze-solver-state-" + gameId + "-" + playerId;
    }
    
}

