// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

public interface LeaveChallengeResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.inspirecenter.amazechallenge.proto.LeaveChallengeResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string message = 1;</code>
   * @return The message.
   */
  String getMessage();
  /**
   * <code>string message = 1;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>.org.inspirecenter.amazechallenge.proto.LeaveChallengeResponse.Status status = 2;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.org.inspirecenter.amazechallenge.proto.LeaveChallengeResponse.Status status = 2;</code>
   * @return The status.
   */
  LeaveChallengeResponse.Status getStatus();
}