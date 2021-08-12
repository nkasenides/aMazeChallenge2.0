/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 12-08-2021 11:56:05
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package com.nkasenides.amc.model;

import com.nkasenides.athlos.proto.Transmittable;
import com.nkasenides.amc.proto.*;
import com.nkasenides.athlos.model.*;
import com.raylabz.firestorm.annotation.FirestormObject;

@FirestormObject
public class AMCTerrainIdentifier implements Transmittable<AMCTerrainIdentifierProto.Builder> {
    private MatrixPosition chunkPosition;    
    private String worldID;    
    private String id;    
    private String chunkID;    

    public MatrixPosition getChunkPosition() {    
        return chunkPosition;        
    }    
    
    public String getWorldID() {    
        return worldID;        
    }    
    
    public String getId() {    
        return id;        
    }    
    
    public String getChunkID() {    
        return chunkID;        
    }    
    

    public void setChunkPosition(MatrixPosition chunkPosition) {    
        this.chunkPosition = chunkPosition;        
    }    
    
    public void setWorldID(String worldID) {    
        this.worldID = worldID;        
    }    
    
    public void setId(String id) {    
        this.id = id;        
    }    
    
    public void setChunkID(String chunkID) {    
        this.chunkID = chunkID;        
    }    
    

    @Override    
    public com.nkasenides.amc.proto.AMCTerrainIdentifierProto.Builder toProto() {    
        com.nkasenides.amc.proto.AMCTerrainIdentifierProto.Builder protoBuilder = com.nkasenides.amc.proto.AMCTerrainIdentifierProto.newBuilder();        
        protoBuilder.setChunkPosition(chunkPosition.toProto().build());        
        protoBuilder.setWorldID(worldID);        
        protoBuilder.setId(id);        
        protoBuilder.setChunkID(chunkID);        
        return protoBuilder;        
    }    
    

}
