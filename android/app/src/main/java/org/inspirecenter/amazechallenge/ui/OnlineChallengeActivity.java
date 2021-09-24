package org.inspirecenter.amazechallenge.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.raylabz.javahttp.OnFailureListener;

import org.inspirecenter.amazechallenge.model.AMCPlayer;
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
import org.inspirecenter.amazechallenge.stubs.BinaryRequest;
import org.inspirecenter.amazechallenge.stubs.Stubs;
import org.inspirecenter.amazechallenge.utils.FileManager;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Pattern;

import static org.inspirecenter.amazechallenge.ui.GameActivity.SELECTED_PLAYER_WORLD_SESSION_KEY;
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
    private TextView noChallengesTextView;
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
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.activity_online_challenge_progress_bar);
        noChallengesTextView = findViewById(R.id.activity_online_challenge_nothing_textview);

        challengesRecyclerView = findViewById(R.id.activity_online_challenge_list_view);
        challengesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        challengesRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));

        challengeAdapter = new ChallengeAdapter(this, this);
        challengesRecyclerView.setAdapter(challengeAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_online_challenge_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.refresh_items_button) {
            listChallengesHTTP();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final String code = sharedPreferences.getString(BlocklyActivity.KEY_ALGORITHM_ACTIVITY_CODE, "");
        if (code.isEmpty()) {
            AlertDialog.Builder noCodeDialog = new AlertDialog.Builder(this, R.style.ErrorDialogStyle);
            noCodeDialog.setTitle(R.string.no_code_title);
            noCodeDialog.setMessage(R.string.no_code_message);
            noCodeDialog.setPositiveButton(R.string.no_code_action, (dialogInterface, i) -> {
                startActivity(new Intent(OnlineChallengeActivity.this, BlocklyActivity.class));
                finish();
            });
            noCodeDialog.setCancelable(true);
            noCodeDialog.create().show();
        }

        final String email = sharedPreferences.getString(PREFERENCE_KEY_EMAIL, getString(R.string.Guest_email));
        final String name = sharedPreferences.getString(PREFERENCE_KEY_NAME, getString(R.string.Guest));
        final String colorName = sharedPreferences.getString(PREFERENCE_KEY_COLOR, AmazeColor.BLACK_AmazeColor.name());
        final String iconName = sharedPreferences.getString(PREFERENCE_KEY_ICON, AmazeIcon.ICON_1_AmazeIcon.name());

        //Create online profile (required for utilizing HTTP stubs):
        createOnlinePlayerProfile(name, email, colorName, iconName);

        //List challenges:
        listChallengesHTTP();
    }

    @Override
    public void onChallengeSelected(final ChallengeProto challenge) {

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(OnlineChallengeActivity.this);
        final String email = sharedPreferences.getString(PREFERENCE_KEY_EMAIL, getString(R.string.Guest_email));
        final String name = sharedPreferences.getString(PREFERENCE_KEY_NAME, getString(R.string.Guest));
        final String colorName = sharedPreferences.getString(PREFERENCE_KEY_COLOR, AmazeColor.BLACK_AmazeColor.name());
        final String iconName = sharedPreferences.getString(PREFERENCE_KEY_ICON, AmazeIcon.ICON_1_AmazeIcon.name());
        final String shapeCode = sharedPreferences.getString(PREFERENCE_SHAPE_CODE, "triangle");

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.Missing_email)
                    .setMessage(R.string.Missing_or_invalid_email)
                    .setPositiveButton(R.string.OK, (dialog, which) -> finish())
                    .create()
                    .show();
        } else {
            Snackbar.make(findViewById(R.id.activity_online_challenge), "Joining " + challenge.getName() + " ...", Snackbar.LENGTH_SHORT).show();
            joinChallengeHTTP(challenge);
//            new JoinChallengeAsyncTask(email, name, colorName, iconName, shapeCode, challenge).execute();
        }
    }

    @Override
    public void onChallengeLongSelect(ChallengeProto challenge) {
        //Do nothing
    }

    private void createOnlinePlayerProfile(String name, String email, String colorName, String iconName) {
        AMCPlayer player = new AMCPlayer();
        player.setId(name);
        player.setEmail(email);
        player.setName(name);
        player.setColor(AmazeColor.valueOf(colorName));
        player.setIcon(AmazeIcon.valueOf(iconName));
        player.setCreatedOn(System.currentTimeMillis());
        player.setPassword("");
        player.setTeamID("");
        AMCClient.getInstance().setPlayer(player);
    }

    private void listChallengesHTTP() {

        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = Stubs.BASE_URL + "/api/challenge/list";
        ListChallengesRequest requestMessage = ListChallengesRequest.newBuilder().build();

        BinaryRequest listChallengesRequest = new BinaryRequest(Request.Method.POST, url, requestMessage, response -> {
            try {
                ListChallengesResponse listChallengesResponse = ListChallengesResponse.parseFrom(response);
                if (listChallengesResponse.getStatus() == ListChallengesResponse.Status.OK) {
                    progressBar.setVisibility(View.GONE);

                    challengeAdapter.clear();
                    challengeAdapter.addAll(listChallengesResponse.getChallengesList());
                    challengeAdapter.addAllPlayersPerChallenge(listChallengesResponse.getActivePlayersByChallengeMap());


                    if (listChallengesResponse.getChallengesList().isEmpty()) {
                        noChallengesTextView.setVisibility(View.VISIBLE);
                        challengesRecyclerView.setVisibility(View.GONE);
                    }
                    else {
                        noChallengesTextView.setVisibility(View.GONE);
                        challengesRecyclerView.setVisibility(View.VISIBLE);
                    }

                    challengeAdapter.notifyDataSetChanged();
                } else {
                    Snackbar.make(findViewById(R.id.activity_online_challenge), getString(R.string.load_challenges_fail), Snackbar.LENGTH_SHORT).show();
                    System.err.println(listChallengesResponse.getMessage());
                }
            } catch (InvalidProtocolBufferException e) {
                Toast.makeText(OnlineChallengeActivity.this, getString(R.string.load_challenges_fail), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }, error -> {
            Toast.makeText(OnlineChallengeActivity.this, getString(R.string.load_challenges_fail), Toast.LENGTH_LONG).show();
            error.printStackTrace();
        });

        progressBar.setVisibility(View.VISIBLE);
        challengesRecyclerView.setVisibility(View.GONE);
        queue.add(listChallengesRequest);
    }

    private void joinChallengeHTTP(ChallengeProto challenge) {

        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = Stubs.BASE_URL + "/api/challenge/join";
        JoinChallengeRequest requestMessage = JoinChallengeRequest.newBuilder()
                .setChallengeID(challenge.getId())
                .setPlayer(AMCClient.getInstance().getPlayer().toProto())
                .setInstallationID(Installation.id(OnlineChallengeActivity.this))
                .build();

        progressBar.setVisibility(View.VISIBLE);
        challengesRecyclerView.setVisibility(View.GONE);

        BinaryRequest listChallengesRequest = new BinaryRequest(Request.Method.POST, url, requestMessage, response -> {
            try {
                JoinChallengeResponse joinChallengeResponse = JoinChallengeResponse.parseFrom(response);
                progressBar.setVisibility(View.GONE);
                if (joinChallengeResponse.getStatus() == JoinChallengeResponse.Status.OK) {
                    Toast.makeText(OnlineChallengeActivity.this, R.string.join_success, Toast.LENGTH_SHORT).show();
                    AMCClient.getInstance().setWorldSession(joinChallengeResponse.getWorldSession().toObject());

                    final Intent intent = new Intent(OnlineChallengeActivity.this, OnlineGameActivity.class);
                    intent.putExtra(PREFERENCE_KEY_CHALLENGE, challenge);
                    intent.putExtra(SELECTED_PLAYER_WORLD_SESSION_KEY, joinChallengeResponse.getWorldSession().toObject());
                    startActivity(intent);

                } else {
                    switch (joinChallengeResponse.getMessage()) {
                        case "INVALID_PLAYER_NAME":
                            Snackbar.make(findViewById(R.id.activity_online_challenge), R.string.invalid_name, Snackbar.LENGTH_SHORT).show();
                            break;
                        case "INVALID_PLAYER_EMAIL":
                            Snackbar.make(findViewById(R.id.activity_online_challenge), R.string.invalid_email, Snackbar.LENGTH_SHORT).show();
                            break;
                        case "INVALID_CHALLENGE_ID":
                            Snackbar.make(findViewById(R.id.activity_online_challenge), R.string.invalid_challenge, Snackbar.LENGTH_SHORT).show();
                            break;
                        case "CHALLENGE_NOT_STARTED":
                            Snackbar.make(findViewById(R.id.activity_online_challenge), R.string.challenge_not_started, Snackbar.LENGTH_SHORT).show();
                            break;
                        case "CHALLENGE_OVER":
                            Snackbar.make(findViewById(R.id.activity_online_challenge), R.string.challenge_finished, Snackbar.LENGTH_SHORT).show();
                            break;
                        case "PLAYER_NAME_EXISTS":
                            Snackbar.make(findViewById(R.id.activity_online_challenge), R.string.name_exists, Snackbar.LENGTH_SHORT).show();

                            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DefaultDialogStyle);
                            builder.setTitle(R.string.change_name);
                            final EditText input = new EditText(this);
                            input.setInputType(InputType.TYPE_CLASS_TEXT);
                            builder.setView(input);
                            builder.setMessage(R.string.name_exists);
                            builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String newName = input.getText().toString();
                                    if (!newName.isEmpty() && newName.length() > 2 && newName.matches("^[a-zA-Z0-9_]*$")) {
                                        final SharedPreferences.Editor sharedPreferences = PreferenceManager.getDefaultSharedPreferences(OnlineChallengeActivity.this).edit();
                                        sharedPreferences.putString(PREFERENCE_KEY_NAME, newName).apply();
                                        AMCClient.getInstance().getPlayer().setName(newName);
                                        dialog.dismiss();
                                        joinChallengeHTTP(challenge);
                                    }
                                    else {
                                        Toast.makeText(OnlineChallengeActivity.this, R.string.invalid_name, Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                            builder.setNegativeButton(R.string.cancel, (dialog, which) -> dialog.cancel());

                            builder.show();

                            break;
                        default:
                            Snackbar.make(findViewById(R.id.activity_online_challenge), getString(R.string.join_failure) + " '" + challenge.getName() + "'.", Snackbar.LENGTH_SHORT).show();
                            break;
                    }
                    progressBar.setVisibility(View.GONE);
                    challengesRecyclerView.setVisibility(View.VISIBLE);
                    System.err.println(joinChallengeResponse.getMessage());
                }
            } catch (InvalidProtocolBufferException e) {
                Toast.makeText(OnlineChallengeActivity.this, getString(R.string.load_challenges_fail), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }, error -> {
            Toast.makeText(OnlineChallengeActivity.this, getString(R.string.load_challenges_fail), Toast.LENGTH_LONG).show();
            error.printStackTrace();
        });

        queue.add(listChallengesRequest);
    }

    public static String convertStreamToString(final InputStream inputStream) {
        final Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }
}