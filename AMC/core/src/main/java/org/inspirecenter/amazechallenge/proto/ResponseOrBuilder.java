// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

public interface ResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Response)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.SubmitQuestionnaireResponse submitQuestionnaireResponse = 1;</code>
   * @return Whether the submitQuestionnaireResponse field is set.
   */
  boolean hasSubmitQuestionnaireResponse();
  /**
   * <code>.SubmitQuestionnaireResponse submitQuestionnaireResponse = 1;</code>
   * @return The submitQuestionnaireResponse.
   */
  SubmitQuestionnaireResponse getSubmitQuestionnaireResponse();
  /**
   * <code>.SubmitQuestionnaireResponse submitQuestionnaireResponse = 1;</code>
   */
  SubmitQuestionnaireResponseOrBuilder getSubmitQuestionnaireResponseOrBuilder();

  /**
   * <code>.GetStateResponse getStateResponse = 2;</code>
   * @return Whether the getStateResponse field is set.
   */
  boolean hasGetStateResponse();
  /**
   * <code>.GetStateResponse getStateResponse = 2;</code>
   * @return The getStateResponse.
   */
  GetStateResponse getGetStateResponse();
  /**
   * <code>.GetStateResponse getStateResponse = 2;</code>
   */
  GetStateResponseOrBuilder getGetStateResponseOrBuilder();

  /**
   * <code>.JoinChallengeResponse joinChallengeResponse = 3;</code>
   * @return Whether the joinChallengeResponse field is set.
   */
  boolean hasJoinChallengeResponse();
  /**
   * <code>.JoinChallengeResponse joinChallengeResponse = 3;</code>
   * @return The joinChallengeResponse.
   */
  JoinChallengeResponse getJoinChallengeResponse();
  /**
   * <code>.JoinChallengeResponse joinChallengeResponse = 3;</code>
   */
  JoinChallengeResponseOrBuilder getJoinChallengeResponseOrBuilder();

  /**
   * <code>.UpdateStateResponse updateStateResponse = 4;</code>
   * @return Whether the updateStateResponse field is set.
   */
  boolean hasUpdateStateResponse();
  /**
   * <code>.UpdateStateResponse updateStateResponse = 4;</code>
   * @return The updateStateResponse.
   */
  UpdateStateResponse getUpdateStateResponse();
  /**
   * <code>.UpdateStateResponse updateStateResponse = 4;</code>
   */
  UpdateStateResponseOrBuilder getUpdateStateResponseOrBuilder();

  /**
   * <code>.SubmitCodeResponse submitCodeResponse = 5;</code>
   * @return Whether the submitCodeResponse field is set.
   */
  boolean hasSubmitCodeResponse();
  /**
   * <code>.SubmitCodeResponse submitCodeResponse = 5;</code>
   * @return The submitCodeResponse.
   */
  SubmitCodeResponse getSubmitCodeResponse();
  /**
   * <code>.SubmitCodeResponse submitCodeResponse = 5;</code>
   */
  SubmitCodeResponseOrBuilder getSubmitCodeResponseOrBuilder();

  /**
   * <code>.SubscribeResponse subscribeResponse = 6;</code>
   * @return Whether the subscribeResponse field is set.
   */
  boolean hasSubscribeResponse();
  /**
   * <code>.SubscribeResponse subscribeResponse = 6;</code>
   * @return The subscribeResponse.
   */
  SubscribeResponse getSubscribeResponse();
  /**
   * <code>.SubscribeResponse subscribeResponse = 6;</code>
   */
  SubscribeResponseOrBuilder getSubscribeResponseOrBuilder();

  /**
   * <code>.UnsubscribeResponse unsubscribeResponse = 7;</code>
   * @return Whether the unsubscribeResponse field is set.
   */
  boolean hasUnsubscribeResponse();
  /**
   * <code>.UnsubscribeResponse unsubscribeResponse = 7;</code>
   * @return The unsubscribeResponse.
   */
  UnsubscribeResponse getUnsubscribeResponse();
  /**
   * <code>.UnsubscribeResponse unsubscribeResponse = 7;</code>
   */
  UnsubscribeResponseOrBuilder getUnsubscribeResponseOrBuilder();

  /**
   * <code>.ListChallengesResponse listChallengesResponse = 8;</code>
   * @return Whether the listChallengesResponse field is set.
   */
  boolean hasListChallengesResponse();
  /**
   * <code>.ListChallengesResponse listChallengesResponse = 8;</code>
   * @return The listChallengesResponse.
   */
  ListChallengesResponse getListChallengesResponse();
  /**
   * <code>.ListChallengesResponse listChallengesResponse = 8;</code>
   */
  ListChallengesResponseOrBuilder getListChallengesResponseOrBuilder();

  /**
   * <code>.AddChallengeResponse addChallengeResponse = 9;</code>
   * @return Whether the addChallengeResponse field is set.
   */
  boolean hasAddChallengeResponse();
  /**
   * <code>.AddChallengeResponse addChallengeResponse = 9;</code>
   * @return The addChallengeResponse.
   */
  AddChallengeResponse getAddChallengeResponse();
  /**
   * <code>.AddChallengeResponse addChallengeResponse = 9;</code>
   */
  AddChallengeResponseOrBuilder getAddChallengeResponseOrBuilder();

  public Response.ResponseCase getResponseCase();
}