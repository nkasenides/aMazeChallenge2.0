/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 17-08-2021 12:37:25
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.service;
import org.inspirecenter.amazechallenge.model.AMCWorldSession;
import org.inspirecenter.amazechallenge.model.Challenge;
import org.inspirecenter.amazechallenge.model.Health;
import org.inspirecenter.amazechallenge.persistence.DBManager;
import org.inspirecenter.amazechallenge.proto.AMCPlayerProto;
import com.nkasenides.athlos.backend.AthlosService;
import org.inspirecenter.amazechallenge.proto.JoinChallengeRequest;
import org.inspirecenter.amazechallenge.auth.*;
import org.inspirecenter.amazechallenge.proto.JoinChallengeResponse;

import java.util.Collection;

public class JoinChallenge implements AthlosService<JoinChallengeRequest, JoinChallengeResponse> {

    @Override    
    public JoinChallengeResponse serve(JoinChallengeRequest request, Object... additionalParams) {

        final AMCPlayerProto player = request.getPlayer();

        System.out.println(player.getEmail());

        //Player name must not be empty:
        if (player.getName().isEmpty()) {
            return JoinChallengeResponse.newBuilder()
                    .setStatus(JoinChallengeResponse.Status.INVALID_PLAYER)
                    .setMessage("INVALID_PLAYER_NAME")
                    .build();
        }

        //Player name must contain only letters, numbers and underscores:
        if (!player.getName().matches("^[a-zA-Z0-9_]*$")) {
            return JoinChallengeResponse.newBuilder()
                    .setStatus(JoinChallengeResponse.Status.INVALID_PLAYER)
                    .setMessage("INVALID_PLAYER_NAME")
                    .build();
        }

        //Player email must not be empty:
        if (player.getEmail().isEmpty()) {
            return JoinChallengeResponse.newBuilder()
                    .setStatus(JoinChallengeResponse.Status.INVALID_PLAYER)
                    .setMessage("INVALID_PLAYER_EMAIL")
                    .build();
        }

        //Player email must be valid:
        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        if (!player.getEmail().matches(emailRegex)) {
            return JoinChallengeResponse.newBuilder()
                    .setStatus(JoinChallengeResponse.Status.INVALID_PLAYER)
                    .setMessage("INVALID_PLAYER_EMAIL")
                    .build();
        }

        //Challenge ID must not be empty:
        final String challengeID = request.getChallengeID();
        if (challengeID.isEmpty()) {
            return JoinChallengeResponse.newBuilder()
                    .setStatus(JoinChallengeResponse.Status.INVALID_CHALLENGE)
                    .setMessage("INVALID_CHALLENGE_ID")
                    .build();
        }

        //Challenge must exist:
        final Challenge challenge = DBManager.challenge.get(challengeID);
        if (challenge == null) {
            return JoinChallengeResponse.newBuilder()
                    .setStatus(JoinChallengeResponse.Status.INVALID_CHALLENGE)
                    .setMessage("INVALID_CHALLENGE_ID")
                    .build();
        }

        //Challenge must be started:
        if (challenge.getStartTime() > System.currentTimeMillis()) {
            return JoinChallengeResponse.newBuilder()
                    .setStatus(JoinChallengeResponse.Status.CHALLENGE_NOT_STARTED)
                    .setMessage("CHALLENGE_NOT_STARTED")
                    .build();
        }

        //Challenge must not be over:
        if (challenge.getEndTime() < System.currentTimeMillis()) {
            return JoinChallengeResponse.newBuilder()
                    .setStatus(JoinChallengeResponse.Status.CHALLENGE_OVER)
                    .setMessage("CHALLENGE_OVER")
                    .build();
        }

        final Collection<AMCWorldSession> challengeSessions = DBManager.worldSession.listForWorld(challengeID);

        //Challenge must have empty slots:
        if (challengeSessions.size() >= challenge.getMaxActivePlayers()) {
            return JoinChallengeResponse.newBuilder()
                    .setStatus(JoinChallengeResponse.Status.CHALLENGE_FULL)
                    .setMessage("CHALLENGE_FULL")
                    .build();
        }

        //Challenge must not have a player with the same name:
        for (AMCWorldSession challengeSession : challengeSessions) {
            if (challengeSession.getPlayerID().equalsIgnoreCase(player.getName())) {
                return JoinChallengeResponse.newBuilder()
                        .setStatus(JoinChallengeResponse.Status.INVALID_PLAYER)
                        .setMessage("PLAYER_NAME_EXISTS")
                        .build();
            }
        }

        //Create world session:
        AMCWorldSession worldSession = new AMCWorldSession();
        worldSession.setCameraPosition(challenge.getGrid().getStartingPosition());
        worldSession.setWorldID(challengeID);
        worldSession.setCode("");
        worldSession.setHealth(new Health());
        worldSession.setCreatedOn(System.currentTimeMillis());
        worldSession.setExpiresOn(System.currentTimeMillis() + 3600*24); //24h
        worldSession.setIpAddress((String) additionalParams[0]);
        worldSession.setPlayerID(player.getName());
        worldSession.setPoints(0);

        DBManager.worldSession.create(worldSession);
        return JoinChallengeResponse.newBuilder()
                .setStatus(JoinChallengeResponse.Status.OK)
                .setMessage("OK")
                .setChallenge(challenge.toProto())
                .setWorldSession(worldSession.toProto())
                .build();


    }
    
}

