package org.inspirecenter.amazechallenge.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.protobuf.InvalidProtocolBufferException;

import org.inspirecenter.amazechallenge.model.QuestionEntry;
import org.inspirecenter.amazechallenge.model.QuestionnaireEntry;
import org.inspirecenter.amazechallenge.proto.ChallengeProto;
import org.inspirecenter.amazechallenge.proto.DichotomousResponse;
import org.inspirecenter.amazechallenge.proto.LikertResponse;

import org.inspirecenter.amazechallenge.R;
import org.inspirecenter.amazechallenge.proto.SubmitQuestionnaireRequest;
import org.inspirecenter.amazechallenge.proto.SubmitQuestionnaireResponse;
import org.inspirecenter.amazechallenge.stubs.BinaryRequest;
import org.inspirecenter.amazechallenge.stubs.Stubs;

import java.util.ArrayList;
import java.util.Arrays;

import static org.inspirecenter.amazechallenge.ui.MainActivity.setLanguage;

public class QuestionnaireActivity extends AppCompatActivity {

    public static final String TAG = "amaze-questionnaire";

    public static final String CHALLENGE_KEY = "ChallengeID";

    //Views:
    private Button skipButton;
    private Button submitButton;

    private RatingBar overallExperienceRatingBar;
    private RatingBar singleplayerExperienceRatingBar;
    private RatingBar multiplayerExperienceRatingBar;

    private RadioButton currentExperience_Novice_RadioButton;
    private RadioButton currentExperience_Intermediate_RadioButton;
    private RadioButton currentExperience_Confident_RadioButton;
    private RadioButton currentExperience_Expert_RadioButton;
    private RadioButton currentExperience_NotSure_RadioButton;

    private RadioButton opinion_VeryInteresting_RadioButton;
    private RadioButton opinion_Interesting_RadioButton;
    private RadioButton opinion_Neutral_RadioButton;
    private RadioButton opinion_Boring_RadioButton;
    private RadioButton opinion_VeryBoring_RadioButton;

    private RadioButton difficulty_VeryEasy_RadioButton;
    private RadioButton difficulty_Easy_RadioButton;
    private RadioButton difficulty_Difficult_RadioButton;
    private RadioButton difficulty_VeryDifficult_RadioButton;
    private RadioButton difficulty_NotSure_RadioButton;

    private RadioButton helpful_ExtremelyHelpful_RadioButton;
    private RadioButton helpful_Helpful_RadioButton;
    private RadioButton helpful_Neutral_RadioButton;
    private RadioButton helpful_NotHelpful_RadioButton;
    private RadioButton helpful_Ineffective_RadioButton;

    private RadioButton skillsAffected_SignificantlyImproved_RadioButton;
    private RadioButton skillsAffected_SlightlyImproved_RadioButton;
    private RadioButton skillsAffected_NoChange_RadioButton;
    private RadioButton skillsAffected_Reduced_RadioButton;
    private RadioButton skillsAffected_SeverelyReduced_RadioButton;

    private RadioButton competition_DefinitelyGood_RadioButton;
    private RadioButton competition_Good_RadioButton;
    private RadioButton competition_Neutral_RadioButton;
    private RadioButton competition_Bad_RadioButton;
    private RadioButton competition_DefinitelyBad_RadioButton;

    private RadioButton playAgain_VeryLikely_RadioButton;
    private RadioButton playAgain_Likely_RadioButton;
    private RadioButton playAgain_Unlikely_RadioButton;
    private RadioButton playAgain_VeryUnlikely_RadioButton;
    private RadioButton playAgain_NotSure_RadioButton;

    private EditText bestFeaturesEditText;
    private EditText worstFeaturesEditText;
    private EditText extraCommentsEditText;

    //Answers:
    private float q1Answer;
    private float q2Answer;
    private float q3Answer;
    private int q4Answer;
    private int q5Answer;
    private int q6Answer;
    private int q7Answer;
    private int q8Answer;
    private int q9Answer;
    private int q10Answer;
    private String q11Answer;
    private String q12Answer;
    private String q13Answer;

    private ChallengeProto challenge;
    private String worldSessionID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setLanguage(this);
        setContentView(R.layout.activity_questionnaire);

        this.challenge = (ChallengeProto) getIntent().getSerializableExtra("challenge");
        this.worldSessionID = getIntent().getStringExtra("worldSessionID");

        //Controls:
        overallExperienceRatingBar = findViewById(R.id.answerOverallExperience);
        singleplayerExperienceRatingBar = findViewById(R.id.answerSinglePlayerExperience);
        multiplayerExperienceRatingBar = findViewById(R.id.answerMultiplayerExperience);

        currentExperience_Novice_RadioButton = findViewById(R.id.levelOfProgrammingRadio1);
        currentExperience_Intermediate_RadioButton = findViewById(R.id.levelOfProgrammingRadio2);
        currentExperience_Confident_RadioButton = findViewById(R.id.levelOfProgrammingRadio3);
        currentExperience_Expert_RadioButton = findViewById(R.id.levelOfProgrammingRadio4);
        currentExperience_NotSure_RadioButton = findViewById(R.id.levelOfProgrammingRadio5);

        opinion_VeryInteresting_RadioButton = findViewById(R.id.programmingOpinionRadio1);
        opinion_Interesting_RadioButton = findViewById(R.id.programmingOpinionRadio2);
        opinion_Neutral_RadioButton = findViewById(R.id.programmingOpinionRadio3);
        opinion_Boring_RadioButton = findViewById(R.id.programmingOpinionRadio4);
        opinion_VeryBoring_RadioButton = findViewById(R.id.programmingOpinionRadio5);

        difficulty_VeryEasy_RadioButton = findViewById(R.id.difficultyRadio1);
        difficulty_Easy_RadioButton = findViewById(R.id.difficultyRadio2);
        difficulty_Difficult_RadioButton = findViewById(R.id.difficultyRadio3);
        difficulty_VeryDifficult_RadioButton = findViewById(R.id.difficultyRadio4);
        difficulty_NotSure_RadioButton = findViewById(R.id.difficultyRadio5);

        helpful_ExtremelyHelpful_RadioButton = findViewById(R.id.helpfulnessRadio1);
        helpful_Helpful_RadioButton = findViewById(R.id.helpfulnessRadio2);
        helpful_Neutral_RadioButton = findViewById(R.id.helpfulnessRadio3);
        helpful_NotHelpful_RadioButton = findViewById(R.id.helpfulnessRadio4);
        helpful_Ineffective_RadioButton = findViewById(R.id.helpfulnessRadio5);

        skillsAffected_SignificantlyImproved_RadioButton = findViewById(R.id.skillsAffectedRadio1);
        skillsAffected_SlightlyImproved_RadioButton = findViewById(R.id.skillsAffectedRadio2);
        skillsAffected_NoChange_RadioButton = findViewById(R.id.skillsAffectedRadio3);
        skillsAffected_Reduced_RadioButton = findViewById(R.id.skillsAffectedRadio4);
        skillsAffected_SeverelyReduced_RadioButton = findViewById(R.id.skillsAffectedRadio5);

        competition_DefinitelyGood_RadioButton = findViewById(R.id.competitionRadio1);
        competition_Good_RadioButton = findViewById(R.id.competitionRadio2);
        competition_Neutral_RadioButton = findViewById(R.id.competitionRadio3);
        competition_Bad_RadioButton = findViewById(R.id.competitionRadio4);
        competition_DefinitelyBad_RadioButton = findViewById(R.id.competitionRadio5);

        playAgain_VeryLikely_RadioButton = findViewById(R.id.playAgainRadio1);
        playAgain_Likely_RadioButton = findViewById(R.id.playAgainRadio2);
        playAgain_Unlikely_RadioButton = findViewById(R.id.playAgainRadio3);
        playAgain_VeryUnlikely_RadioButton = findViewById(R.id.playAgainRadio4);
        playAgain_NotSure_RadioButton = findViewById(R.id.playAgainRadio5);

        bestFeaturesEditText = findViewById(R.id.bestFeaturesAnswer);
        worstFeaturesEditText = findViewById(R.id.worstFeaturesAnswer);
        extraCommentsEditText = findViewById(R.id.extraCommentsAnswer);

        submitButton = findViewById(R.id.submit_button);
        skipButton = findViewById(R.id.skip_button);

        //Submit Button:
        submitButton.setOnClickListener(view -> submitAnswers());

        //Skip Button:
        skipButton.setOnClickListener(view -> finish());

    }

    private int getActiveIndex(boolean[] entries) {
        if (entries.length == 0) {
            return -1;
        }
        for (int i = 0; i < entries.length; i++) {
            if (entries[i]) {
                return i;
            }
        }
        return -1;
    }

    private void getAnswers() {
        q1Answer = overallExperienceRatingBar.getRating();
        q2Answer = singleplayerExperienceRatingBar.getRating();
        q3Answer = multiplayerExperienceRatingBar.getRating();

        //Q4:
        boolean[] q4 = {
                currentExperience_Novice_RadioButton.isChecked(),
                currentExperience_Intermediate_RadioButton.isChecked(),
                currentExperience_Confident_RadioButton.isChecked(),
                currentExperience_Expert_RadioButton.isChecked(),
                currentExperience_NotSure_RadioButton.isChecked()
        };
        q4Answer = getActiveIndex(q4);

        //Q5:
        boolean[] q5 = {
                opinion_VeryInteresting_RadioButton.isChecked(),
                opinion_Interesting_RadioButton.isChecked(),
                opinion_Neutral_RadioButton.isChecked(),
                opinion_Boring_RadioButton.isChecked(),
                opinion_VeryBoring_RadioButton.isChecked()
        };
        q5Answer = getActiveIndex(q5);

        //Q6:
        boolean[] q6 = {
                difficulty_VeryEasy_RadioButton.isChecked(),
                difficulty_Easy_RadioButton.isChecked(),
                difficulty_Difficult_RadioButton.isChecked(),
                difficulty_VeryDifficult_RadioButton.isChecked(),
                difficulty_NotSure_RadioButton.isChecked()
        };
        q6Answer = getActiveIndex(q6);

        //Q7:
        boolean[] q7 = {
                helpful_ExtremelyHelpful_RadioButton.isChecked(),
                helpful_Helpful_RadioButton.isChecked(),
                helpful_Neutral_RadioButton.isChecked(),
                helpful_NotHelpful_RadioButton.isChecked(),
                helpful_Ineffective_RadioButton.isChecked()
        };
        q7Answer = getActiveIndex(q7);

        //Q8:
        boolean[] q8 = {
                skillsAffected_SignificantlyImproved_RadioButton.isChecked(),
                skillsAffected_SlightlyImproved_RadioButton.isChecked(),
                skillsAffected_NoChange_RadioButton.isChecked(),
                skillsAffected_Reduced_RadioButton.isChecked(),
                skillsAffected_SeverelyReduced_RadioButton.isChecked()
        };
        q8Answer = getActiveIndex(q8);

        //Q9:
        boolean[] q9 = {
                competition_DefinitelyGood_RadioButton.isChecked(),
                competition_Good_RadioButton.isChecked(),
                competition_Neutral_RadioButton.isChecked(),
                competition_Bad_RadioButton.isChecked(),
                competition_DefinitelyBad_RadioButton.isChecked()
        };
        q9Answer = getActiveIndex(q9);

        //Q10:
        boolean[] q10 = {
                playAgain_VeryLikely_RadioButton.isChecked(),
                playAgain_Likely_RadioButton.isChecked(),
                playAgain_Unlikely_RadioButton.isChecked(),
                playAgain_VeryUnlikely_RadioButton.isChecked(),
                playAgain_NotSure_RadioButton.isChecked()
        };
        q10Answer = getActiveIndex(q10);

        //Q11:
        q11Answer = bestFeaturesEditText.getText().toString();

        //Q12:
        q12Answer = worstFeaturesEditText.getText().toString();

        //Q13:
        q13Answer = extraCommentsEditText.getText().toString();

    }

    private void submitAnswers() {

        getAnswers();

        if (checkAnswers()) {

            //Create the entry:
            final QuestionEntry[] questionEntries = {
                    new QuestionEntry(getString(R.string.questionOverallExperience), Float.toString(q1Answer)),
                    new QuestionEntry(getString(R.string.questionSingleplayerExperience), Float.toString(q2Answer)),
                    new QuestionEntry(getString(R.string.questionMultiplayerExperience), Float.toString(q3Answer)),
                    new QuestionEntry(getString(R.string.questionLevelOfProgramming), Integer.toString(q4Answer)),
                    new QuestionEntry(getString(R.string.what_is_your_opinion_about_programming), Integer.toString(q5Answer)),
                    new QuestionEntry(getString(R.string.how_easy_or_difficult_is_it_to_play_amazechallenge), Integer.toString(q6Answer)),
                    new QuestionEntry(getString(R.string.how_helpful_was_amazechallenge_to_teach_you_programming), Integer.toString(q7Answer)),
                    new QuestionEntry(getString(R.string.how_are_your_programming_skills_affected_by_playing_amazechallenge), Integer.toString(q8Answer)),
                    new QuestionEntry(getString(R.string.do_you_believe_competition_is_good_or_bad_when_learning_programming), Integer.toString(q9Answer)),
                    new QuestionEntry(getString(R.string.how_likely_is_it_to_play_this_game_again_in_the_future), Integer.toString(q10Answer)),
                    new QuestionEntry(getString(R.string.best_features), q11Answer),
                    new QuestionEntry(getString(R.string.worst_features), q12Answer),
                    new QuestionEntry(getString(R.string.extra_comments_question), q13Answer),
            };

            final String name = PreferenceManager.getDefaultSharedPreferences(this).getString(PersonalizeActivity.PREFERENCE_KEY_NAME, "");
            final String email = PreferenceManager.getDefaultSharedPreferences(this).getString(PersonalizeActivity.PREFERENCE_KEY_EMAIL, "");

            final QuestionnaireEntry questionnaireEntry = new QuestionnaireEntry();
            questionnaireEntry.setChallengeID(challenge.getId());
            questionnaireEntry.setId(worldSessionID);
            questionnaireEntry.setQuestionEntry(new ArrayList<>(Arrays.asList(questionEntries)));
            questionnaireEntry.setParticipantEmail(email);
            questionnaireEntry.setParticipantName(name);
            submitQuestionnaireHTTP(questionnaireEntry);

        }
        else Toast.makeText(this, R.string.invalid_questionnaire_response, Toast.LENGTH_LONG).show();
    }

    private boolean checkAnswers() {

        //Q1
        if (q1Answer < 0) {
            overallExperienceRatingBar.requestFocus();
            return false;
        }

        //Q2
        if (q2Answer < 0) {
            singleplayerExperienceRatingBar.requestFocus();
            return false;
        }

        //Q3
        if (q3Answer < 0) {
            multiplayerExperienceRatingBar.requestFocus();
            return false;
        }

        //Q4
        if (q4Answer < 0) {
            currentExperience_Novice_RadioButton.requestFocus();
            currentExperience_Novice_RadioButton.setError(getString(R.string.no_response));
        }

        //Q5
        if (q5Answer < 0) {
            opinion_VeryInteresting_RadioButton.requestFocus();
            opinion_VeryInteresting_RadioButton.setError(getString(R.string.no_response));
        }

        //Q6
        if (q6Answer < 0) {
            difficulty_VeryEasy_RadioButton.requestFocus();
            difficulty_VeryEasy_RadioButton.setError(getString(R.string.no_response));
        }

        //Q7
        if (q7Answer < 0) {
            helpful_ExtremelyHelpful_RadioButton.requestFocus();
            helpful_ExtremelyHelpful_RadioButton.setError(getString(R.string.no_response));
        }

        //Q8
        if (q8Answer < 0) {
            skillsAffected_SignificantlyImproved_RadioButton.requestFocus();
            skillsAffected_SignificantlyImproved_RadioButton.setError(getString(R.string.no_response));
        }

        //Q9
        if (q9Answer < 0) {
            competition_DefinitelyGood_RadioButton.requestFocus();
            competition_DefinitelyGood_RadioButton.setError(getString(R.string.no_response));
        }

        //Q10
        if (q10Answer < 0) {
            playAgain_VeryLikely_RadioButton.requestFocus();
            playAgain_VeryLikely_RadioButton.setError(getString(R.string.no_response));
        }

        return true;
    }

    private void submitQuestionnaireHTTP(QuestionnaireEntry questionnaireEntry) {

        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = Stubs.BASE_URL + "/api/submitQuestionnaire";

        SubmitQuestionnaireRequest submitQuestionnaireRequest = SubmitQuestionnaireRequest.newBuilder()
                .setWorldSessionID(worldSessionID)
                .setQuestionnaireEntry(questionnaireEntry.toProto())
                .build();

        BinaryRequest request = new BinaryRequest(Request.Method.POST, url, submitQuestionnaireRequest, response -> {
            try {
                SubmitQuestionnaireResponse submitQuestionnaireResponse = SubmitQuestionnaireResponse.parseFrom(response);
                if (submitQuestionnaireResponse.getStatus() == SubmitQuestionnaireResponse.Status.OK) {
                    Toast.makeText(QuestionnaireActivity.this, R.string.thank_feedback, Toast.LENGTH_LONG).show();
                    finish();
                }
                else {
                    showUploadFailDialog(questionnaireEntry);
                }
            } catch (InvalidProtocolBufferException e) {
                showUploadFailDialog(questionnaireEntry);
            }
        }, error -> {
            showUploadFailDialog(questionnaireEntry);
        });

        queue.add(request);
    }

    private void showUploadFailDialog(QuestionnaireEntry questionnaireEntry) {
        new AlertDialog.Builder(QuestionnaireActivity.this)
                .setTitle(R.string.error)
                .setMessage(R.string.questionnaire_upload_fail)
                .setPositiveButton(R.string.try_again, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        submitQuestionnaireHTTP(questionnaireEntry);
                    }
                })
                .setNegativeButton(R.string.go_back, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .create().show();
    }

}