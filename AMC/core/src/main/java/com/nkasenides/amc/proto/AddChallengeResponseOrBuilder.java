// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

public interface AddChallengeResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.nkasenides.amc.proto.AddChallengeResponse)
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
   * <code>.com.nkasenides.amc.proto.AddChallengeResponse.Status status = 2;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.com.nkasenides.amc.proto.AddChallengeResponse.Status status = 2;</code>
   * @return The status.
   */
  AddChallengeResponse.Status getStatus();
}
