/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 17-08-2021 12:37:25
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.servlet.admin;

import org.inspirecenter.amazechallenge.model.AdminKey;
import org.inspirecenter.amazechallenge.model.Challenge;
import org.inspirecenter.amazechallenge.model.Grid;
import org.inspirecenter.amazechallenge.model.MatrixPosition;
import org.inspirecenter.amazechallenge.persistence.DBManager;
import org.inspirecenter.amazechallenge.proto.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.stream.Collectors;

public class EditChallengeServlet extends HttpServlet {
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

//        System.out.println(parametersMap);

        final String adminKey = parametersMap.get("adminKey");

        final AdminKey adminKeyServer = DBManager.adminKey.get();
        if (!adminKeyServer.getId().equals(adminKey)) {
            resp.getWriter().write("Error: Invalid admin key");
            return;
        }

        final String id = parametersMap.get("id");

        if (id == null || id.isEmpty()) {
            resp.getWriter().write("Error: Invalid challenge ID");
            return;
        }

        final Challenge challenge = DBManager.challenge.get(id);
        if (challenge == null) {
            resp.getWriter().write("Error: Invalid challenge ID");
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
        final Difficulty difficulty = calculateDifficulty(rewards, penalties);

        Grid grid = new Grid();
        grid.setData(gridData);
        grid.setWidth(gridSize);
        grid.setHeight(gridSize);
        grid.setStartingDirection(gridStartingDirection);
        grid.setStartingPosition(gridStartingPosition);
        grid.setTargetPosition(gridTargetPosition);

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
        challenge.setCreatedOn(createdOn);
        challenge.setHasQuestionnaire(hasQuestionnaire);
        challenge.setLineColor(lineColor);
        challenge.setMaxActivePlayers(maxActivePlayers);
        challenge.setMinActivePlayers(minActivePlayers);
        challenge.setPenalties(penalties);
        challenge.setName(name);
        challenge.setRewards(rewards);
        challenge.setStartTime(startTime);

        //Check if another challenge has the same name:
        for (Challenge c : DBManager.challenge.list()) {
            if (c.getName().equals(name) && !c.getId().equals(id)) {
                resp.getWriter().write("Error: A challenge with the name '" + name + "' already exists.");
                return;
            }
        }

        final boolean result = DBManager.challenge.update(challenge);
        if (result) {
            resp.getWriter().write("OK");
        }
        else {
            resp.getWriter().write("Error: Could not save challenge.");
        }
    }

    private Difficulty calculateDifficulty(PickableIntensity rewardsIntensity, PickableIntensity penaltiesIntensity) {
        if (rewardsIntensity == penaltiesIntensity) return Difficulty.MEDIUM_Difficulty;
        else {
            if (rewardsIntensity == PickableIntensity.LOW_PickableIntensity && penaltiesIntensity == PickableIntensity.HIGH_PickableIntensity) return Difficulty.VERY_HARD_Difficulty;
            else if (rewardsIntensity == PickableIntensity.HIGH_PickableIntensity && penaltiesIntensity == PickableIntensity.LOW_PickableIntensity) return Difficulty.VERY_EASY_Difficulty;
            else if (rewardsIntensity == PickableIntensity.MEDIUM_PickableIntensity && penaltiesIntensity == PickableIntensity.LOW_PickableIntensity) return Difficulty.EASY_Difficulty;
            else if (rewardsIntensity == PickableIntensity.LOW_PickableIntensity && penaltiesIntensity == PickableIntensity.MEDIUM_PickableIntensity) return Difficulty.HARD_Difficulty;
            else if (rewardsIntensity == PickableIntensity.MEDIUM_PickableIntensity && penaltiesIntensity == PickableIntensity.HIGH_PickableIntensity) return Difficulty.HARD_Difficulty;
            else /*if (rewardsIntensity == PickableIntensity.HIGH && penaltiesIntensity == PickableIntensity.MEDIUM)*/ return Difficulty.EASY_Difficulty;
        }
    }

}