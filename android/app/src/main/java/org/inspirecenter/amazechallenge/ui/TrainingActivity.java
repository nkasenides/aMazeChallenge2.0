package org.inspirecenter.amazechallenge.ui;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.inspirecenter.amazechallenge.Installation;
import org.inspirecenter.amazechallenge.R;
import org.inspirecenter.amazechallenge.utils.FileManager;

import com.nkasenides.amc.model.AMCWorldSession;
import com.nkasenides.amc.proto.AMCWorldSessionProto;
import com.nkasenides.amc.proto.AmazeColor;
import com.nkasenides.amc.proto.AmazeIcon;
import com.nkasenides.amc.proto.ChallengeProto;
import com.nkasenides.amc.proto.Shape;
import com.nkasenides.amc.model.Challenge;
import com.nkasenides.amc.model.AMCPlayer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static org.inspirecenter.amazechallenge.ui.MainActivity.setLanguage;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PREFERENCE_KEY_COLOR;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PREFERENCE_KEY_EMAIL;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PREFERENCE_KEY_ICON;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PREFERENCE_KEY_NAME;

public class TrainingActivity extends AppCompatActivity implements ChallengeAdapter.OnChallengeSelectedListener, ChallengeAdapter.OnChallengeLongSelectionListener {

    public static final String TAG = "aMaze";
    public static final String CHALLENGES_PATH = "challenges";

    ChallengeAdapter challengeAdapter;
    Gson gson;
    RecyclerView challengesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setLanguage(this);
        setContentView(R.layout.activity_training);

        final ActionBar actionBar = getActionBar();
        if(actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        final String userColorName = sharedPreferences.getString(PREFERENCE_KEY_COLOR, AmazeColor.BLACK_AmazeColor.toString());
        final AmazeColor userAmazeColor = AmazeColor.valueOf(userColorName);

        final String userIconName = sharedPreferences.getString(PersonalizeActivity.PREFERENCE_KEY_ICON, AmazeIcon.ICON_1_AmazeIcon.name());
        final AmazeIcon userAmazeIcon = AmazeIcon.getByName(userIconName);

        final GIFView gifView = findViewById(R.id.activity_training_icon);
        gifView.setImageResource(getResources().getIdentifier(userAmazeIcon.getResourceName(), "drawable", this.getPackageName()));
        //gifView.play();

        final String name = PreferenceManager.getDefaultSharedPreferences(this).getString(PREFERENCE_KEY_NAME, getString(R.string.Guest));
        final CardView infoCard = findViewById(R.id.cardview_name_email);
        final TextView nameTextView = findViewById(R.id.activity_training_user_name);
        infoCard.setBackgroundColor(Color.parseColor(userAmazeColor.getHexCode()));
        nameTextView.setText(name);
        final String email = PreferenceManager.getDefaultSharedPreferences(this).getString(PREFERENCE_KEY_EMAIL, getString(R.string.Guest_email));
        final TextView emailTextView = findViewById(R.id.activity_training_user_email);
        emailTextView.setText(email);

        if (ColorFragment.isBrightColor(Color.parseColor(userAmazeColor.getHexCode()))) {
            nameTextView.setTextColor(Color.BLACK);
            emailTextView.setTextColor(Color.BLACK);
        } else {
            nameTextView.setTextColor(Color.WHITE);
            emailTextView.setTextColor(Color.WHITE);
        }

        challengesRecyclerView = findViewById(R.id.activity_training_challenges_list_view);
        challengesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        challengesRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));

        gson = new Gson();
        challengeAdapter = new ChallengeAdapter(this, this);
        updateChallengesAdapter();
    }

    @Override
    public void onChallengeSelected(final ChallengeProto challenge) {
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        final String email = sharedPreferences.getString(PREFERENCE_KEY_EMAIL, "guest@example.com");
        final String name = sharedPreferences.getString(PREFERENCE_KEY_NAME, "Guest");
        final String userColorName = sharedPreferences.getString(PREFERENCE_KEY_COLOR, AmazeColor.BLACK_AmazeColor.name());
        final AmazeColor userAmazeColor = AmazeColor.valueOf(userColorName);
        final String userIconName = sharedPreferences.getString(PREFERENCE_KEY_ICON, AmazeIcon.ICON_1_AmazeIcon.name());
        final AmazeIcon userAmazeIcon = AmazeIcon.getByName(userIconName);
        final Shape shape = Shape.TRIANGLE_Shape; // todo enable user selection
        final AMCPlayer player = new AMCPlayer();
        player.setId(Installation.id(this));
        player.setEmail(email);
        player.setName(name);
        player.setColor(userAmazeColor);
        player.setIcon(userAmazeIcon);

        AMCWorldSession worldSession = new AMCWorldSession();
        worldSession.setPlayerID(player.getId());
        worldSession.setCreatedOn(System.currentTimeMillis());

        final Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(GameActivity.SELECTED_CHALLENGE_KEY, challenge.toObject());
        intent.putExtra(GameActivity.SELECTED_PLAYER_KEY, player);
        intent.putExtra(GameActivity.SELECTED_PLAYER_WORLD_SESSION_KEY, worldSession);
        startActivity(intent);
    }

    public static String convertStreamToString(final InputStream inputStream) {
        final Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }

    @Override
    public void onChallengeLongSelect(final ChallengeProto challenge) {
        if (!challenge.getCreatedByID().equals("admin")) {

            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle(getString(R.string.challenge_delete_title));
            dialog.setMessage(getString(R.string.challenge_delete_message));
            dialog.setNegativeButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    final String combinedName = FileManager.SAVED_MAZES_FILENAME_PREFIX + challenge.getName() + ".json";
                    boolean delete = FileManager.deleteFile(TrainingActivity.this, combinedName);
                    if (delete) {
                        Toast.makeText(TrainingActivity.this, challenge.getName() + " " + getString(R.string.challenge_deleted), Toast.LENGTH_LONG).show();
                        updateChallengesAdapter();
                    }
                }
            });
            dialog.setPositiveButton(getString(R.string.Cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            final Dialog deleteDialog = dialog.create();

            //Show option between edit and delete:
            AlertDialog.Builder optionDialog = new AlertDialog.Builder(this);
            optionDialog.setMessage(getString(R.string.challenge_choose_option));
            optionDialog.setNegativeButton(getString(R.string.Edit), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(TrainingActivity.this, MazeDesignerActivity.class);
                    intent.putExtra(MazeDesignerActivity.DESIGNER_MODE_KEY, MazeDesignerActivity.DesignerMode.EDIT);
                    intent.putExtra(MazeDesignerActivity.DESIGNER_DATA_KEY, challenge);
                    startActivity(intent);
                }
            });
            optionDialog.setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    deleteDialog.show();
                    dialogInterface.dismiss();
                }
            });
            optionDialog.create().show();



        }
    }

    public void updateChallengesAdapter() {
        challengeAdapter.clear();
        ArrayList<Challenge> challenges = new ArrayList<>();
        try {
            //Challenges from assets:
            final String [] allAssets = getAssets().list(CHALLENGES_PATH);
            for(final String asset : allAssets) {
                final InputStream inputStream = getAssets().open(CHALLENGES_PATH + "/" + asset);
                final String json = convertStreamToString(inputStream);
                inputStream.close();
                final Challenge challenge = gson.fromJson(json, Challenge.class);
                challenges.add(challenge);
                inputStream.close();
            }

            //Sort the default challenges:
            Collections.sort(challenges, (challengeLeft, challengeRight) -> challengeLeft.getId().compareToIgnoreCase(challengeRight.getId()));

            //Player-created challenges:
            final ArrayList<String> playerChallenges = FileManager.readPlayerMazes(this);
            for (String content : playerChallenges) {
                final Challenge challenge = gson.fromJson(content, Challenge.class);
                challenges.add(challenge);
            }

            Collections.sort(challenges, (challenge, t1) -> Long.compare(t1.getCreatedOn(), challenge.getCreatedOn()));

            for (Challenge c : challenges) {
                challengeAdapter.add(c.toProto().build());
            }

        } catch (IOException e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("challenges", "Error: " + e.getMessage());
            finish();
        }
        challengesRecyclerView.setAdapter(challengeAdapter);
    }
}