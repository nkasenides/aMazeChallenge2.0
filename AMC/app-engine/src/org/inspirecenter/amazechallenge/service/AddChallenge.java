/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 17-08-2021 12:37:25
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.service;
import org.inspirecenter.amazechallenge.model.AdminKey;
import org.inspirecenter.amazechallenge.model.Challenge;
import org.inspirecenter.amazechallenge.persistence.DBManager;
import com.nkasenides.athlos.backend.AthlosService;
import org.inspirecenter.amazechallenge.proto.AddChallengeRequest;
import org.inspirecenter.amazechallenge.auth.*;
import org.inspirecenter.amazechallenge.proto.AddChallengeResponse;

import java.util.Collection;

public class AddChallenge implements AthlosService<AddChallengeRequest, AddChallengeResponse> {

    @Override    
    public AddChallengeResponse serve(AddChallengeRequest request, Object... additionalParams) {    

        //Validate as admin:
        final AdminKey adminKey = DBManager.adminKey.get();
        if (adminKey == null) {
            return AddChallengeResponse.newBuilder()
                    .setStatus(AddChallengeResponse.Status.SERVER_ERROR)
                    .setMessage("MISSING_ADMIN_KEY")
                    .build();
        }

        final String adminKeyID = adminKey.getId();
        if (!adminKeyID.equals(request.getAdminKey())) {
            return AddChallengeResponse.newBuilder()
                    .setStatus(AddChallengeResponse.Status.INVALID_CREDENTIALS)
                    .setMessage("INVALID_ADMIN_KEY")
                    .build();
        }

        final Challenge challenge = request.getChallenge().toObject();

        //Challenges must start in the future:
        if (challenge.getStartTime() <= System.currentTimeMillis()) {
            return AddChallengeResponse.newBuilder()
                    .setStatus(AddChallengeResponse.Status.INVALID_CHALLENGE)
                    .setMessage("INVALID_START_TIME")
                    .build();
        }

        //Challenges must end after they have started:
        if (challenge.getEndTime() <= challenge.getStartTime()) {
            return AddChallengeResponse.newBuilder()
                    .setStatus(AddChallengeResponse.Status.INVALID_CHALLENGE)
                    .setMessage("INVALID_END_TIME")
                    .build();
        }

        //Challenges must have a minimum number of players > 0:
        if (challenge.getMinActivePlayers() < 0) {
            return AddChallengeResponse.newBuilder()
                    .setStatus(AddChallengeResponse.Status.INVALID_CHALLENGE)
                    .setMessage("INVALID_MIN_ACTIVE_PLAYERS")
                    .build();
        }

        //Challenges must have a maximum number of players that is >= minimum:
        if (challenge.getMaxActivePlayers() < challenge.getMinActivePlayers()) {
            return AddChallengeResponse.newBuilder()
                    .setStatus(AddChallengeResponse.Status.INVALID_CHALLENGE)
                    .setMessage("INVALID_MAX_ACTIVE_PLAYERS")
                    .build();
        }

        //Challenges must have a unique name:
        final Collection<Challenge> challenges = DBManager.challenge.list();
        for (Challenge c : challenges) {
            if (challenge.getName().equals(c.getName())) {
                return AddChallengeResponse.newBuilder()
                        .setStatus(AddChallengeResponse.Status.INVALID_CHALLENGE)
                        .setMessage("CHALLENGE_NAME_EXISTS")
                        .build();
            }
        }

        //Create the challenge:
        DBManager.challenge.create(challenge);
        return AddChallengeResponse.newBuilder()
                .setStatus(AddChallengeResponse.Status.OK)
                .setMessage("OK")
                .build();
    }    
    
}
