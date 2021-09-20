/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 12-08-2021 11:56:05
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.state;


import org.inspirecenter.amazechallenge.model.*;
import org.inspirecenter.amazechallenge.*;
import org.inspirecenter.amazechallenge.model.*;
import org.inspirecenter.amazechallenge.persistence.DBManager;
import org.inspirecenter.amazechallenge.generation.AMCTerrainGenerator;
import com.raylabz.jsec.Hashing;
import com.raylabz.jsec.HashType;
import org.inspirecenter.amazechallenge.proto.*;

import java.util.*;

public class WorldContext {

    private final String worldID;
    private final AMCWorld world;
    private final AMCTerrainGenerator terrainGenerator;

    public WorldContext(String worldID) {
        this.worldID = worldID;
        this.world = DBManager.world.get(worldID);
        this.terrainGenerator = new AMCTerrainGenerator(world);
    }

    public String getWorldID() {
        return worldID;
    }

    public AMCTerrainGenerator getTerrainGenerator() {
        return terrainGenerator;
    }

    public AMCWorld getWorld() {
        return world;
    }

     /**
     * Requests terrain data for a specific chunk.
     * @param chunkRow The row of the chunk to load.
     * @param chunkCol The column of the chunk to load.
     * @return Returns a TerrainChunk.
     */
    private AMCTerrainChunk requestChunk(int chunkRow, int chunkCol) {
        final String chunkHash = Hashing.hash(HashType.MD5, chunkRow + "," + chunkCol);

        //Find the chunk using the identifier:
        AMCTerrainIdentifier chunkIdentifier = null;
        final Collection<AMCTerrainIdentifier> terrainIdentifiers = DBManager.terrainIdentifier.listForWorld(worldID);
        for (AMCTerrainIdentifier terrainIdentifier : terrainIdentifiers) {
            if (terrainIdentifier.getChunkPosition().toHash().equals(chunkHash)) {
                chunkIdentifier = terrainIdentifier;
            }
        }

        //Retrieve the chunk by ID, if it exists:
        if (chunkIdentifier != null) {
            return DBManager.terrainChunk.get(chunkIdentifier.getChunkID());
        }
        //If cache and/or database don't have the chunk, generate it and store it:
        else {
            final AMCTerrainChunk generatedChunk = terrainGenerator.generateChunk(chunkRow, chunkCol);
            DBManager.terrainChunk.create(generatedChunk);
            AMCWorld updatedWorld = DBManager.world.get(worldID);
            updatedWorld.addChunk(generatedChunk.getId());
            DBManager.world.update(updatedWorld);
            return generatedChunk;
        }
    }

    /**
     * Retrieves the terrain cells that are within the area of interest of a list of entities.
     * @param playerEntities The list of entities.
     * @return Returns a Map containing the terrain cells.
     */
    public Map<String, AMCTerrainCellProto> getTerrain(Collection<AMCEntity> playerEntities) {

        HashMap<String, AMCTerrainCellProto> cells = new HashMap<>();

        HashSet<MatrixPosition> chunksNeeded = new HashSet<>();
        for (AMCEntity entity : playerEntities) {
            int minRow, maxRow, minCol, maxCol;
            minRow = (int) (entity.getPosition().getRow() - entity.getAreaOfInterest());
            maxRow = (int) (entity.getPosition().getRow() + entity.getAreaOfInterest());
            minCol = (int) (entity.getPosition().getCol() - entity.getAreaOfInterest());
            maxCol = (int) (entity.getPosition().getCol() + entity.getAreaOfInterest());

            final int INCREMENTATION_STEP = (int) Math.min(entity.getAreaOfInterest(), AMCTerrainChunk.SIZE);

            for (int cellRow = minRow; cellRow <= maxRow; cellRow += INCREMENTATION_STEP) {
                for (int cellCol = minCol; cellCol <= maxCol; cellCol += INCREMENTATION_STEP) {
                    chunksNeeded.add(AMCTerrainChunk.getChunkPosition(cellRow, cellCol));
                }
            }
        }

        ArrayList<AMCTerrainChunk> chunks = new ArrayList<>();
        for (MatrixPosition chunkPos : chunksNeeded) {
            if (world.chunkIsInBounds(chunkPos.getRow(), chunkPos.getCol())) {
                //Request the entire chunk:
                AMCTerrainChunk chunk = requestChunk(chunkPos.getRow(), chunkPos.getCol());
                chunks.add(chunk);
            }
        }

        for (AMCEntity entity : playerEntities) {
            for (AMCTerrainChunk chunk : chunks) {
                //Only include cells from this chunk that are within the AoI:
                for (Map.Entry<String, AMCTerrainCell> entry : chunk.getCells().entrySet()) {
                    final MatrixPosition position = entry.getValue().getPosition();
                    final double distance = position.distanceTo(entity.getPosition());
                    if (distance <= entity.getAreaOfInterest()) {
                        cells.put(position.toHash(), entry.getValue().toProto().build());
                    }
                }
            }
        }
        return cells;
    }

    /**
     * Retrieves the terrain cells that are within the area of interest of a list of entities.
     * @param playerEntities The list of entities.
     * @return Returns a Map containing the terrain cells.
     */
    public Map<String, AMCTerrainCellProto> getTerrain(List<AMCEntityProto> playerEntities) {

        HashMap<String, AMCTerrainCellProto> cells = new HashMap<>();

        HashSet<MatrixPosition> chunksNeeded = new HashSet<>();
        for (AMCEntityProto entity : playerEntities) {
            int minRow, maxRow, minCol, maxCol;
            minRow = (int) (entity.getPosition().getRow() - entity.getAreaOfInterest());
            maxRow = (int) (entity.getPosition().getRow() + entity.getAreaOfInterest());
            minCol = (int) (entity.getPosition().getCol() - entity.getAreaOfInterest());
            maxCol = (int) (entity.getPosition().getCol() + entity.getAreaOfInterest());

            final int INCREMENTATION_STEP = (int) Math.min(entity.getAreaOfInterest(), AMCTerrainChunk.SIZE);

            for (int cellRow = minRow; cellRow <= maxRow; cellRow += INCREMENTATION_STEP) {
                for (int cellCol = minCol; cellCol <= maxCol; cellCol += INCREMENTATION_STEP) {
                    chunksNeeded.add(AMCTerrainChunk.getChunkPosition(cellRow, cellCol));
                }
            }
        }

        ArrayList<AMCTerrainChunk> chunks = new ArrayList<>();
        for (MatrixPosition chunkPos : chunksNeeded) {
            if (world.chunkIsInBounds(chunkPos.getRow(), chunkPos.getCol())) {
                //Request the entire chunk:
                AMCTerrainChunk chunk = requestChunk(chunkPos.getRow(), chunkPos.getCol());
                chunks.add(chunk);
            }
        }

        for (AMCEntityProto entity : playerEntities) {
            for (AMCTerrainChunk chunk : chunks) {
                //Only include cells from this chunk that are within the AoI:
                for (Map.Entry<String, AMCTerrainCell> entry : chunk.getCells().entrySet()) {
                    final MatrixPosition position = entry.getValue().getPosition();
                    final double distance = position.distanceTo(entity.getPosition().toObject());
                    if (distance <= entity.getAreaOfInterest()) {
                        cells.put(position.toHash(), entry.getValue().toProto().build());
                    }
                }
            }
        }
        return cells;
    }

    /**
     * Retrieves the terrain cells that are within the area of interest of a specific position.
     * @param position The position.
     * @param radius The radius of the area of interest.
     * @return Returns a map of terrain cells.
     */
    public Map<String, AMCTerrainCellProto> getTerrain(MatrixPosition position, float radius) {
        HashMap<String, AMCTerrainCellProto> cells = new HashMap<>();

        HashSet<MatrixPosition> chunksNeeded = new HashSet<>();
        int minRow, maxRow, minCol, maxCol;
        minRow = (int) (position.getRow() - radius);
        maxRow = (int) (position.getRow() + radius);
        minCol = (int) (position.getCol() - radius);
        maxCol = (int) (position.getCol() + radius);

        final int INCREMENTATION_STEP = (int) Math.min(radius, AMCTerrainChunk.SIZE);

        for (int cellRow = minRow; cellRow <= maxRow; cellRow += INCREMENTATION_STEP) {
            for (int cellCol = minCol; cellCol <= maxCol; cellCol += INCREMENTATION_STEP) {
                chunksNeeded.add(AMCTerrainChunk.getChunkPosition(cellRow, cellCol));
            }
        }

        ArrayList<AMCTerrainChunk> chunks = new ArrayList<>();
        for (MatrixPosition chunkPos : chunksNeeded) {
            if (world.chunkIsInBounds(chunkPos.getRow(), chunkPos.getCol())) {
                //Request the entire chunk:
                AMCTerrainChunk chunk = requestChunk(chunkPos.getRow(), chunkPos.getCol());
                chunks.add(chunk);
            }
        }

        for (AMCTerrainChunk chunk : chunks) {
            //Only include cells from this chunk that are within the AoI:
            for (Map.Entry<String, AMCTerrainCell> entry : chunk.getCells().entrySet()) {
                final MatrixPosition cellPosition = entry.getValue().getPosition();
                final double distance = cellPosition.distanceTo(position);
                if (distance <= radius) {
                    cells.put(cellPosition.toHash(), entry.getValue().toProto().build());
                }
            }
        }
        return cells;
    }

    /**
     * Retrieves the entities that are within the area of interest of a given set of entities.
     * @param playerEntities The entities given.
     * @return Returns a map of entities.
     */
    public Map<String, AMCEntityProto> getEntities(Collection<AMCEntity> playerEntities) {
        HashMap<String, AMCEntityProto> entitiesInAOI = new HashMap<>();
        for (AMCEntity e : playerEntities) {
            entitiesInAOI.put(e.getId(), e.toGenericProto().build());
        }
        final Collection<AMCEntity> allEntities = DBManager.entity.listForWorld(worldID);
        for (AMCEntity providedEntity : playerEntities) {
            for (AMCEntity entity : allEntities) {
                if (!providedEntity.getId().equals(entity.getId()) && !entitiesInAOI.containsKey(entity.getId())) {
                    if (providedEntity.getPosition().distanceTo(entity.getPosition()) <= providedEntity.getAreaOfInterest()) {
                        entitiesInAOI.put(entity.getId(), entity.toGenericProto().build());
                    }
                }
            }
        }
        return entitiesInAOI;
    }

    /**
     * Retrieves the entities that are within a radius of a given position.
     * @param position The position given.
     * @param radius The radius.
     * @return Returns a map of entities.
     */
    public Map<String, AMCEntityProto> getEntities(MatrixPosition position, float radius) {
        HashMap<String, AMCEntityProto> entitiesInAOI = new HashMap<>();
        final Collection<AMCEntity> allEntities = DBManager.entity.listForWorld(worldID);
        for (AMCEntity entity : allEntities) {
            if (!entitiesInAOI.containsKey(entity.getId())) {
                if (position.distanceTo(entity.getPosition()) <= radius) {
                    entitiesInAOI.put(entity.getId(), entity.toGenericProto().build());
                }
            }
        }
        return entitiesInAOI;
    }

    /**
     * Retrieves a snapshot of the current partial state using a player's entities and their AoI.
     * @param worldSession The world session retrieving the snapshot.
     * @return Returns a PartialStateProto.
     */
    public AMCPartialStateProto getPartialStateSnapshot(AMCWorldSession worldSession) {
        final Collection<AMCEntity> playerEntities = DBManager.entity.listForPlayerAndWorld(worldSession.getPlayerID(), worldSession.getWorldID());
        final AMCWorld world = DBManager.world.get(worldSession.getWorldID());
        return AMCPartialStateProto.newBuilder()
                .putAllEntities(getEntities(playerEntities))
                .putAllTerrain(getTerrain(playerEntities))
                .setTimestamp(System.currentTimeMillis())
                .setWorldSession(worldSession.toProto())
                .setGrid(world.getGrid().toProto())
                .build();
    }

    /**
     * Retrieves a snapshot of the current partial state using a position and a radius as an AoI.
     * @param worldSession The world session retrieving the snapshot.
     * @param position The position to retrieve the partial state at.
     * @param radius The radius of the AoI in this partial state.
     * @return Returns a PartialStateProto.
     */
    public AMCPartialStateProto getPartialStateSnapshot(AMCWorldSession worldSession, MatrixPosition position, float radius) {
        return AMCPartialStateProto.newBuilder()
                .putAllEntities(getEntities(position, radius))
                .putAllTerrain(getTerrain(position, radius))
                .setTimestamp(System.currentTimeMillis())
                .setWorldSession(worldSession.toProto())
                .build();
    }

    /**
     * Saves the state of an <b>entire</b> partial state to the cache/DB.
     * @param partialStateProto The partial state.
     */
    public void saveState(AMCPartialStateProto partialStateProto) {
        saveTerrain(partialStateProto);
        saveEntities(partialStateProto);
    }

    /**
     * Saves the state to the cache/DB based on a state update.
     * @param stateUpdateProto The state update.
     */
    public void saveState(AMCStateUpdateProto stateUpdateProto) {
        saveTerrain(stateUpdateProto);
        saveEntities(stateUpdateProto);
    }

    /**
     * Saves the terrain of an <b>entire</b> partial state to the cache/DB.
     * @param partialStateProto The partial state.
     */
    public void saveTerrain(AMCPartialStateProto partialStateProto) {
        //Get the referenced chunks using the partial state provided:
        final Map<String, AMCTerrainCellProto> terrainMap = partialStateProto.getTerrainMap();
        HashSet<MatrixPosition> chunkPositions = new HashSet<>();
        for (AMCTerrainCellProto cell : terrainMap.values()) {
            chunkPositions.add(AMCTerrainChunk.getChunkPosition(cell.getPosition().toObject()));
        }

        HashMap<String, AMCTerrainChunk> chunks = new HashMap<>();
        for (MatrixPosition chunkPosition : chunkPositions) {
            final AMCTerrainChunk chunk = DBManager.terrainChunk.getForWorld(worldID, chunkPosition.toHash());
            chunks.put(chunkPosition.toHash(), chunk);
        }

        //For each cell, find its corresponding chunk and update it:
        for (AMCTerrainCellProto cell : partialStateProto.getTerrainMap().values()) {
            final AMCTerrainChunk referencedChunk = chunks.get(AMCTerrainChunk.getChunkPosition(cell.getPosition().toObject()).toHash());
            referencedChunk.getCells().put(cell.getPosition().toHash(), cell.toObject());
        }

        //Save the chunks:
        for (AMCTerrainChunk chunk : chunks.values()) {
            DBManager.terrainChunk.update(chunk);
        }
    }

    /**
     * Saves the terrain to the cache/DB based on a state update.
     * @param stateUpdateProto The state update.
     */
    public void saveTerrain(AMCStateUpdateProto stateUpdateProto) {
        //Get the referenced chunks using the state update:
        final Map<String, AMCTerrainCellProto> terrainMap = stateUpdateProto.getPartialState().getTerrainMap();
        HashSet<MatrixPosition> chunkPositions = new HashSet<>();
        for (AMCTerrainCellProto cell : terrainMap.values()) {
            chunkPositions.add(AMCTerrainChunk.getChunkPosition(cell.getPosition().toObject()));
        }

        HashMap<String, AMCTerrainChunk> chunks = new HashMap<>();
        for (MatrixPosition chunkPosition : chunkPositions) {
            final AMCTerrainChunk chunk = DBManager.terrainChunk.getForWorld(worldID, chunkPosition.toHash());
            chunks.put(chunkPosition.toHash(), chunk);
        }

        //For each cell, find its corresponding chunk and update it:
        for (AMCTerrainCellProto cell : stateUpdateProto.getPartialState().getTerrainMap().values()) {
            final AMCTerrainChunk referencedChunk = chunks.get(AMCTerrainChunk.getChunkPosition(cell.getPosition().toObject()).toHash());
            referencedChunk.getCells().put(cell.getPosition().toHash(), cell.toObject());
        }

        //Save the chunks:
        for (AMCTerrainChunk chunk : chunks.values()) {
            DBManager.terrainChunk.update(chunk);
        }
    }

    /**
     * Saves the entities of an <b>entire</b> partial state to the cache/DB.
     * @param partialStateProto The partial state.
     */
    public void saveEntities(AMCPartialStateProto partialStateProto) {
        for (AMCEntityProto entity : partialStateProto.getEntitiesMap().values()) {
            if (entity.hasPickableEntity()) {
                DBManager.pickableEntity.update(entity.getPickableEntity().toObject());
            }
            if (entity.hasPlayerEntity()) {
                DBManager.playerEntity.update(entity.getPlayerEntity().toObject());
            }
        }
    }

    /**
     * Saves the entities to the cache/DB based on a state update.
     * @param stateUpdateProto The state update.
     */
    public void saveEntities(AMCStateUpdateProto stateUpdateProto) {
        for (AMCEntityProto entity : stateUpdateProto.getPartialState().getEntitiesMap().values()) {
            if (entity.hasPickableEntity()) {
                DBManager.pickableEntity.update(entity.getPickableEntity().toObject());
            }
            if (entity.hasPlayerEntity()) {
                DBManager.playerEntity.update(entity.getPlayerEntity().toObject());
            }
        }
    }

   /**
     * Refreshes the terrain of a particular StateUpdateBuilder using the new entities' AoI.
     * @param entities The old (existing) entities.
     * @param stateUpdateBuilder The builder, which contains the new entities.
     * @return Returns a StateUpdateBuilder.
     */
    public StateUpdateBuilder refreshTerrain(List<AMCEntity> entities, StateUpdateBuilder stateUpdateBuilder) {
        final Map<String, AMCTerrainCellProto> terrain = getTerrain(entities);
        for (AMCTerrainCellProto terrainCell : terrain.values()) {
            stateUpdateBuilder.addUpdatedTerrain(terrainCell);
        }
        return stateUpdateBuilder;
    }

    /**
     * Refreshes the entities of a particular StateUpdateBuilder.
     * @param stateUpdateBuilder The builder.
     * @return Returns a StateUpdateBuilder.
     */
    public StateUpdateBuilder refreshEntities(AMCWorldSession worldSession, StateUpdateBuilder stateUpdateBuilder) {
        final Collection<AMCEntity> playerEntities = DBManager.entity.listForPlayerAndWorld(worldSession.getPlayerID(), worldSession.getWorldID());
        final Map<String, AMCEntityProto> aoiEntities = getEntities(playerEntities);
        for (AMCEntityProto value : aoiEntities.values()) {
            stateUpdateBuilder.addUpdatedEntity(value);
        }
        return stateUpdateBuilder;
    }

    /**
     * Refreshes an existing state's terrain ONLY, using existing entities in the stateUpdateBuilder provided.
     * @param stateUpdateBuilder An existing state update builder, containing the entities created in the last action.
     * @return Returns a StateUpdateBuilder.
     */
    public StateUpdateBuilder checkAndRefreshTerrain(AMCWorldSession worldSession, StateUpdateBuilder stateUpdateBuilder) {
        //For each entity, find if the a entity is contained inside it
        final List<AMCEntity> entities = new ArrayList<>(DBManager.entity.listForPlayerAndWorld(worldSession.getPlayerID(), worldSession.getWorldID()));

        boolean contained = false;
        outterLoop:
        for (AMCEntity existingEntity : entities) {
            for (AMCEntityProto createdEntity : stateUpdateBuilder.getUpdatedEntities().values()) {
                if (worldSession.getPlayerID().equals(createdEntity.getPlayerID())) {
                    break outterLoop;
                }
                double distance = existingEntity.getPosition().distanceTo(createdEntity.getPosition().toObject());
                if (distance - createdEntity.getAreaOfInterest() < existingEntity.getAreaOfInterest()) {
                    contained = true;
                    break outterLoop;
                }
            }
        }

        //If not contained, fetch the terrain and any entities associated with it.
        if (!contained) {
            stateUpdateBuilder = refreshTerrain(entities, stateUpdateBuilder);
            stateUpdateBuilder = refreshEntities(worldSession, stateUpdateBuilder);
        }

        return stateUpdateBuilder;
    }

    /**
     * Composes a custom state update, optionally refreshing the terrain and/or entities.
     * Important note: Refreshing terrain/entities may impact the performance of this method significantly. Opt to refresh
     * the terrain and entities only when necessary.
     * @param worldSessionsMap A map of world sessions for which the state must be updated.
     * @param globalStateUpdateBuilder The state update, as provided by the action made.
     * @param refreshEntities Refresh entities?
     * @param refreshTerrain Refresh terrain?
     * @return Returns a StateUpdateProto
     */
    public HashMap<AMCWorldSession, UpdateStateResponse> composeStateUpdate(HashMap<AMCWorldSession, ArrayList<AMCEntity>> worldSessionsMap, StateUpdateBuilder globalStateUpdateBuilder,
                                                                            boolean refreshTerrain, boolean refreshEntities) {
        final HashMap<AMCWorldSession, UpdateStateResponse> stateUpdateMap = new HashMap<>();
        for (Map.Entry<AMCWorldSession, ArrayList<AMCEntity>> entry : worldSessionsMap.entrySet()) {
            if (refreshTerrain) {
                globalStateUpdateBuilder = checkAndRefreshTerrain(entry.getKey(), globalStateUpdateBuilder);
            }
            if (refreshEntities) {
                globalStateUpdateBuilder = refreshEntities(entry.getKey(), globalStateUpdateBuilder);
            }
            StateUpdateBuilder individualStateUpdateBuilder = globalStateUpdateBuilder.clone();
            final AMCPlayer player = DBManager.player.get(entry.getKey().getPlayerID());

            //If any of the new entities belonging to the player are not within the current AOI of the player's entities, get the terrain around their AOI:
            final Collection<AMCEntity> currentPlayerEntities = DBManager.entity.listForPlayerAndWorld(player.getId(), entry.getKey().getWorldID());
            for (AMCEntityProto updatedEntity : individualStateUpdateBuilder.getUpdatedEntities().values()) {
                if (updatedEntity.getPlayerID().equals(entry.getKey().getPlayerID())) {
                    for (AMCEntity playerEntity : currentPlayerEntities) {
                        if (State.Entities.isOutOfAOI(updatedEntity, playerEntity.toGenericProto().build())) {
                            final Map<String, AMCTerrainCellProto> newTerrain = getTerrain(updatedEntity.getPosition().toObject(), updatedEntity.getAreaOfInterest());
                            for (Map.Entry<String, AMCTerrainCellProto> tEntry : newTerrain.entrySet()) {
                                individualStateUpdateBuilder.addUpdatedTerrain(tEntry.getValue());
                            }
                        }
                    }
                }
            }

            final UpdateStateResponse response = UpdateStateResponse.newBuilder()
                    .setStatus(UpdateStateResponse.Status.OK)
                    .setMessage("OK")
                    .setStateUpdate(globalStateUpdateBuilder.build())
                    .build();
            stateUpdateMap.put(entry.getKey(), response);
        }
        return stateUpdateMap;
    }

    /**
     * Returns the active sessions for this world.
     * @return Returns a collection of WorldSessions.
     */
    public Collection<AMCWorldSession> getAllSessions() {
        return DBManager.worldSession.listForWorld(worldID);
    }

    /**
     * Returns the subscribed sessions (those receiving state updates) for this world.
     * @return Returns the subscribed sessions of this world.
     */
    public Collection<AMCWorldSession> getSubscribedSessions() {
        final List<String> subscribedSessionIDs = DBManager.world.get(worldID).getSubscribedSessionIDs();
        return DBManager.worldSession.getMany(subscribedSessionIDs);
    }

    /**
     * Subscribes a world session to a world.
     * @param worldSession The world session.
     */
    public void subscribe(AMCWorldSession worldSession) {
        final AMCWorld world = DBManager.world.get(worldID);
        if (!world.getSubscribedSessionIDs().contains(worldSession.getId())) {
            world.getSubscribedSessionIDs().add(worldSession.getId());
            DBManager.world.update(world);
        }
    }

    /**
     * Unsubscribes a world session.
     * @param worldSession The world session to unsubscribe.
     */
    public void unsubscribe(AMCWorldSession worldSession) {
        final AMCWorld world = DBManager.world.get(worldID);
        world.getSubscribedSessionIDs().remove(worldSession.getId());
        DBManager.world.update(world);
    }


}
