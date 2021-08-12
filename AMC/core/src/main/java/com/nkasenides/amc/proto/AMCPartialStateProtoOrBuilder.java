// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

public interface AMCPartialStateProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.nkasenides.amc.proto.AMCPartialStateProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCEntityProto&gt; entities = 1;</code>
   */
  int getEntitiesCount();
  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCEntityProto&gt; entities = 1;</code>
   */
  boolean containsEntities(
      java.lang.String key);
  /**
   * Use {@link #getEntitiesMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, com.nkasenides.amc.proto.AMCEntityProto>
  getEntities();
  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCEntityProto&gt; entities = 1;</code>
   */
  java.util.Map<java.lang.String, com.nkasenides.amc.proto.AMCEntityProto>
  getEntitiesMap();
  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCEntityProto&gt; entities = 1;</code>
   */

  com.nkasenides.amc.proto.AMCEntityProto getEntitiesOrDefault(
      java.lang.String key,
      com.nkasenides.amc.proto.AMCEntityProto defaultValue);
  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCEntityProto&gt; entities = 1;</code>
   */

  com.nkasenides.amc.proto.AMCEntityProto getEntitiesOrThrow(
      java.lang.String key);

  /**
   * <code>.com.nkasenides.amc.proto.AMCWorldSessionProto worldSession = 2;</code>
   * @return Whether the worldSession field is set.
   */
  boolean hasWorldSession();
  /**
   * <code>.com.nkasenides.amc.proto.AMCWorldSessionProto worldSession = 2;</code>
   * @return The worldSession.
   */
  com.nkasenides.amc.proto.AMCWorldSessionProto getWorldSession();
  /**
   * <code>.com.nkasenides.amc.proto.AMCWorldSessionProto worldSession = 2;</code>
   */
  com.nkasenides.amc.proto.AMCWorldSessionProtoOrBuilder getWorldSessionOrBuilder();

  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; terrain = 3;</code>
   */
  int getTerrainCount();
  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; terrain = 3;</code>
   */
  boolean containsTerrain(
      java.lang.String key);
  /**
   * Use {@link #getTerrainMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, com.nkasenides.amc.proto.AMCTerrainCellProto>
  getTerrain();
  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; terrain = 3;</code>
   */
  java.util.Map<java.lang.String, com.nkasenides.amc.proto.AMCTerrainCellProto>
  getTerrainMap();
  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; terrain = 3;</code>
   */

  com.nkasenides.amc.proto.AMCTerrainCellProto getTerrainOrDefault(
      java.lang.String key,
      com.nkasenides.amc.proto.AMCTerrainCellProto defaultValue);
  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; terrain = 3;</code>
   */

  com.nkasenides.amc.proto.AMCTerrainCellProto getTerrainOrThrow(
      java.lang.String key);

  /**
   * <code>uint64 timestamp = 4;</code>
   * @return The timestamp.
   */
  long getTimestamp();
}
