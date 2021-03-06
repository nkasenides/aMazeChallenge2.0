// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

public interface RequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Request)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.AddChallengeRequest addChallengeRequest = 1;</code>
   * @return Whether the addChallengeRequest field is set.
   */
  boolean hasAddChallengeRequest();
  /**
   * <code>.AddChallengeRequest addChallengeRequest = 1;</code>
   * @return The addChallengeRequest.
   */
  AddChallengeRequest getAddChallengeRequest();
  /**
   * <code>.AddChallengeRequest addChallengeRequest = 1;</code>
   */
  AddChallengeRequestOrBuilder getAddChallengeRequestOrBuilder();

  /**
   * <code>.GetStateRequest getStateRequest = 2;</code>
   * @return Whether the getStateRequest field is set.
   */
  boolean hasGetStateRequest();
  /**
   * <code>.GetStateRequest getStateRequest = 2;</code>
   * @return The getStateRequest.
   */
  GetStateRequest getGetStateRequest();
  /**
   * <code>.GetStateRequest getStateRequest = 2;</code>
   */
  GetStateRequestOrBuilder getGetStateRequestOrBuilder();

  /**
   * <code>.SubscribeRequest subscribeRequest = 3;</code>
   * @return Whether the subscribeRequest field is set.
   */
  boolean hasSubscribeRequest();
  /**
   * <code>.SubscribeRequest subscribeRequest = 3;</code>
   * @return The subscribeRequest.
   */
  SubscribeRequest getSubscribeRequest();
  /**
   * <code>.SubscribeRequest subscribeRequest = 3;</code>
   */
  SubscribeRequestOrBuilder getSubscribeRequestOrBuilder();

  /**
   * <code>.ListChallengesRequest listChallengesRequest = 4;</code>
   * @return Whether the listChallengesRequest field is set.
   */
  boolean hasListChallengesRequest();
  /**
   * <code>.ListChallengesRequest listChallengesRequest = 4;</code>
   * @return The listChallengesRequest.
   */
  ListChallengesRequest getListChallengesRequest();
  /**
   * <code>.ListChallengesRequest listChallengesRequest = 4;</code>
   */
  ListChallengesRequestOrBuilder getListChallengesRequestOrBuilder();

  /**
   * <code>.UnsubscribeRequest unsubscribeRequest = 5;</code>
   * @return Whether the unsubscribeRequest field is set.
   */
  boolean hasUnsubscribeRequest();
  /**
   * <code>.UnsubscribeRequest unsubscribeRequest = 5;</code>
   * @return The unsubscribeRequest.
   */
  UnsubscribeRequest getUnsubscribeRequest();
  /**
   * <code>.UnsubscribeRequest unsubscribeRequest = 5;</code>
   */
  UnsubscribeRequestOrBuilder getUnsubscribeRequestOrBuilder();

  /**
   * <code>.SubmitCodeRequest submitCodeRequest = 6;</code>
   * @return Whether the submitCodeRequest field is set.
   */
  boolean hasSubmitCodeRequest();
  /**
   * <code>.SubmitCodeRequest submitCodeRequest = 6;</code>
   * @return The submitCodeRequest.
   */
  SubmitCodeRequest getSubmitCodeRequest();
  /**
   * <code>.SubmitCodeRequest submitCodeRequest = 6;</code>
   */
  SubmitCodeRequestOrBuilder getSubmitCodeRequestOrBuilder();

  /**
   * <code>.UpdateStateRequest updateStateRequest = 7;</code>
   * @return Whether the updateStateRequest field is set.
   */
  boolean hasUpdateStateRequest();
  /**
   * <code>.UpdateStateRequest updateStateRequest = 7;</code>
   * @return The updateStateRequest.
   */
  UpdateStateRequest getUpdateStateRequest();
  /**
   * <code>.UpdateStateRequest updateStateRequest = 7;</code>
   */
  UpdateStateRequestOrBuilder getUpdateStateRequestOrBuilder();

  /**
   * <code>.JoinChallengeRequest joinChallengeRequest = 8;</code>
   * @return Whether the joinChallengeRequest field is set.
   */
  boolean hasJoinChallengeRequest();
  /**
   * <code>.JoinChallengeRequest joinChallengeRequest = 8;</code>
   * @return The joinChallengeRequest.
   */
  JoinChallengeRequest getJoinChallengeRequest();
  /**
   * <code>.JoinChallengeRequest joinChallengeRequest = 8;</code>
   */
  JoinChallengeRequestOrBuilder getJoinChallengeRequestOrBuilder();

  /**
   * <code>.SubmitQuestionnaireRequest submitQuestionnaireRequest = 9;</code>
   * @return Whether the submitQuestionnaireRequest field is set.
   */
  boolean hasSubmitQuestionnaireRequest();
  /**
   * <code>.SubmitQuestionnaireRequest submitQuestionnaireRequest = 9;</code>
   * @return The submitQuestionnaireRequest.
   */
  SubmitQuestionnaireRequest getSubmitQuestionnaireRequest();
  /**
   * <code>.SubmitQuestionnaireRequest submitQuestionnaireRequest = 9;</code>
   */
  SubmitQuestionnaireRequestOrBuilder getSubmitQuestionnaireRequestOrBuilder();

  public Request.RequestCase getRequestCase();
}
