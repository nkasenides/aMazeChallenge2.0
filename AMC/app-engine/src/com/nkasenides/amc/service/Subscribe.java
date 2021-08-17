/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 17-08-2021 12:37:25
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package com.nkasenides.amc.service;
import com.nkasenides.amc.model.AMCWorldSession;
import com.nkasenides.amc.proto.SubmitQuestionnaireResponse;
import com.nkasenides.amc.state.State;
import com.nkasenides.athlos.backend.AthlosService;
import com.nkasenides.amc.proto.SubscribeRequest;
import com.nkasenides.amc.auth.*;
import com.nkasenides.amc.proto.SubscribeResponse;

public class Subscribe implements AthlosService<SubscribeRequest, SubscribeResponse> {

    @Override    
    public SubscribeResponse serve(SubscribeRequest request, Object... additionalParams) {

        //Check world session ID:
        if (request.getWorldSessionID().isEmpty()) {
            return SubscribeResponse.newBuilder()
                    .setStatus(SubscribeResponse.Status.NO_SUCH_WORLD_SESSION)
                    .setMessage("NO_SUCH_WORLD_SESSION")
                    .build();
        }

        //Verify world session:
        final AMCWorldSession worldSession = Auth.verifyWorldSessionID(request.getWorldSessionID());
        if (worldSession == null) {
            return SubscribeResponse.newBuilder()
                    .setStatus(SubscribeResponse.Status.NO_SUCH_WORLD_SESSION)
                    .setMessage("NO_SUCH_WORLD_SESSION")
                    .build();
        }

        //Add as subscribed:
        State.forWorld(worldSession.getWorldID()).subscribe(worldSession);

        return SubscribeResponse.newBuilder()
                .setStatus(SubscribeResponse.Status.OK)
                .setMessage("OK")
                .build();
    }    
    
}

