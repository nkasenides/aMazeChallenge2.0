/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 12-08-2021 11:56:05
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.auth;
import org.inspirecenter.amazechallenge.model.AMCWorldSession;
import org.inspirecenter.amazechallenge.persistence.*;
import org.inspirecenter.amazechallenge.persistence.DBManager;

public final class Auth {

//    public static AMCPlayer verifyGameSessionID(final String gameSessionID) {
//        return DBManager.gameSession.getPlayer(gameSessionID);
//    }

    public static AMCWorldSession verifyWorldSessionID(final String worldSessionID) {
        return DBManager.worldSession.get(worldSessionID);
    }

}
