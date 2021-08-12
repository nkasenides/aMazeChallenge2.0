// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

public interface GridProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.nkasenides.amc.proto.GridProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.nkasenides.amc.proto.Direction4 startingDirection = 1;</code>
   * @return The enum numeric value on the wire for startingDirection.
   */
  int getStartingDirectionValue();
  /**
   * <code>.com.nkasenides.amc.proto.Direction4 startingDirection = 1;</code>
   * @return The startingDirection.
   */
  com.nkasenides.amc.proto.Direction4 getStartingDirection();

  /**
   * <code>string data = 2;</code>
   * @return The data.
   */
  java.lang.String getData();
  /**
   * <code>string data = 2;</code>
   * @return The bytes for data.
   */
  com.google.protobuf.ByteString
      getDataBytes();

  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
   * @return Whether the targetPosition field is set.
   */
  boolean hasTargetPosition();
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
   * @return The targetPosition.
   */
  com.nkasenides.amc.proto.MatrixPositionProto getTargetPosition();
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
   */
  com.nkasenides.amc.proto.MatrixPositionProtoOrBuilder getTargetPositionOrBuilder();

  /**
   * <code>int32 width = 4;</code>
   * @return The width.
   */
  int getWidth();

  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
   * @return Whether the startingPosition field is set.
   */
  boolean hasStartingPosition();
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
   * @return The startingPosition.
   */
  com.nkasenides.amc.proto.MatrixPositionProto getStartingPosition();
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
   */
  com.nkasenides.amc.proto.MatrixPositionProtoOrBuilder getStartingPositionOrBuilder();

  /**
   * <code>int32 height = 6;</code>
   * @return The height.
   */
  int getHeight();
}
