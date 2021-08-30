// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

public interface AMCTerrainChunkProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:AMCTerrainChunkProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>string worldID = 2;</code>
   * @return The worldID.
   */
  String getWorldID();
  /**
   * <code>string worldID = 2;</code>
   * @return The bytes for worldID.
   */
  com.google.protobuf.ByteString
      getWorldIDBytes();

  /**
   * <code>.MatrixPositionProto position = 3;</code>
   * @return Whether the position field is set.
   */
  boolean hasPosition();
  /**
   * <code>.MatrixPositionProto position = 3;</code>
   * @return The position.
   */
  MatrixPositionProto getPosition();
  /**
   * <code>.MatrixPositionProto position = 3;</code>
   */
  MatrixPositionProtoOrBuilder getPositionOrBuilder();

  /**
   * <code>map&lt;string, .AMCTerrainCellProto&gt; cells = 4;</code>
   */
  int getCellsCount();
  /**
   * <code>map&lt;string, .AMCTerrainCellProto&gt; cells = 4;</code>
   */
  boolean containsCells(
      String key);
  /**
   * Use {@link #getCellsMap()} instead.
   */
  @Deprecated
  java.util.Map<String, AMCTerrainCellProto>
  getCells();
  /**
   * <code>map&lt;string, .AMCTerrainCellProto&gt; cells = 4;</code>
   */
  java.util.Map<String, AMCTerrainCellProto>
  getCellsMap();
  /**
   * <code>map&lt;string, .AMCTerrainCellProto&gt; cells = 4;</code>
   */

  AMCTerrainCellProto getCellsOrDefault(
      String key,
      AMCTerrainCellProto defaultValue);
  /**
   * <code>map&lt;string, .AMCTerrainCellProto&gt; cells = 4;</code>
   */

  AMCTerrainCellProto getCellsOrThrow(
      String key);
}