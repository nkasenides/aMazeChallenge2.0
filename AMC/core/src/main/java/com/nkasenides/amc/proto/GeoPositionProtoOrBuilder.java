// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

public interface GeoPositionProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.nkasenides.amc.proto.GeoPositionProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>float x = 1;</code>
   * @return The x.
   */
  float getX();

  /**
   * <code>float y = 2;</code>
   * @return The y.
   */
  float getY();

  /**
   * <code>float z = 3;</code>
   * @return The z.
   */
  float getZ();

  /**
   * <code>string positionHash = 4;</code>
   * @return The positionHash.
   */
  java.lang.String getPositionHash();
  /**
   * <code>string positionHash = 4;</code>
   * @return The bytes for positionHash.
   */
  com.google.protobuf.ByteString
      getPositionHashBytes();
}
