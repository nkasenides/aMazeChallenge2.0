package org.inspirecenter.amazechallenge.ui;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.protobuf.InvalidProtocolBufferException;

import org.inspirecenter.amazechallenge.controller.AudioEventListener;
import org.inspirecenter.amazechallenge.controller.GameEndListener;
import org.inspirecenter.amazechallenge.model.AMCPlayer;
import org.inspirecenter.amazechallenge.model.AMCWorldSession;
import org.inspirecenter.amazechallenge.model.PickableEntity;
import org.inspirecenter.amazechallenge.proto.AMCStateUpdateProto;
import org.inspirecenter.amazechallenge.proto.Audio;
import org.inspirecenter.amazechallenge.proto.AudioFormat;
import org.inspirecenter.amazechallenge.proto.AudioType;
import org.inspirecenter.amazechallenge.proto.ChallengeProto;
import org.inspirecenter.amazechallenge.proto.GetStateRequest;
import org.inspirecenter.amazechallenge.proto.GetStateResponse;
import org.inspirecenter.amazechallenge.proto.LeaveChallengeRequest;
import org.inspirecenter.amazechallenge.proto.LeaveChallengeResponse;
import org.inspirecenter.amazechallenge.proto.SubmitCodeRequest;
import org.inspirecenter.amazechallenge.proto.SubmitCodeResponse;
import org.inspirecenter.amazechallenge.proto.UpdateStateRequest;
import org.inspirecenter.amazechallenge.proto.UpdateStateResponse;

import org.inspirecenter.amazechallenge.R;
import org.inspirecenter.amazechallenge.stubs.AMCClient;
import org.inspirecenter.amazechallenge.stubs.BinaryRequest;
import org.inspirecenter.amazechallenge.stubs.Stubs;
import org.inspirecenter.amazechallenge.ui.discovery.DiscoveryView;
import org.inspirecenter.amazechallenge.utils.Emoji;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import io.ably.lib.realtime.AblyRealtime;
import io.ably.lib.realtime.Channel;
import io.ably.lib.realtime.ChannelBase;
import io.ably.lib.types.AblyException;
import io.ably.lib.types.Message;

import static org.inspirecenter.amazechallenge.ui.BlocklyActivity.INTENT_KEY_NEXT_ACTIVITY;
import static org.inspirecenter.amazechallenge.ui.GameActivity.DEFAULT_AMBIENT_VOLUME;
import static org.inspirecenter.amazechallenge.ui.GameActivity.DEFAULT_EVENTS_VOLUME;
import static org.inspirecenter.amazechallenge.ui.GameActivity.SELECTED_PLAYER_KEY;
import static org.inspirecenter.amazechallenge.ui.GameActivity.SELECTED_PLAYER_WORLD_SESSION_KEY;
import static org.inspirecenter.amazechallenge.ui.MainActivity.KEY_DISCOVER_CODE_EDITOR_ONLINE;
import static org.inspirecenter.amazechallenge.ui.MainActivity.KEY_PREF_SOUND;
import static org.inspirecenter.amazechallenge.ui.MainActivity.KEY_PREF_VIBRATION;
import static org.inspirecenter.amazechallenge.ui.MainActivity.setLanguage;
import static org.inspirecenter.amazechallenge.ui.OnlineChallengeActivity.PREFERENCE_KEY_CHALLENGE;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PREFERENCE_KEY_EMAIL;
import static org.inspirecenter.amazechallenge.ui.PersonalizeActivity.PREFERENCE_KEY_NAME;

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

    private AMCWorldSession currentPlayerWorldSession;

    private ChallengeProto challenge;
    private String email = null;

    private Handler handler;
    private Timer timer = null;

    AblyRealtime ably;
    Channel channel;

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

        //Preferences and passed data:
        //Preferences and passed data:
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final String name = sharedPreferences.getString(PREFERENCE_KEY_NAME, getString(R.string.Guest));
        currentPlayerWorldSession = (AMCWorldSession) getIntent().getSerializableExtra(SELECTED_PLAYER_WORLD_SESSION_KEY);

        //Set up Ably:
        try {
            ably = new AblyRealtime("KC5T5A.vG4G5Q:kpD9gGw44EERYqI-");
        } catch (AblyException e) {
            e.printStackTrace();
        }
        channel = ably.channels.get("stateUpdate-" + currentPlayerWorldSession.getPlayerID());

        // specify and set an adapter
        onlinePlayerAdapter = new OnlinePlayerAdapter(name);
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

        boolean discoveredCodeEditor = PreferenceManager.getDefaultSharedPreferences(this).getBoolean(KEY_DISCOVER_CODE_EDITOR_ONLINE, false);

        if (!discoveredCodeEditor) {
            mainFAB.post(() -> {
                DiscoveryView discoveryView = new DiscoveryView.Builder(OnlineGameActivity.this, mainFAB)
                        .setPrimaryText(R.string.discovery_code)
                        .setSecondaryText("")
                        .setBackgroundColor(getColor(R.color.colorPrimaryDark))
                        .setPrimaryTextColor(getColor(R.color.colorAccentLight))
                        .setOnClickListener(new DiscoveryView.OnDiscoveryViewClickListener() {
                            @Override
                            public void onDiscoveryViewClicked(DiscoveryView discoveryView) {
                                discoveryView.dismiss();
                            }

                            @Override
                            public void onDiscoveryViewDismissed(DiscoveryView discoveryView) {
                                discoveryView.dismiss();
                            }
                        })
                        .build();
                discoveryView.show();
                PreferenceManager.getDefaultSharedPreferences(OnlineGameActivity.this).edit().putBoolean(KEY_DISCOVER_CODE_EDITOR_ONLINE, true).apply();
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(OnlineGameActivity.this);
        email = sharedPreferences.getString(PREFERENCE_KEY_EMAIL, getString(R.string.Guest_email));

        // get challenge from intent
        challenge = (ChallengeProto) getIntent().getSerializableExtra(PREFERENCE_KEY_CHALLENGE);
        if (challenge == null) {
            Log.e(TAG, "Invalid null argument 'challenge' in Intent");
            finish();
        }

        //NEW in 2.0, sets the correct background image based on the challenge.
        this.gameView.setBackgroundDrawable(challenge.getBackgroundImage());

        //NEW in 2.0, plays background audio:
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

        //NEW in 2.0, adjusts the line color based on the challenge:
        this.gameView.setLineColor(challenge.getLineColor());

        getStateHTTP();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (backgroundAudio != null) backgroundAudio.stop();
        if (timer != null) timer.cancel();
        leaveChallengeHTTP();
    }

    private void leaveChallengeHTTP() {
        finish();
        RequestQueue queue = Volley.newRequestQueue(OnlineGameActivity.this);
        final String url = Stubs.BASE_URL + "/api/challenge/leave";

        LeaveChallengeRequest requestMessage = LeaveChallengeRequest.newBuilder()
                .setChallengeID(challenge.getId())
                .setWorldSessionID(currentPlayerWorldSession.getId())
                .build();

        BinaryRequest leaveChallengeRequest = new BinaryRequest(Request.Method.POST, url, requestMessage, response -> {
            try {
                LeaveChallengeResponse leaveChallengeResponse = LeaveChallengeResponse.parseFrom(response);
                if (leaveChallengeResponse.getStatus() == LeaveChallengeResponse.Status.OK) {

                }
                else {
                    Snackbar.make(findViewById(R.id.activity_online_game), R.string.could_not_leave_challenge, Snackbar.LENGTH_SHORT).show();
                    System.err.println(leaveChallengeResponse.getMessage());
                }
            } catch (InvalidProtocolBufferException e) {
                Snackbar.make(findViewById(R.id.activity_online_game), R.string.could_not_leave_challenge, Snackbar.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }, error -> {
            Snackbar.make(findViewById(R.id.activity_online_game), R.string.could_not_leave_challenge, Snackbar.LENGTH_SHORT).show();
            error.printStackTrace();
        });

        queue.add(leaveChallengeRequest);
    }

    @Override
    protected void onStop() {
        super.onStop();
        leaveChallengeHTTP();
    }

    @Override
    public void onBackPressed() {
        if (!isFABOpen) {

            //Confirm leaving the game:
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(OnlineGameActivity.this)
                    .setTitle(R.string.leave_challenge)
                    .setMessage(R.string.confirm_leave_challenge_msg)
                    .setNegativeButton(R.string.cancel, (dialogInterface, i) -> dialogInterface.dismiss())
                    .setPositiveButton(R.string.exit, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            leaveChallengeHTTP();
                        }
                    });

            dialogBuilder.create().show();

        } else {
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
                if (pickable.getState() == 1 || pickable.getState() == 2) {
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
            winAudio = MediaPlayer.create(this, getResources().getIdentifier(Audio.EVENT_WIN_Audio.getSoundResourceName(), "raw", getPackageName()));
            winAudio.start();
        } else {
            loseAudio = MediaPlayer.create(this, getResources().getIdentifier(Audio.EVENT_LOSE_Audio.getSoundResourceName(), "raw", getPackageName()));
            loseAudio.start();
        }
    }

    private void submitCodeHTTP(String code) {

        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = Stubs.BASE_URL + "/api/submitCode";

        SubmitCodeRequest requestMessage = SubmitCodeRequest.newBuilder()
                .setCode(code)
                .setWorldSessionID(AMCClient.getInstance().getWorldSession().getId())
                .build();

        BinaryRequest submitCodeRequest = new BinaryRequest(Request.Method.POST, url, requestMessage, response -> {
            try {
                SubmitCodeResponse submitCodeResponse = SubmitCodeResponse.parseFrom(response);
                if (submitCodeResponse.getStatus() == SubmitCodeResponse.Status.OK) {
                    Snackbar.make(findViewById(R.id.activity_online_game), R.string.code_uploaded, Snackbar.LENGTH_SHORT).show();
                } else {
                    switch (submitCodeResponse.getMessage()) {
                        case "INVALID_WORLD_SESSION":
                            Snackbar.make(findViewById(R.id.activity_online_game), R.string.invalid_session, Snackbar.LENGTH_SHORT).show();
                            break;
                        case "CODE_EMPTY":
                            Snackbar.make(findViewById(R.id.activity_online_game), R.string.code_empty, Snackbar.LENGTH_SHORT).show();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                Toast.makeText(OnlineGameActivity.this, getString(R.string.code_upload_failed), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }, error -> {
            Toast.makeText(OnlineGameActivity.this, getString(R.string.code_upload_failed), Toast.LENGTH_LONG).show();
            error.printStackTrace();
        });

        queue.add(submitCodeRequest);
    }

    private void getStateHTTP() {

        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = Stubs.BASE_URL + "/api/state/get";

        GetStateRequest requestMessage = GetStateRequest.newBuilder()
                .setWorldSessionID(AMCClient.getInstance().getWorldSession().getId())
                .build();

        BinaryRequest getStateRequest = new BinaryRequest(Request.Method.POST, url, requestMessage, response -> {
            try {
                GetStateResponse getStateResponse = GetStateResponse.parseFrom(response);
                if (getStateResponse.getStatus() == GetStateResponse.Status.OK) {
                    gameView.initialize(getStateResponse.getPartialState());

                    onlinePlayerAdapter.clear();
                    onlinePlayerAdapter.update(getStateResponse.getPartialState());
                    onlinePlayerAdapter.notifyDataSetChanged();
//                        final boolean active = gameFullState.getActivePlayerIDs().contains(Installation.id(OnlineGameActivity.this));
//                        final boolean queued = gameFullState.getQueuedPlayerIDs().contains(Installation.id(OnlineGameActivity.this));

                    handler = new Handler();

                    if (timer == null) {
                        timer = new Timer();
                    }
//                    timer.schedule(new OnlineMazeRunner(), 0L, ONE_SECOND); // todo

                    ChannelBase.MessageListener listener = new ChannelBase.MessageListener() {
                        @Override
                        public void onMessage(Message message) {
                            byte[] responseData = (byte[]) message.data;
                            try {
                                UpdateStateResponse updateStateResponse = UpdateStateResponse.parseFrom(responseData);
                                if (updateStateResponse.getStatus() == UpdateStateResponse.Status.OK) {
                                    if (updateStateResponse.getStateUpdate().getTimestamp() > lastUpdateTimestamp) {
                                        runOnUiThread(() -> {
                                            gameView.update(updateStateResponse.getStateUpdate());
                                            handleOnlineEvents(updateStateResponse.getStateUpdate());
                                            onlinePlayerAdapter.clear();
                                            onlinePlayerAdapter.update(updateStateResponse.getStateUpdate().getPartialState());
                                            onlinePlayerAdapter.notifyDataSetChanged();
                                        });
                                    }
                                }
                                else {
                                    Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.state_update_failed), Snackbar.LENGTH_SHORT).show();
                                    System.err.println(updateStateResponse.getMessage());
                                }
                            } catch (InvalidProtocolBufferException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    try {
                        channel.subscribe("stateUpdate", listener);
                    } catch (AblyException e) {
                        e.printStackTrace();
                    }

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
                else {
                    Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.gamestate_getting_error), Snackbar.LENGTH_SHORT).show();
                    System.err.println(getStateResponse.getMessage());
                }
            } catch (InvalidProtocolBufferException e) {
                Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.gamestate_getting_error), Snackbar.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }, error -> {
            Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.gamestate_getting_error), Snackbar.LENGTH_SHORT).show();
            error.printStackTrace();
        });

        queue.add(getStateRequest);
    }

    private long lastUpdateTimestamp = 0;

    private void updateStateHTTP() {

        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = Stubs.BASE_URL + "/api/state/update";

        UpdateStateRequest requestMessage = UpdateStateRequest.newBuilder()
                .setWorldSessionID(AMCClient.getInstance().getWorldSession().getId())
                .build();

        BinaryRequest updateStateRequest = new BinaryRequest(Request.Method.POST, url, requestMessage, response -> {
            try {
                UpdateStateResponse updateStateResponse = UpdateStateResponse.parseFrom(response);
                if (updateStateResponse.getStatus() == UpdateStateResponse.Status.OK) {
                    if (updateStateResponse.getStateUpdate().getTimestamp() > lastUpdateTimestamp) {
                        gameView.update(updateStateResponse.getStateUpdate());
                        handleOnlineEvents(updateStateResponse.getStateUpdate());
                        onlinePlayerAdapter.clear();
                        onlinePlayerAdapter.update(updateStateResponse.getStateUpdate().getPartialState());
                        onlinePlayerAdapter.notifyDataSetChanged();

//                        final boolean active = gameFullState.getActivePlayerIDs().contains(Installation.id(OnlineGameActivity.this));
//                        final boolean queued = gameFullState.getQueuedPlayerIDs().contains(Installation.id(OnlineGameActivity.this));
                    }
                }
                else {
                    Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.state_update_failed), Snackbar.LENGTH_SHORT).show();
                    System.err.println(updateStateResponse.getMessage());
                }
            } catch (InvalidProtocolBufferException e) {
                Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.state_update_failed), Snackbar.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }, error -> {
            Snackbar.make(findViewById(R.id.activity_online_game), getString(R.string.state_update_failed), Snackbar.LENGTH_SHORT).show();
            error.printStackTrace();
        });

        queue.add(updateStateRequest);
    }

    public static String convertStreamToString(final InputStream inputStream) {
        final Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }

    private class OnlineMazeRunner extends TimerTask {
        @Override
        public void run() {
            if (handler != null) {
                handler.post(() -> {
                    if (challenge == null) {
                        finish();
                    } else {
                        updateStateHTTP();
                    }
                });
            }
        }
    }

    private void handleOnlineEvents(AMCStateUpdateProto stateUpdate) {

        for (Audio audio : stateUpdate.getEventsList()) {
            if (audio == Audio.EVENT_WIN_Audio) {
                onGameEndAudioEvent(true);
                onWin();
            }
            else if (audio == Audio.EVENT_LOSE_Audio) {
                onGameEndAudioEvent(false);
                onLose();
            }
            else {
                switch (audio) {
                    case EVENT_FOOD_Audio:
                        if (sound) audioEventsMap.get(Audio.EVENT_FOOD_Audio.toString()).start();
                        Toast.makeText(OnlineGameActivity.this, Emoji.getEmojiAsString(Emoji.FOOD) + " " + "Nom nom nom" + " " + Emoji.getEmojiAsString(Emoji.STRONG), Toast.LENGTH_SHORT).show();
                        break;
                    case EVENT_COIN5_Audio:
                        if (sound) audioEventsMap.get(Audio.EVENT_COIN5_Audio.toString()).start();
                        Toast.makeText(OnlineGameActivity.this, Emoji.getEmojiAsString(Emoji.COINS), Toast.LENGTH_SHORT).show();
                        break;
                    case EVENT_COIN10_Audio:
                        if (sound) audioEventsMap.get(Audio.EVENT_COIN10_Audio.toString()).start();
                        Toast.makeText(OnlineGameActivity.this, Emoji.getEmojiAsString(Emoji.COINS), Toast.LENGTH_SHORT).show();
                        break;
                    case EVENT_COIN20_Audio:
                        if (sound) audioEventsMap.get(Audio.EVENT_COIN20_Audio.toString()).start();
                        Toast.makeText(OnlineGameActivity.this, Emoji.getEmojiAsString(Emoji.COINS), Toast.LENGTH_SHORT).show();
                        break;
                    case EVENT_GIFTBOX_Audio:
                        if (sound) audioEventsMap.get(Audio.EVENT_GIFTBOX_Audio.toString()).start();
                        Toast.makeText(OnlineGameActivity.this, Emoji.getEmojiAsString(Emoji.COINS), Toast.LENGTH_SHORT).show();
                        break;
                    case EVENT_BOMB_Audio:
                        if (sound) audioEventsMap.get(Audio.EVENT_BOMB_Audio.toString()).start();
                        if (vibration) {
                            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            if (v != null) v.vibrate(250);
                        }
                        Toast.makeText(OnlineGameActivity.this, getString(R.string.bomb) + " " + Emoji.getEmojiAsString(Emoji.BOMB), Toast.LENGTH_SHORT).show();
                        break;
                    case EVENT_SPEEDHACK_Audio:
                        if (sound) audioEventsMap.get(Audio.EVENT_SPEEDHACK_Audio.toString()).start();
                        if (vibration) {
                            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            long[] pattern = {100, 100, 100};
                            if (v != null) v.vibrate(pattern, -1);
                        }
                        Toast.makeText(OnlineGameActivity.this, getString(R.string.speedhack) + " " + Emoji.getEmojiAsString(Emoji.SPEEDHACK), Toast.LENGTH_SHORT).show();
                        break;
                    case EVENT_TRAP_Audio:
                        if (sound) audioEventsMap.get(Audio.EVENT_TRAP_Audio.toString()).start();
                        if (vibration) {
                            Vibrator vTrap = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            if (vTrap != null) vTrap.vibrate(250);
                        }
                        Toast.makeText(OnlineGameActivity.this, getString(R.string.trap) + " " + Emoji.getEmojiAsString(Emoji.TRAP), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }

    }

    private void showFABMenu() {
        isFABOpen = true;
        fabBackground.setVisibility(View.VISIBLE);
        fabLayout_edit.setVisibility(View.VISIBLE);
        fabLayout_upload.setVisibility(View.VISIBLE);
        fabLayout_edit.animate().translationY(-getResources().getDimension(R.dimen.standard_65));
        fabLayout_upload.animate().translationY(-getResources().getDimension(R.dimen.standard_125));
    }

    private void closeFABMenu() {
        isFABOpen = false;
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

    private void onWin() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(OnlineGameActivity.this)
                .setTitle(R.string.win)
                .setMessage(R.string.win_message)
                .setPositiveButton(R.string.leave, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        leaveChallengeHTTP();
                    }
                })
                .setNegativeButton(R.string.watch, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setNeutralButton(R.string.try_again, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(OnlineGameActivity.this, OnlineChallengeActivity.class));
                        finish();
                    }
                })
                .setCancelable(false);
        dialogBuilder.create().show();
    }

    private void onLose() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(OnlineGameActivity.this)
                .setTitle(R.string.lost)
                .setMessage(R.string.lost_message)
                .setPositiveButton(R.string.leave, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        leaveChallengeHTTP();
                    }
                })
                .setNegativeButton(R.string.watch, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setNeutralButton(R.string.try_again, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(OnlineGameActivity.this, OnlineChallengeActivity.class));
                        finish();
                    }
                })
                .setCancelable(false);
        dialogBuilder.create().show();
    }

}