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
                                        output += "<a href=\"feedback.jsp?challengeID=" + challenge.getId() + "\" class=\"collection-item white indigo-text\">" + challenge.getName() + "</a>";
                                    }
                                    return output;
                                }
                            %>
                            <%= listChallenges()%>

                        </div>
                    </div>

                    <div class="col s12 l6">
                        <a class="right" href="feedbackDetailed.jsp">View more details</a>
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

                        //Question 1:
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

                        //Question 2:
                        double question2Average = 0;
                        double question2Min = Double.MAX_VALUE;
                        double question2Max = Double.MIN_VALUE;
                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(1).getAnswerText();
                            final double v = Double.parseDouble(answerText);
                            question2Average += v;
                            if (v < question2Min) {
                                question2Min = v;
                            }
                            if (v > question2Max) {
                                question2Max = v;
                            }
                        }

                        if (usedEntries.size() > 0) {
                            question2Average = question2Average / (double) usedEntries.size();
                        }

                        //Question 3:
                        double question3Average = 0;
                        double question3Min = Double.MAX_VALUE;
                        double question3Max = Double.MIN_VALUE;
                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(2).getAnswerText();
                            final double v = Double.parseDouble(answerText);
                            question3Average += v;
                            if (v < question3Min) {
                                question3Min = v;
                            }
                            if (v > question3Max) {
                                question3Max = v;
                            }
                        }

                        if (usedEntries.size() > 0) {
                            question3Average = question3Average / (double) usedEntries.size();
                        }

                        //Question 4:
                        int q4Novice = 0;
                        int q4Intermediate = 0;
                        int q4Confident = 0;
                        int q4Expert = 0;
                        int q4NotSure = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(3).getAnswerText();
                            final int v = Integer.parseInt(answerText);
                            switch (v) {
                                case 0:
                                    q4Novice++;
                                    break;
                                case 1:
                                    q4Intermediate++;
                                    break;
                                case 2:
                                    q4Confident++;
                                    break;
                                case 3:
                                    q4Expert++;
                                    break;
                                case 4:
                                    q4NotSure++;
                                    break;
                            }
                        }

                        //Question 5:
                        int q5VeryInteresting = 0;
                        int q5Interesting = 0;
                        int q5Neutral = 0;
                        int q5Boring = 0;
                        int q5VeryBoring = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(4).getAnswerText();
                            final int v = Integer.parseInt(answerText);
                            switch (v) {
                                case 0:
                                    q5VeryInteresting++;
                                    break;
                                case 1:
                                    q5Interesting++;
                                    break;
                                case 2:
                                    q5Neutral++;
                                    break;
                                case 3:
                                    q5Boring++;
                                    break;
                                case 4:
                                    q5VeryBoring++;
                                    break;
                            }
                        }

                        //Question 6:
                        int q6VeryEasy = 0;
                        int q6Easy = 0;
                        int q6IDoNotKnow = 0;
                        int q6Difficult = 0;
                        int q6VeryDifficult = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(5).getAnswerText();
                            final int v = Integer.parseInt(answerText);
                            switch (v) {
                                case 0:
                                    q6VeryEasy++;
                                    break;
                                case 1:
                                    q6Easy++;
                                    break;
                                case 2:
                                    q6IDoNotKnow++;
                                    break;
                                case 3:
                                    q6Difficult++;
                                    break;
                                case 4:
                                    q6VeryDifficult++;
                                    break;
                            }
                        }

                        //Question 7:
                        int q7ExtremelyHelpful = 0;
                        int q7Helpful = 0;
                        int q7Neutral = 0;
                        int q7NotHelpful = 0;
                        int q7Ineffective = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(6).getAnswerText();
                            final int v = Integer.parseInt(answerText);
                            switch (v) {
                                case 0:
                                    q7ExtremelyHelpful++;
                                    break;
                                case 1:
                                    q7Helpful++;
                                    break;
                                case 2:
                                    q7Neutral++;
                                    break;
                                case 3:
                                    q7NotHelpful++;
                                    break;
                                case 4:
                                    q7Ineffective++;
                                    break;
                            }
                        }

                        //Question 8:
                        int q8SignImproved = 0;
                        int q8SlightImproved = 0;
                        int q8NoChange = 0;
                        int q8Reduced = 0;
                        int q8SevReduced = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(7).getAnswerText();
                            final int v = Integer.parseInt(answerText);
                            switch (v) {
                                case 0:
                                    q8SignImproved++;
                                    break;
                                case 1:
                                    q8SlightImproved++;
                                    break;
                                case 2:
                                    q8NoChange++;
                                    break;
                                case 3:
                                    q8Reduced++;
                                    break;
                                case 4:
                                    q8SevReduced++;
                                    break;
                            }
                        }

                        //Question 9:
                        int q9DefGood = 0;
                        int q9Good = 0;
                        int q9Neutral = 0;
                        int q9Bad = 0;
                        int q9DefBad = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(8).getAnswerText();
                            final int v = Integer.parseInt(answerText);
                            switch (v) {
                                case 0:
                                    q9DefGood++;
                                    break;
                                case 1:
                                    q9Good++;
                                    break;
                                case 2:
                                    q9Neutral++;
                                    break;
                                case 3:
                                    q9Bad++;
                                    break;
                                case 4:
                                    q9DefBad++;
                                    break;
                            }
                        }


                        //Question 10:
                        int q10VeryLikely = 0;
                        int q10Likely = 0;
                        int q10NotSure = 0;
                        int q10Unlikely = 0;
                        int q10VeryUnlikely = 0;

                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(9).getAnswerText();
                            final int v = Integer.parseInt(answerText);
                            switch (v) {
                                case 0:
                                    q10VeryLikely++;
                                    break;
                                case 1:
                                    q10Likely++;
                                    break;
                                case 2:
                                    q10NotSure++;
                                    break;
                                case 3:
                                    q10Unlikely++;
                                    break;
                                case 4:
                                    q10VeryUnlikely++;
                                    break;
                            }
                        }

                        //Question 11:
                        String question11Answers = "";
                        int entryIndex = 1;
                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(10).getAnswerText();
                            question11Answers += "Entry " + entryIndex + ":<br/>" + answerText + "<br/><br/>";
                            entryIndex++;
                        }

                        //Question 12:
                        String question12Answers = "";
                        entryIndex = 1;
                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(11).getAnswerText();
                            question12Answers += "Entry " + entryIndex + ":<br/>" + answerText + "<br/><br/>";
                            entryIndex++;
                        }

                        //Question 13:
                        String question13Answers = "";
                        entryIndex = 1;
                        for (QuestionnaireEntry usedEntry : usedEntries) {
                            final String answerText = usedEntry.getQuestionEntry().get(12).getAnswerText();
                            question13Answers += "Entry " + entryIndex + ":<br/>" + answerText + "<br/><br/>";
                            entryIndex++;
                        }

                    %>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 1</h5>
                            <p>Rate your overall experience with aMazeChallenge.</p>
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
                            <p>Rate your experience with the single-player (training) mode of aMazeChallenge.</p>
                            <p>
                                Min response: <%= question2Min == Double.MAX_VALUE ? "N/A" : String.format("%1.0f/5", question2Min) %> <br/>
                                Max response: <%= question2Max == Double.MIN_VALUE ? "N/A" : String.format("%1.0f/5", question2Max) %><br/>
                                Average response: <%= String.format("%1.2f/5", question2Average) %>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 3</h5>
                            <p>Rate your experience with the multi-player (online) mode of aMazeChallenge.</p>
                            <p>
                                Min response: <%= question3Min == Double.MAX_VALUE ? "N/A" : String.format("%1.0f/5", question3Min) %> <br/>
                                Max response: <%= question3Max == Double.MIN_VALUE ? "N/A" : String.format("%1.0f/5", question3Max) %><br/>
                                Average response: <%= String.format("%1.2f/5", question3Average) %>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 4</h5>
                            <p>What is the current level of your programming experience?</p>
                            <p>
                                Novice: <%= q4Novice %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q4Novice / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Intermediate: <%= q4Intermediate %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q4Intermediate / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Confident: <%= q4Confident %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q4Confident / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Expert: <%= q4Expert %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q4Expert / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Not sure: <%= q4NotSure %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q4NotSure / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 5</h5>
                            <p>What is your opinion about programming?</p>
                            <p>
                                Very interesting: <%= q5VeryInteresting %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q5VeryInteresting / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Interesting: <%= q5Interesting %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q5Interesting / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Neutral: <%= q5Neutral %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q5Neutral / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Boring: <%= q5Boring %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q5Boring / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Very boring: <%= q5VeryBoring %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q5VeryBoring / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 6</h5>
                            <p>How easy or difficult is it to play aMazeChallenge?</p>
                            <p>
                                Very easy: <%= q6VeryEasy %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q6VeryEasy / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Easy: <%= q6Easy %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q6Easy / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                I do not know: <%= q6IDoNotKnow %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q6IDoNotKnow / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Difficult: <%= q6Difficult %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q6Difficult / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Very difficulty: <%= q6VeryDifficult %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q6VeryDifficult / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 7</h5>
                            <p>How helpful was aMazeChallenge to teach you programming?</p>
                            <p>
                                Extremely helpful: <%= q7ExtremelyHelpful %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q7ExtremelyHelpful / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Helpful: <%= q7Helpful %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q7Helpful / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Neutral: <%= q7Neutral %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q7Neutral / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Not helpful: <%= q7NotHelpful %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q7NotHelpful / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Completely ineffective: <%= q7Ineffective %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q7Ineffective / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 8</h5>
                            <p>How are your programming skills affected by playing aMazeChallenge?</p>
                            <p>
                                Significantly improved: <%= q8SignImproved %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q8SignImproved / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Slightly improved: <%= q8SlightImproved %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q8SlightImproved / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                No change: <%= q8NoChange %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q8NoChange / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Reduced: <%= q8Reduced %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q8Reduced / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Severely reduced: <%= q8SevReduced %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q8SevReduced / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 9</h5>
                            <p>Do you believe competition is good or bad when learning programming?</p>
                            <p>
                                Definitely good: <%= q9DefGood %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q9DefGood / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Good: <%= q9Good %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q9Good / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Neutral: <%= q9Neutral %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q9Neutral / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Bad: <%= q9Bad %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q9Bad / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Definitely bad: <%= q9DefBad %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q9DefBad / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 10</h5>
                            <p>How likely is it to play this game again in the future?</p>
                            <p>
                                Very likely: <%= q10VeryLikely %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q10VeryLikely / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Likely: <%= q10Likely %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q10Likely / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Not sure: <%= q10NotSure %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q10NotSure / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Unlikely: <%= q10Unlikely %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q10Unlikely / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                                Very unlikely: <%= q10VeryUnlikely %> (<%= !usedEntries.isEmpty() ? String.format("%.2f", q10VeryUnlikely / (float) usedEntries.size() * 100) : 0 %>%) <br/>
                            </p>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 11</h5>
                            <p>What are the best features of aMazeChallenge?</p>
                            <button class="btn btn-flat transparent blue-text" onclick="showModal('Question 11', '<%= question11Answers %>')">See responses</button>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 12</h5>
                            <p>What are the worst features of aMazeChallenge?</p>
                            <button class="btn btn-flat transparent blue-text" onclick="showModal('Question 12', '<%= question12Answers %>')">See responses</button>
                        </div>
                    </div>

                    <div class="col s12">
                        <div class="card-panel yellow lighten-4">
                            <h5>Question 13</h5>
                            <p>Is there anything else you would like to add? (Please provide suggestions for improvement, any issues you faced, or additional comments)</p>
                            <button class="btn btn-flat transparent blue-text" onclick="showModal('Question 13', '<%= question13Answers %>')">See responses</button>
                        </div>
                    </div>

                    <!-- Modal Structure -->
                    <div id="modal1" class="modal">
                        <div class="modal-content">
                            <h4 id="questionText"></h4>
                            <p id="responses"></p>
                        </div>
                        <div class="modal-footer">
                            <a href="#!" class="modal-close waves-effect waves-green btn-flat">OK</a>
                        </div>
                    </div>

                    <script>
                        const questionTextElement = document.getElementById("questionText");
                        const responseElement = document.getElementById("responses");

                        function showModal(question, responses) {
                            questionTextElement.innerHTML = question;
                            responseElement.innerHTML = responses;
                            var instance = M.Modal.getInstance(document.getElementById("modal1"));
                            instance.open();
                        }
                    </script>


                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>
