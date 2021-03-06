/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 12-08-2021 11:56:05
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.state;


import org.inspirecenter.amazechallenge.*;
import org.inspirecenter.amazechallenge.model.*;
import org.inspirecenter.amazechallenge.model.AMCEntity;
import org.inspirecenter.amazechallenge.model.GeoPosition;
import org.inspirecenter.amazechallenge.model.MatrixPosition;
import org.inspirecenter.amazechallenge.persistence.DBManager;
import java.io.IOException;
import java.util.*;
import com.raylabz.jsec.Hashing;
import com.nkasenides.athlos.proto.Modifiable;
import org.inspirecenter.amazechallenge.model.AMCWorldSession;
import org.inspirecenter.amazechallenge.proto.*;


public class State {

    private static WorldContext currentContext;
    private static final double cameraRange = 50.0;

    public static WorldContext forWorld(String worldID) {
        if (currentContext == null || !currentContext.getWorldID().equals(worldID)) {
            currentContext = new WorldContext(worldID);
        }
        return currentContext;
    }

    /**
     * Identifies a cell/chunk/position using its hashed value.
     * @param matrixPosition The MatrixPosition.
     * @return Returns a String hash.
     */
    public static String identify(MatrixPosition matrixPosition) {
        return Hashing.hash(matrixPosition.getRow() + "," + matrixPosition.getCol());
    }

    /**
     * Identifies a cell/chunk/position using its hashed value.
     * @param matrixPositionProto The MatrixPosition.
     * @return Returns a String hash.
     */
    public static String identify(MatrixPositionProto matrixPositionProto) {
        return Hashing.hash(matrixPositionProto.getRow() + "," + matrixPositionProto.getCol());
    }

    /**
     * Identifies a cell/chunk/position using its hashed value.
     * @param geoPosition The GeoPosition.
     * @return Returns a String hash.
     */
    public static String identify(GeoPosition geoPosition) {
        return identify(geoPosition.toMatrixPosition());
    }

    /**
     * Identifies a cell/chunk/position using its hashed value.
     * @param geoPositionProto The GeoPosition.
     * @return Returns a String hash.
     */
    public static String identify(GeoPositionProto geoPositionProto) {
        return identify(geoPositionProto.toMatrixPosition());
    }

    /**
     * Filters the sessions that should be updated based on game-specific criteria.
     * @param areaOfEffect The area of effect of the action.
     * @param actionPosition The action position.
     * @param worldID The ID of the world.
     * @return Returns a collection of world sessions.
     */
    public static HashMap<AMCWorldSession, ArrayList<AMCEntity>> filterUpdateSessions(AMCWorldSession initiatingSession, String worldID, MatrixPosition actionPosition, float areaOfEffect) {
        ArrayList<AMCWorldSession> allSessions = new ArrayList<>(State.forWorld(worldID).getSubscribedSessions());
        HashMap<AMCWorldSession, ArrayList<AMCEntity>> filteredSessions = new HashMap<>();
        for (AMCWorldSession worldSession : allSessions) {

            boolean hasEntitiesInAOI = false;
            final ArrayList<AMCEntity> playerEntities = new ArrayList<>(DBManager.entity.listForPlayerAndWorld(worldSession.getPlayerID(), worldSession.getWorldID()));

            //If this is the owner of the update, send the update.
            if (initiatingSession.getId().equals(worldSession.getId())) {
                filteredSessions.put(worldSession, playerEntities);
            }

            //If this is not the owner, check distance of entities and camera to action.
            else {

                //Check entity area of interest vs action area of effect:
                for (AMCEntity entity : playerEntities) {
                    if (entity.getAreaOfInterest() > 0) {
                        double distance = entity.getPosition().distanceTo(actionPosition);
                        if (distance - areaOfEffect < entity.getAreaOfInterest()) {
                            hasEntitiesInAOI = true;
                            break;
                        }
                    }
                }

                //Check camera positioning:
                boolean cameraIsInRange = worldSession.getCameraPosition().distanceTo(actionPosition) - cameraRange <= areaOfEffect;

                if (hasEntitiesInAOI && cameraIsInRange) {
                    filteredSessions.put(worldSession, playerEntities);
                }
            }

        }
        return filteredSessions;
    }

    /**
     * Provides utility methods for accessing the terrain of a state.
     */
    public static class Terrain {
        /**
         * Observes a cell from a partial state without modifying it.
         * @param partialStateProto The partial state.
         * @param cellRow The cell's row.
         * @param cellCol The cell's column
         * @return Returns a TerrainCellProto.
         */
        public static AMCTerrainCellProto observe(AMCPartialStateProto partialStateProto, int cellRow, int cellCol) {
            return partialStateProto.getTerrainMap().get(new MatrixPosition(cellRow, cellCol).toHash());
        }

        /**
         * Observes a cell from a partial state without modifying it.
         * @param partialStateProto The partial state.
         * @param cellPosition The cell's position.
         * @return Returns a TerrainCellProto.
         */
        public static AMCTerrainCellProto observe(AMCPartialStateProto partialStateProto, MatrixPosition cellPosition) {
            return partialStateProto.getTerrainMap().get(cellPosition.toHash());
        }

        /**
         * Observes a cell from a partial state without modifying it.
         * @param partialStateProto The partial state.
         * @param cellPosition The cell's position.
         * @return Returns a TerrainCellProto.
         */
        public static AMCTerrainCellProto observe(AMCPartialStateProto partialStateProto, MatrixPositionProto cellPosition) {
            return partialStateProto.getTerrainMap().get(cellPosition.toHash());
        }

        /**
         * Modifies a cell in a partial state.
         * @param partialState The partial state.
         * @param cellRow The cell's row.
         * @param cellCol The cell's column.
         * @param modifiable A modifiable, which defines how the item will be modified.
         */
        public static void modify(AMCPartialStateProto partialState, int cellRow, int cellCol, Modifiable<AMCTerrainCellProto.Builder> modifiable) {
            final AMCTerrainCellProto.Builder builder = partialState.getTerrainMap().get(new MatrixPosition(cellRow, cellCol).toHash()).toBuilder();
            modifiable.modify(builder);
            partialState.toBuilder().putTerrain(builder.getPosition().toHash(), builder.build());
        }

        /**
         * Modifies a cell in a partial state.
         * @param partialState The partial state.
         * @param cellPosition The cell's position.
         * @param modifiable A modifiable, which defines how the item will be modified.
         */
        public static void modify(AMCPartialStateProto partialState, MatrixPosition cellPosition, Modifiable<AMCTerrainCellProto.Builder> modifiable) {
            final AMCTerrainCellProto.Builder builder = partialState.getTerrainMap().get(cellPosition.toHash()).toBuilder();
            modifiable.modify(builder);
            partialState.toBuilder().putTerrain(builder.getPosition().toHash(), builder.build());
        }

        /**
         * Modifies a cell in a partial state.
         * @param partialState The partial state.
         * @param cellPosition The cell's position.
         * @param modifiable A modifiable, which defines how the item will be modified.
         */
        public static void modify(AMCPartialStateProto partialState, MatrixPositionProto cellPosition, Modifiable<AMCTerrainCellProto.Builder> modifiable) {
            final AMCTerrainCellProto.Builder builder = partialState.getTerrainMap().get(cellPosition.toHash()).toBuilder();
            modifiable.modify(builder);
            partialState.toBuilder().putTerrain(builder.getPosition().toHash(), builder.build());
        }

        /**
         * Modifies all cells in the partial state.
         * @param partialState The partial state.
         * @param modifiable A modifiable, which defines how the item will be modified.
         */
        public static void modifyAll(AMCPartialStateProto partialState, Modifiable<AMCTerrainCellProto.Builder> modifiable) {
            for (AMCTerrainCellProto cell : partialState.getTerrainMap().values()) {
                final AMCTerrainCellProto.Builder builder = cell.toBuilder();
                modifiable.modify(builder);
                partialState.toBuilder().putTerrain(cell.getPosition().toHash(), builder.build());
            }
        }

        /**
         * Modifies all cells in a specified range of a position.
         * @param partialState The partial state.
         * @param position The position.
         * @param range The range.
         * @param modifiable A modifiable, which defines how the item will be modified.
         */
        public static void modifyAllInRange(AMCPartialStateProto partialState, MatrixPosition position, float range, Modifiable<AMCTerrainCellProto.Builder> modifiable) {
            for (AMCTerrainCellProto cell : partialState.getTerrainMap().values()) {
                if (cell.getPosition().toObject().distanceTo(position) <= range) {
                    final AMCTerrainCellProto.Builder builder = cell.toBuilder();
                    modifiable.modify(builder);
                    partialState.toBuilder().putTerrain(cell.getPosition().toHash(), builder.build());
                }
            }
        }

    }

    /**
     * Provides utility methods for accessing entities.
     */
    public static class Entities {

        /**
         * Observes an entity from a partial state without modifying it.
         * @param partialStateProto The partial state.
         * @param entityID The entity's ID.
         * @return Returns a TerrainCellProto.
         */
        public static AMCEntityProto observe(AMCPartialStateProto partialStateProto, String entityID) {
            return partialStateProto.getEntitiesMap().get(entityID);
        }

        /**
         * Observes entities at a specific position.
         * @param partialStateProto The partial state.
         * @param cellRow The cell's row.
         * @param cellCol The cell's column.
         * @return Returns a list of entities located at this position.
         */
        public static List<AMCEntityProto> observeAt(AMCPartialStateProto partialStateProto, int cellRow, int cellCol) {
            ArrayList<AMCEntityProto> entities = new ArrayList<>();
            for (AMCEntityProto entity : partialStateProto.getEntitiesMap().values()) {
                if (entity.getPosition().toObject().equals(new MatrixPosition(cellRow, cellCol))) {
                    entities.add(entity);
                }
            }
            return entities;
        }

        /**
         * Observes entities at a specific position.
         * @param partialStateProto The partial state.
         * @param position The position.
         * @return Returns a list of entities located at this position.
         */
        public static List<AMCEntityProto> observeAt(AMCPartialStateProto partialStateProto, MatrixPosition position) {
            ArrayList<AMCEntityProto> entities = new ArrayList<>();
            for (AMCEntityProto entity : partialStateProto.getEntitiesMap().values()) {
                if (entity.getPosition().toObject().equals(position)) {
                    entities.add(entity);
                }
            }
            return entities;
        }

        /**
         * Observes entities at a specific position.
         * @param partialStateProto The partial state.
         * @param position The position.
         * @return Returns a list of entities located at this position.
         */
        public static List<AMCEntityProto> observeAt(AMCPartialStateProto partialStateProto, MatrixPositionProto position) {
            ArrayList<AMCEntityProto> entities = new ArrayList<>();
            for (AMCEntityProto entity : partialStateProto.getEntitiesMap().values()) {
                if (entity.getPosition().equals(position)) {
                    entities.add(entity);
                }
            }
            return entities;
        }

        /**
         * Modifies an entity in a partial state.
         * @param partialState The partial state.
         * @param entityID The entity's ID.
         * @param modifiable A modifiable, which defines how the item will be modified.
         */
        public static void modify(AMCPartialStateProto partialState, String entityID, Modifiable<AMCEntityProto.Builder> modifiable) {
            final AMCEntityProto.Builder builder = partialState.getEntitiesMap().get(entityID).toBuilder();
            modifiable.modify(builder);
            partialState.toBuilder().putEntities(entityID, builder.build());
        }

        /**
         * Modifies all entities in the partial state.
         * @param partialState The partial state.
         * @param modifiable A modifiable, which defines how the item will be modified.
         */
        public static void modifyAll(AMCPartialStateProto partialState, Modifiable<AMCEntityProto.Builder> modifiable) {
            for (AMCEntityProto entity : partialState.getEntitiesMap().values()) {
                final AMCEntityProto.Builder builder = entity.toBuilder();
                modifiable.modify(builder);
                partialState.toBuilder().putEntities(entity.getId(), builder.build());
            }
        }

        /**
         * Modifies all entities at the given position.
         * @param partialState The partial state.
         * @param cellRow The cell row.
         * @param cellCol The cell column.
         * @param modifiable A modifiable, which defines how the item will be modified.
         */
        public static void modifyAllAt(AMCPartialStateProto partialState, int cellRow, int cellCol, Modifiable<AMCEntityProto.Builder> modifiable) {
            for (AMCEntityProto entity : partialState.getEntitiesMap().values()) {
                if (entity.getPosition().toObject().equals(new MatrixPosition(cellRow, cellCol))) {
                    final AMCEntityProto.Builder builder = entity.toBuilder();
                    modifiable.modify(builder);
                    partialState.toBuilder().putEntities(entity.getId(), builder.build());
                }
            }
        }

        /**
         * Modifies all entities at the given position.
         * @param partialState The partial state.
         * @param position The position.
         * @param modifiable A modifiable, which defines how the item will be modified.
         */
        public static void modifyAllAt(AMCPartialStateProto partialState, MatrixPosition position, Modifiable<AMCEntityProto.Builder> modifiable) {
            for (AMCEntityProto entity : partialState.getEntitiesMap().values()) {
                if (entity.getPosition().toObject().equals(position)) {
                    final AMCEntityProto.Builder builder = entity.toBuilder();
                    modifiable.modify(builder);
                    partialState.toBuilder().putEntities(entity.getId(), builder.build());
                }
            }
        }

        /**
         * Modifies all entities at the given position.
         * @param partialState The partial state.
         * @param position The position.
         * @param modifiable A modifiable, which defines how the item will be modified.
         */
        public static void modifyAllAt(AMCPartialStateProto partialState, MatrixPositionProto position, Modifiable<AMCEntityProto.Builder> modifiable) {
            for (AMCEntityProto entity : partialState.getEntitiesMap().values()) {
                if (entity.getPosition().equals(position)) {
                    final AMCEntityProto.Builder builder = entity.toBuilder();
                    modifiable.modify(builder);
                    partialState.toBuilder().putEntities(entity.getId(), builder.build());
                }
            }
        }

        /**
         * Checks if a position is within the AOI of an entity.
         * @param position The position.
         * @param entity The entity.
         * @return Returns true if the position within the AOI, false otherwise.
         */
        public static boolean isInAOI(MatrixPosition position, AMCEntity entity) {
            return (position.distanceTo(entity.getPosition()) <= entity.getAreaOfInterest());
        }

        /**
         * Checks if a position is within the AOI of an entity.
         * @param position The position.
         * @param entity The entity.
         * @return Returns true if the position within the AOI, false otherwise.
         */
        public static boolean isInAOI(MatrixPosition position, AMCEntityProto entity) {
            return (position.distanceTo(entity.getPosition().toObject()) <= entity.getAreaOfInterest());
        }

       /**
         * Check if an entity's AOI fully lies within another entity's AOI.
         * @param newEntity The current/new entity.
         * @param oldEntity The old/other entity.
         * @return Returns true if the newEntity AOI lies within the oldEntityAOI, false otherwise.
         */
        public static boolean aoiIsInAOI(AMCEntity newEntity, AMCEntity oldEntity) {
            double distance = Math.sqrt(
                    (newEntity.getPosition().getRow() - oldEntity.getPosition().getRow()) * (newEntity.getPosition().getRow() - oldEntity.getPosition().getRow())
                    +
                    ((newEntity.getPosition().getCol() - oldEntity.getPosition().getCol()) * (newEntity.getPosition().getCol() - oldEntity.getPosition().getCol()))
            );
            return oldEntity.getAreaOfInterest() > (distance + newEntity.getAreaOfInterest());
        }

        /**
         * Check if an entity's AOI fully lies within another entity's AOI.
         * @param newEntity The current/new entity.
         * @param oldEntity The old/other entity.
         * @return Returns true if the newEntity AOI lies within the oldEntityAOI, false otherwise.
         */
        public static boolean aoiIsInAOI(AMCEntityProto newEntity, AMCEntityProto oldEntity) {
            double distance = Math.sqrt(
                    (newEntity.getPosition().getRow() - oldEntity.getPosition().getRow()) * (newEntity.getPosition().getRow() - oldEntity.getPosition().getRow())
                            +
                            ((newEntity.getPosition().getCol() - oldEntity.getPosition().getCol()) * (newEntity.getPosition().getCol() - oldEntity.getPosition().getCol()))
            );
            return oldEntity.getAreaOfInterest() > (distance + newEntity.getAreaOfInterest());
        }

        /**
         * Check if an entity's AOI overlaps with another's.
         * @param newEntity The current/new entity.
         * @param oldEntity The old/other entity.
         * @return Returns true if the newEntity AOI overlaps oldEntityAOI, false otherwise.
         */
        public static boolean aoisOverlap(AMCEntity newEntity, AMCEntity oldEntity) {
            double distance = Math.sqrt(Math.pow(oldEntity.getPosition().getRow() - newEntity.getPosition().getRow(), 2) + (Math.pow(oldEntity.getPosition().getCol() - newEntity.getPosition().getCol(), 2)));
            return distance <= (newEntity.getAreaOfInterest() + oldEntity.getAreaOfInterest()) && distance >= Math.abs(newEntity.getAreaOfInterest() - oldEntity.getAreaOfInterest());
        }

        /**
         * Checks if an entity's AOI fully lies outside another entity's AOI.
         * @param newEntity The current/new entity.
         * @param oldEntity The old/other entity.
         * @return Returns true if the newEntity AOI lies outside the oldEntityAOI, false otherwise.
         */
        public static boolean isOutOfAOI(AMCEntity newEntity, AMCEntity oldEntity) {
            return !aoisOverlap(newEntity, oldEntity);
        }

        /**
         * Check if an entity's AOI overlaps with another's.
         * @param newEntity The current/new entity.
         * @param oldEntity The old/other entity.
         * @return Returns true if the newEntity AOI overlaps oldEntityAOI, false otherwise.
         */
        public static boolean aoisOverlap(AMCEntityProto newEntity, AMCEntityProto oldEntity) {
            double distance = Math.sqrt(Math.pow(oldEntity.getPosition().getRow() - newEntity.getPosition().getRow(), 2) + (Math.pow(oldEntity.getPosition().getCol() - newEntity.getPosition().getCol(), 2)));
            return distance <= (newEntity.getAreaOfInterest() + oldEntity.getAreaOfInterest()) && distance >= Math.abs(newEntity.getAreaOfInterest() - oldEntity.getAreaOfInterest());
        }

        /**
         * Checks if an entity's AOI fully lies outside another entity's AOI.
         * @param newEntity The current/new entity.
         * @param oldEntity The old/other entity.
         * @return Returns true if the newEntity AOI lies outside the oldEntityAOI, false otherwise.
         */
        public static boolean isOutOfAOI(AMCEntityProto newEntity, AMCEntityProto oldEntity) {
            return !aoisOverlap(newEntity, oldEntity);
        }

    }

    /**
     * Sends a state update to sessions that should receive it based on the result of <i>filterUpdateSessions()</i>.
     * @param initiatingSession The session initiating the update.
     * @param stateUpdateBuilder The state update builder containing the update.
     * @param worldID The world ID.
     * @param actionPosition The action position.
     * @param areaOfEffect The area of effect.
     * @param refreshTerrain Refresh the terrain in this update.
     * @param refreshEntities Refresh the entities in this update.
     * @throws IOException thrown when the update cannot be sent.
     */
    public static void sendUpdate(AMCWorldSession initiatingSession, StateUpdateBuilder stateUpdateBuilder, String worldID, MatrixPosition actionPosition, float areaOfEffect, boolean refreshTerrain, boolean refreshEntities) throws IOException {
        final HashMap<AMCWorldSession, ArrayList<AMCEntity>> worldSessionsToBeUpdated = State.filterUpdateSessions(initiatingSession, worldID, actionPosition, areaOfEffect); //Filter
        final HashMap<AMCWorldSession, UpdateStateResponse> responses = State.forWorld(worldID).composeStateUpdate(worldSessionsToBeUpdated, stateUpdateBuilder, refreshTerrain, refreshEntities); //Compose
        //TODO - Important! Use your state update mechanism here to send the update to the client(s).
    }

    /**
     * Multicasts an update to a given list of world sessions.
     * @param stateUpdateBuilder The update builder.
     * @param worldID The world ID.
     * @param worldSessions A list of world sessions.
     * @throws IOException thrown when the update cannot be sent.
     */
    public static void multicastUpdate(StateUpdateBuilder stateUpdateBuilder, String worldID, List<AMCWorldSession> worldSessions) throws IOException {
        //TODO - Important! Use your state update mechanism here to send the update to the client(s).
    }

    /**
     * Broadcasts an update to a given list of world sessions.
     * @param stateUpdateBuilder The update builder.
     * @param worldID The world ID.
     * @throws IOException thrown when the update cannot be sent.
     */
    public static void broadcastUpdate(StateUpdateBuilder stateUpdateBuilder, String worldID) throws IOException {
        //TODO - Important! Use your state update mechanism here to send the update to the client(s).
    }


}
