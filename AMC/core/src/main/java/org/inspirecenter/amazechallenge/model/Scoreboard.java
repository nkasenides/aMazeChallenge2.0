package org.inspirecenter.amazechallenge.model;

import com.raylabz.firestorm.annotation.FirestormObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@FirestormObject
public class Scoreboard implements Serializable {

    private String id;
    private String challengeID;
    private HashMap<String, Long> entries = new HashMap<>();

    public Scoreboard() {
        this.challengeID = "";
    }

    public Scoreboard(String challengeID) {
        this.challengeID = challengeID;
    }

    public String getChallengeID() {
        return challengeID;
    }

    public void setChallengeID(String challengeID) {
        this.challengeID = challengeID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, Long> getEntries() {
        return entries;
    }

    public void setEntries(HashMap<String, Long> entries) {
        this.entries = entries;
    }

    public void addEntry(String worldSessionID, long exitTime) {
        this.entries.put(worldSessionID, exitTime);
    }

}
