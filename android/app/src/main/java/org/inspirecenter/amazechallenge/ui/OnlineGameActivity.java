package org.inspirecenter.amazechallenge.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import org.inspirecenter.amazechallenge.controller.AudioEventListener;
import org.inspirecenter.amazechallenge.controller.GameEndListener;
import org.inspirecenter.amazechallenge.model.AMCPlayer;
import org.inspirecenter.amazechallenge.model.Challenge;
import org.inspirecenter.amazechallenge.model.PickableEntity;
import org.inspirecenter.amazechallenge.proto.Audio;
import org.inspirecenter.amazechallenge.proto.AudioFormat;
import org.inspirecenter.amazechallenge.proto.AudioType;
import org.inspirecenter.amazechallenge.proto.ChallengeProto;
import org.inspirecenter.amazechallenge.proto.GetStateRequest;
import org.inspirecenter.amazechallenge.proto.GetStateResponse;
import org.inspirecenter.amazechallenge.proto.SubmitCodeRequest;
import org.inspirecenter.amazechallenge.proto.SubmitCodeResponse;
import org.inspirecenter.amazechallenge.proto.UpdateStateRequest;
import org.inspirecenter.amazechallenge.proto.UpdateStateResponse;

import org.inspirecenter.amazechallenge.Installation;
import org.inspirecenter.amazechallenge.R;
import org.inspirecenter.amazechallenge.stubs.AMCClient;
import org.inspirecenter.amazechallenge.stubs.Stubs;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import static org.inspirecenter.amazechallenge.ui.BlocklyActivity.INTENT_KEY_NEXT_ACTIVITY;
import static org.inspirecenter.amazechallenge.ui.GameActivity.DEFAULT_AMBIENT_VOLUME;
import static org.inspirecenter.amazechallenge.ui.GameActivity.DEFAULT_EVENTS_VOLUME;
import static org.inspirecenter.amazechallenge.ui.GameActivity.SELECTED_PLAYER_KEY;
import static org.inspirecenter.amazechallenge.ui.MainActivity.KEY_PREF_SOUND;
import static org.inspirecenter.amazechallenge.ui.MainActivity.KEY_PREF_VIBRATION;
import static org.inspirecenter.amazechallenge.ui.MainActivity.setLanguage;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PERMISSIONS_REQUEST_GET_ACCOUNT;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PREFERENCE_KEY_EMAIL;

public class OnlineGameActivity extends AppCompatActivity implements GameEndListener, AudioEventListener {

    public static final String TAG = "aMazeChallenge";
    public static final long ONE_SECOND = 1000L;
    private boolean isFABOpen = false;

    private GameView gameView;
    private RecyclerView scoreboardRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private OnlinePlayerAdapter onlinePlayerAdapter;

    private View fabBackground;
    FloatingActionButton mainFAB;
    LinearLayout fabLayout_upload;
    LinearLayout fabLayout_edit;

    private MediaPlayer backgroundAudio;
    MediaPlayer winAudio;
    MediaPlayer loseAudio;
    private boolean sound = true;
    private boolean vibration = true;
    private HashMap<String, MediaPlayer> audioEventsMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setLanguage(this);
        setContentView(R.layout.activity_online_game);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        gameView = findViewById(R.id.activity_online_game_game_view);

        scoreboardRecyclerView = findViewById(R.id.activity_online_game_recycler_view);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        scoreboardRecyclerView.setLayoutManager(layoutManager);

        // specify and set an adapter
        onlinePlayerAdapter = new OnlinePlayerAdapter(Installation.id(this));
        scoreboardRecyclerView.setAdapter(onlinePlayerAdapter);

        mainFAB = findViewById(R.id.activity_online_game_button_main_fab);
        fabLayout_edit = findViewById(R.id.fabLayout_edit);
        fabLayout_upload = findViewById(R.id.fabLayout_upload);

        fabBackground = findViewById(R.id.fab_background);
        fabBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFABMenu();
            }
        });

        //Create audio map:
        for (final Audio audio : Audio.values()) {
            if (audio.getAudioType() == AudioType.EVENT_AudioType) {
                if (audio.getAudioFormat() != AudioFormat.UNDEFINED_FORMAT_AudioFormat && !audio.getSoundResourceName().equals(Audio.AUDIO_NONE_Audio.getSoundResourceName())) {
                    final int identifier = getResources().getIdentifier(audio.getSoundResourceName(), "raw", getPackageName());
                    final MediaPlayer mediaPlayer = MediaPlayer.create(this, identifier);
                    mediaPlayer.setVolume(DEFAULT_EVENTS_VOLUME, DEFAULT_EVENTS_VOLUME);
                    audioEventsMap.put(audio.toString(), mediaPlayer);
                }
            }
        }

        //Sound prefs:
        sound = PreferenceManager.getDefaultSharedPreferences(this).getBoolean(KEY_PREF_SOUND, true);
        vibration = PreferenceManager.getDefaultSharedPreferences(this).getBoolean(KEY_PREF_VIBRATION, true);

    }

    private ChallengeProto challenge;
    private String email = null;

    private Handler handler;
    private Timer timer = null;

    @Override
    protected void onResume() {
        super.onResume();

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(OnlineGameActivity.this);
        email = sharedPreferences.getString(PREFERENCE_KEY_EMAIL, getString(R.string.Guest_email));

        // get challenge from intent
        challenge = (ChallengeProto) getIntent().getSerializableExtra(OnlineChallengeActivity.PREFERENCE_KEY_CHALLENGE);
        if(challenge == null) {
            Log.e(TAG, "Invalid null argument 'challenge'in Intent");
            finish();
        }

        onlinePlayerAdapter.clear();
        onlinePlayerAdapter.notifyDataSetChanged();

        handler = new Handler();

        if(timer == null) {
            timer = new Timer();
        }
        timer.schedule(new OnlineMazeRunner(), 0L, ONE_SECOND); // todo

        //Play background audio:
        final Audio audioResource = challenge.getBackgroundAudio();
        System.out.println("Sound is: " + sound);
        if (audioResource.getAudioFormat() != AudioFormat.UNDEFINED_FORMAT_AudioFormat && !audioResource.getName().equals(Audio.AUDIO_NONE_Audio.getSoundResourceName())) {
            backgroundAudio = MediaPlayer.create(this, getResources().getIdentifier(audioResource.getSoundResourceName(), "raw", getPackageName()));
            if (backgroundAudio != null && sound) {
                backgroundAudio.setLooping(true);
                backgroundAudio.setVolume(DEFAULT_AMBIENT_VOLUME, DEFAULT_AMBIENT_VOLUME);
                backgroundAudio.start();
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (backgroundAudio != null) backgroundAudio.stop();
        timer.cancel();

        // todo ask user to confirm and withdraw
    }

    @Override
    public void onBackPressed() {
        if(!isFABOpen){
            super.onBackPressed();
        }else{
            closeFABMenu();
        }
    }

    public void editCode(final View view) {
        closeFABMenu();

        final Intent intent = new Intent(OnlineGameActivity.this, BlocklyActivity.class);
        intent.putExtra(INTENT_KEY_NEXT_ACTIVITY, OnlineGameActivity.class.getCanonicalName());
        startActivity(intent);
    }

    public void submitCode(final View view) {
        closeFABMenu();

        // todo use dialog to ask user to confirm
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final String email = sharedPreferences.getString(PREFERENCE_KEY_EMAIL, getString(R.string.Guest_email));
        final String code = sharedPreferences.getString(BlocklyActivity.KEY_ALGORITHM_ACTIVITY_CODE, "");

//        new SubmitCodeAsyncTask(email, code, challenge, getString(R.string.api_url), getString(R.string.magic)).execute();
        submitCodeHTTP(code);
    }

    @Override
    public void onPlayerHasWon(String playerID) {
        final Intent intent = getIntent();
        final AMCPlayer player = (AMCPlayer) intent.getSerializableExtra(SELECTED_PLAYER_KEY);
        if (player.getId().equals(playerID)) {
            onGameEndAudioEvent(true);
        }
    }

    @Override
    public void onPlayerHasLost(String playerID) {
        final Intent intent = getIntent();
        final AMCPlayer player = (AMCPlayer) intent.getSerializableExtra(SELECTED_PLAYER_KEY);
        if (player.getId().equals(playerID)) {
            onGameEndAudioEvent(false);
        }
    }

    @Override
    public void onAudioEvent(PickableEntity pickable) {

        switch (pickable.getPickableType()) {
            case APPLE_PickableType:
            case BANANA_PickableType:
            case STRAWBERRY_PickableType:
            case PEACH_PickableType:
            case WATERMELON_PickableType:
            case GRAPES_PickableType:
            case ORANGE_PickableType:
                if (sound) audioEventsMap.get(Audio.EVENT_FOOD_Audio.toString()).start();
                break;
            case COIN_5_PickableType:
                if (sound) audioEventsMap.get(Audio.EVENT_COIN5_Audio.toString()).start();
                break;
            case COIN_10_PickableType:
                if (sound) audioEventsMap.get(Audio.EVENT_COIN10_Audio.toString()).start();
                break;
            case COIN_20_PickableType:
                if (sound) audioEventsMap.get(Audio.EVENT_COIN20_Audio.toString()).start();
                break;
            case GIFTBOX_PickableType:
                if (sound) audioEventsMap.get(Audio.EVENT_GIFTBOX_Audio.toString()).start();
                break;
            case BOMB_PickableType:
                if (pickable.getState() == 1  || pickable.getState() == 2) {
                    if (sound) audioEventsMap.get(Audio.EVENT_BOMB_Audio.toString()).start();
                    if (vibration) {
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        if (v != null) v.vibrate(250);
                    }
                }
                break;
            case SPEEDHACK_PickableType:
                if (sound) audioEventsMap.get(Audio.EVENT_SPEEDHACK_Audio.toString()).start();
                if (vibration) {
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    long[] pattern = {100, 100, 100};
                    if (v != null) v.vibrate(pattern, -1);
                }
                break;
            case TRAP_PickableType:
                if (sound) audioEventsMap.get(Audio.EVENT_TRAP_Audio.toString()).start();
                if (vibration) {
                    Vibrator vTrap = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vTrap != null) vTrap.vibrate(250);
                }
                break;
        }
    }

    @Override
    public void onGameEndAudioEvent(boolean win) {
        if (win) {
            winAudio= MediaPlayer.create(this, getResources().getIdentifier(Audio.EVENT_WIN_Audio.getSoundResourceName(), "raw", getPackageName()));
            winAudio.start();
        } else {
            loseAudio = MediaPlayer.create(this, getResources().getIdentifier(Audio.EVENT_LOSE_Audio.getSoundResourceName(), "raw", getPackageName()));
            loseAudio.start();
        }
    }

//    private class SubmitCodeAsyncTask extends AsyncTask<Void, Void, String> {
//
//        private final String email;
//        private final String code;
//        private final Challenge challenge;
//        private final String apiUrlBase;
//        private final String magic;
//
//        SubmitCodeAsyncTask(final String email, final String code, final Challenge challenge, final String apiUrlBase, final String magic) {
//            this.email = email;
//            this.code = code;
//            this.challenge = challenge;
//            this.apiUrlBase = apiUrlBase;
//            this.magic = magic;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected String doInBackground(final Void... ignore) {
//            try {
//                final URL apiURL = new URL(apiUrlBase + "/submit-code?magic=" + magic
//                        + "&challenge=" + challenge.getId()
//                        + "&id=" + Installation.id(OnlineGameActivity.this));
//                Log.d(TAG, "apiURL: " + apiURL.toString());
//                final HttpURLConnection httpURLConnection = (HttpURLConnection) apiURL.openConnection();
//                httpURLConnection.setDoInput(true); // Allow Inputs
//                httpURLConnection.setDoOutput(true); // Allow Outputs
//                httpURLConnection.setUseCaches(false); // Don't use a Cached Copy
//                httpURLConnection.setRequestMethod("POST");
//                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
//                httpURLConnection.setRequestProperty("Content-Type", "application/json");
//
//                final DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
//                dataOutputStream.write(code.getBytes());
//                dataOutputStream.close();
//
//                final InputStream inputStream = httpURLConnection.getInputStream();
//                return convertStreamToString(inputStream);
//            } catch (IOException e) {
//                // show message in snackbar
//                Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.code_upload_failed), Snackbar.LENGTH_SHORT).show();
//                // log error
//                Log.e(TAG, "Error: " + Arrays.toString(e.getStackTrace()));
//                return "Error: " + Arrays.toString(e.getStackTrace());
//            }
//        }
//
//        @Override
//        protected void onPostExecute(final String reply) {
//            super.onPostExecute(reply);
//            Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.code_uploaded), Snackbar.LENGTH_SHORT).show();
//            Log.d(TAG, "reply: " + reply);
//        }
//    }

    private void submitCodeHTTP(String code) {
        Stubs.submitCodeStub(AMCClient.getInstance()).sendAndWait(
                SubmitCodeRequest.newBuilder()
                        .setCode(code)
                        .setWorldSessionID(AMCClient.getInstance().getWorldSession().getId())
                        .build(),
                submitCodeResponse -> {
                    if (submitCodeResponse.getStatus() == SubmitCodeResponse.Status.OK) {
                        Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.code_uploaded), Snackbar.LENGTH_SHORT).show();
                        System.out.println("Code upload OK");
                        getStateHTTP();
                    }
                    else {
                        Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.code_upload_failed), Snackbar.LENGTH_SHORT).show();
                        System.err.println(submitCodeResponse.getMessage());
                    }
                }
        );
    }

    private void getStateHTTP() {
        Stubs.getStateStub(AMCClient.getInstance()).sendAndWait(
                GetStateRequest.newBuilder()
                        .setWorldSessionID(AMCClient.getInstance().getWorldSession().getId())
                        .build(),
                getStateResponse -> {
                    if (getStateResponse.getStatus() == GetStateResponse.Status.OK) {
                        gameView.initialize(getStateResponse.getPartialState());
                        //TODO - Do later.
//                        onlinePlayerAdapter.update(gameFullState);
//                        onlinePlayerAdapter.notifyDataSetChanged();
//                        final boolean active = gameFullState.getActivePlayerIDs().contains(Installation.id(OnlineGameActivity.this));
//                        final boolean queued = gameFullState.getQueuedPlayerIDs().contains(Installation.id(OnlineGameActivity.this));
                        // todo save to preferences and check if sounds needs to be played
                    }
                    else {
                        Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.gamestate_getting_error) + getStateResponse.getMessage(), Snackbar.LENGTH_SHORT).show();
                        System.err.println(getStateResponse.getMessage());
                    }
                }
        );
    }

    private long lastUpdateTimestamp = 0;

    private void updateStateHTTP() {
        Stubs.updateStateStub(AMCClient.getInstance()).sendAndWait(
                 UpdateStateRequest.newBuilder()
                         .setWorldSessionID(AMCClient.getInstance().getWorldSession().getId())
                         .build(),
                updateStateResponse -> {
                     if (updateStateResponse.getStatus() == UpdateStateResponse.Status.OK) {
                         if (updateStateResponse.getStateUpdate().getTimestamp() > lastUpdateTimestamp) { //only update the state if the update was sent after the last update
                             gameView.update(updateStateResponse.getStateUpdate());
                         }
                     }
                     else {
                         Toast.makeText(OnlineGameActivity.this, R.string.state_update_failed, Toast.LENGTH_SHORT).show();
                         System.err.println(updateStateResponse.getMessage());
                     }
                }
        );
    }

//    private class GetGameStateAsyncTask extends AsyncTask<Void, Void, String> {
//
//        private final long challengeId;
//        private final String installationId;
//
//        GetGameStateAsyncTask(final long challengeId) {
//            this.challengeId = challengeId;
//            this.installationId = Installation.id(OnlineGameActivity.this);
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected String doInBackground(final Void... ignore) {
//            InputStream inputStream = null;
//            try {
//                final String apiUrlBase = getString(R.string.api_url);
//                final String magic = getString(R.string.magic);
//                final URL apiURL = new URL(apiUrlBase + "/game-state?magic=" + magic + "&installation=" + installationId + "&challenge=" + challengeId);
//                Log.d(TAG, "apiURL: " + apiURL.toString());
//                final HttpURLConnection httpURLConnection = (HttpURLConnection) apiURL.openConnection();
//                httpURLConnection.setDoInput(true); // Allow Inputs
//                httpURLConnection.setUseCaches(false); // Don't use a Cached Copy
//                httpURLConnection.setRequestMethod("GET");
//                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
//                httpURLConnection.setRequestProperty("Content-Type", "application/json");
//
//                inputStream = httpURLConnection.getInputStream();
//                return convertStreamToString(inputStream);
//            } catch (IOException e) {
//                // show message in snackbar
//                Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.gamestate_getting_error) + e.getMessage(), Snackbar.LENGTH_SHORT).show();
//                // log error
//                Log.e(TAG, "Error: " + e.getMessage());
//                e.printStackTrace();
//                return "Error: " + Arrays.toString(e.getStackTrace());
//            } finally {
//                try {
//                    if (inputStream != null) inputStream.close();
//                } catch (IOException ioe) {
//                    Log.e(TAG, "Error: " + ioe.getMessage());
//                }
//            }
//        }
//
//        @Override
//        protected void onPostExecute(final String reply) {
//            super.onPostExecute(reply);
//            final ReplyWithGameFullState replyWithFullGameState = new Gson().fromJson(reply, ReplyWithGameFullState.class);
//            final GameFullState gameFullState = replyWithFullGameState.getGameFullState();
//            switch (replyWithFullGameState.getStatus()) {
//                case OK:
//                    if(gameFullState != null) {
//
//                        gameView.update(gameFullState);
//                        onlinePlayerAdapter.update(gameFullState);
//                        onlinePlayerAdapter.notifyDataSetChanged();
//                        final boolean active = gameFullState.getActivePlayerIDs().contains(Installation.id(OnlineGameActivity.this));
//                        final boolean queued = gameFullState.getQueuedPlayerIDs().contains(Installation.id(OnlineGameActivity.this));
//                        // todo save to preferences and check if sounds needs to be played
//                    }
//                    break;
//                case ERROR:
//                default:
//                    final ReplyWithErrors replyWithErrors = new Gson().fromJson(reply, ReplyWithErrors.class);
//                    Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.gamestate_error) + replyWithErrors.getErrors(), Snackbar.LENGTH_SHORT).show();
//            }
//        }
//    }

    public static String convertStreamToString(final InputStream inputStream) {
        final Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }

    private class OnlineMazeRunner extends TimerTask {
        @Override
        public void run() {
            if(handler != null) {
                handler.post(() -> {
                    if(challenge == null) {
                        finish();
                    } else {
                        updateStateHTTP();
                    }
                });
            }
        }
    }

    private void showFABMenu(){
        isFABOpen=true;
        fabBackground.setVisibility(View.VISIBLE);
        fabLayout_edit.setVisibility(View.VISIBLE);
        fabLayout_upload.setVisibility(View.VISIBLE);
        fabLayout_edit.animate().translationY(-getResources().getDimension(R.dimen.standard_65));
        fabLayout_upload.animate().translationY(-getResources().getDimension(R.dimen.standard_125));
    }

    private void closeFABMenu(){
        isFABOpen=false;
        fabBackground.setVisibility(View.GONE);
        fabLayout_edit.setVisibility(View.GONE);
        fabLayout_upload.setVisibility(View.GONE);
        fabLayout_edit.animate().translationY(0);
        fabLayout_upload.animate().translationY(0);
    }

    public void openFAB(View view) {
        if (!isFABOpen) showFABMenu();
        else closeFABMenu();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (backgroundAudio != null) {
            backgroundAudio.stop();
            backgroundAudio.release();
        }
    }
}