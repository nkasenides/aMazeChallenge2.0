// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

public interface AMCWorldProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.nkasenides.amc.proto.AMCWorldProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>sint64 maxRows = 1;</code>
   * @return The maxRows.
   */
  long getMaxRows();

  /**
   * <code>uint32 heightLimit = 2;</code>
   * @return The heightLimit.
   */
  int getHeightLimit();

  /**
   * <code>sint64 seed = 3;</code>
   * @return The seed.
   */
  long getSeed();

  /**
   * <code>.com.nkasenides.amc.proto.GridProto grid = 4;</code>
   * @return Whether the grid field is set.
   */
  boolean hasGrid();
  /**
   * <code>.com.nkasenides.amc.proto.GridProto grid = 4;</code>
   * @return The grid.
   */
  GridProto getGrid();
  /**
   * <code>.com.nkasenides.amc.proto.GridProto grid = 4;</code>
   */
  GridProtoOrBuilder getGridOrBuilder();

  /**
   * <code>string name = 5;</code>
   * @return The name.
   */
  String getName();
  /**
   * <code>string name = 5;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>repeated string chunkIDs = 6;</code>
   * @return A list containing the chunkIDs.
   */
  java.util.List<String>
      getChunkIDsList();
  /**
   * <code>repeated string chunkIDs = 6;</code>
   * @return The count of chunkIDs.
   */
  int getChunkIDsCount();
  /**
   * <code>repeated string chunkIDs = 6;</code>
   * @param index The index of the element to return.
   * @return The chunkIDs at the given index.
   */
  String getChunkIDs(int index);
  /**
   * <code>repeated string chunkIDs = 6;</code>
   * @param index The index of the value to return.
   * @return The bytes of the chunkIDs at the given index.
   */
  com.google.protobuf.ByteString
      getChunkIDsBytes(int index);

  /**
   * <code>string id = 7;</code>
   * @return The id.
   */
  String getId();
  /**
   * <code>string id = 7;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>string ownerID = 8;</code>
   * @return The ownerID.
   */
  String getOwnerID();
  /**
   * <code>string ownerID = 8;</code>
   * @return The bytes for ownerID.
   */
  com.google.protobuf.ByteString
      getOwnerIDBytes();

  /**
   * <code>uint64 createdOn = 9;</code>
   * @return The createdOn.
   */
  long getCreatedOn();

  /**
   * <code>sint64 maxCols = 10;</code>
   * @return The maxCols.
   */
  long getMaxCols();

  /**
   * <code>repeated string subscribedSessionIDs = 11;</code>
   * @return A list containing the subscribedSessionIDs.
   */
  java.util.List<String>
      getSubscribedSessionIDsList();
  /**
   * <code>repeated string subscribedSessionIDs = 11;</code>
   * @return The count of subscribedSessionIDs.
   */
  int getSubscribedSessionIDsCount();
  /**
   * <code>repeated string subscribedSessionIDs = 11;</code>
   * @param index The index of the element to return.
   * @return The subscribedSessionIDs at the given index.
   */
  String getSubscribedSessionIDs(int index);
  /**
   * <code>repeated string subscribedSessionIDs = 11;</code>
   * @param index The index of the value to return.
   * @return The bytes of the subscribedSessionIDs at the given index.
   */
  com.google.protobuf.ByteString
      getSubscribedSessionIDsBytes(int index);
}
