package org.inspirecenter.amazechallenge.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.protobuf.InvalidProtocolBufferException;

import org.inspirecenter.amazechallenge.model.Challenge;
import org.inspirecenter.amazechallenge.model.QuestionEntry;
import org.inspirecenter.amazechallenge.model.QuestionnaireEntry;
import org.inspirecenter.amazechallenge.proto.Audio;
import org.inspirecenter.amazechallenge.proto.AudioFormat;
import org.inspirecenter.amazechallenge.proto.ChallengeProto;
import org.inspirecenter.amazechallenge.proto.DichotomousResponse;
import org.inspirecenter.amazechallenge.proto.GetStateRequest;
import org.inspirecenter.amazechallenge.proto.GetStateResponse;
import org.inspirecenter.amazechallenge.proto.LikertResponse;

import org.inspirecenter.amazechallenge.Installation;
import org.inspirecenter.amazechallenge.R;
import org.inspirecenter.amazechallenge.proto.SubmitCodeRequest;
import org.inspirecenter.amazechallenge.proto.SubmitQuestionnaireRequest;
import org.inspirecenter.amazechallenge.proto.SubmitQuestionnaireResponse;
import org.inspirecenter.amazechallenge.proto.UpdateStateResponse;
import org.inspirecenter.amazechallenge.stubs.AMCClient;
import org.inspirecenter.amazechallenge.stubs.BinaryRequest;
import org.inspirecenter.amazechallenge.stubs.Stubs;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;

import io.ably.lib.realtime.ChannelBase;
import io.ably.lib.types.AblyException;
import io.ably.lib.types.Message;

import static org.inspirecenter.amazechallenge.ui.GameActivity.DEFAULT_AMBIENT_VOLUME;
import static org.inspirecenter.amazechallenge.ui.MainActivity.setLanguage;
import static org.inspirecenter.amazechallenge.ui.OnlineGameActivity.convertStreamToString;

public class QuestionnaireActivity extends AppCompatActivity {

    public static final String TAG = "amaze-questionnaire";

    public static final String CHALLENGE_KEY = "ChallengeID";

    //Views:
    private Button skipButton;
    private Button submitButton;

    private RatingBar question_1_ratingBar;

    private RadioButton question2_no;
    private RadioButton question2_maybe;
    private RadioButton question2_yes;

    private RadioButton question3_high;
    private RadioButton question3_medium;
    private RadioButton question3_low;

    private RadioButton question4_veryHigh;
    private RadioButton question4_high;
    private RadioButton question4_medium;
    private RadioButton question4_low;
    private RadioButton question4_veryLow;

    private RadioButton question5_high;
    private RadioButton question5_medium;
    private RadioButton question5_low;

    private RadioButton question6_no;
    private RadioButton question6_notsure;
    private RadioButton question6_yes;

    private RadioButton question7_veryHigh;
    private RadioButton question7_high;
    private RadioButton question7_medium;
    private RadioButton question7_low;
    private RadioButton question7_veryLow;

    private RadioButton question8_no;
    private RadioButton question8_maybe;
    private RadioButton question8_yes;

    private EditText question9_answer;
    private EditText question10_answer;

    //Response values:
    float question1Response = -1;
    DichotomousResponse question2Response = null;
    DichotomousResponse question3Response = null;
    LikertResponse question4Response = null;
    DichotomousResponse question5Response = null;
    DichotomousResponse question6Response = null;
    LikertResponse question7Response = null;
    DichotomousResponse question8Response = null;
    String question9Response = null;
    String question10Response = null;

    private ChallengeProto challenge;
    private String worldSessionID;

    @Override
    public void onBackPressed() {
        //DO NOTHING - Do not allow player to return to the game unless they skip or finish the questionnaire.
    }

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
        question_1_ratingBar = findViewById(R.id.answer_1);
        question2_no = findViewById(R.id.question_2_no);
        question2_maybe = findViewById(R.id.question_2_maybe);
        question2_yes = findViewById(R.id.question_2_yes);
        question3_high = findViewById(R.id.q3_high);
        question3_medium = findViewById(R.id.q3_medium);
        question3_low = findViewById(R.id.q3_low);
        question4_veryHigh = findViewById(R.id.q4_veryhigh);
        question4_high = findViewById(R.id.q4_high);
        question4_medium = findViewById(R.id.q4_medium);
        question4_low = findViewById(R.id.q4_low);
        question4_veryLow = findViewById(R.id.q4_verylow);
        question5_high = findViewById(R.id.q5_high);
        question5_medium = findViewById(R.id.q5_medium);
        question5_low = findViewById(R.id.q5_low);
        question6_no = findViewById(R.id.question_6_no);
        question6_notsure = findViewById(R.id.question_6_notsure);
        question6_yes = findViewById(R.id.question_6_yes);
        question7_veryHigh = findViewById(R.id.q7_veryhigh);
        question7_high = findViewById(R.id.q7_high);
        question7_medium = findViewById(R.id.q7_medium);
        question7_low = findViewById(R.id.q7_low);
        question7_veryLow = findViewById(R.id.q7_verylow);
        question8_no = findViewById(R.id.q8_low);
        question8_maybe = findViewById(R.id.q8_medium);
        question8_yes = findViewById(R.id.q8_high);
        question9_answer = findViewById(R.id.question9_answer);
        question10_answer = findViewById(R.id.question10_answer);

        submitButton = findViewById(R.id.submit_button);
        skipButton = findViewById(R.id.skip_button);


        //--LISTENERS:

        //Q1:
        question_1_ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                question1Response = v;
            }
        });

        //Q2:
        question2_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question2Response = DichotomousResponse.NO_DichotomousResponse;
            }
        });

        question2_maybe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question2Response = DichotomousResponse.MAYBE_DichotomousResponse;
            }
        });

        question2_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question2Response = DichotomousResponse.YES_DichotomousResponse;
            }
        });

        //Q3:
        question3_high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question3Response = DichotomousResponse.YES_DichotomousResponse;
            }
        });

        question3_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question3Response = DichotomousResponse.MAYBE_DichotomousResponse;
            }
        });

        question3_low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question3Response = DichotomousResponse.NO_DichotomousResponse;
            }
        });

        //Q4:
        question4_veryHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question4Response = LikertResponse.VERY_POSITIVE_LikertResponse;
            }
        });

        question4_high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question4Response = LikertResponse.POSITIVE_LikertResponse;
            }
        });

        question4_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question4Response = LikertResponse.NEUTRAL_LikertResponse;
            }
        });

        question4_low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question4Response = LikertResponse.NEGATIVE_LikertResponse;
            }
        });

        question4_veryLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question4Response = LikertResponse.VERY_NEGATIVE_LikertResponse;
            }
        });

        //Q5:
        question5_high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question5Response = DichotomousResponse.YES_DichotomousResponse;
            }
        });

        question5_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question5Response = DichotomousResponse.MAYBE_DichotomousResponse;
            }
        });

        question5_low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question5Response = DichotomousResponse.NO_DichotomousResponse;
            }
        });

        //Q6:
        question6_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question6Response = DichotomousResponse.NO_DichotomousResponse;
            }
        });

        question6_notsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question6Response = DichotomousResponse.MAYBE_DichotomousResponse;
            }
        });

        question6_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question6Response = DichotomousResponse.YES_DichotomousResponse;
            }
        });

        //Q7:
        question7_veryHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question7Response = LikertResponse.VERY_POSITIVE_LikertResponse;
            }
        });

        question7_high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question7Response = LikertResponse.POSITIVE_LikertResponse;
            }
        });

        question7_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question7Response = LikertResponse.NEUTRAL_LikertResponse;
            }
        });

        question7_low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question7Response = LikertResponse.NEGATIVE_LikertResponse;
            }
        });

        question7_veryLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question7Response = LikertResponse.VERY_NEGATIVE_LikertResponse;
            }
        });

        //Q8:
        question8_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question8Response = DichotomousResponse.NO_DichotomousResponse;
            }
        });

        question8_maybe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question8Response = DichotomousResponse.MAYBE_DichotomousResponse;
            }
        });

        question8_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question8Response = DichotomousResponse.YES_DichotomousResponse;
            }
        });

        //Q9:
        question9_answer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().isEmpty()) question9Response = null;
                else question9Response = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        //Q10:
        question10_answer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().isEmpty()) question10Response = null;
                else question10Response = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        question_1_ratingBar.setFocusable(true);
        question_1_ratingBar.setFocusableInTouchMode(true);
        question2_yes.setFocusable(true);
        question2_yes.setFocusableInTouchMode(true);
        question3_high.setFocusable(true);
        question3_high.setFocusableInTouchMode(true);
        question4_veryHigh.setFocusable(true);
        question4_veryHigh.setFocusableInTouchMode(true);
        question5_high.setFocusable(true);
        question5_high.setFocusableInTouchMode(true);
        question6_yes.setFocusable(true);
        question6_yes.setFocusableInTouchMode(true);
        question7_veryHigh.setFocusable(true);
        question7_veryHigh.setFocusableInTouchMode(true);
        question8_yes.setFocusable(true);
        question8_yes.setFocusableInTouchMode(true);
        question9_answer.setFocusable(true);
        question9_answer.setFocusableInTouchMode(true);
        question10_answer.setFocusable(true);
        question10_answer.setFocusableInTouchMode(true);

        //Submit Button:
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitAnswers();
            }
        });

        //Skip Button:
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    private void submitAnswers() {

        if (checkAnswers()) {

            System.out.println("Answers:");
            System.out.println("Q1: " + question1Response);
            System.out.println("Q2: " + question2Response);
            System.out.println("Q3: " + question3Response);
            System.out.println("Q4: " + question4Response);
            System.out.println("Q5: " + question5Response);
            System.out.println("Q6: " + question6Response);
            System.out.println("Q7: " + question7Response);
            System.out.println("Q8: " + question8Response);
            System.out.println("Q9: " + question9Response);
            System.out.println("Q10: " + question10Response);

            // first convert to JSON
            final QuestionEntry[] questionEntries = {
                    new QuestionEntry("Q1", Float.toString(question1Response)),
                    new QuestionEntry("Q2", question2Response.toString()),
                    new QuestionEntry("Q3", question3Response.toString()),
                    new QuestionEntry("Q4", question4Response.toString()),
                    new QuestionEntry("Q5", question5Response.toString()),
                    new QuestionEntry("Q6", question6Response.toString()),
                    new QuestionEntry("Q7", question7Response.toString()),
                    new QuestionEntry("Q8", question8Response.toString()),
                    new QuestionEntry("Q9", question9Response),
                    new QuestionEntry("Q10", question10Response)
            };

            final QuestionnaireEntry questionnaireEntry = new QuestionnaireEntry();
            questionnaireEntry.setChallengeID(challenge.getId());
            questionnaireEntry.setId(worldSessionID);
            questionnaireEntry.setQuestionEntry(new ArrayList<>(Arrays.asList(questionEntries)));

            submitQuestionnaireHTTP(questionnaireEntry);

        }
        else Toast.makeText(this, R.string.invalid_questionnaire_response, Toast.LENGTH_LONG).show();
    }

    private boolean checkAnswers() {

        //Q1
        if (question1Response < 0) {
            question_1_ratingBar.requestFocus();
            return false;
        }

        //Q2
        if (question2Response == null) {
            question2_yes.setError(getString(R.string.no_response));
            question2_yes.requestFocus();
            return false;
        } else question2_yes.setError(null);

        //Q3
        if (question3Response == null) {
            question3_high.setError(getString(R.string.no_response));
            question3_high.requestFocus();
            return false;
        } else question3_high.setError(null);

        //Q4
        if (question4Response == null) {
            question4_veryHigh.setError(getString(R.string.no_response));
            question4_veryHigh.requestFocus();
            return false;
        } else question4_veryHigh.setError(null);

        //Q5
        if (question5Response == null) {
            question5_high.setError(getString(R.string.no_response));
            question5_high.requestFocus();
            return false;
        } else question5_high.setError(null);

        //Q6
        if (question6Response == null) {
            question6_yes.setError(getString(R.string.no_response));
            question6_yes.requestFocus();
            return false;
        } else question6_yes.setError(null);

        //Q7
        if (question7Response == null) {
            question7_veryHigh.setError(getString(R.string.no_response));
            question7_veryHigh.requestFocus();
            return false;
        } else question7_veryHigh.setError(null);

        //Q7
        if (question8Response == null) {
            question8_yes.setError(getString(R.string.no_response));
            question8_yes.requestFocus();
            return false;
        } else question8_yes.setError(null);

        //Q9
        if (question9Response == null) {
            question9Response = "No response";
        }

        //Q10 - OPTIONAL
        if (question10Response == null) {
            question10Response = "No response";
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