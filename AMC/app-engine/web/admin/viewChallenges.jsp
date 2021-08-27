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
</head>
<body style="background-image: url('img/maze_background_pattern.png'); background-repeat: repeat">
<div class="container">

    <div class="row">
        <div class="col s12">

            <div class="center-align">
                <img class="responsive-img" src="img/amaze_logo.png" />
            </div>

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
                    <td><%=challenge.getDifficulty().toString().split("_")[0]%>
                    </td>
                    <td><%=dateFormat.format(new Date(challenge.getStartTime()))%>
                    </td>
                    <td><%=dateFormat.format(new Date(challenge.getEndTime()))%>
                    </td>
                    <td><input type="button" onclick="deleteChallenge('<%=challenge.getId()%>')" value="Delete" class="btn"/></td>
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

            <p style="color: red; font-weight: bolder; font-size: large"><%=(message != null && !message.isEmpty()) ? message : ""%></p>

            <form method="post" id="add-challenge-form" class="col s12" onsubmit="event.preventDefault()">

                <h4>Add challenge</h4>

                <p><label>Name: <input type="text" name="name" id="name" required/></label></p>

                <p>Description: </p>
                <p>
                    <textarea maxlength="255" name="description" id="description" form="add-challenge-form"
                              required></textarea>
                </p>

                <p>Algorithm: </p>
                <p>
                    <select name="algorithm" id="algorithm" class="browser-default">
                        <option value="EMPTY_Algorithm">Empty</option>
                        <option value="SPARSE_Algorithm">Sparse</option>
                        <option value="SINGLE_SOLUTION_Algorithm">Single solution</option>
                        <option value="MANY_SOLUTIONS_Algorithm">Many solutions</option>
                    </select>
                </p>

                <p><label>Grid size: <input type="number" id="gridSize" name="gridSize" min="5" max="30"
                                            onchange="startingPositionRowField.max = gridSizeField.max - 1; startingPositionColField.max = gridSizeField - 1;
                                                targetPositionRowField.max = gridSizeField.max - 1; targetPositionColField.max = gridSizeField - 1"
                                            required/></label></p>

                <p><label>Starting position | Row:
                    <input type="number" id="startingPositionRow" name="startingPositionRow" min="0" required/></label>
                    <label>Starting position | Col: <input type="number" id="startingPositionCol" min="0"
                                                           name="startingPositionCol"
                                                           required/></label>
                </p>

                <p><label>Target position | Row:
                    <input type="number" id="targetPositionRow" name="targetPositionRow" min="0" required/></label>
                    <label>Target position | Col: <input type="number" id="targetPositionCol" name="targetPositionCol"
                                                         min="0" required/></label>
                </p>

                <p>Grid hex data:</p>
                <p>
                    <textarea rows="4" cols="80" name="gridData" id="gridData" form="add-challenge-form" required></textarea>
                </p>

                <div class="right">
                    <input onclick="generateGrid()" type="button" class="btn-small black white-text" value="Generate grid" id="generateGridButton" />
                </div>

                <div class="clearfix"></div>

                <p><label>Admin key: <input type="text" id="adminKey" required/></label></p>

                <div class="center-align">
                    <input class="btn btn-large" type="submit" id="createChallengeButton" value="Add Challenge" onclick="createChallenge()"/>
                </div>
            </form>

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

    function deleteChallenge(challengeID) {
        let adminKey = prompt("Admin key:");
        if (adminKey.length === 0) {
            alert("Please provide an admin key");
            return;
        }
        document.location.href = "../api/challenge/delete?challengeID=" + challengeID + "&adminKey=" + adminKey;
    }

    function createChallenge() {
        createChallengeButton.style.visibility = "hidden";

        if (nameField.value.length < 1) {
            alert("Please provide a challenge name.")
            return false;
        }

        if (Number(startingPositionRowField.value) === Number(targetPositionRowField.value) && Number(startingPositionColField.value) === Number(targetPositionColField.value)) {
            alert("Starting and target position must not be the same.")
            return false;
        }

        if (gridDataField.value.length < 1) {
            alert("Please provide grid data");
            return false;
        }

        if (adminKeyField.value.length < 1) {
            alert("Please provide an admin key.");
            return false;
        }

        //HTTP:
        const url = "../api/challenge/add";
        const body =
            "name=" + nameField.value +
            "&description=" + descriptionField.value +
            "&algorithm=" + "SINGLE_SOLUTION_Algorithm" +
            "&apiVersion=" + "1" +
            "&canJoinAfterStart=" + "true" +
            "&canRepeat=" + "true" +
            "&canStepOnEachOther=" + "true" +
            "&createdOn=" + new Date().getTime() +
            "&createdByID=" + "admin" +
            "&id=" + "" +
            "&endTime=" + new Date().getTime() + 24 * 3600 +
            "&difficulty=" + "MEDIUM_Difficulty" +
            "&lineColor=" + "#FFFFFF" +
            "&maxActivePlayers=" + "30" +
            "&minActivePlayers=" + "1" +
            "&rewards=" + "MEDIUM_PickableIntensity" +
            "&penalties=" + "MEDIUM_PickableIntensity" +
            "&hasQuestionnaire=" + "true" +
            "&backgroundImage=" + "TEXTURE_GRASS_BackgroundImage" +
            "&backgroundAudio=" + "AUDIO_NONE_Audio" +
            "&startTime=" + new Date().getTime() +

            "&gridSize=" + gridSizeField.value +
            "&gridData=" + gridDataField.value +
            "&gridStartingDirection=" + "NORTH" +
            "&gridStartingPositionRow=" + startingPositionRowField.value +
            "&gridStartingPositionCol=" + startingPositionColField.value +
            "&gridTargetPositionRow=" + targetPositionRowField.value +
            "&gridTargetPositionCol=" + targetPositionColField.value +

            "&adminKey=" + adminKeyField.value

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
                }
                else {
                    document.location.href = "viewChallenges.jsp";
                }
            })

        return true;
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
            gridDataField.value = response;
            generateGridButton.style.visibility = "visible";
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
