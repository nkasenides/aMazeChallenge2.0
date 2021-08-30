// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

public interface GameProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GameProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string finishedPlayers = 1;</code>
   * @return A list containing the finishedPlayers.
   */
  java.util.List<String>
      getFinishedPlayersList();
  /**
   * <code>repeated string finishedPlayers = 1;</code>
   * @return The count of finishedPlayers.
   */
  int getFinishedPlayersCount();
  /**
   * <code>repeated string finishedPlayers = 1;</code>
   * @param index The index of the element to return.
   * @return The finishedPlayers at the given index.
   */
  String getFinishedPlayers(int index);
  /**
   * <code>repeated string finishedPlayers = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the finishedPlayers at the given index.
   */
  com.google.protobuf.ByteString
      getFinishedPlayersBytes(int index);

  /**
   * <code>repeated string activePlayers = 2;</code>
   * @return A list containing the activePlayers.
   */
  java.util.List<String>
      getActivePlayersList();
  /**
   * <code>repeated string activePlayers = 2;</code>
   * @return The count of activePlayers.
   */
  int getActivePlayersCount();
  /**
   * <code>repeated string activePlayers = 2;</code>
   * @param index The index of the element to return.
   * @return The activePlayers at the given index.
   */
  String getActivePlayers(int index);
  /**
   * <code>repeated string activePlayers = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the activePlayers at the given index.
   */
  com.google.protobuf.ByteString
      getActivePlayersBytes(int index);

  /**
   * <code>repeated .PickableEntityProto pickables = 3;</code>
   */
  java.util.List<PickableEntityProto>
      getPickablesList();
  /**
   * <code>repeated .PickableEntityProto pickables = 3;</code>
   */
  PickableEntityProto getPickables(int index);
  /**
   * <code>repeated .PickableEntityProto pickables = 3;</code>
   */
  int getPickablesCount();
  /**
   * <code>repeated .PickableEntityProto pickables = 3;</code>
   */
  java.util.List<? extends PickableEntityProtoOrBuilder>
      getPickablesOrBuilderList();
  /**
   * <code>repeated .PickableEntityProto pickables = 3;</code>
   */
  PickableEntityProtoOrBuilder getPickablesOrBuilder(
      int index);

  /**
   * <code>repeated string queuedPlayers = 4;</code>
   * @return A list containing the queuedPlayers.
   */
  java.util.List<String>
      getQueuedPlayersList();
  /**
   * <code>repeated string queuedPlayers = 4;</code>
   * @return The count of queuedPlayers.
   */
  int getQueuedPlayersCount();
  /**
   * <code>repeated string queuedPlayers = 4;</code>
   * @param index The index of the element to return.
   * @return The queuedPlayers at the given index.
   */
  String getQueuedPlayers(int index);
  /**
   * <code>repeated string queuedPlayers = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the queuedPlayers at the given index.
   */
  com.google.protobuf.ByteString
      getQueuedPlayersBytes(int index);

  /**
   * <code>uint64 counter = 5;</code>
   * @return The counter.
   */
  long getCounter();

  /**
   * <code>repeated string waitingPlayers = 6;</code>
   * @return A list containing the waitingPlayers.
   */
  java.util.List<String>
      getWaitingPlayersList();
  /**
   * <code>repeated string waitingPlayers = 6;</code>
   * @return The count of waitingPlayers.
   */
  int getWaitingPlayersCount();
  /**
   * <code>repeated string waitingPlayers = 6;</code>
   * @param index The index of the element to return.
   * @return The waitingPlayers at the given index.
   */
  String getWaitingPlayers(int index);
  /**
   * <code>repeated string waitingPlayers = 6;</code>
   * @param index The index of the value to return.
   * @return The bytes of the waitingPlayers at the given index.
   */
  com.google.protobuf.ByteString
      getWaitingPlayersBytes(int index);

  /**
   * <code>map&lt;string, .AMCPlayerProto&gt; allPlayers = 7;</code>
   */
  int getAllPlayersCount();
  /**
   * <code>map&lt;string, .AMCPlayerProto&gt; allPlayers = 7;</code>
   */
  boolean containsAllPlayers(
      String key);
  /**
   * Use {@link #getAllPlayersMap()} instead.
   */
  @Deprecated
  java.util.Map<String, AMCPlayerProto>
  getAllPlayers();
  /**
   * <code>map&lt;string, .AMCPlayerProto&gt; allPlayers = 7;</code>
   */
  java.util.Map<String, AMCPlayerProto>
  getAllPlayersMap();
  /**
   * <code>map&lt;string, .AMCPlayerProto&gt; allPlayers = 7;</code>
   */

  AMCPlayerProto getAllPlayersOrDefault(
      String key,
      AMCPlayerProto defaultValue);
  /**
   * <code>map&lt;string, .AMCPlayerProto&gt; allPlayers = 7;</code>
   */

  AMCPlayerProto getAllPlayersOrThrow(
      String key);

  /**
   * <code>uint64 lastUpdated = 8;</code>
   * @return The lastUpdated.
   */
  long getLastUpdated();

  /**
   * <code>string challengeID = 9;</code>
   * @return The challengeID.
   */
  String getChallengeID();
  /**
   * <code>string challengeID = 9;</code>
   * @return The bytes for challengeID.
   */
  com.google.protobuf.ByteString
      getChallengeIDBytes();

  /**
   * <code>map&lt;string, .PlayerEntityProto&gt; playerEntities = 10;</code>
   */
  int getPlayerEntitiesCount();
  /**
   * <code>map&lt;string, .PlayerEntityProto&gt; playerEntities = 10;</code>
   */
  boolean containsPlayerEntities(
      String key);
  /**
   * Use {@link #getPlayerEntitiesMap()} instead.
   */
  @Deprecated
  java.util.Map<String, PlayerEntityProto>
  getPlayerEntities();
  /**
   * <code>map&lt;string, .PlayerEntityProto&gt; playerEntities = 10;</code>
   */
  java.util.Map<String, PlayerEntityProto>
  getPlayerEntitiesMap();
  /**
   * <code>map&lt;string, .PlayerEntityProto&gt; playerEntities = 10;</code>
   */

  PlayerEntityProto getPlayerEntitiesOrDefault(
      String key,
      PlayerEntityProto defaultValue);
  /**
   * <code>map&lt;string, .PlayerEntityProto&gt; playerEntities = 10;</code>
   */

  PlayerEntityProto getPlayerEntitiesOrThrow(
      String key);

  /**
   * <code>string id = 11;</code>
   * @return The id.
   */
  String getId();
  /**
   * <code>string id = 11;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>uint64 lastExecutionTime = 12;</code>
   * @return The lastExecutionTime.
   */
  long getLastExecutionTime();

  /**
   * <code>map&lt;string, .AMCWorldSessionProto&gt; playerWorldSessions = 13;</code>
   */
  int getPlayerWorldSessionsCount();
  /**
   * <code>map&lt;string, .AMCWorldSessionProto&gt; playerWorldSessions = 13;</code>
   */
  boolean containsPlayerWorldSessions(
      String key);
  /**
   * Use {@link #getPlayerWorldSessionsMap()} instead.
   */
  @Deprecated
  java.util.Map<String, AMCWorldSessionProto>
  getPlayerWorldSessions();
  /**
   * <code>map&lt;string, .AMCWorldSessionProto&gt; playerWorldSessions = 13;</code>
   */
  java.util.Map<String, AMCWorldSessionProto>
  getPlayerWorldSessionsMap();
  /**
   * <code>map&lt;string, .AMCWorldSessionProto&gt; playerWorldSessions = 13;</code>
   */

  AMCWorldSessionProto getPlayerWorldSessionsOrDefault(
      String key,
      AMCWorldSessionProto defaultValue);
  /**
   * <code>map&lt;string, .AMCWorldSessionProto&gt; playerWorldSessions = 13;</code>
   */

  AMCWorldSessionProto getPlayerWorldSessionsOrThrow(
      String key);
}