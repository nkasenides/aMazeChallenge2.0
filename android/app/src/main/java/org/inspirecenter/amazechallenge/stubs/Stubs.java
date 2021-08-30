/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 17-08-2021 12:37:25
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.stubs;

import java.util.HashMap;

public final class Stubs {

    public static final String BASE_URL = "http://10.0.2.2:8080";
    
    public static class Actions {    
    }    
    
    

    private static final HashMap<String, SubmitQuestionnaire> submitQuestionnaireStubMap = new HashMap<>();
    public static SubmitQuestionnaire submitQuestionnaireStub(AMCClient client) {
        if (submitQuestionnaireStubMap.get(client.getPlayer().getId()) == null) {
                final SubmitQuestionnaire stub = new SubmitQuestionnaire();
                submitQuestionnaireStubMap.put(client.getPlayer().getId(), stub);
        }
        return submitQuestionnaireStubMap.get(client.getPlayer().getId());
    }
    
    
    

    private static final HashMap<String, ListChallenges> listChallengesStubMap = new HashMap<>();
    public static ListChallenges listChallengesStub(AMCClient client) {
        if (listChallengesStubMap.get(client.getPlayer().getId()) == null) {
                final ListChallenges stub = new ListChallenges();
                listChallengesStubMap.put(client.getPlayer().getId(), stub);
        }
        return listChallengesStubMap.get(client.getPlayer().getId());
    }
    
    
    

    private static final HashMap<String, SubmitCode> submitCodeStubMap = new HashMap<>();
    public static SubmitCode submitCodeStub(AMCClient client) {
        if (submitCodeStubMap.get(client.getPlayer().getId()) == null) {
                final SubmitCode stub = new SubmitCode();
                submitCodeStubMap.put(client.getPlayer().getId(), stub);
        }
        return submitCodeStubMap.get(client.getPlayer().getId());
    }
    
    
    

    private static final HashMap<String, JoinChallenge> joinChallengeStubMap = new HashMap<>();
    public static JoinChallenge joinChallengeStub(AMCClient client) {
        if (joinChallengeStubMap.get(client.getPlayer().getId()) == null) {
                final JoinChallenge stub = new JoinChallenge();
                joinChallengeStubMap.put(client.getPlayer().getId(), stub);
        }
        return joinChallengeStubMap.get(client.getPlayer().getId());
    }
    
    
    

    private static final HashMap<String, GetState> getStateStubMap = new HashMap<>();
    public static GetState getStateStub(AMCClient client) {
        if (getStateStubMap.get(client.getPlayer().getId()) == null) {
                final GetState stub = new GetState();
                getStateStubMap.put(client.getPlayer().getId(), stub);
        }
        return getStateStubMap.get(client.getPlayer().getId());
    }
    
    
    

    private static final HashMap<String, UpdateState> updateStateStubMap = new HashMap<>();
    public static UpdateState updateStateStub(AMCClient client) {
        if (updateStateStubMap.get(client.getPlayer().getId()) == null) {
                final UpdateState stub = new UpdateState();
                updateStateStubMap.put(client.getPlayer().getId(), stub);
        }
        return updateStateStubMap.get(client.getPlayer().getId());
    }
    
    
    

    private static final HashMap<String, Subscribe> subscribeStubMap = new HashMap<>();
    public static Subscribe subscribeStub(AMCClient client) {
        if (subscribeStubMap.get(client.getPlayer().getId()) == null) {
                final Subscribe stub = new Subscribe();
                subscribeStubMap.put(client.getPlayer().getId(), stub);
        }
        return subscribeStubMap.get(client.getPlayer().getId());
    }
    
    
    

    private static final HashMap<String, Unsubscribe> unsubscribeStubMap = new HashMap<>();
    public static Unsubscribe unsubscribeStub(AMCClient client) {
        if (unsubscribeStubMap.get(client.getPlayer().getId()) == null) {
                final Unsubscribe stub = new Unsubscribe();
                unsubscribeStubMap.put(client.getPlayer().getId(), stub);
        }
        return unsubscribeStubMap.get(client.getPlayer().getId());
    }
    
    
    

    private static final HashMap<String, AddChallenge> addChallengeStubMap = new HashMap<>();
    public static AddChallenge addChallengeStub(AMCClient client) {
        if (addChallengeStubMap.get(client.getPlayer().getId()) == null) {
                final AddChallenge stub = new AddChallenge();
                addChallengeStubMap.put(client.getPlayer().getId(), stub);
        }
        return addChallengeStubMap.get(client.getPlayer().getId());
    }
    
    

}