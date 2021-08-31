/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 20-08-2021 17:28:40
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.inspirecenter.amazechallenge.controller.AudioEventListener;
import org.inspirecenter.amazechallenge.controller.GameEndListener;
import com.nkasenides.athlos.proto.Transmittable;
import org.inspirecenter.amazechallenge.proto.*;
import org.inspirecenter.amazechallenge.proto.*;

public class Game implements Transmittable<GameProto.Builder>, Serializable {
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

    public void addPlayer(final AMCPlayer player, AMCWorldSession worldSession) {
        final String playerId = player.getId();
        allPlayers.put(playerId, player);
        playerWorldSessions.put(playerId, worldSession);
        finishedPlayers.remove(playerId);
        queuedPlayers.remove(playerId);
        if(!waitingPlayers.contains(playerId)) waitingPlayers.add(playerId);
    }

    public boolean resetPlayerById(final String playerId) {
        boolean existed = finishedPlayers.remove(playerId);
        if(queuedPlayers.remove(playerId)) existed = true;
        if(!waitingPlayers.contains(playerId)) waitingPlayers.add(playerId);

        //Reset:
        playerWorldSessions.get(playerId).setHealth(new Health());
        playerWorldSessions.get(playerId).setPoints(0);
        return existed;
    }

    public boolean queuePlayerById(final String playerId) {
        if(waitingPlayers.contains(playerId)) {
            waitingPlayers.remove(playerId);
            queuedPlayers.add(playerId); // adds to the end of the 'queue'
            return true;
        } else {
            return false;
        }
    }

    public boolean activateNextPlayer(final Grid grid) {
        if(!queuedPlayers.isEmpty()) {
            final String nextPlayerId = queuedPlayers.remove(0); // get first in line from 'queued'
            activePlayers.add(nextPlayerId);
            final AMCWorldSession worldSession = getPlayerWorldSessions().get(nextPlayerId);
            worldSession.setHealth(new Health());

            AMCPlayer player = allPlayers.get(nextPlayerId);

            //Upon activation, also create the player's entity, and place it in playerEntities:
            if (player != null) {
                PlayerEntity playerEntity = new PlayerEntity();
                playerEntity.setAreaOfInterest(0);
                playerEntity.setDirection(grid.getStartingDirection());
                playerEntity.setId("");
                playerEntity.setPlayerID(player.getId());
                playerEntity.setPosition(grid.getStartingPosition());
                playerEntity.setWorldID(worldSession.getWorldID());
                playerEntities.put(player.getId(), playerEntity);
            }

            return true;
        } else {
            return false;
        }
    }

    public void resetPickables() {
        pickables.clear();
    }

    public void touch(final long lastExecutionTime) {
        this.lastExecutionTime = lastExecutionTime;
        lastUpdated = System.currentTimeMillis();
        counter++;
    }
    

}
