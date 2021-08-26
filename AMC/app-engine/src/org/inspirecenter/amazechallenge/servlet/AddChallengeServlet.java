/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 17-08-2021 12:37:25
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.servlet;

import org.apache.commons.lang3.builder.Diff;
import org.inspirecenter.amazechallenge.model.AdminKey;
import org.inspirecenter.amazechallenge.model.Challenge;
import org.inspirecenter.amazechallenge.model.Grid;
import org.inspirecenter.amazechallenge.model.MatrixPosition;
import org.inspirecenter.amazechallenge.persistence.DBManager;
import org.inspirecenter.amazechallenge.proto.*;
import org.inspirecenter.amazechallenge.service.Services;
import com.nkasenides.athlos.exception.ServiceNotFoundException;
import com.nkasenides.athlos.serverless.servlet.AthlosServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.stream.Collectors;

public class AddChallengeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        HashMap<String, String> parametersMap = new HashMap<>();

        String[] paramsStr = body.split("&");
        for (String paramStr : paramsStr) {
            final String[] paramItems = paramStr.split("=");
            final String paramKey = paramItems[0];
            if (paramItems.length > 1) {
                final String paramValue = paramItems[1];
                parametersMap.put(paramKey, paramValue);
            }
            else {
                parametersMap.put(paramKey, "");
            }

        }

        System.out.println(parametersMap);

        final String adminKey = parametersMap.get("adminKey");

        final AdminKey adminKeyServer = DBManager.adminKey.get();
        if (!adminKeyServer.getId().equals(adminKey)) {
            resp.getWriter().write("Error: Invalid admin key");
            return;
        }


        final String name = parametersMap.get("name");
        final String description = parametersMap.get("description");
        final Algorithm algorithm = Algorithm.valueOf(parametersMap.get("algorithm"));
        final int apiVersion = Integer.parseInt(parametersMap.get("apiVersion"));
        final boolean canJoinAfterStart = Boolean.parseBoolean(parametersMap.get("canJoinAfterStart"));
        final boolean canRepeat = Boolean.parseBoolean(parametersMap.get("canRepeat"));
        final boolean canStepOnEachOther = Boolean.parseBoolean(parametersMap.get("canStepOnEachOther"));
        final long createdOn = Long.parseLong(parametersMap.get("createdOn"));
        final String createdByID = parametersMap.get("createdByID");
        final long endTime = Long.parseLong(parametersMap.get("endTime"));
        final Difficulty difficulty = Difficulty.valueOf(parametersMap.get("difficulty"));
        final String lineColor = parametersMap.get("lineColor");
        final int maxActivePlayers = Integer.parseInt(parametersMap.get("maxActivePlayers"));
        final int minActivePlayers = Integer.parseInt(parametersMap.get("minActivePlayers"));
        final PickableIntensity rewards = PickableIntensity.valueOf(parametersMap.get("rewards"));
        final PickableIntensity penalties = PickableIntensity.valueOf(parametersMap.get("penalties"));
        final boolean hasQuestionnaire = Boolean.parseBoolean(parametersMap.get("hasQuestionnaire"));
        final BackgroundImage backgroundImage = BackgroundImage.valueOf(parametersMap.get("backgroundImage"));
        final Audio backgroundAudio = Audio.valueOf(parametersMap.get("backgroundAudio"));
        final int gridSize = Integer.parseInt(parametersMap.get("gridSize"));
        final Direction4 gridStartingDirection = Direction4.valueOf(parametersMap.get("gridStartingDirection"));
        final MatrixPosition gridStartingPosition = new MatrixPosition(Integer.parseInt(parametersMap.get("gridStartingPositionRow")), Integer.parseInt(parametersMap.get("gridStartingPositionCol")));
        final MatrixPosition gridTargetPosition = new MatrixPosition(Integer.parseInt(parametersMap.get("gridTargetPositionRow")), Integer.parseInt(parametersMap.get("gridTargetPositionCol")));
        final String gridData = parametersMap.get("gridData");
        final long startTime = Long.parseLong(parametersMap.get("startTime"));

        Grid grid = new Grid();
        grid.setData(gridData);
        grid.setWidth(gridSize);
        grid.setHeight(gridSize);
        grid.setStartingDirection(gridStartingDirection);
        grid.setStartingPosition(gridStartingPosition);
        grid.setTargetPosition(gridTargetPosition);

        Challenge challenge = new Challenge();
        challenge.setAlgorithm(algorithm);
        challenge.setApiVersion(apiVersion);
        challenge.setBackgroundAudio(backgroundAudio);
        challenge.setBackgroundImage(backgroundImage);
        challenge.setCanJoinAfterStart(canJoinAfterStart);
        challenge.setCanRepeat(canRepeat);
        challenge.setCanStepOnEachOther(canStepOnEachOther);
        challenge.setCreatedByID(createdByID);
        challenge.setCreatedOn(System.currentTimeMillis());
        challenge.setDescription(description);
        challenge.setDifficulty(difficulty);
        challenge.setEndTime(endTime);
        challenge.setGrid(grid);
        challenge.setHasQuestionnaire(hasQuestionnaire);
        challenge.setLineColor(lineColor);
        challenge.setMaxActivePlayers(maxActivePlayers);
        challenge.setMinActivePlayers(minActivePlayers);
        challenge.setPenalties(penalties);
        challenge.setName(name);
        challenge.setRewards(rewards);
        challenge.setStartTime(startTime);

        final boolean result = DBManager.challenge.create(challenge);
        if (result) {
            resp.getWriter().write("OK");
        }
        else {
            resp.getWriter().write("Error: Could not create challenge.");
        }


    }
}

//public class AddChallengeServlet extends AthlosServlet {
//
//    @Override
//    protected byte[] callProcessMethod(HttpServletRequest servletRequest, HttpServletResponse servletResponse, DataInputStream inputStream) throws ServiceNotFoundException, IOException {
//        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//        int nRead;
//        byte[] data = new byte[16384];
//        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
//            buffer.write(data, 0, nRead);
//        }
//        final Object[] additionalParameters = {
//              servletRequest.getRemoteAddr(),
//        };
//        return Services.addChallenge(buffer.toByteArray(), additionalParameters).toByteArray();
//    }
//
//}
