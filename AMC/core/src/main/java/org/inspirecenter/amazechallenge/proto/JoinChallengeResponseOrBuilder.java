// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

public interface JoinChallengeResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:JoinChallengeResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ChallengeProto challenge = 1;</code>
   * @return Whether the challenge field is set.
   */
  boolean hasChallenge();
  /**
   * <code>.ChallengeProto challenge = 1;</code>
   * @return The challenge.
   */
  ChallengeProto getChallenge();
  /**
   * <code>.ChallengeProto challenge = 1;</code>
   */
  ChallengeProtoOrBuilder getChallengeOrBuilder();

  /**
   * <code>.AMCWorldSessionProto worldSession = 2;</code>
   * @return Whether the worldSession field is set.
   */
  boolean hasWorldSession();
  /**
   * <code>.AMCWorldSessionProto worldSession = 2;</code>
   * @return The worldSession.
   */
  AMCWorldSessionProto getWorldSession();
  /**
   * <code>.AMCWorldSessionProto worldSession = 2;</code>
   */
  AMCWorldSessionProtoOrBuilder getWorldSessionOrBuilder();

  /**
   * <code>string message = 3;</code>
   * @return The message.
   */
  String getMessage();
  /**
   * <code>string message = 3;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>.JoinChallengeResponse.Status status = 4;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.JoinChallengeResponse.Status status = 4;</code>
   * @return The status.
   */
  JoinChallengeResponse.Status getStatus();
}
