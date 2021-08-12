/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 12-08-2021 11:56:05
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package com.nkasenides.amc.model;

import java.util.ArrayList;
import java.util.List;
import com.nkasenides.athlos.proto.Transmittable;
import com.nkasenides.amc.proto.*;
import com.nkasenides.athlos.model.*;

public class AMCWorld implements Transmittable<AMCWorldProto.Builder>, IGrid4World {

    public static final WorldType type = WorldType.TILE_HEX;

    private long maxRows;    
    private int heightLimit;    
    private long seed;    
    private String name;    
    private ArrayList<String> chunkIDs = new ArrayList<>();    
    private String id;    
    private String ownerID;    
    private long createdOn;    
    private long maxCols;    
    private ArrayList<String> subscribedSessionIDs = new ArrayList<>();    

    public long getMaxRows() {    
        return maxRows;        
    }    
    
    public int getHeightLimit() {    
        return heightLimit;        
    }    
    
    public long getSeed() {    
        return seed;        
    }    
    
    public String getName() {    
        return name;        
    }    
    
    public List<String> getChunkIDs() {
        return chunkIDs;        
    }    
    
    public String getId() {    
        return id;        
    }    
    
    public String getOwnerID() {    
        return ownerID;        
    }    
    
    public long getCreatedOn() {    
        return createdOn;        
    }    
    
    public long getMaxCols() {    
        return maxCols;        
    }    
    
    public List<String> getSubscribedSessionIDs() {
        return subscribedSessionIDs;        
    }    
    

    public void setMaxRows(long maxRows) {    
        this.maxRows = maxRows;        
    }    
    
    public void setHeightLimit(int heightLimit) {    
        this.heightLimit = heightLimit;        
    }    
    
    public void setSeed(long seed) {    
        this.seed = seed;        
    }    
    
    public void setName(String name) {    
        this.name = name;        
    }    
    
    public void setChunkIDs(ArrayList<String> chunkIDs) {
        this.chunkIDs = chunkIDs;        
    }    
    
    public void setId(String id) {    
        this.id = id;        
    }    
    
    public void setOwnerID(String ownerID) {    
        this.ownerID = ownerID;        
    }    
    
    public void setCreatedOn(long createdOn) {    
        this.createdOn = createdOn;        
    }    
    
    public void setMaxCols(long maxCols) {    
        this.maxCols = maxCols;        
    }    
    
    public void setSubscribedSessionIDs(ArrayList<String> subscribedSessionIDs) {
        this.subscribedSessionIDs = subscribedSessionIDs;        
    }    
    

    @Override    
    public com.nkasenides.amc.proto.AMCWorldProto.Builder toProto() {    
        com.nkasenides.amc.proto.AMCWorldProto.Builder protoBuilder = com.nkasenides.amc.proto.AMCWorldProto.newBuilder();        
        protoBuilder.setMaxRows(maxRows);        
        protoBuilder.setHeightLimit(heightLimit);        
        protoBuilder.setSeed(seed);        
        protoBuilder.setName(name);        
        protoBuilder.addAllChunkIDs(chunkIDs);        
        protoBuilder.setId(id);        
        protoBuilder.setOwnerID(ownerID);        
        protoBuilder.setCreatedOn(createdOn);        
        protoBuilder.setMaxCols(maxCols);        
        protoBuilder.addAllSubscribedSessionIDs(subscribedSessionIDs);        
        return protoBuilder;        
    }    
    
    public final boolean cellIsInBounds(int cellRow, int cellCol) {

        Long maxCellRow = null;
        Long minCellRow = null;
        Long maxCellCol = null;
        Long minCellCol = null;

        if (maxCols >= 1) {
            if (maxCols % 2 == 0) {
                maxCellCol = maxCols / 2;
                minCellCol = -maxCols / 2 + 1;
            }
            else {
                maxCellCol = maxCols / 2;
                minCellCol = -maxCols / 2;
            }
        }

        if (maxRows >= 1) {
            if (maxRows % 2 == 0) {
                maxCellRow = maxRows / 2;
                minCellRow = -maxRows / 2 + 1;
            }
            else {
                maxCellRow = maxRows / 2;
                minCellRow = -maxRows / 2;
            }
        }

        //Limited state initializes min and max for row and col:
        if (maxCellRow != null && maxCellCol != null && minCellRow != null && minCellCol != null) {
            return cellRow >= minCellRow && cellRow <= maxCellRow && cellCol >= minCellCol && cellCol <= maxCellCol;
        }
        //Unlimited state will not initialize any of these, return true because everything falls within bounds:
        else {
            return true;
        }
    }

    public final boolean cellIsInBounds(final MatrixPosition cellPosition) {
        return cellIsInBounds(cellPosition.getRow(), cellPosition.getCol());
    }

    public final boolean chunkIsInBounds(int chunkRow, int chunkCol) {
        final int startRow = AMCTerrainChunk.getChunkStartRowFromChunkRow(chunkRow);
        final int lastRow = AMCTerrainChunk.getChunkLastRowFromChunkRow(chunkRow);
        final int startCol = AMCTerrainChunk.getChunkStartColFromChunkCol(chunkCol);
        final int lastCol = AMCTerrainChunk.getChunkLastColFromChunkCol(chunkCol);
        for (int row = startRow; row <= lastRow; row++) {
            for (int col = startCol; col <= lastCol; col++) {
                if (cellIsInBounds(row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean hasChunk(final String chunkID) {
        for (final String id : chunkIDs) {
            if (id.equals(chunkID)) {
                return true;
            }
        }
        return false;
    }
    public final void addChunk(final String chunkID) {
        if (!hasChunk(chunkID)) {
            this.chunkIDs.add(chunkID);
        }
    }


}
