/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 12-08-2021 11:56:05
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.persistence;


import com.nkasenides.athlos.persistence.*;
import org.inspirecenter.amazechallenge.model.*;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.firestorm.QueryResult;
import org.inspirecenter.amazechallenge.model.AMCTerrainChunk;

import java.util.Collection;


public class AMCTerrainChunkDAO implements WorldBasedDAO<AMCTerrainChunk> {


    @Override
    public boolean create(AMCTerrainChunk object) {
        return Firestorm.create(object) != null;
    }

    @Override
    public boolean update(AMCTerrainChunk object) {
        Firestorm.update(object);
        return true;
    }

    @Override
    public boolean delete(AMCTerrainChunk object) {
        Firestorm.delete(object);
        return true;
    }

    @Override
    public AMCTerrainChunk get(String itemID) {
        return Firestorm.get(AMCTerrainChunk.class, itemID);
    }

    @Override
    public AMCTerrainChunk getForWorld(String worldID, String itemID) {
        final QueryResult<AMCTerrainChunk> result = Firestorm.filter(AMCTerrainChunk.class)
                .whereEqualTo("worldID", worldID)
                .whereEqualTo("id", itemID)
                .limit(1)
                .fetch();
        if (result.hasItems()) {
            return result.getItems().get(0);
        }
        return null;
    }

    @Override
    public Collection<AMCTerrainChunk> listForWorld(String worldID) {
        return Firestorm.filter(AMCTerrainChunk.class)
                .whereEqualTo("worldID", worldID)
                .fetch()
                .getItems();
    }

}

