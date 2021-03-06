/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 12-08-2021 11:56:05
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.client;
import com.google.protobuf.InvalidProtocolBufferException;
import com.nkasenides.athlos.client.ServerlessGameClient;
import com.raylabz.javahttp.OnFailureListener;
import io.ably.lib.realtime.AblyRealtime;
import io.ably.lib.realtime.Channel;
import io.ably.lib.types.AblyException;
import io.ably.lib.types.Message;
import org.inspirecenter.amazechallenge.client.stubs.ListChallenges;
import org.inspirecenter.amazechallenge.client.stubs.Stubs;
import org.inspirecenter.amazechallenge.model.*;
import org.inspirecenter.amazechallenge.proto.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class SimulationClient extends ServerlessGameClient<AMCPartialStateProto, AMCGameSession, AMCWorldSession, AMCPlayer, AMCWorld, AMCEntityProto, AMCTerrainCellProto> {

    private final Simulation simulation;
    private final String name;
    private final String installationID = UUID.randomUUID().toString();

    private List<ChallengeProto> challenges;
    private ChallengeProto selectedChallenge;
    private AMCWorldSessionProto worldSession;
    private boolean codeSubmitted = false;
    private boolean finished = false;

    private static final ConcurrentHashMap<String, Vector<Long>> latencies = new ConcurrentHashMap<>();

    public SimulationClient(Simulation simulation, String name) {
        this.name = name;
        this.simulation = simulation;
        AMCPlayerProto player = AMCPlayerProto.newBuilder()
                .setId(name)
                .setName(name)
                .setEmail(name + "@simulation.com")
                .setCreatedOn(System.currentTimeMillis())
                .setPassword("")
                .setTeamID("")
                .setColor(selectRandomColor())
                .setIcon(selectRandomIcon())
                .build();
        setPlayer(player.toObject());
    }

    @Override
    protected void onStart() {
        new Thread(() -> {
            System.out.println("'" + name + "' started");
            listAvailableChallenges();
            selectChallenge();
            joinChallenge();
            submitCode();
            updateState();
        }).start();
    }

    private void listAvailableChallenges() {
        final ListChallenges stub = Stubs.listChallengesStub(this);
        if (stub == null) {
            System.err.println(name + "  --- NULL STUB! ---");
        }
        stub.sendAndWait(
                ListChallengesRequest.newBuilder()
                        .build(),
                listChallengesResponse -> {
                    if (listChallengesResponse.getStatus() == ListChallengesResponse.Status.OK) {
                        challenges = listChallengesResponse.getChallengesList();
                    }
                    else {
                        System.err.println("[ERROR]");
                        System.err.println(listChallengesResponse.getMessage());
                        stop();
                    }
                }
        );
    }

    private void selectChallenge() {
        if (challenges == null) {
            System.err.println("[ERROR]");
            System.err.println("No challenges available.");
            stop();
        }
        else {
            selectedChallenge = challenges.get(0);
        }
    }

    private void joinChallenge() {
        if (selectedChallenge == null) {
            System.err.println("[ERROR]");
            System.err.println("No selected challenge.");
            stop();
        }
        else {
            Stubs.joinChallengeStub(this).sendAndWait(
                    JoinChallengeRequest.newBuilder()
                            .setChallengeID(selectedChallenge.getId())
                            .setPlayer(getPlayer().toProto())
                            .setInstallationID(installationID)
                            .build(),
                    joinChallengeResponse -> {
                        if (joinChallengeResponse.getStatus() == JoinChallengeResponse.Status.OK) {
                             this.worldSession = joinChallengeResponse.getWorldSession();
                        }
                        else {
                            System.err.println("[ERROR]");
                            System.err.println(joinChallengeResponse.getMessage());
                            stop();
                        }
                    }
            );
        }
    }

    private void submitCode() {
        final String playerCode = Code.getRandomCode();
        Stubs.submitCodeStub(this).sendAndWait(
                SubmitCodeRequest.newBuilder()
                        .setCode(playerCode)
                        .setWorldSessionID(worldSession.getId())
                        .build(),
                submitCodeResponse -> {
                    if (submitCodeResponse.getStatus() == SubmitCodeResponse.Status.OK) {
                        System.out.println("'" + name + "' submitted code.");
                        this.codeSubmitted = true;
                        getState();
                    }
                    else {
                        System.err.println("[ERROR]");
                        System.err.println(submitCodeResponse.getMessage());
                    }
                }
        );
    }

    private void getState() {
        if (codeSubmitted) {
            Stubs.getStateStub(this).sendAndWait(
                    GetStateRequest.newBuilder()
                            .setWorldSessionID(worldSession.getId())
                            .build(),
                    getStateResponse -> {
                        if (getStateResponse.getStatus() == GetStateResponse.Status.OK) {
//                            this.state = getStateResponse.getPartialState();
                        } else {
                            System.err.println("[ERROR]");
                            System.err.println(getStateResponse.getMessage());
                        }
                    },
                    new OnFailureListener() {
                        @Override
                        public void onFailure(Throwable error) {
                            System.err.println("Error in get state");
                            System.err.println(error.getMessage());
                        }
                    }
            );
        }
    }

    private void updateState() {

        boolean[] gameEnd = new boolean[1];
        latencies.put(name, new Vector<>());
        do {
            long timeSent = System.currentTimeMillis();
            Stubs.updateStateStub(this).sendAndWait(
                    UpdateStateRequest.newBuilder()
                            .setWorldSessionID(worldSession.getId())
                            .build(),
                    updateStateResponse -> {

                        //Performance
                        long latency = System.currentTimeMillis() - timeSent;
                        final Vector<Long> latencies = SimulationClient.latencies.get(name);
                        latencies.add(latency);
                        SimulationClient.latencies.put(name, latencies);

                        if (updateStateResponse.getStatus() == UpdateStateResponse.Status.OK) {
                            final AMCStateUpdateProto stateUpdate = updateStateResponse.getStateUpdate();
                            if (stateUpdate.getEventsList().contains(Audio.EVENT_LOSE_Audio) || stateUpdate.getEventsList().contains(Audio.EVENT_WIN_Audio)) {
                                gameEnd[0] = true;
                            }
                        } else {
                            System.err.println("[ERROR]");
                            System.err.println(updateStateResponse.getMessage());
                        }
                    },
                    new OnFailureListener() {
                        @Override
                        public void onFailure(Throwable error) {
                            System.err.println("Error in update state");
                            System.err.println(error.getMessage());
                        }
                    }
            );
            //1s delay between updates:
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!gameEnd[0]);
        leaveChallenge();

//        try {
//            AblyRealtime ably = new AblyRealtime("KC5T5A.vG4G5Q:kpD9gGw44EERYqI-");
//            Channel channel = ably.channels.get("stateUpdate-" + worldSession.getPlayerID());
//            Channel.MessageListener listener = message -> {
//
//                byte[] responseData = (byte[]) message.data;
//                try {
//                    UpdateStateResponse updateStateResponse = UpdateStateResponse.parseFrom(responseData);
//                    if (updateStateResponse.getStatus() == UpdateStateResponse.Status.OK) {
//                        final AMCStateUpdateProto stateUpdate = updateStateResponse.getStateUpdate();
//                        if (stateUpdate.getEventsList().contains(Audio.EVENT_LOSE_Audio) || stateUpdate.getEventsList().contains(Audio.EVENT_WIN_Audio)) {
//                            leaveChallenge();
//                        }
//                    } else {
//                        System.err.println("[ERROR]");
//                        System.err.println(updateStateResponse.getMessage());
//                    }
//                } catch (InvalidProtocolBufferException e) {
//                    e.printStackTrace();
//                }
//            };
//            channel.subscribe("stateUpdate", listener);
//        } catch (AblyException e) {
//            e.printStackTrace();
//        }



    }

    private void leaveChallenge() {
        Stubs.leaveChallengeStub(this).sendAndWait(
                LeaveChallengeRequest.newBuilder()
                        .setChallengeID(selectedChallenge.getId())
                        .setWorldSessionID(worldSession.getId())
                        .build(),
                leaveChallengeResponse -> {
                    if (leaveChallengeResponse.getStatus() == LeaveChallengeResponse.Status.OK) {

                        synchronized (SimulationClient.class) {
                            finished = true;
                            System.out.println(name + " finished!");

                            double average = 0;
                            int latencyEntries = 0;
                            for (Map.Entry<String, Vector<Long>> entry : SimulationClient.latencies.entrySet()) {
                                for (Long latency : entry.getValue()) {
                                    average += latency;
                                    latencyEntries++;
                                }
                            }
                            average = average / (double) latencyEntries;

                            System.out.println("Average latency so far (ms): " + average);

                            boolean allClientsFinished = true;
                            for (SimulationClient client : simulation.getClients()) {
                                if (!client.finished) {
                                    allClientsFinished = false;
                                    break;
                                }
                            }

                            if (allClientsFinished) {
                                System.out.println("Simulation finished!");
                                simulation.setEndTime(System.currentTimeMillis());

                                System.out.println("Number of players: " + simulation.getNumOfPlayers());
                                System.out.println("Simulation duration (ms): " + (simulation.getEndTime() - simulation.getStartTime()));
                                System.exit(0);
                            }
                        }


                        stop();
                    } else {
                        System.err.println("[ERROR]");
                        System.err.println(leaveChallengeResponse.getMessage());
                    }
                },
                error -> error.printStackTrace()
        );
    }

    private AmazeColor selectRandomColor() {
        Random random = new Random();
        final int randomIndex = random.nextInt(AmazeColor.values().length);
        if (AmazeColor.values()[randomIndex] == AmazeColor.UNRECOGNIZED) {
            return AmazeColor.BLACK_AmazeColor;
        }
        else {
            return AmazeColor.values()[randomIndex];
        }
    }

    private AmazeIcon selectRandomIcon() {
        Random random = new Random();
        final int randomIndex = random.nextInt(AmazeIcon.values().length);
        if (AmazeIcon.values()[randomIndex] == AmazeIcon.UNRECOGNIZED) {
            return AmazeIcon.ICON_1_AmazeIcon;
        }
        else {
            return AmazeIcon.values()[randomIndex];
        }
    }

}
