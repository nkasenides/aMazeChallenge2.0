/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 12-08-2021 11:56:05
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package com.nkasenides.amc.client;
import com.nkasenides.amc.model.*;
import com.nkasenides.amc.proto.*;
import com.nkasenides.athlos.client.ServerlessGameClient;


public class AMCClient extends ServerlessGameClient<AMCPartialStateProto, AMCGameSession, AMCWorldSession, AMCPlayer, AMCWorld, AMCEntityProto, AMCTerrainCellProto> {

    public static void main(String[] args) {
        AMCClient client = new AMCClient();
        client.start();
    }


}
