<%@ page import="org.inspirecenter.amazechallenge.persistence.DBManager" %>
<%@ page import="org.inspirecenter.amazechallenge.model.Challenge" %>
<%@ page import="java.util.Collection" %><%--
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
    <title>aMazeChallenge - Performance</title>
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
                        <h4>Performance</h4>
                    </div>

                    <h5>Challenges</h5>
                    <ul>
                        <%!

                            String output() {
                                String output = "";
                                Collection<Challenge> challenges = DBManager.challenge.list();
                                for (Challenge challenge : challenges) {
                                    output += "<li><a href='../api/admin/performance?challengeID=" + challenge.getId() + "'>" + challenge.getName() + "</a></li>";
                                }
                                return output;
                            }

                        %>
                        <%= output() %>
                    </ul>


                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>
