// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

public interface AMCPartialStateProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.inspirecenter.amazechallenge.proto.AMCPartialStateProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string activePlayers = 1;</code>
   * @return A list containing the activePlayers.
   */
  java.util.List<String>
      getActivePlayersList();
  /**
   * <code>repeated string activePlayers = 1;</code>
   * @return The count of activePlayers.
   */
  int getActivePlayersCount();
  /**
   * <code>repeated string activePlayers = 1;</code>
   * @param index The index of the element to return.
   * @return The activePlayers at the given index.
   */
  String getActivePlayers(int index);
  /**
   * <code>repeated string activePlayers = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the activePlayers at the given index.
   */
  com.google.protobuf.ByteString
      getActivePlayersBytes(int index);

  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCEntityProto&gt; entities = 2;</code>
   */
  int getEntitiesCount();
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCEntityProto&gt; entities = 2;</code>
   */
  boolean containsEntities(
      String key);
  /**
   * Use {@link #getEntitiesMap()} instead.
   */
  @Deprecated
  java.util.Map<String, AMCEntityProto>
  getEntities();
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCEntityProto&gt; entities = 2;</code>
   */
  java.util.Map<String, AMCEntityProto>
  getEntitiesMap();
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCEntityProto&gt; entities = 2;</code>
   */

  AMCEntityProto getEntitiesOrDefault(
      String key,
      AMCEntityProto defaultValue);
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCEntityProto&gt; entities = 2;</code>
   */

  AMCEntityProto getEntitiesOrThrow(
      String key);

  /**
   * <code>.org.inspirecenter.amazechallenge.proto.GridProto grid = 3;</code>
   * @return Whether the grid field is set.
   */
  boolean hasGrid();
  /**
   * <code>.org.inspirecenter.amazechallenge.proto.GridProto grid = 3;</code>
   * @return The grid.
   */
  GridProto getGrid();
  /**
   * <code>.org.inspirecenter.amazechallenge.proto.GridProto grid = 3;</code>
   */
  GridProtoOrBuilder getGridOrBuilder();

  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCPlayerProto&gt; players = 4;</code>
   */
  int getPlayersCount();
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCPlayerProto&gt; players = 4;</code>
   */
  boolean containsPlayers(
      String key);
  /**
   * Use {@link #getPlayersMap()} instead.
   */
  @Deprecated
  java.util.Map<String, AMCPlayerProto>
  getPlayers();
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCPlayerProto&gt; players = 4;</code>
   */
  java.util.Map<String, AMCPlayerProto>
  getPlayersMap();
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCPlayerProto&gt; players = 4;</code>
   */

  AMCPlayerProto getPlayersOrDefault(
      String key,
      AMCPlayerProto defaultValue);
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCPlayerProto&gt; players = 4;</code>
   */

  AMCPlayerProto getPlayersOrThrow(
      String key);

  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCWorldSessionProto&gt; worldSessions = 5;</code>
   */
  int getWorldSessionsCount();
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCWorldSessionProto&gt; worldSessions = 5;</code>
   */
  boolean containsWorldSessions(
      String key);
  /**
   * Use {@link #getWorldSessionsMap()} instead.
   */
  @Deprecated
  java.util.Map<String, AMCWorldSessionProto>
  getWorldSessions();
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCWorldSessionProto&gt; worldSessions = 5;</code>
   */
  java.util.Map<String, AMCWorldSessionProto>
  getWorldSessionsMap();
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCWorldSessionProto&gt; worldSessions = 5;</code>
   */

  AMCWorldSessionProto getWorldSessionsOrDefault(
      String key,
      AMCWorldSessionProto defaultValue);
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCWorldSessionProto&gt; worldSessions = 5;</code>
   */

  AMCWorldSessionProto getWorldSessionsOrThrow(
      String key);

  /**
   * <code>.org.inspirecenter.amazechallenge.proto.AMCWorldSessionProto worldSession = 6;</code>
   * @return Whether the worldSession field is set.
   */
  boolean hasWorldSession();
  /**
   * <code>.org.inspirecenter.amazechallenge.proto.AMCWorldSessionProto worldSession = 6;</code>
   * @return The worldSession.
   */
  AMCWorldSessionProto getWorldSession();
  /**
   * <code>.org.inspirecenter.amazechallenge.proto.AMCWorldSessionProto worldSession = 6;</code>
   */
  AMCWorldSessionProtoOrBuilder getWorldSessionOrBuilder();

  /**
   * <code>repeated string queuedPlayers = 7;</code>
   * @return A list containing the queuedPlayers.
   */
  java.util.List<String>
      getQueuedPlayersList();
  /**
   * <code>repeated string queuedPlayers = 7;</code>
   * @return The count of queuedPlayers.
   */
  int getQueuedPlayersCount();
  /**
   * <code>repeated string queuedPlayers = 7;</code>
   * @param index The index of the element to return.
   * @return The queuedPlayers at the given index.
   */
  String getQueuedPlayers(int index);
  /**
   * <code>repeated string queuedPlayers = 7;</code>
   * @param index The index of the value to return.
   * @return The bytes of the queuedPlayers at the given index.
   */
  com.google.protobuf.ByteString
      getQueuedPlayersBytes(int index);

  /**
   * <code>repeated string waitingPlayers = 8;</code>
   * @return A list containing the waitingPlayers.
   */
  java.util.List<String>
      getWaitingPlayersList();
  /**
   * <code>repeated string waitingPlayers = 8;</code>
   * @return The count of waitingPlayers.
   */
  int getWaitingPlayersCount();
  /**
   * <code>repeated string waitingPlayers = 8;</code>
   * @param index The index of the element to return.
   * @return The waitingPlayers at the given index.
   */
  String getWaitingPlayers(int index);
  /**
   * <code>repeated string waitingPlayers = 8;</code>
   * @param index The index of the value to return.
   * @return The bytes of the waitingPlayers at the given index.
   */
  com.google.protobuf.ByteString
      getWaitingPlayersBytes(int index);

  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCTerrainCellProto&gt; terrain = 9;</code>
   */
  int getTerrainCount();
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCTerrainCellProto&gt; terrain = 9;</code>
   */
  boolean containsTerrain(
      String key);
  /**
   * Use {@link #getTerrainMap()} instead.
   */
  @Deprecated
  java.util.Map<String, AMCTerrainCellProto>
  getTerrain();
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCTerrainCellProto&gt; terrain = 9;</code>
   */
  java.util.Map<String, AMCTerrainCellProto>
  getTerrainMap();
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCTerrainCellProto&gt; terrain = 9;</code>
   */

  AMCTerrainCellProto getTerrainOrDefault(
      String key,
      AMCTerrainCellProto defaultValue);
  /**
   * <code>map&lt;string, .org.inspirecenter.amazechallenge.proto.AMCTerrainCellProto&gt; terrain = 9;</code>
   */

  AMCTerrainCellProto getTerrainOrThrow(
      String key);

  /**
   * <code>uint64 timestamp = 10;</code>
   * @return The timestamp.
   */
  long getTimestamp();
}
