<%--
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
    <title>aMazeChallenge - Admin key</title>
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
                        <h4>Admin key</h4>
                    </div>

                    <form onsubmit="event.preventDefault();">
                        <p>Admin key: <input type="text" id="newAdminKey" required/></p>
                        <script>
                            const newAdminKeyField = document.getElementById("newAdminKey");
                            newAdminKeyField.value = Cookies.getCookie(Cookies.ADMIN_KEY_COOKIE);
                        </script>
                        <p><input class="btn indigo darken-3 white-text" id="changeButton" type="button"
                                  onclick="changeKey()" value="Change key"/></p>
                    </form>


                    <script>

                        const changeButton = document.getElementById("changeButton");

                        function changeKey() {
                            const newKey = newAdminKeyField.value;
                            if (newKey.length < 6) {
                                alert("Please provide a key that contains 6 characters or more.");
                                return;
                            }

                            //HTTP:
                            const url = "../admin/changeAdminKey?adminKey=" + Cookies.getCookie(Cookies.ADMIN_KEY_COOKIE) + "&newAdminKey=" + newKey;

                            const httpOptions = {
                                method: "POST",
                            };

                            changeButton.style.visibility = "hidden";

                            fetch(url, httpOptions)
                                .then(response => response.text())
                                .then(text => {
                                    changeButton.style.visibility = "visible";
                                    if (text.includes("Error")) {
                                        alert(text);
                                    } else {
                                        changeButton.style.visibility = "visible";
                                        Cookies.setCookie(Cookies.ADMIN_KEY_COOKIE, newKey);
                                        newAdminKeyField.value = newKey;
                                        alert("The admin key has been updated successfully.\nAdmin key: " + newKey)
                                    }
                                })

                        }
                    </script>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>
