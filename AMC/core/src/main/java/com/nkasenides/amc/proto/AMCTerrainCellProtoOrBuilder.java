// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

public interface AMCTerrainCellProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.nkasenides.amc.proto.AMCTerrainCellProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 1;</code>
   * @return Whether the position field is set.
   */
  boolean hasPosition();
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 1;</code>
   * @return The position.
   */
  com.nkasenides.amc.proto.MatrixPositionProto getPosition();
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 1;</code>
   */
  com.nkasenides.amc.proto.MatrixPositionProtoOrBuilder getPositionOrBuilder();

  /**
   * <code>bool rightWall = 2;</code>
   * @return The rightWall.
   */
  boolean getRightWall();

  /**
   * <code>bool downWall = 3;</code>
   * @return The downWall.
   */
  boolean getDownWall();

  /**
   * <code>bool upWall = 4;</code>
   * @return The upWall.
   */
  boolean getUpWall();

  /**
   * <code>bool leftWall = 5;</code>
   * @return The leftWall.
   */
  boolean getLeftWall();
}
