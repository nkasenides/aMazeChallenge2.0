/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 17-08-2021 12:37:25
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.stubs;


import com.nkasenides.amc.proto.*;
import com.nkasenides.athlos.client.stubs.OnRequestSuccessListener;
import com.raylabz.javahttp.BinaryHTTPRequest;
import com.raylabz.javahttp.OnFailureListener;
public class ListChallenges {

    private final String url = Stubs.BASE_URL + "/api/challenge/list";

    public void sendAndWait(ListChallengesRequest request, OnRequestSuccessListener<ListChallengesResponse> successListener, OnFailureListener failureListener) {
        BinaryHTTPRequest.create(url)
                .onSuccess(response -> {
                    final byte[] content = response.getContent();
                    final ListChallengesResponse protoResponse = ListChallengesResponse.parseFrom(content);
                    successListener.onSuccess(protoResponse);
                })
                .onFailure(failureListener)
                .putBytes(request.toByteArray())
                .build()
                .sendAndWait();
    }

    public void send(ListChallengesRequest request, OnRequestSuccessListener<ListChallengesResponse> successListener, OnFailureListener failureListener) {
        BinaryHTTPRequest.create(url)
                .onSuccess(response -> {
                    final byte[] content = response.getContent();
                    final ListChallengesResponse protoResponse = ListChallengesResponse.parseFrom(content);
                    successListener.onSuccess(protoResponse);
                })
                .onFailure(failureListener)
                .putBytes(request.toByteArray())
                .build()
                .send();
    }

    public void sendAndWait(ListChallengesRequest request, OnRequestSuccessListener<ListChallengesResponse> successListener) {
        BinaryHTTPRequest.create(url)
                .onSuccess(response -> {
                    final byte[] content = response.getContent();
                    final ListChallengesResponse protoResponse = ListChallengesResponse.parseFrom(content);
                    successListener.onSuccess(protoResponse);
                })
                .putBytes(request.toByteArray())
                .build()
                .sendAndWait();
    }

    public void send(ListChallengesRequest request, OnRequestSuccessListener<ListChallengesResponse> successListener) {
        BinaryHTTPRequest.create(url)
                .onSuccess(response -> {
                    final byte[] content = response.getContent();
                    final ListChallengesResponse protoResponse = ListChallengesResponse.parseFrom(content);
                    successListener.onSuccess(protoResponse);
                })
                .putBytes(request.toByteArray())
                .build()
                .send();
    }
}

