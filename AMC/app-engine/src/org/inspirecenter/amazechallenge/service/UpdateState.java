/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 17-08-2021 12:37:25
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.service;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.nkasenides.athlos.backend.AthlosService;
import org.inspirecenter.amazechallenge.auth.Auth;
import org.inspirecenter.amazechallenge.model.*;
import org.inspirecenter.amazechallenge.persistence.DBManager;
import org.inspirecenter.amazechallenge.proto.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class UpdateState implements AthlosService<UpdateStateRequest, UpdateStateResponse> {

    @Override
    public UpdateStateResponse serve(UpdateStateRequest request, Object... additionalParams) {

        //Check world session ID:
        if (request.getWorldSessionID().isEmpty()) {
            return UpdateStateResponse.newBuilder()
                    .setStatus(UpdateStateResponse.Status.INVALID_DATA)
                    .setMessage("INVALID_WORLD_SESSION")
                    .build();
        }

        //Verify world session:
        final AMCWorldSession worldSession = Auth.verifyWorldSessionID(request.getWorldSessionID());
        if (worldSession == null) {
            return UpdateStateResponse.newBuilder()
                    .setStatus(UpdateStateResponse.Status.INVALID_DATA)
                    .setMessage("INVALID_WORLD_SESSION")
                    .build();
        }

        final Challenge challenge = DBManager.challenge.get(worldSession.getWorldID());
        final Grid grid = challenge.getGrid();

        final MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();

        Game game = (Game) memcache.get("game_" + challenge.getId());
        final List<PickableEntity> pickables = game.getPickables();
        final Map<String, PlayerEntity> playerEntities = game.getPlayerEntities();

        final AMCPartialStateProto.Builder builder = AMCPartialStateProto.newBuilder();

        //Pickable entities:
        for (PickableEntity pickable : pickables) {
            builder.putEntities(pickable.getId(), pickable.toGenericProto().build());
        }

        //Player entities:
        for (Map.Entry<String, PlayerEntity> entry : playerEntities.entrySet()) {
            builder.putEntities(entry.getKey(), entry.getValue().toGenericProto().build());
//            System.out.println(entry.getKey() + ": " + entry.getValue().getPosition().getRow() + ", " + entry.getValue().getPosition().getCol());
        }

        //Players:
        for (Map.Entry<String, AMCPlayer> entry : game.getAllPlayers().entrySet()) {
            builder.putPlayers(entry.getKey(), entry.getValue().toProto().build());
        }

        //World sessions:
        for (Map.Entry<String, AMCWorldSession> entry : game.getPlayerWorldSessions().entrySet()) {
            builder.putWorldSessions(entry.getKey(), entry.getValue().toProto().build());
        }

        //Handle events:
        final HashMap<Long, Audio> playerEvents = game.getPlayerEvents(worldSession.getPlayerID());
        Vector<Audio> dispatchedEvents = new Vector<>(playerEvents.values());
        game.clearAllPlayerEvents(worldSession.getPlayerID());
        memcache.put(game.getId(), game);

        //Retrieve the partial state:
        builder
                .setTimestamp(System.currentTimeMillis())
                .setWorldSession(worldSession.toProto())
                .setGrid(grid.toProto()) //Optimize: Perhaps not necessary to include the grid, since its state does not change?
                .addAllActivePlayers(game.getActivePlayers())
                .addAllQueuedPlayers(game.getQueuedPlayers())
                .addAllWaitingPlayers(game.getWaitingPlayers())
                .build();

        return UpdateStateResponse.newBuilder()
                .setStatus(UpdateStateResponse.Status.OK)
                .setMessage("OK")
                .setStateUpdate(AMCStateUpdateProto.newBuilder()
                        .setPartialState(builder.build())
                        .setTimestamp(System.currentTimeMillis())
                        .setWorldSessionID(worldSession.getId())
                        .addAllEvents(dispatchedEvents)
                        .build()
                )
                .build();

    }

}

