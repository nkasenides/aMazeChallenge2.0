<%@ page import="java.util.List" %>
<%@ page import="org.inspirecenter.amazechallenge.model.Challenge" %>
<%@ page import="org.inspirecenter.amazechallenge.persistence.DBManager" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: Nearchos
  Date: 02-Nov-17
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>aMazeChallenge - Challenges</title>
    <script src="../js/Cookies.js"></script>
</head>
<body>
<h1>aMazeChallenge - Challenges</h1>

<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Description</td>
        <td>Grid (hex)</td>
    </tr>
    <%
        final String error = request.getParameter("error");

        final Collection<Challenge> allChallenges = DBManager.challenge.list();

        if (allChallenges.size() > 0) {
            for (final Challenge challenge : allChallenges) {
    %>
    <tr>
        <td><%=challenge.getId()%>
        </td>
        <td><%=challenge.getName()%>
        </td>
        <td><%=challenge.getDescription()%>
        </td>
        <td><%=challenge.getGrid().getData()%>
        </td>
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
    </tr>
    <%}%>
</table>

<hr/>

<p style="color: red;"><%=(error != null && !error.isEmpty()) ? error : ""%>
</p>

<form method="post" id="add-challenge-form" onsubmit="event.preventDefault()">

    <p><label>Name: <input type="text" name="name" id="name" required/></label></p>

    <p><label>Description: <textarea rows="10" cols="80" name="description" id="description" form="add-challenge-form"
                                     required></textarea></label></p>

    <p><label>Grid size: <input type="number" id="gridSize" name="gridSize" min="5" max="30"
                                onchange="startingPositionRowField.max = gridSizeField.max - 1; startingPositionColField.max = gridSizeField - 1;
                                                targetPositionRowField.max = gridSizeField.max - 1; targetPositionColField.max = gridSizeField - 1"
                                required/></label></p>

    <p><label>Starting position | Row:
        <input type="number" id="startingPositionRow" name="startingPositionRow" min="0" required/></label>
        <label>Col: <input type="number" id="startingPositionCol" min="0" name="startingPositionCol" required/></label>
    </p>

    <p><label>Target position | Row:
        <input type="number" id="targetPositionRow" name="targetPositionRow" min="0" required/></label>
        <label>Col: <input type="number" id="targetPositionCol" name="targetPositionCol" min="0" required/></label></p>

    <p><label>Grid as Hex: <textarea rows="4" cols="80" name="gridData" id="gridData" form="add-challenge-form"
                                     required></textarea></label></p>

    <p><label>Admin key: <input type="text" id="adminKey" required/></label></p>

    <input type="submit" id="createChallengeButton" value="Add Challenge" onclick="createChallenge()"/>
</form>

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

    function createChallenge() {
        createChallengeButton.style.display = "none";

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
            "&endTime=" + new Date().getTime() + 24*3600 +
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
            createChallengeButton.style.display = "block";
            console.log(text);
            if (text.contains("Error")) {
                alert(text);
            }
        })

        return true;
    }

</script>

</body>
</html>
