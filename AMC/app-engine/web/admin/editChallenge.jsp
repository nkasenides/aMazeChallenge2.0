<%@ page import="java.util.List" %>
<%@ page import="org.inspirecenter.amazechallenge.model.Challenge" %>
<%@ page import="org.inspirecenter.amazechallenge.persistence.DBManager" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="org.inspirecenter.amazechallenge.proto.*" %><%--
  Created by IntelliJ IDEA.
  User: Nearchos
  Date: 02-Nov-17
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd,HH:mm");

    final String challengeID = request.getParameter("challengeID");
    if (challengeID == null) {
        response.sendRedirect("viewChallenges.jsp?message=Invalid challenge.");
        return;
    }

    final Challenge challenge = DBManager.challenge.get(challengeID);
    if (challenge == null) {
        response.sendRedirect("viewChallenges.jsp?message=Invalid challenge.");
        return;
    }

%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <%--    <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>--%>
    <title>aMazeChallenge - Challenges</title>
    <script src="js/Cookies.js"></script>
    <script>
        if (!Cookies.cookieExists(Cookies.ADMIN_KEY_COOKIE)) {
            document.location.href = "index.jsp";
        }
    </script>
</head>
<body style="background-image: url('img/maze_background_pattern.png'); background-repeat: repeat">
<div class="container">

    <div class="row">
        <div class="col s12">

            <div class="center-align">
                <img class="responsive-img" src="img/maze_banner_transparent.png" style="max-height: 200px" />
            </div>

            <div class="white card row">

                <form method="post" id="add-challenge-form" class="col s12" onsubmit="event.preventDefault()">

                    <div style="height: 20px"></div>
                    <a href="index.jsp"><i class="material-icons indigo-text">arrow_back</i></a>

                    <h4>Edit challenge</h4>

                    <div class="col s12">
                        <p><label>Name: <input type="text" name="name" id="name" value="<%= challenge.getName() %>" required/></label></p>
                    </div>

                    <div class="col s12">
                        <p>Description: </p>
                        <p>
                            <textarea maxlength="255" name="description" id="description" form="add-challenge-form"
                                      required><%=challenge.getDescription()%></textarea>
                        </p>
                    </div>

                    <div class="col s12">
                        <p><label>Grid size: <input type="number" id="gridSize" name="gridSize" min="5" max="30"
                                                    onchange="startingPositionRowField.max = gridSizeField.max - 1; startingPositionColField.max = gridSizeField - 1;
                                                        targetPositionRowField.max = gridSizeField.max - 1; targetPositionColField.max = gridSizeField - 1"
                                                    required value="<%=challenge.getGrid().getHeight()%>"/></label></p>
                    </div>

                    <div class="col s12 m6">
                        <p><label>Starting position | Row:
                            <input type="number" id="startingPositionRow" name="startingPositionRow" min="0" value="<%=challenge.getGrid().getStartingPosition().getRow()%>" required/></label>
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>
                            <label>Starting position | Col: <input type="number" id="startingPositionCol" min="0"
                                                                   name="startingPositionCol" value="<%=challenge.getGrid().getStartingPosition().getCol()%>"
                                                                   required/></label>
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p><label>Target position | Row:
                            <input type="number" id="targetPositionRow" name="targetPositionRow" min="0" value="<%=challenge.getGrid().getTargetPosition().getRow()%>" required/></label>
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>
                            <label>Target position | Col: <input type="number" id="targetPositionCol" name="targetPositionCol"
                                                                 value="<%=challenge.getGrid().getTargetPosition().getCol()%>" min="0" required/></label>
                        </p>
                    </div>

                    <div class="col s12">
                        <p>Algorithm: </p>
                        <p>
                            <select name="algorithm" id="algorithm" class="browser-default">
                                <option value="EMPTY_Algorithm" <%=challenge.getAlgorithm() == Algorithm.EMPTY_Algorithm ? "selected" : ""%> >Empty</option>
                                <option value="SPARSE_Algorithm" <%=challenge.getAlgorithm() == Algorithm.SPARSE_Algorithm ? "selected" : ""%> >Sparse</option>
                                <option value="SINGLE_SOLUTION_Algorithm" <%=challenge.getAlgorithm() == Algorithm.SINGLE_SOLUTION_Algorithm ? "selected" : ""%> >Single solution</option>
                                <option value="MANY_SOLUTIONS_Algorithm" <%=challenge.getAlgorithm() == Algorithm.MANY_SOLUTIONS_Algorithm ? "selected" : ""%> >Many solutions</option>
                            </select>
                        </p>
                    </div>

                    <div class="col s12">
                        <p>Starting direction: </p>
                        <p>
                            <select name="startingDirection" id="startingDirection" class="browser-default">
                                <option value="NORTH" <%=challenge.getGrid().getStartingDirection() == Direction4.NORTH ? "selected" : ""%> >North</option>
                                <option value="EAST" <%=challenge.getGrid().getStartingDirection() == Direction4.EAST ? "selected" : ""%> >East</option>
                                <option value="SOUTH" <%=challenge.getGrid().getStartingDirection() == Direction4.SOUTH ? "selected" : ""%> >South</option>
                                <option value="WEST" <%=challenge.getGrid().getStartingDirection() == Direction4.WEST ? "selected" : ""%> >West</option>
                            </select>
                        </p>
                    </div>

                    <div class="col s12">
                        <p>Grid hex data:</p>
                        <p>
                            <textarea rows="4" cols="80" name="gridData" id="gridData" form="add-challenge-form" required><%=challenge.getGrid().getData()%></textarea>
                        </p>
                    </div>

                    <div class="right">
                        <input onclick="if (confirm('Are you sure you would like to overwrite the existing grid?')) generateGrid()"
                               type="button" class="btn-small black white-text" value="Generate new grid" id="generateGridButton" />
                    </div>

                    <div class="clearfix"></div>

                    <div class="col s12 m6">
                        <p>Rewards</p>
                        <p>
                            <select name="rewards" id="rewards" class="browser-default">
                                <option value="NONE_PickableIntensity" <%=challenge.getRewards() == PickableIntensity.NONE_PickableIntensity ? "selected" : ""%> >None</option>
                                <option value="LOW_PickableIntensity" <%=challenge.getRewards() == PickableIntensity.LOW_PickableIntensity ? "selected" : ""%> >Low</option>
                                <option value="MEDIUM_PickableIntensity" <%=challenge.getRewards() == PickableIntensity.MEDIUM_PickableIntensity ? "selected" : ""%> >Medium</option>
                                <option value="HIGH_PickableIntensity" <%=challenge.getRewards() == PickableIntensity.HIGH_PickableIntensity ? "selected" : ""%> >High</option>
                            </select>
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>Penalties</p>
                        <p>
                            <select name="penalties" id="penalties" class="browser-default">
                                <option value="NONE_PickableIntensity" <%=challenge.getPenalties() == PickableIntensity.NONE_PickableIntensity ? "selected" : ""%> >None</option>
                                <option value="LOW_PickableIntensity" <%=challenge.getPenalties() == PickableIntensity.LOW_PickableIntensity ? "selected" : ""%> >Low</option>
                                <option value="MEDIUM_PickableIntensity" <%=challenge.getPenalties() == PickableIntensity.MEDIUM_PickableIntensity ? "selected" : ""%> >Medium</option>
                                <option value="HIGH_PickableIntensity" <%=challenge.getPenalties() == PickableIntensity.HIGH_PickableIntensity ? "selected" : ""%> >High</option>
                            </select>
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>Start time:
                            <input type="datetime-local" name="startTime" id="startTime" value="<%=simpleDateFormat.format(new Date(challenge.getStartTime())).replace(",", "T")%>" required />
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>End time:
                            <input type="datetime-local" name="endTime" id="endTime" value="<%=simpleDateFormat.format(new Date(challenge.getEndTime())).replace(",", "T")%>" required />
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>Minimum active players:
                            <input type="number" step="1" name="minActivePlayers" id="minActivePlayers" value="<%=challenge.getMinActivePlayers()%>" required />
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>Maximum active players:
                            <input type="number" step="1" name="maxActivePlayers" id="maxActivePlayers" value="<%=challenge.getMaxActivePlayers()%>" required />
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>Background image</p>
                        <p>
                            <select name="backgroundImage" id="backgroundImage" class="browser-default">
                                <option value="TEXTURE_WATER_BackgroundImage" <%=challenge.getBackgroundImage() == BackgroundImage.TEXTURE_WATER_BackgroundImage ? "selected" : ""%> >Water</option>
                                <option value="TEXTURE_ROCKY_BackgroundImage" <%=challenge.getBackgroundImage() == BackgroundImage.TEXTURE_ROCKY_BackgroundImage ? "selected" : ""%> >Rocky</option>
                                <option value="TEXTURE_SPACE_BackgroundImage" <%=challenge.getBackgroundImage() == BackgroundImage.TEXTURE_SPACE_BackgroundImage ? "selected" : ""%> >Space</option>
                                <option value="TEXTURE_METAL_BackgroundImage" <%=challenge.getBackgroundImage() == BackgroundImage.TEXTURE_METAL_BackgroundImage ? "selected" : ""%> >Metal</option>
                                <option value="TEXTURE_MOON_BackgroundImage" <%=challenge.getBackgroundImage() == BackgroundImage.TEXTURE_MOON_BackgroundImage ? "selected" : ""%> >Moon</option>
                                <option value="TEXTURE_LAVA_BackgroundImage" <%=challenge.getBackgroundImage() == BackgroundImage.TEXTURE_LAVA_BackgroundImage ? "selected" : ""%> >Lava</option>
                                <option value="TEXTURE_GRAVEL_BackgroundImage" <%=challenge.getBackgroundImage() == BackgroundImage.TEXTURE_GRAVEL_BackgroundImage ? "selected" : ""%> >Gravel</option>
                                <option value="TEXTURE_WOOD_BackgroundImage" <%=challenge.getBackgroundImage() == BackgroundImage.TEXTURE_WOOD_BackgroundImage ? "selected" : ""%> >Wood</option>
                                <option value="TEXTURE_GRASS_BackgroundImage" <%=challenge.getBackgroundImage() == BackgroundImage.TEXTURE_GRASS_BackgroundImage ? "selected" : ""%> >Grass</option>
                                <option value="TEXTURE_TILES_BackgroundImage" <%=challenge.getBackgroundImage() == BackgroundImage.TEXTURE_TILES_BackgroundImage ? "selected" : ""%> >Tiles</option>
                            </select>
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>Background audio</p>
                        <p>
                            <select name="backgroundAudio" id="backgroundAudio" class="browser-default" required>
                                <option value="AMBIENT_STORM_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_STORM_Audio ? "selected" : ""%> >Storm</option>
                                <option value="AMBIENT_NIGHT_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_NIGHT_Audio ? "selected" : ""%> >Night</option>
                                <option value="AMBIENT_SNOW_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_SNOW_Audio ? "selected" : ""%> >Snow</option>
                                <option value="AMBIENT_ALPINE_FOREST_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_ALPINE_FOREST_Audio ? "selected" : ""%> >Alpine forest</option>
                                <option value="AMBIENT_RIVER_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_RIVER_Audio ? "selected" : ""%> >River</option>
                                <option value="AMBIENT_CAVE_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_CAVE_Audio ? "selected" : ""%> >Cave</option>
                                <option value="AMBIENT_PRISON_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_PRISON_Audio ? "selected" : ""%> >Prison</option>
                                <option value="AMBIENT_SANDSTORM_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_SANDSTORM_Audio ? "selected" : ""%> >Sandstorm</option>
                                <option value="AMBIENT_CITY_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_CITY_Audio ? "selected" : ""%> >City</option>
                                <option value="AMBIENT_STREET_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_STREET_Audio ? "selected" : ""%> >Street</option>
                                <option value="AMBIENT_TROPICAL_FOREST_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_TROPICAL_FOREST_Audio ? "selected" : ""%> >Tropical forest</option>
                                <option value="AMBIENT_FIRE_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_FIRE_Audio ? "selected" : ""%> >Fire</option>
                                <option value="AMBIENT_HIGHTECH_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_HIGHTECH_Audio ? "selected" : ""%> >High-tech</option>
                                <option value="AMBIENT_UNDERWATER_Audio" <%=challenge.getBackgroundAudio() == Audio.AMBIENT_UNDERWATER_Audio ? "selected" : ""%> >Underwater</option>
                            </select>
                        </p>
                    </div>

                    <div class="col s12 ">
                        <p>Line/Wall color</p>
                        <p>
                            <input type="color" name="lineColor" id="lineColor" value="<%=challenge.getLineColor()%>>" required />
                        </p>
                    </div>

                    <div class="clearfix"></div>
                    <div style="height: 20px"></div>

                    <div class="col s4">
                        <p>
                            <label class="black-text">
                                <input type="checkbox" class="filled-in" name="canJoinAfterStart" id="canJoinAfterStart" <%=challenge.isCanJoinAfterStart() ? "checked" : ""%> />
                                <span>Can join after start</span>
                            </label>
                        </p>
                    </div>

                    <div class="col s4">
                        <p>
                            <label class="black-text">
                                <input type="checkbox" class="filled-in" name="canRepeat" id="canRepeat" <%=challenge.isCanRepeat() ? "checked" : ""%> />
                                <span>Can repeat</span>
                            </label>
                        </p>
                    </div>

                    <div class="col s4">
                        <p>
                            <label class="black-text">
                                <input type="checkbox" class="filled-in" name="canStepOnEachOther" id="canStepOnEachOther" <%=challenge.isCanStepOnEachOther() ? "checked" : ""%> />
                                <span>Can step on each other</span>
                            </label>
                        </p>
                    </div>

                    <div class="col s4">
                        <p>
                            <label class="black-text">
                                <input type="checkbox" class="filled-in" name="questionnaire" id="questionnaire" <%=challenge.isHasQuestionnaire() ? "checked" : ""%> />
                                <span>Questionnaire</span>
                            </label>
                        </p>
                    </div>

                    <div style="height: 20px"></div>
                    <div class="clearfix"></div>
                    <div style="height: 50px"></div>

                    <a class="btn btn-large red white-text left" href="viewChallenges.jsp">Cancel</a>
                    <input class="btn btn-large indigo darken-3 white-text s12 m6 right" type="submit" id="createChallengeButton" value="Save" onclick="editChallenge(false)"/>

                </form>

            </div>

        </div>
    </div>
</div>

<script>

    const nameField = document.getElementById("name");
    const descriptionField = document.getElementById("description");
    const gridSizeField = document.getElementById("gridSize");
    const startingPositionRowField = document.getElementById("startingPositionRow");
    const startingPositionColField = document.getElementById("startingPositionCol");
    const targetPositionRowField = document.getElementById("targetPositionRow");
    const targetPositionColField = document.getElementById("targetPositionCol");
    const gridDataField = document.getElementById("gridData");
    const adminKeyField = document.getElementById("adminKey");
    const createChallengeButton = document.getElementById("createChallengeButton");
    const generateGridButton = document.getElementById("generateGridButton");
    const algorithmSelect = document.getElementById("algorithm");
    const rewardsSelect = document.getElementById("rewards");
    const penaltiesSelect = document.getElementById("penalties");
    const startTimeField = document.getElementById("startTime");
    const endTimeField = document.getElementById("endTime");
    const minActivePlayersField = document.getElementById("minActivePlayers");
    const maxActivePlayersField = document.getElementById("maxActivePlayers");
    const backgroundImageSelect = document.getElementById("backgroundImage");
    const backgroundAudioSelect = document.getElementById("backgroundAudio");
    const lineColorField = document.getElementById("lineColor");
    const canJoinAfterStartField = document.getElementById("canJoinAfterStart");
    const canRepeatField = document.getElementById("canRepeat");
    const canStepOnEachOtherField = document.getElementById("canStepOnEachOther");
    const questionnaireField = document.getElementById("questionnaire");
    const startingDirectionSelect = document.getElementById("startingDirection");

    function editChallenge() {

        if (nameField.value.length < 1) {
            alert("Please provide a challenge name.")
            nameField.focus();
            return false;
        }

        if (Number(startingPositionRowField.value) === Number(targetPositionRowField.value) && Number(startingPositionColField.value) === Number(targetPositionColField.value)) {
            alert("Starting and target position must not be the same.")
            startingPositionRowField.focus();
            return false;
        }

        if (gridDataField.value.length < 1) {
            gridDataField.focus();
            alert("Please provide grid data");
            return false;
        }

        if (startTimeField.value.length < 1) {
            startTimeField.focus();
            alert("Please provide a start date/time.");
            return false;
        }

        if (endTimeField.value.length < 1) {
            endTimeField.focus();
            alert("Please provide an end date/time.");
            return false;
        }

        const startTime = new Date(startTimeField.value).getTime();
        const endTime = new Date(endTimeField.value).getTime();
        const timeNow = new Date().getTime();

        if (startTime >= endTime) {
            endTimeField.focus();
            alert("End time must be after start time.")
            return false;
        }

        if (startTime <= timeNow) {
            startTimeField.focus();
            alert("The start time must be in the future.")
            return false;
        }

        const minPlayers = Number(minActivePlayersField.value);
        const maxPlayers = Number(maxActivePlayersField.value);

        if (!Number.isInteger(minPlayers) || minPlayers < 1) {
            minActivePlayersField.focus();
            alert("The minimum active players must be an integer >= 1.");
            return false;
        }

        if (!Number.isInteger(maxPlayers) || minPlayers > maxPlayers) {
            maxActivePlayersField.focus();
            alert("The maximum active players must be an integer >= minPlayers.");
            return false;
        }

        const canJoinAfterStart = canJoinAfterStartField.checked;
        const canRepeat = canRepeatField.checked;
        const canStepOnEachOther = canStepOnEachOtherField.checked;
        const questionnaire = questionnaireField.checked;

        //HTTP:
        createChallengeButton.style.visibility = "hidden";
        const url = "../api/challenge/edit";
        const body =
            "name=" + nameField.value +
            "&description=" + descriptionField.value +
            "&algorithm=" + algorithmSelect.selectedOptions[0].value +
            "&apiVersion=" + "1" +
            "&canJoinAfterStart=" + canJoinAfterStart +
            "&canRepeat=" + canRepeat +
            "&canStepOnEachOther=" + canStepOnEachOther +
            "&createdOn=" + new Date().getTime() +
            "&createdByID=" + "admin" +
            "&id=" + "<%=challengeID%>" +
            "&endTime=" + endTime +
            "&lineColor=" + lineColorField.value +
            "&maxActivePlayers=" + maxPlayers +
            "&minActivePlayers=" + minPlayers +
            "&rewards=" + rewardsSelect.selectedOptions[0].value +
            "&penalties=" + penaltiesSelect.selectedOptions[0].value +
            "&hasQuestionnaire=" + questionnaire +
            "&backgroundImage=" + backgroundImageSelect.selectedOptions[0].value +
            "&backgroundAudio=" + backgroundAudioSelect.selectedOptions[0].value +
            "&startTime=" + startTime +

            "&gridSize=" + gridSizeField.value +
            "&gridData=" + gridDataField.value +
            "&gridStartingDirection=" + startingDirectionSelect.selectedOptions[0].value +
            "&gridStartingPositionRow=" + startingPositionRowField.value +
            "&gridStartingPositionCol=" + startingPositionColField.value +
            "&gridTargetPositionRow=" + targetPositionRowField.value +
            "&gridTargetPositionCol=" + targetPositionColField.value +

            "&adminKey=" + Cookies.getCookie(Cookies.ADMIN_KEY_COOKIE)
        ;


        const httpOptions = {
            method: "POST",
            body: body
        };

        fetch(url, httpOptions)
            .then(response => response.text())
            .then(text => {
                createChallengeButton.style.visibility = "visible";
                if (text.includes("Error")) {
                    alert(text);
                } else {
                    document.location.href = "viewChallenges.jsp";
                }
            })
    }

    function generateGrid() {

        if (Number(gridSizeField.value) < 5) {
            alert("Grid size must be 5 or larger.")
            return false;
        }

        if (Number(startingPositionRowField.value) === Number(targetPositionRowField.value) && Number(startingPositionColField.value) === Number(targetPositionColField.value)) {
            alert("Starting and target position must not be the same.")
            return false;
        }

        const selectedAlgorithm = algorithmSelect.options[algorithmSelect.selectedIndex].value;

        const url = "../api/challenge/generateGrid" +
            "?algorithm=" + selectedAlgorithm +
            "&size=" + gridSizeField.value +
            "&startingPositionRow=" +  startingPositionRowField.value +
            "&startingPositionCol=" + startingPositionColField.value +
            "&targetPositionRow=" + targetPositionRowField.value +
            "&targetPositionCol=" + targetPositionColField.value
        ;

        generateGridButton.style.visibility = "hidden";
        fetch(url)
        .then(result => result.text())
        .then(response => {
            if (response.includes("Error")) {
                alert(response);
                generateGridButton.style.visibility = "visible";
            }
            else {
                gridDataField.value = response;
                generateGridButton.style.visibility = "visible";
            }
        })
        .catch(error => {
            alert(error);
        });

    }

</script>

</body>

<!--  Scripts-->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<%--<script src="js/init.js"></script>--%>

</html>
