<%--
  User: hfnov
  Date: 02-Sep-21
  Time: 11:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="theme-color" content="#000000"/>
    <link rel="shortcut icon" href="#"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <title>aMazeChallenge | Admin panel</title>
    <script src="js/Cookies.js"></script>
    <script>
        if (!Cookies.cookieExists(Cookies.ADMIN_KEY_COOKIE)) {
            document.location.href = "auth.jsp";
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

                    <div class="center-align">
                        <h4>Admin panel</h4>
                    </div>

                    <div style="height: 20px"></div>

                    <p><a class="btn indigo darken-3 white-text" href="viewChallenges.jsp">Manage challenges</a></p>
                    <p><a class="btn indigo darken-3 white-text" href="changeAdminKey.jsp">Change admin key</a></p>
                    <p><input type="button" class="btn indigo darken-3 white-text" value="Reset sessions" id="resetSessions" onclick="if (confirm('Are you sure you would like to reset session data?')) resetSessions()"/></p>
                    <p><input type="button" class="btn indigo darken-3 white-text" value="Reset all data" id="resetAllData" onclick="if (confirm('Are you sure you would like to reset all data? This will delete all challenges and associated sessions!')) resetAllData()"/></p>
                    <p><input onclick="logout()" class="btn indigo darken-3 white-text" value="Log out" type="button" /></p>

                    <div style="height: 20px"></div>

                </div>

            </div>

            <script>
                function logout() {
                    Cookies.resetCookies();
                    document.location.href = "auth.jsp";
                }

                function resetAllData() {
                    const url = "../api/reset?adminKey=" + Cookies.getCookie(Cookies.ADMIN_KEY_COOKIE);

                    fetch(url)
                        .then(response => response.text())
                        .then(text => {
                            if (text.includes("Error")) {
                                alert(text);
                            } else {
                                alert("Data reset!");
                            }
                        })
                }

                function resetSessions() {
                    const url = "../api/resetSessions?adminKey=" + Cookies.getCookie(Cookies.ADMIN_KEY_COOKIE);

                    fetch(url)
                        .then(response => response.text())
                        .then(text => {
                            if (text.includes("Error")) {
                                alert(text);
                            } else {
                                alert("Sessions reset!");
                            }
                        })
                }
            </script>

        </div>

    </div>



</body>
</html>
