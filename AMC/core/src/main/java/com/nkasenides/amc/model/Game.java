/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 20-08-2021 17:28:40
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package com.nkasenides.amc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.nkasenides.amc.controller.AudioEventListener;
import com.nkasenides.amc.controller.GameEndListener;
import com.nkasenides.athlos.proto.Transmittable;
import com.nkasenides.athlos.proto.GenericTransmittable;
import com.nkasenides.amc.proto.*;
import com.nkasenides.athlos.model.*;

public class Game implements Transmittable<GameProto.Builder> {
    private ArrayList<String> finishedPlayers = new ArrayList<>();    
    private ArrayList<String> activePlayers = new ArrayList<>();    
    private ArrayList<PickableEntity> pickables = new ArrayList<>();    
    private ArrayList<String> queuedPlayers = new ArrayList<>();    
    private long counter;    
    private ArrayList<String> waitingPlayers = new ArrayList<>();    
    private HashMap<String, AMCPlayer> allPlayers = new HashMap<>();
    private long lastUpdated;    
    private String challengeID;    
    private HashMap<String, PlayerEntity> playerEntities = new HashMap<>();
    private String id;    
    private long lastExecutionTime;    
    private HashMap<String, AMCWorldSession> playerWorldSessions = new HashMap<>();

    public List<String> getFinishedPlayers() {
        return finishedPlayers;        
    }    
    
    public List<String> getActivePlayers() {
        return activePlayers;        
    }    
    
    public List<PickableEntity> getPickables() {
        return pickables;        
    }    
    
    public List<String> getQueuedPlayers() {
        return queuedPlayers;        
    }    
    
    public long getCounter() {    
        return counter;        
    }    
    
    public List<String> getWaitingPlayers() {
        return waitingPlayers;        
    }    
    
    public Map<String, AMCPlayer> getAllPlayers() {
        return allPlayers;        
    }    
    
    public long getLastUpdated() {    
        return lastUpdated;        
    }    
    
    public String getChallengeID() {    
        return challengeID;        
    }    
    
    public Map<String, PlayerEntity> getPlayerEntities() {
        return playerEntities;        
    }    
    
    public String getId() {    
        return id;        
    }    
    
    public long getLastExecutionTime() {    
        return lastExecutionTime;        
    }    
    
    public Map<String, AMCWorldSession> getPlayerWorldSessions() {
        return playerWorldSessions;        
    }    
    

    public void setFinishedPlayers(ArrayList<String> finishedPlayers) {
        this.finishedPlayers = finishedPlayers;        
    }    
    
    public void setActivePlayers(ArrayList<String> activePlayers) {
        this.activePlayers = activePlayers;        
    }    
    
    public void setPickables(ArrayList<PickableEntity> pickables) {
        this.pickables = pickables;        
    }    
    
    public void setQueuedPlayers(ArrayList<String> queuedPlayers) {
        this.queuedPlayers = queuedPlayers;        
    }    
    
    public void setCounter(long counter) {    
        this.counter = counter;        
    }    
    
    public void setWaitingPlayers(ArrayList<String> waitingPlayers) {
        this.waitingPlayers = waitingPlayers;        
    }    
    
    public void setAllPlayers(HashMap<String, AMCPlayer> allPlayers) {
        this.allPlayers = allPlayers;        
    }    
    
    public void setLastUpdated(long lastUpdated) {    
        this.lastUpdated = lastUpdated;        
    }    
    
    public void setChallengeID(String challengeID) {    
        this.challengeID = challengeID;        
    }    
    
    public void setPlayerEntities(HashMap<String, PlayerEntity> playerEntities) {
        this.playerEntities = playerEntities;        
    }    
    
    public void setId(String id) {    
        this.id = id;        
    }    
    
    public void setLastExecutionTime(long lastExecutionTime) {    
        this.lastExecutionTime = lastExecutionTime;        
    }    
    
    public void setPlayerWorldSessions(HashMap<String, AMCWorldSession> playerWorldSessions) {
        this.playerWorldSessions = playerWorldSessions;        
    }    
    

    @Override    
    public GameProto.Builder toProto() {
        GameProto.Builder protoBuilder = GameProto.newBuilder();
        protoBuilder.addAllFinishedPlayers(finishedPlayers);        
        protoBuilder.addAllActivePlayers(activePlayers);        
        ArrayList<PickableEntityProto> pickablesList = new ArrayList<>();
        for (int i = 0; i < pickables.size(); i++) {        
            pickablesList.add(pickables.get(i).toProto().build());            
        }        
        protoBuilder.addAllPickables(pickablesList);        
        protoBuilder.addAllQueuedPlayers(queuedPlayers);        
        protoBuilder.setCounter(counter);        
        protoBuilder.addAllWaitingPlayers(waitingPlayers);        
        HashMap<String, AMCPlayerProto> allPlayersMap = new HashMap<>();
        for (Map.Entry<String, AMCPlayer> entry : allPlayers.entrySet()) {
            allPlayersMap.put(entry.getKey(), entry.getValue().toProto().build());            
        }        
        protoBuilder.getAllPlayersMap().putAll(allPlayersMap);        
        protoBuilder.setLastUpdated(lastUpdated);        
        protoBuilder.setChallengeID(challengeID);        
        HashMap<String, PlayerEntityProto> playerEntitiesMap = new HashMap<>();
        for (Map.Entry<String, PlayerEntity> entry : playerEntities.entrySet()) {
            playerEntitiesMap.put(entry.getKey(), entry.getValue().toProto().build());            
        }        
        protoBuilder.getPlayerEntitiesMap().putAll(playerEntitiesMap);        
        protoBuilder.setId(id);        
        protoBuilder.setLastExecutionTime(lastExecutionTime);        
        HashMap<String, AMCWorldSessionProto> playerWorldSessionsMap = new HashMap<>();
        for (Map.Entry<String, AMCWorldSession> entry : playerWorldSessions.entrySet()) {
            playerWorldSessionsMap.put(entry.getKey(), entry.getValue().toProto().build());            
        }        
        protoBuilder.getPlayerWorldSessionsMap().putAll(playerWorldSessionsMap);        
        return protoBuilder;        
    }

    /**-----------------------------------------------------------------------------------------------------------------*/

    public AMCPlayer getPlayerByID(String playerID) {
        return allPlayers.get(playerID);
    }

    public boolean resetPlayerById(final String playerId) {
        boolean existed = false;
        if (finishedPlayers.remove(playerId)) existed = true;
        if (activePlayers.remove(playerId)) existed = true;
        if (queuedPlayers.remove(playerId)) existed = true;
        if (!waitingPlayers.contains(playerId)) waitingPlayers.add(playerId);

        final AMCWorldSession worldSession = getPlayerWorldSessions().get(playerId);

        //Reset:
        worldSession.setHealth(new Health());
        worldSession.setPoints(0);
        return existed;
    }

    private AudioEventListener audioEventListener = null;
    private GameEndListener gameEndListener = null;

    public void setOnAudioEventListener(AudioEventListener audioEventListener) {
        this.audioEventListener = audioEventListener;
    }

    public AudioEventListener getAudioEventListener() {
        return audioEventListener;
    }

    public void setGameEndListener(GameEndListener gameEndListener) {
        this.gameEndListener = gameEndListener;
    }

    public GameEndListener getGameEndListener() { return gameEndListener; }

    public void removePickupItem(int i) {
        pickables.remove(i);
    }

    public int getNumOfBiasType(final Bias biasType) {
        int count = 0;
        for(final PickableEntity pickable : pickables) {
            if(pickable.getPickableType().getBias() == biasType) count++;
        }
        return count;
    }

    public void addPickableItem(final PickableEntity pickable) {
        this.pickables.add(pickable);
    }
    

}
