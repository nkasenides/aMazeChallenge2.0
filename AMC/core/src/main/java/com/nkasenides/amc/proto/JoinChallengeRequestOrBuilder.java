// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

public interface JoinChallengeRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.nkasenides.amc.proto.JoinChallengeRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string challengeID = 1;</code>
   * @return The challengeID.
   */
  String getChallengeID();
  /**
   * <code>string challengeID = 1;</code>
   * @return The bytes for challengeID.
   */
  com.google.protobuf.ByteString
      getChallengeIDBytes();

  /**
   * <code>.com.nkasenides.amc.proto.AMCPlayerProto player = 2;</code>
   * @return Whether the player field is set.
   */
  boolean hasPlayer();
  /**
   * <code>.com.nkasenides.amc.proto.AMCPlayerProto player = 2;</code>
   * @return The player.
   */
  AMCPlayerProto getPlayer();
  /**
   * <code>.com.nkasenides.amc.proto.AMCPlayerProto player = 2;</code>
   */
  AMCPlayerProtoOrBuilder getPlayerOrBuilder();
}
