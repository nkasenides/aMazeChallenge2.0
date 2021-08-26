package org.inspirecenter.amazechallenge.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import org.inspirecenter.amazechallenge.model.Challenge;
import org.inspirecenter.amazechallenge.proto.AMCPlayerProto;
import org.inspirecenter.amazechallenge.proto.AmazeColor;
import org.inspirecenter.amazechallenge.proto.AmazeIcon;
import org.inspirecenter.amazechallenge.proto.ChallengeProto;
import org.inspirecenter.amazechallenge.proto.JoinChallengeRequest;
import org.inspirecenter.amazechallenge.proto.JoinChallengeResponse;
import org.inspirecenter.amazechallenge.proto.ListChallengesRequest;
import org.inspirecenter.amazechallenge.proto.ListChallengesResponse;

import org.inspirecenter.amazechallenge.Installation;
import org.inspirecenter.amazechallenge.R;
import org.inspirecenter.amazechallenge.stubs.AMCClient;
import org.inspirecenter.amazechallenge.stubs.Stubs;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

import static org.inspirecenter.amazechallenge.ui.MainActivity.setLanguage;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PREFERENCE_KEY_COLOR;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PREFERENCE_KEY_EMAIL;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PREFERENCE_KEY_ICON;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PREFERENCE_KEY_NAME;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PREFERENCE_SHAPE_CODE;

public class OnlineChallengeActivity extends AppCompatActivity implements ChallengeAdapter.OnChallengeSelectedListener, ChallengeAdapter.OnChallengeLongSelectionListener {

    public static final String TAG = "aMazeChallenge";

    public static final String PREFERENCE_KEY_CHALLENGE = "pref-challenge";

    private ProgressBar progressBar;
    private RecyclerView challengesRecyclerView;
    private ChallengeAdapter challengeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setLanguage(this);
        setContentView(R.layout.activity_online_challenge);

        final ActionBar actionBar = getActionBar();
        if(actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.activity_online_challenge_progress_bar);

        challengesRecyclerView = findViewById(R.id.activity_online_challenge_list_view);
        challengesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        challengesRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));

        challengeAdapter = new ChallengeAdapter(this, this);
        challengesRecyclerView.setAdapter(challengeAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // todo if no code was submitted yet, advise the player

        // start online request
        listChallengesHTTP();
//        new FetchChallengesAsyncTask().execute();
    }

    @Override
    public void onChallengeSelected(final ChallengeProto challenge) {

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(OnlineChallengeActivity.this);
        final String email = sharedPreferences.getString(PREFERENCE_KEY_EMAIL, getString(R.string.Guest_email));
        final String name = sharedPreferences.getString(PREFERENCE_KEY_NAME, getString(R.string.Guest));
        final String colorName = sharedPreferences.getString(PREFERENCE_KEY_COLOR, AmazeColor.BLACK_AmazeColor.name());
        final String iconName = sharedPreferences.getString(PREFERENCE_KEY_ICON, AmazeIcon.ICON_1_AmazeIcon.name());
        final String shapeCode = sharedPreferences.getString(PREFERENCE_SHAPE_CODE, "triangle");

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.Missing_email)
                    .setMessage(R.string.Missing_or_invalid_email)
                    .setPositiveButton(R.string.OK, (dialog, which) -> finish())
                    .create()
                    .show();
        } else {
            Snackbar.make(findViewById(R.id.activity_online_challenge), "Joining " + challenge.getName() + " ...", Snackbar.LENGTH_SHORT).show();
            joinChallengeHTTP(email, name, colorName, iconName, challenge);
//            new JoinChallengeAsyncTask(email, name, colorName, iconName, shapeCode, challenge).execute();
        }
    }

    @Override
    public void onChallengeLongSelect(ChallengeProto challenge) {
        //Do nothing
    }

    private void listChallengesHTTP() {
        progressBar.setVisibility(View.VISIBLE);
        challengesRecyclerView.setVisibility(View.GONE);

        Stubs.listChallengesStub(AMCClient.getInstance()).sendAndWait(
                ListChallengesRequest.newBuilder()
                        .build(),
                listChallengesResponse -> {
                    if (listChallengesResponse.getStatus() == ListChallengesResponse.Status.OK) {
                        progressBar.setVisibility(View.GONE);
                        challengeAdapter.clear();
                        challengeAdapter.addAll(listChallengesResponse.getChallengesList());
                        challengesRecyclerView.setVisibility(View.VISIBLE);
                    }
                    else {
                        Snackbar.make(findViewById(R.id.activity_online_challenge), "Error while accessing list of challenges: " + listChallengesResponse.getMessage(), Snackbar.LENGTH_SHORT).show();
                        System.err.println(listChallengesResponse.getMessage());
                    }
                }
        );


    }

//    private class FetchChallengesAsyncTask extends AsyncTask<Void, Void, Reply> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            progressBar.setVisibility(View.VISIBLE);
//            challengesRecyclerView.setVisibility(View.GONE);
//        }
//
//        @Override
//        protected Reply doInBackground(Void... v) {
//            try {
//                final String apiUrlBase = getString(R.string.api_url);
//                final URL apiURL = new URL(apiUrlBase + "/challenges");
//                Log.d(TAG, "Opening URL: " + apiURL.toString());
//                final InputStream inputStream = apiURL.openStream();
//                final String json = convertStreamToString(inputStream);
//                Log.v(TAG, "Read JSON: " + json);
//                final Gson gson = new Gson();
//                return gson.fromJson(json, ChallengesReply.class);
//            } catch (IOException e) {
//                // show message in snackbar
//                Snackbar.make(findViewById(R.id.activity_online_challenge), "Error while accessing list of challenges: " + e.getMessage(), Snackbar.LENGTH_SHORT).show();
//                // log error
//                Log.e(TAG, "Error: " + e.getMessage());
//                return new ReplyWithErrors(e.getMessage());
//            }
//       }
//
//        @Override
//        protected void onPostExecute(final Reply reply) {
//            super.onPostExecute(reply);
//            progressBar.setVisibility(View.GONE);
//            // check if reply is not null first
//            if(reply != null && reply instanceof ChallengesReply) {
//                final Collection<Challenge> challenges = ((ChallengesReply) reply).getChallenges();
//                challengeAdapter.clear();
//                challengeAdapter.addAll(challenges);
//                challengesRecyclerView.setVisibility(View.VISIBLE);
//            } else {
//                // show message in snack-bar
//                final Vector<String> messages = new Vector<>();
//                if(reply == null) messages.add("Server is down or connection is cancelled");
//                else messages.addAll(((ReplyWithErrors) reply).getErrors());
//                Snackbar.make(findViewById(R.id.activity_online_challenge), "Error(s): " + messages, Snackbar.LENGTH_SHORT).show();
//                // also log warning
//                Log.w(TAG, "Error messages: " + messages);
//            }
//        }
//    }

    private void joinChallengeHTTP(String email, String name, String colorName, String iconName, ChallengeProto challenge) {
        progressBar.setVisibility(View.VISIBLE);

        Stubs.joinChallengeStub(AMCClient.getInstance()).sendAndWait(
                JoinChallengeRequest.newBuilder()
                        .setChallengeID(challenge.getId())
                        .setPlayer(
                                AMCPlayerProto.newBuilder()
                                        .setEmail(email)
                                        .setName(name)
                                        .setColor(AmazeColor.valueOf(colorName))
                                        .setIcon(AmazeIcon.valueOf(iconName))
                                        .build()
                        )
                        .build(),
                joinChallengeResponse -> {
                    if (joinChallengeResponse.getStatus() == JoinChallengeResponse.Status.OK) {
                        Toast.makeText(OnlineChallengeActivity.this, R.string.join_success, Toast.LENGTH_SHORT).show();
                        AMCClient.getInstance().setWorldSession(joinChallengeResponse.getWorldSession().toObject());
                        final Intent intent = new Intent(OnlineChallengeActivity.this, OnlineGameActivity.class);
                        intent.putExtra(PREFERENCE_KEY_CHALLENGE, challenge);
                        startActivity(intent);
                    }
                    else {
                        Snackbar.make(findViewById(R.id.activity_online_challenge), getString(R.string.join_failure) + challenge.getName(), Snackbar.LENGTH_SHORT).show();
                        System.err.println(joinChallengeResponse.getMessage());
                    }
                }
        );

        progressBar.setVisibility(View.GONE);
    }

//    private class JoinChallengeAsyncTask extends AsyncTask<Void, Void, String> {
//
//        private final String email;
//        private final String name;
//        private final String colorName;
//        private final String iconName;
//        private final String shapeCode;
//        private final Challenge challenge;
//
//        JoinChallengeAsyncTask(final String email, final String name, final String colorName, final String iconName, final String shapeCode, final Challenge challenge) {
//            this.email = email;
//            this.name = name;
//            this.colorName = colorName;
//            this.iconName = iconName;
//            this.shapeCode = shapeCode;
//            this.challenge = challenge;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            progressBar.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        protected String doInBackground(Void... ignore) {
//            try {
//                final String apiUrlBase = getString(R.string.api_url);
//                final String magic = getString(R.string.magic);
//                final URL apiURL = new URL(apiUrlBase + "/join?magic=" + magic + "&name=" + name
//                        + "&email=" + email + "&color=" + colorName + "&icon=" + iconName
//                        + "&shape=" + shapeCode + "&challenge=" + challenge.getId()
//                        + "&id=" + Installation.id(OnlineChallengeActivity.this));
//                Log.d(TAG, "apiURL: " + apiURL.toString());
//                final InputStream inputStream = apiURL.openStream();
//                return convertStreamToString(inputStream);
//            } catch (IOException e) {
//                // show message in snackbar
//                Snackbar.make(findViewById(R.id.activity_online_challenge), getString(R.string.join_failure), Snackbar.LENGTH_SHORT).show();
//                // log error
//                Log.e(TAG, "Error: " + Arrays.toString(e.getStackTrace()));
//                return "Error: " + Arrays.toString(e.getStackTrace());
//            }
//        }
//
//        @Override
//        protected void onPostExecute(final String reply) {
//            super.onPostExecute(reply);
//            progressBar.setVisibility(View.GONE);
//            //Toast.makeText(OnlineChallengeActivity.this, "Joined \n" + reply, Toast.LENGTH_SHORT).show();
//            Toast.makeText(OnlineChallengeActivity.this, R.string.join_success, Toast.LENGTH_SHORT).show();
//            System.out.println("Joined \n" + reply);
//
//            // parse and check reply
//            try {
//                final JSONObject replyJsonObject = new JSONObject(reply);
//                if("ok".equalsIgnoreCase(replyJsonObject.getString("status"))) {
//                    // start online game activity
//                    final Intent intent = new Intent(OnlineChallengeActivity.this, OnlineGameActivity.class);
//                    intent.putExtra(PREFERENCE_KEY_CHALLENGE, challenge);
//                    startActivity(intent);
//                } else {
//                    Snackbar.make(findViewById(R.id.activity_online_challenge), getString(R.string.join_failure) + challenge.getName(), Snackbar.LENGTH_SHORT).show();
//                    Log.w(TAG, reply);
//                }
//            } catch (JSONException jsone) {
//                Snackbar.make(findViewById(R.id.activity_online_challenge), getString(R.string.reply_failure) + jsone.getMessage(), Snackbar.LENGTH_SHORT).show();
//                Log.e(TAG, reply);
//            }
//
//        }
//    }

    public static String convertStreamToString(final InputStream inputStream) {
        final Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }
}