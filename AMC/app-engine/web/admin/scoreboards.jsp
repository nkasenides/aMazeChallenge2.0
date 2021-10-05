<%@ page import="org.inspirecenter.amazechallenge.persistence.DBManager" %>
<%@ page import="com.raylabz.firestorm.Firestorm" %>
<%@ page import="org.inspirecenter.amazechallenge.model.Scoreboard" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.inspirecenter.amazechallenge.model.Challenge" %>
<%@ page import="java.util.Collection" %>
<%@ page import="org.inspirecenter.amazechallenge.model.Game" %>
<%@ page import="com.google.appengine.api.memcache.MemcacheServiceFactory" %>
<%@ page import="com.google.appengine.api.memcache.MemcacheService" %><%--
  User: hfnov
  Date: 02-Sep-21
  Time: 12:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="theme-color" content="#3F51B5"/>
    <link rel="shortcut icon" href="img/amaze_logo.png"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <%--    <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>--%>
    <title>aMazeChallenge - Scoreboards</title>
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

                    <div class="center-align">
                        <h4>Scoreboards</h4>
                    </div>

                    <%

                        final MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();

                        final ArrayList<Challenge> challenges = new ArrayList<>(DBManager.challenge.list());
                        ArrayList<Game> games = new ArrayList<>();
                        for (Challenge challenge : challenges) {
                            final Object o = memcache.get("game_" + challenge.getId());
                            Game game = (Game) o;
                            games.add(game);
                        }

                    %>

                    <%!
                        String printChallengeScoreboards(ArrayList<Challenge> challenges, ArrayList<Game> games) {
                            String out = "";
                            int numOfGames = 0;
                            for (int i = 0; i < games.size(); i++) {
                                if (games.get(i) != null) {
                                    numOfGames++;
                                    if (!games.get(i).getPlayerWorldSessions().isEmpty()) {
                                        out += "<a href=\"scoreboard.jsp?id=" + games.get(i).getId() + "\" class=\"collection-item\">" + challenges.get(i).getName() + "</a>";
                                    } else {
                                        out += "<a class=\"collection-item grey black-text\">" + challenges.get(i).getName() + "</a>";
                                    }
                                }
                            }
                            if (numOfGames < 1) {
                                out += "<a class=\"collection-item\">No scoreboards</a>";
                            }
                            return out;
                        }
                    %>

                    <div class="collection">
                        <%=printChallengeScoreboards(challenges, games)%>
                    </div>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>
