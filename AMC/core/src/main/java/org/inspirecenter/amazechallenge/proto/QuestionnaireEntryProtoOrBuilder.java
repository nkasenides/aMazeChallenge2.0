// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

public interface QuestionnaireEntryProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.inspirecenter.amazechallenge.proto.QuestionnaireEntryProto)
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
   * <code>repeated .org.inspirecenter.amazechallenge.proto.QuestionEntryProto questionEntry = 2;</code>
   */
  java.util.List<QuestionEntryProto>
      getQuestionEntryList();
  /**
   * <code>repeated .org.inspirecenter.amazechallenge.proto.QuestionEntryProto questionEntry = 2;</code>
   */
  QuestionEntryProto getQuestionEntry(int index);
  /**
   * <code>repeated .org.inspirecenter.amazechallenge.proto.QuestionEntryProto questionEntry = 2;</code>
   */
  int getQuestionEntryCount();
  /**
   * <code>repeated .org.inspirecenter.amazechallenge.proto.QuestionEntryProto questionEntry = 2;</code>
   */
  java.util.List<? extends QuestionEntryProtoOrBuilder>
      getQuestionEntryOrBuilderList();
  /**
   * <code>repeated .org.inspirecenter.amazechallenge.proto.QuestionEntryProto questionEntry = 2;</code>
   */
  QuestionEntryProtoOrBuilder getQuestionEntryOrBuilder(
      int index);

  /**
   * <code>string id = 3;</code>
   * @return The id.
   */
  String getId();
  /**
   * <code>string id = 3;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>string participantName = 4;</code>
   * @return The participantName.
   */
  String getParticipantName();
  /**
   * <code>string participantName = 4;</code>
   * @return The bytes for participantName.
   */
  com.google.protobuf.ByteString
      getParticipantNameBytes();

  /**
   * <code>string participantEmail = 5;</code>
   * @return The participantEmail.
   */
  String getParticipantEmail();
  /**
   * <code>string participantEmail = 5;</code>
   * @return The bytes for participantEmail.
   */
  com.google.protobuf.ByteString
      getParticipantEmailBytes();
}
