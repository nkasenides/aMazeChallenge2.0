<%--
  User: hfnov
  Date: 02-Sep-21
  Time: 11:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="theme-color" content="#000000"/>
    <link rel="shortcut icon" href="#"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <title>aMazeChallenge | Admin</title>
    <script src="js/Cookies.js"></script>
    <script>
        if (Cookies.cookieExists(Cookies.ADMIN_KEY_COOKIE)) {
            document.location.href = "index.jsp";
        }
    </script>
</head>
<body style="background-image: url('img/maze_background_pattern.png'); background-repeat: repeat">

    <div class="container">

        <div class="center-align">
            <img class="responsive-img" src="img/maze_banner_transparent.png" style="max-height: 200px" />
        </div>

        <div class="row white card">

            <div class="col s12 l6 offset-l3">

                <form name="authForm" onsubmit="event.preventDefault()">

                    <div class="center-align">
                        <h4>Admin panel authentication</h4>
                    </div>

                    <div style="height: 20px"></div>

                    <p>Please provide the app's admin key: <input type="password" name="adminKey" id="adminKey" placeholder="Admin key" required /></p>

                    <div style="height: 20px"></div>

                    <small>The app's admin key can be found in the console logs of the app once it is initialized.</small>

                    <div style="height: 20px"></div>

                    <div class="center-align">
                        <p><input type="button" id="authButton" class="btn indigo darken-3 white-text" value="Authenticate" onclick="authenticate()" /></p>
                    </div>

                </form>

            </div>

        </div>

    </div>

    <script>

        const adminKeyField = document.getElementById("adminKey");
        const authButton = document.getElementById("authButton");

        function authenticate() {

            const adminKey = adminKeyField.value;
            if (adminKey.length === 0) {
                alert("Please provide an admin key.");
                return;
            }

            //HTTP:
            const url = "../admin/auth?adminKey=" + adminKey;

            const httpOptions = {
                method: "POST",
            };

            authButton.style.visibility = "hidden";

            fetch(url, httpOptions)
                .then(response => response.text())
                .then(text => {
                    authButton.style.visibility = "visible";
                    if (text.includes("Error")) {
                        alert(text);
                    }
                    else {
                        Cookies.setCookie(Cookies.ADMIN_KEY_COOKIE, adminKey);
                        document.location.href = "index.jsp";
                    }
                })


        }
    </script>

</body>
</html>
