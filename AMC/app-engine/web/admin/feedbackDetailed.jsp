<%@ page import="org.inspirecenter.amazechallenge.persistence.DBManager" %>
<%@ page import="org.inspirecenter.amazechallenge.model.Challenge" %>
<%@ page import="java.util.Collection" %>
<%@ page import="org.inspirecenter.amazechallenge.model.QuestionnaireEntry" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.inspirecenter.amazechallenge.model.QuestionEntry" %><%--
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
    <title>aMazeChallenge - Feedback</title>
    <script src="js/materialize.min.js"></script>
    <script src="js/Cookies.js"></script>
    <script>
        if (!Cookies.cookieExists(Cookies.ADMIN_KEY_COOKIE)) {
            document.location.href = "index.jsp";
        }
        document.addEventListener('DOMContentLoaded', function() {
            var elems = document.querySelectorAll('.modal');
            var instances = M.Modal.init(elems, {});
        });
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
                        <h4>Feedback</h4>
                    </div>

                    <div class="col s12 l6">
                        <h5>Filter by challenge</h5>
                        <div class="collection">
                            <a href="feedback.jsp" class="collection-item white indigo-text">All</a>
                            <%!
                                String listChallenges() {
                                    String output = "";
                                    Collection<Challenge> challenges = DBManager.challenge.list();
                                    for (Challenge challenge : challenges) {
                                        output += "<a href=\"feedbackDetailed.jsp?challengeID=" + challenge.getId() + "\" class=\"collection-item white indigo-text\">" + challenge.getName() + "</a>";
                                    }
                                    return output;
                                }
                            %>
                            <%= listChallenges()%>

                        </div>
                    </div>

                    <div class="col s12 l6">
                        <a class="btn btn-small blue white-text right" href="feedback.jsp">View less details</a>
                        <div class="clearfix"></div>
                        <br/>
                        <button class="btn btn-small blue white-text right" onclick="exportToCSV()">Export to CSV</button>
                    </div>

                    <div class="clearfix"></div>
                    <hr />

                    <%

                        final Collection<QuestionnaireEntry> allEntries = DBManager.questionnaireEntry.list();
                        ArrayList<QuestionnaireEntry> usedEntries = new ArrayList<>();
                        final String challengeID = request.getParameter("challengeID");
                        if (challengeID != null && !challengeID.isEmpty()) {
                            for (QuestionnaireEntry entry : allEntries) {
                                if (entry.getChallengeID().equals(challengeID)) {
                                    usedEntries.add(entry);
                                }
                            }
                        }
                        else {
                            usedEntries.addAll(allEntries);
                        }

                    %>

                    <h5>Questions:</h5>
                    <ol>
                        <li>Rate your overall experience with aMazeChallenge.</li>
                        <li>Rate your experience with the single-player (training) mode of aMazeChallenge.</li>
                        <li>Rate your experience with the multi-player (online) mode of aMazeChallenge.</li>
                        <li>What is the current level of your programming experience?</li>
                        <li>What is your opinion about programming?</li>
                        <li>How easy or difficult is it to play aMazeChallenge?</li>
                        <li>How helpful was aMazeChallenge to teach you programming?</li>
                        <li>How are your programming skills affected by playing aMazeChallenge?</li>
                        <li>Do you believe competition is good or bad when learning programming?</li>
                        <li>How likely is it to play this game again in the future?</li>
                        <li>What are the best features of aMazeChallenge?</li>
                        <li>What are the worst features of aMazeChallenge?</li>
                        <li>Is there anything else you would like to add? (Please provide suggestions for improvement, any issues you faced, or additional comments)</li>
                    </ol>


                    <h5>Responses:</h5>

                    <table>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Challenge ID</th>
                            <th>Q1</th>
                            <th>Q2</th>
                            <th>Q3</th>
                            <th>Q4</th>
                            <th>Q5</th>
                            <th>Q6</th>
                            <th>Q7</th>
                            <th>Q8</th>
                            <th>Q9</th>
                            <th>Q10</th>
                            <th>Q11</th>
                            <th>Q12</th>
                            <th>Q13</th>
                        </tr>
                            <%!

                                String printEntries(ArrayList<QuestionnaireEntry> usedEntries) {
                                    String print = "";
                                    for (QuestionnaireEntry usedEntry : usedEntries) {
                                        print += "<tr>";
                                        print += "<td>" + usedEntry.getParticipantName() + "</td>";
                                        print += "<td>" + usedEntry.getParticipantEmail() + "</td>";
                                        print += "<td>" + usedEntry.getChallengeID() + "</td>";
                                        for (QuestionEntry questionEntry : usedEntry.getQuestionEntry()) {
                                            print += "<td>" + questionEntry.getAnswerText() + "</td>";
                                        }
                                        print += "</tr>";
                                    }
                                    return print;
                                }

                            %>
                        <%= printEntries(usedEntries) %>
                    </table>


                </div>

            </div>

        </div>

    </div>

    <script>
        function exportToCSV() {

            let data = "Questions\n"
            data += "Rate your overall experience with aMazeChallenge.\n" +
            "Rate your experience with the single-player (training) mode of aMazeChallenge.\n" +
                "Rate your experience with the multi-player (online) mode of aMazeChallenge.\n" +
                "What is the current level of your programming experience?\n" +
                "What is your opinion about programming?\n" +
                "How easy or difficult is it to play aMazeChallenge?\n" +
                "How helpful was aMazeChallenge to teach you programming?\n" +
                "How are your programming skills affected by playing aMazeChallenge?\n" +
                "Do you believe competition is good or bad when learning programming?\n" +
                "How likely is it to play this game again in the future?\n" +
                "What are the best features of aMazeChallenge?\n" +
                "What are the worst features of aMazeChallenge?\n" +
                "Is there anything else you would like to add? (Please provide suggestions for improvement any issues you faced or additional comments)\n"
            ;

            data += "\n";
            data += "Responses\n";

            data += "Name,Email,Challenge ID,Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13\n";

            <%!

            String toCSVData(ArrayList<QuestionnaireEntry> usedEntries) {
                String output = "";
                for (QuestionnaireEntry usedEntry : usedEntries) {
                    output += usedEntry.getParticipantName() + ",";
                    output += usedEntry.getParticipantEmail() + ",";
                    output += usedEntry.getChallengeID() + ",";
                  for (QuestionEntry questionEntry : usedEntry.getQuestionEntry()) {
                    output += questionEntry.getAnswerText() + ",";
                  }
                  output += "\\n";
                }
                return output;
            }

            %>

            data += "<%=toCSVData(usedEntries)%>";

            downloadFile(data, "feedback.csv", "text/csv");

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
    </script>

</div>

</body>
</html>
