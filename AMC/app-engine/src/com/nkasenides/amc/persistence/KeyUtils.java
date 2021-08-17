package com.nkasenides.amc.persistence;

public class KeyUtils {

    public static String getCodeKey(String challengeID, String playerName) {
        return "code-" + challengeID + "-" + playerName;
    }

}
