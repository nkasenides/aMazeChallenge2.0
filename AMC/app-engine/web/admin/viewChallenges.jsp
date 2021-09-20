<%@ page import="java.util.List" %>
<%@ page import="org.inspirecenter.amazechallenge.model.Challenge" %>
<%@ page import="org.inspirecenter.amazechallenge.persistence.DBManager" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Nearchos
  Date: 02-Nov-17
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

                <div class="col s12">

                    <div style="height: 20px"></div>
                    <a href="index.jsp"><i class="material-icons indigo-text">arrow_back</i></a>

                    <h4>Manage challenges</h4>

                    <table border="1" class="responsive-table">
                        <tr>
        <%--                    <td>ID</td>--%>
                            <td>Name</td>
                            <td>Description</td>
                            <td>Grid size</td>
                            <td>Difficulty</td>
                            <td>Start on</td>
                            <td>Ends on</td>
                            <td></td>
                        </tr>
                        <%
                            final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy, HH:mm");
                            final String message = request.getParameter("message");

                            final Collection<Challenge> allChallenges = DBManager.challenge.list();

                            if (allChallenges.size() > 0) {
                                for (final Challenge challenge : allChallenges) {
                        %>
                        <tr>
        <%--                    <td><%=challenge.getId()%>--%>
        <%--                    </td>--%>
                            <td><%=challenge.getName()%>
                            </td>
                            <td><%=challenge.getDescription()%>
                            </td>
                            <td><%=challenge.getGrid().getWidth()%>x<%=challenge.getGrid().getWidth()%>
                            </td>
                            <td><%=challenge.getDifficulty().toString().split("_").length == 1 ? challenge.getDifficulty().toString().split("_")[0] : challenge.getDifficulty().toString().split("_")[0] + " " + challenge.getDifficulty().toString().split("_")[1]%>
                            </td>
                            <td><%=dateFormat.format(new Date(challenge.getStartTime()))%>
                            </td>
                            <td><%=dateFormat.format(new Date(challenge.getEndTime()))%>
                            </td>
                            <td><input type="button" onclick="if (confirm('Are you sure?')) deleteChallenge('<%=challenge.getId()%>')" value="Delete" class="btn red darken-3 white-text"/></td>
                        </tr>
                        <%
                                }
                            }
                        %>

                        <% if (allChallenges.isEmpty()) { %>
                        <tr>
                            <td>No challenges</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <%}%>
                    </table>

                    <hr/>

                    <div style="height: 50px;"></div>

                </div>

                <div class="center-align">
                    <p style="color: red; font-weight: bolder; font-size: large"><%=(message != null && !message.isEmpty()) ? message : ""%></p>
                </div>

                <form method="post" id="add-challenge-form" class="col s12" onsubmit="event.preventDefault()">

                    <h4>Add challenge</h4>

                    <div class="col s12">
                        <p><label>Name: <input type="text" name="name" id="name" required/></label></p>
                    </div>

                    <div class="col s12">
                        <p>Description: </p>
                        <p>
                            <textarea maxlength="255" name="description" id="description" form="add-challenge-form"
                                      required></textarea>
                        </p>
                    </div>

                    <div class="col s12">
                        <p><label>Grid size: <input type="number" id="gridSize" name="gridSize" min="5" max="30"
                                                    onchange="startingPositionRowField.max = gridSizeField.max - 1; startingPositionColField.max = gridSizeField - 1;
                                                        targetPositionRowField.max = gridSizeField.max - 1; targetPositionColField.max = gridSizeField - 1"
                                                    required/></label></p>
                    </div>

                    <div class="col s12 m6">
                        <p><label>Starting position | Row:
                            <input type="number" id="startingPositionRow" name="startingPositionRow" min="0" required/></label>
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>
                            <label>Starting position | Col: <input type="number" id="startingPositionCol" min="0"
                                                                   name="startingPositionCol"
                                                                   required/></label>
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p><label>Target position | Row:
                            <input type="number" id="targetPositionRow" name="targetPositionRow" min="0" required/></label>
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>
                            <label>Target position | Col: <input type="number" id="targetPositionCol" name="targetPositionCol"
                                                                 min="0" required/></label>
                        </p>
                    </div>

                    <div class="col s12">
                        <p>Algorithm: </p>
                        <p>
                            <select name="algorithm" id="algorithm" class="browser-default">
                                <option value="EMPTY_Algorithm">Empty</option>
                                <option value="SPARSE_Algorithm">Sparse</option>
                                <option value="SINGLE_SOLUTION_Algorithm">Single solution</option>
                                <option value="MANY_SOLUTIONS_Algorithm">Many solutions</option>
                            </select>
                        </p>
                    </div>

                    <div class="col s12">
                        <p>Starting direction: </p>
                        <p>
                            <select name="startingDirection" id="startingDirection" class="browser-default">
                                <option value="NORTH">North</option>
                                <option value="EAST">East</option>
                                <option value="SOUTH">South</option>
                                <option value="WEST">West</option>
                            </select>
                        </p>
                    </div>

                    <div class="col s12">
                        <p>Grid hex data:</p>
                        <p>
                            <textarea rows="4" cols="80" name="gridData" id="gridData" form="add-challenge-form" required></textarea>
                        </p>
                    </div>

                    <div class="right">
                        <input onclick="generateGrid()" type="button" class="btn-small black white-text" value="Generate grid" id="generateGridButton" />
                    </div>

                    <div class="clearfix"></div>

                    <div class="col s12 m6">
                        <p>Rewards</p>
                        <p>
                            <select name="rewards" id="rewards" class="browser-default">
                                <option value="NONE_PickableIntensity">None</option>
                                <option value="LOW_PickableIntensity" selected>Low</option>
                                <option value="MEDIUM_PickableIntensity">Medium</option>
                                <option value="HIGH_PickableIntensity">High</option>
                            </select>
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>Penalties</p>
                        <p>
                            <select name="penalties" id="penalties" class="browser-default">
                                <option value="NONE_PickableIntensity">None</option>
                                <option value="LOW_PickableIntensity" selected>Low</option>
                                <option value="MEDIUM_PickableIntensity">Medium</option>
                                <option value="HIGH_PickableIntensity">High</option>
                            </select>
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>Start time:
                            <input type="datetime-local" name="startTime" id="startTime" required />
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>End time:
                            <input type="datetime-local" name="endTime" id="endTime" required />
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>Minimum active players:
                            <input type="number" step="1" name="minActivePlayers" id="minActivePlayers" value="1" required />
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>Maximum active players:
                            <input type="number" step="1" name="maxActivePlayers" id="maxActivePlayers" value="30" required />
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>Background image</p>
                        <p>
                            <select name="backgroundImage" id="backgroundImage" class="browser-default">
                                <option value="TEXTURE_WATER_BackgroundImage">Water</option>
                                <option value="TEXTURE_ROCKY_BackgroundImage">Rocky</option>
                                <option value="TEXTURE_SPACE_BackgroundImage">Space</option>
                                <option value="TEXTURE_METAL_BackgroundImage">Metal</option>
                                <option value="TEXTURE_MOON_BackgroundImage">Moon</option>
                                <option value="TEXTURE_LAVA_BackgroundImage">Lava</option>
                                <option value="TEXTURE_GRAVEL_BackgroundImage">Gravel</option>
                                <option value="TEXTURE_WOOD_BackgroundImage">Wood</option>
                                <option value="TEXTURE_GRASS_BackgroundImage">Grass</option>
                                <option value="TEXTURE_TILES_BackgroundImage">Tiles</option>
                            </select>
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <p>Background audio</p>
                        <p>
                            <select name="backgroundAudio" id="backgroundAudio" class="browser-default" required>
                                <option value="AMBIENT_STORM_Audio">Storm</option>
                                <option value="AMBIENT_NIGHT_Audio">Night</option>
                                <option value="AMBIENT_SNOW_Audio">Snow</option>
                                <option value="AMBIENT_ALPINE_FOREST_Audio">Alpine forest</option>
                                <option value="AMBIENT_RIVER_Audio">River</option>
                                <option value="AMBIENT_CAVE_Audio">Cave</option>
                                <option value="AMBIENT_PRISON_Audio">Prison</option>
                                <option value="AMBIENT_SANDSTORM_Audio">Sandstorm</option>
                                <option value="AMBIENT_CITY_Audio">City</option>
                                <option value="AMBIENT_STREET_Audio">Street</option>
                                <option value="AMBIENT_TROPICAL_FOREST_Audio">Tropical forest</option>
                                <option value="AMBIENT_FIRE_Audio">Fire</option>
                                <option value="AMBIENT_HIGHTECH_Audio">High-tech</option>
                                <option value="AMBIENT_UNDERWATER_Audio">Underwater</option>
                            </select>
                        </p>
                    </div>

                    <div class="col s12 ">
                        <p>Line/Wall color</p>
                        <p>
                            <input type="color" name="lineColor" id="lineColor" value="#000000" required />
                        </p>
                    </div>

                    <div class="clearfix"></div>
                    <div style="height: 20px"></div>

                    <div class="col s4">
                        <p>
                            <label class="black-text">
                                <input type="checkbox" class="filled-in" name="canJoinAfterStart" id="canJoinAfterStart" checked="checked" required />
                                <span>Can join after start</span>
                            </label>
                        </p>
                    </div>

                    <div class="col s4">
                        <p>
                            <label class="black-text">
                                <input type="checkbox" class="filled-in" name="canRepeat" id="canRepeat" checked required />
                                <span>Can repeat</span>
                            </label>
                        </p>
                    </div>

                    <div class="col s4">
                        <p>
                            <label class="black-text">
                                <input type="checkbox" class="filled-in" name="canStepOnEachOther" id="canStepOnEachOther" checked required />
                                <span>Can step on each other</span>
                            </label>
                        </p>
                    </div>

                    <div class="col s4">
                        <p>
                            <label class="black-text">
                                <input type="checkbox" class="filled-in" name="questionnaire" id="questionnaire" checked required />
                                <span>Questionnaire</span>
                            </label>
                        </p>
                    </div>

                    <div style="height: 20px"></div>
                    <div class="clearfix"></div>
                    <div style="height: 30px"></div>

                    <div class="center-align">
                            <input class="btn btn-large indigo darken-3 white-text s12 m6" type="submit" id="createChallengeButton" value="Add Challenge" onclick="createChallenge(false)"/>
                            <input class="btn btn-large indigo darken-3 white-text s12 m6" type="submit" id="toJsonButton" value="Export to JSON" onclick="createChallenge(true)"/>
                    </div>
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

    function deleteChallenge(challengeID) {
        let adminKey = Cookies.getCookie(Cookies.ADMIN_KEY_COOKIE);
        document.location.href = "../api/challenge/delete?challengeID=" + challengeID + "&adminKey=" + adminKey;
    }

    function createChallenge(toJson) {

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
        if (!toJson) {
            createChallengeButton.style.visibility = "hidden";
            const url = "../api/challenge/add";
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
                "&id=" + "" +
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

        //To JSON file:
        else {
            const challenge = {
                "name": nameField.value,
                "description": descriptionField.value,
                "algorithm": algorithmSelect.selectedOptions[0].value,
                "apiVersion": 1,
                "canJoinAfterStart": canJoinAfterStart,
                "canRepeat": canRepeat,
                "canStepOnEachOther": canStepOnEachOther,
                "createdOn": new Date().getTime(),
                "createdByID": "admin",
                "endTime": endTime,
                "lineColor": lineColorField.value,
                "maxActivePlayers": maxPlayers,
                "minActivePlayers": minPlayers,
                "rewards": rewardsSelect.selectedOptions[0].value,
                "penalties": penaltiesSelect.selectedOptions[0].value,
                "hasQuestionnaire": questionnaire,
                "backgroundImage": backgroundImageSelect.selectedOptions[0].value,
                "backgroundAudio": backgroundAudioSelect.selectedOptions[0].value,
                "grid": {
                  "data": gridDataField.value,
                  "height": gridSizeField.value,
                  "width": gridSizeField.value,
                  "startingDirection": startingDirectionSelect.selectedOptions[0].value,
                  "startingPosition": {
                      "col": startingPositionColField.value,
                      "row": startingPositionRowField.value
                  },
                    "targetPosition": {
                      "col": targetPositionColField.value,
                        "row": targetPositionRowField.value
                    },
                },
                "startTime": startTime,
                "difficulty": calculateDifficulty(rewardsSelect.selectedOptions[0].value, penaltiesSelect.selectedOptions[0].value)
            }

            const challengeJSON = JSON.stringify(challenge);
            console.log(challengeJSON);
            downloadFile(challengeJSON, challenge.name + ".json", "application/json");
        }

        return true;
    }

    function calculateDifficulty(rewards, penalties) {
        if (rewards === penalties) return "MEDIUM_Difficulty";
        if (rewards === "LOW_PickableIntensity" && penalties === "HIGH_PickableIntensity") return "VERY_HARD_Difficulty";
        else if (rewards === "HIGH_PickableIntensity" && penalties === "LOW_PickableIntensity") return "VERY_EASY_Difficulty";
        else if (rewards === "MEDIUM_PickableIntensity" && penalties === "LOW_PickableIntensity") return "EASY_Difficulty";
        else if (rewards === "LOW_PickableIntensity" && penalties === "MEDIUM_PickableIntensity") return "HARD_Difficulty";
        else if (rewards === "MEDIUM_PickableIntensity" && penalties === "HIGH_PickableIntensity") return "HARD_Difficulty";
        else return "EASY_Difficulty";
    }

    function downloadFile(data, filename, type) {
        let file = new Blob([data], {type: type});
        if (window.navigator.msSaveOrOpenBlob) // IE10+
            window.navigator.msSaveOrOpenBlob(file, filename);
        else { // Others
            let a = document.createElement("a"),
                url = URL.createObjectURL(file);
            a.href = url;
            a.download = filename;
            document.body.appendChild(a);
            a.click();
            setTimeout(function() {
                document.body.removeChild(a);
                window.URL.revokeObjectURL(url);
            }, 0);
        }
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
