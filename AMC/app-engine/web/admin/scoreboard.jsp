<%@ page import="org.inspirecenter.amazechallenge.persistence.DBManager" %>
<%@ page import="com.raylabz.firestorm.Firestorm" %>
<%@ page import="org.inspirecenter.amazechallenge.model.Scoreboard" %>
<%@ page import="org.inspirecenter.amazechallenge.model.Challenge" %>
<%@ page import="org.inspirecenter.amazechallenge.model.Game" %>
<%@ page import="com.google.appengine.api.memcache.MemcacheServiceFactory" %>
<%@ page import="com.google.appengine.api.memcache.MemcacheService" %>
<%@ page import="org.inspirecenter.amazechallenge.model.AMCWorldSession" %>
<%@ page import="java.util.*" %><%--
  User: hfnov
  Date: 02-Sep-21
  Time: 12:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    final String id = request.getParameter("id");
    if (id == null || id.isEmpty()) {
        response.sendError(400, "Please provide a game ID.");
        return;
    }

    final MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();
    final Object object = memcache.get(id);
    if (object == null) {
        response.sendError(400, "Invalid game ID, game not found.");
        return;
    }

    final Game game = (Game) object;
    final Challenge challenge = DBManager.challenge.get(id.split("_")[1]);

    if (challenge == null) {
        response.sendError(400, "Invalid game ID, challenge not found.");
        return;
    }


%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="theme-color" content="#3F51B5"/>
    <link rel="shortcut icon" href="img/amaze_logo.png"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <%--    <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>--%>
    <title>aMazeChallenge - <%=challenge.getName()%></title>
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
                <img class="responsive-img" src="img/maze_banner_transparent.png" style="max-height: 200px"/>
            </div>

            <div class="white card row">

                <div class="col s12">

                    <div style="height: 20px"></div>
                    <a href="index.jsp"><i class="material-icons indigo-text">arrow_back</i></a>
                    <a href="scoreboard.jsp?id=<%=id%>"><i class="material-icons indigo-text right">refresh</i></a>

                    <div class="center-align">
                        <h4><%=challenge.getName()%> - Scoreboard</h4>
                    </div>

                    <%!

                        String formatTime(long seconds) {
                            if (seconds >= 60*60) {
                                long hours = seconds / 3600;
                                long minutes = seconds % 3600 / 60;
                                long secondsT = seconds % 60;
                                return hours + "h " + minutes + "m " + secondsT + "s";
                            }
                            else if (seconds >= 60) {
                                long minutes = seconds / 60;
                                long secondsT = seconds % 60;
                                return minutes + "m " + secondsT + "s";
                            }
                            else {
                                return seconds + "s";
                            }
                        }

                        String printScoreboardRows(Challenge challenge, Game game) {
                            String out = "";
                            ArrayList<String> worldSessionsToGet = new ArrayList<>();
                            for (Map.Entry<String, Long> entries : game.getScoreboard().getEntries().entrySet()) {
                                worldSessionsToGet.add(entries.getKey());
                            }

                            final Map<String, AMCWorldSession> worldSessions = game.getPlayerWorldSessions();

                            ArrayList<Map.Entry<String, Long>> sortedScoreboardList = new ArrayList<>(game.getScoreboard().getEntries().entrySet());
                            sortedScoreboardList.sort(new Comparator<Map.Entry<String, Long>>() {
                                @Override
                                public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                                    if (o1.getValue() == -1) {
                                        return 1;
                                    }
                                    if (o1.getValue() < o2.getValue()) {
                                        return -1;
                                    } else if (o1.getValue() > o2.getValue()) {
                                        return 1;
                                    } else {
                                        if (worldSessions.get(o1.getKey()).getPoints() > worldSessions.get(o2.getKey()).getPoints()) {
                                            return -1;
                                        } else if (worldSessions.get(o1.getKey()).getPoints() < worldSessions.get(o2.getKey()).getPoints()) {
                                            return 1;
                                        } else {
                                            return Integer.compare(worldSessions.get(o1.getKey()).getHealth().getHealth(), worldSessions.get(o2.getKey()).getHealth().getHealth());
                                        }
                                    }
                                }
                            });

                            if (!sortedScoreboardList.isEmpty()) {
                                int position = 1;
                                for (Map.Entry<String, Long> entry : sortedScoreboardList) {
                                    String name;
                                    int points;
                                    int health;
                                    long finishTime;

                                    final AMCWorldSession worldSession = worldSessions.get(entry.getKey());

                                    name = worldSession.getPlayerID();
                                    points = worldSession.getPoints();
                                    health = worldSession.getPoints();
                                    finishTime = entry.getValue();

                                    String color = "style='background-color: %COLOR'";
                                    switch (position) {
                                        case 1:
                                            color = color.replace("%COLOR", "gold");
                                            break;
                                        case 2:
                                            color = color.replace("%COLOR", "silver");
                                            break;
                                        case 3:
                                            color = color.replace("%COLOR", "chocolate");
                                            break;
                                    }

                                    out += "<tr " + (position <= 3 ? color : "") + ">" +
                                            "<td>" + position + "</td>" +
                                            "<td>" + name + "</td>" +
                                            "<td>" + (finishTime == -1 ? "N/A" : formatTime((finishTime - challenge.getStartTime()) / 1000)) + "</td>" +
                                            "<td>" + points + "</td>" +
                                            "<td>" + health + "</td>" +
                                            "</tr>";

                                    position++;
                                }
                            }
                            else {
                                out += "<tr>" +
                                        "<td>-</td>" +
                                        "<td>No entries</td>" +
                                        "<td>-</td>" +
                                        "<td>-</td>" +
                                        "<td>-</td>" +
                                        "</tr>";
                            }
                            return out;
                        }
                    %>

                    <br/>

                    <table class="responsive-table">
                        <thead>
                            <tr style='background-color: black; color: white;'>
                                <th></th>
                                <th>Name</th>
                                <th>Elapsed time</th>
                                <th>Points</th>
                                <th>Health</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%=printScoreboardRows(challenge, game)%>
                        </tbody>
                    </table>

                   <br/>

                </div>

            </div>

        </div>

    </div>

    <script>
        //Update every 5 seconds:
        setInterval(function() {
            location.reload();
        }, 5000);
    </script>

</div>

</body>
</html>
