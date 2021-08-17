// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

public interface AMCStateUpdateProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.nkasenides.amc.proto.AMCStateUpdateProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.nkasenides.amc.proto.AMCPartialStateProto partialState = 1;</code>
   * @return Whether the partialState field is set.
   */
  boolean hasPartialState();
  /**
   * <code>.com.nkasenides.amc.proto.AMCPartialStateProto partialState = 1;</code>
   * @return The partialState.
   */
  AMCPartialStateProto getPartialState();
  /**
   * <code>.com.nkasenides.amc.proto.AMCPartialStateProto partialState = 1;</code>
   */
  AMCPartialStateProtoOrBuilder getPartialStateOrBuilder();

  /**
   * <code>string worldSessionID = 2;</code>
   * @return The worldSessionID.
   */
  String getWorldSessionID();
  /**
   * <code>string worldSessionID = 2;</code>
   * @return The bytes for worldSessionID.
   */
  com.google.protobuf.ByteString
      getWorldSessionIDBytes();

  /**
   * <code>repeated string removedEntities = 3;</code>
   * @return A list containing the removedEntities.
   */
  java.util.List<String>
      getRemovedEntitiesList();
  /**
   * <code>repeated string removedEntities = 3;</code>
   * @return The count of removedEntities.
   */
  int getRemovedEntitiesCount();
  /**
   * <code>repeated string removedEntities = 3;</code>
   * @param index The index of the element to return.
   * @return The removedEntities at the given index.
   */
  String getRemovedEntities(int index);
  /**
   * <code>repeated string removedEntities = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the removedEntities at the given index.
   */
  com.google.protobuf.ByteString
      getRemovedEntitiesBytes(int index);

  /**
   * <code>repeated string removedTerrain = 4;</code>
   * @return A list containing the removedTerrain.
   */
  java.util.List<String>
      getRemovedTerrainList();
  /**
   * <code>repeated string removedTerrain = 4;</code>
   * @return The count of removedTerrain.
   */
  int getRemovedTerrainCount();
  /**
   * <code>repeated string removedTerrain = 4;</code>
   * @param index The index of the element to return.
   * @return The removedTerrain at the given index.
   */
  String getRemovedTerrain(int index);
  /**
   * <code>repeated string removedTerrain = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the removedTerrain at the given index.
   */
  com.google.protobuf.ByteString
      getRemovedTerrainBytes(int index);

  /**
   * <code>uint64 timestamp = 5;</code>
   * @return The timestamp.
   */
  long getTimestamp();
}
