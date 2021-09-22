<%@ page import="org.inspirecenter.amazechallenge.persistence.DBManager" %>
<%@ page import="org.inspirecenter.amazechallenge.model.Challenge" %>
<%@ page import="java.util.Collection" %>
<%@ page import="org.inspirecenter.amazechallenge.model.QuestionnaireEntry" %>
<%@ page import="java.util.ArrayList" %><%--
  User: hfnov
  Date: 02-Sep-21
  Time: 12:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <%--    <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>--%>
    <title>aMazeChallenge - Feedback</title>
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
                                        output += "<a href=\"feedback.jsp?challengeID=" + challenge.getId() + "\" class=\"collection-item white indigo-text\">" + challenge.getName() + "</a>";
                                    }
                                    return output;
                                }
                            %>
                            <%= listChallenges()%>

                        </div>
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

                        double question1Average = 0;
                        double question1Min = Double.MAX_VALUE;
                        double question1Max = Double.MIN_VALUE;
                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(0).getAnswerText();
                            final double v = Double.parseDouble(answerText);
                            question1Average += v;
                            if (v < question1Min) {
                                question1Min = v;
                            }
                            if (v > question1Max) {
                                question1Max = v;
                            }
                        }

                        if (usedEntries.size() > 0) {
                            question1Average = question1Average / (double) usedEntries.size();
                        }

                        int question2Yes = 0;
                        int question2No = 0;
                        int question2Maybe = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(1).getAnswerText();
                            if (answerText.contains("YES")) {
                                question2Yes++;
                            }
                            else if (answerText.contains("NO")) {
                                question2No++;
                            }
                            else if (answerText.contains("MAYBE")) {
                                question2Maybe++;
                            }
                        }

                        int question3Yes = 0;
                        int question3No = 0;
                        int question3Maybe = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(2).getAnswerText();
                            if (answerText.contains("YES")) {
                                question3Yes++;
                            }
                            else if (answerText.contains("NO")) {
                                question3No++;
                            }
                            else if (answerText.contains("MAYBE")) {
                                question3Maybe++;
                            }
                        }

                        int question4VeryPositive = 0;
                        int question4VeryNegative = 0;
                        int question4Neutral = 0;
                        int question4Positive = 0;
                        int question4Negative = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(3).getAnswerText();
                            if (answerText.contains("VERY_POSITIVE")) {
                                question4VeryPositive++;
                            }
                            else if (answerText.contains("VERY_NEGATIVE")) {
                                question4VeryNegative++;
                            }
                            else if (answerText.contains("NEUTRAL")) {
                                question4Neutral++;
                            }
                            else if (answerText.contains("POSITIVE")) {
                                question4Positive++;
                            }
                            else if (answerText.contains("NEGATIVE")) {
                                question4Negative++;
                            }
                        }

                        int question5Yes = 0;
                        int question5No = 0;
                        int question5Maybe = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(4).getAnswerText();
                            if (answerText.contains("YES")) {
                                question5Yes++;
                            }
                            else if (answerText.contains("NO")) {
                                question5No++;
                            }
                            else if (answerText.contains("MAYBE")) {
                                question5Maybe++;
                            }
                        }

                        int question6Yes = 0;
                        int question6No = 0;
                        int question6Maybe = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(5).getAnswerText();
                            if (answerText.contains("YES")) {
                                question6Yes++;
                            }
                            else if (answerText.contains("NO")) {
                                question6No++;
                            }
                            else if (answerText.contains("MAYBE")) {
                                question6Maybe++;
                            }
                        }

                        int question7VeryPositive = 0;
                        int question7VeryNegative = 0;
                        int question7Neutral = 0;
                        int question7Positive = 0;
                        int question7Negative = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(6).getAnswerText();
                            if (answerText.contains("VERY_POSITIVE")) {
                                question7VeryPositive++;
                            }
                            else if (answerText.contains("VERY_NEGATIVE")) {
                                question7VeryNegative++;
                            }
                            else if (answerText.contains("NEUTRAL")) {
                                question7Neutral++;
                            }
                            else if (answerText.contains("POSITIVE")) {
                                question7Positive++;
                            }
                            else if (answerText.contains("NEGATIVE")) {
                                question7Negative++;
                            }
                        }

                        int question8Yes = 0;
                        int question8No = 0;
                        int question8Maybe = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(7).getAnswerText();
                            if (answerText.contains("YES")) {
                                question8Yes++;
                            }
                            else if (answerText.contains("NO")) {
                                question8No++;
                            }
                            else if (answerText.contains("MAYBE")) {
                                question8Maybe++;
                            }
                        }

                        String question9Answers = "";
                        int entryIndex = 1;
                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(8).getAnswerText();
                            question9Answers += "Entry " + entryIndex + ":" + "\\n" + answerText + "\\n\\n";
                            entryIndex++;
                        }

                        String question10Answers = "";
                        entryIndex = 1;
                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(9).getAnswerText();
                            question10Answers += "Entry " + entryIndex + ":" + "\\n" + answerText + "\\n\\n";
                            entryIndex++;
                        }

                    %>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 1</h5>
                            <p>
                                Min response: <%= question1Min == Double.MAX_VALUE ? "N/A" : String.format("%1.0f/5", question1Min) %> <br/>
                            Max response: <%= question1Max == Double.MIN_VALUE ? "N/A" : String.format("%1.0f/5", question1Max) %><br/>
                            Average response: <%= String.format("%1.2f/5", question1Average) %>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 2</h5>
                            <p>
                                Yes: <%= question2Yes%> <br/>
                                Maybe: <%= question2Maybe%> <br/>
                                No: <%= question2No%> <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 3</h5>
                            <p>
                                Very helpful: <%= question3Yes%> <br/>
                                Somewhat helpful: <%= question3Maybe%> <br/>
                                Not helpful: <%= question3No%> <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 4</h5>
                            <p>
                                Very positive: <%= question4VeryPositive%> <br/>
                                Positive: <%= question4Positive%> <br/>
                                Neutral: <%= question4Neutral%> <br/>
                                Negative: <%= question4Negative%> <br/>
                                Very negative: <%= question4VeryNegative%> <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 5</h5>
                            <p>
                                Very helpful: <%= question5Yes%> <br/>
                                Somewhat helpful: <%= question5Maybe%> <br/>
                                Not helpful: <%= question5No%> <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 6</h5>
                            <p>
                                Yes: <%= question6Yes%> <br/>
                                Not sure: <%= question6Maybe%> <br/>
                                No: <%= question6No%> <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 7</h5>
                            <p>
                                Significantly improved: <%= question7VeryPositive%> <br/>
                                Slightly improved: <%= question7Positive%> <br/>
                                The same: <%= question7Neutral%> <br/>
                                Reduced: <%= question7Negative%> <br/>
                                Significantly reduced: <%= question7VeryNegative%> <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 8</h5>
                            <p>
                                Would like to play again: <%= question8Yes%> <br/>
                                Not sure: <%= question8Maybe%> <br/>
                                Won't play again: <%= question8No%> <br/>
                            </p>
                        </div>
                    </div>

                    <script>

                        function showModal(question, responses) {
                            alert(question + "\n\n" + responses);
                        }
                    </script>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 9</h5>
                            <button class="btn btn-flat transparent blue-text" onclick="showModal('Question 9', '<%= question9Answers%>')">See responses</button>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 10</h5>
                            <button class="btn btn-flat transparent blue-text" onclick="showModal('Question 10', '<%= question10Answers%>')">See responses</button>
                        </div>
                    </div>


                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>
