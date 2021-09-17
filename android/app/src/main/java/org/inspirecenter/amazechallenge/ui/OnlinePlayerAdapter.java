package org.inspirecenter.amazechallenge.ui;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.inspirecenter.amazechallenge.proto.AMCEntityProto;
import org.inspirecenter.amazechallenge.proto.AMCPartialStateProto;
import org.inspirecenter.amazechallenge.proto.AMCPlayerProto;
import org.inspirecenter.amazechallenge.proto.AMCWorldSessionProto;
import org.inspirecenter.amazechallenge.proto.PlayerEntityProto;

import org.inspirecenter.amazechallenge.R;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * @author Nearchos
 *         Created: 28-Feb-18
 */

public class OnlinePlayerAdapter extends RecyclerView.Adapter<OnlinePlayerAdapter.ViewHolder>  {

    private final String currentPlayerName;
    private final Vector<AMCPlayerProto> players;
    private final Map<String, AMCWorldSessionProto> worldSessions;
    private final Map<String, PlayerEntityProto> playerEntities;
    private final Map<String,String> playerIDsToStatus = new HashMap<>();

    OnlinePlayerAdapter(final String currentPlayerName) {
        this.currentPlayerName = currentPlayerName;
        this.players = new Vector<>();
        this.worldSessions = new HashMap<>();
        this.playerEntities = new HashMap<>();
    }

    void update(final AMCPartialStateProto partialState) {
        final Collection<AMCPlayerProto> allPlayers = partialState.getPlayersMap().values();
        final Map<String, AMCWorldSessionProto> worldSessions = partialState.getWorldSessionsMap();

        this.players.clear();
        this.players.addAll(allPlayers);
        this.worldSessions.putAll(worldSessions);

        for (Map.Entry<String, AMCEntityProto> entry : partialState.getEntitiesMap().entrySet()) {
            if (entry.getValue().hasPlayerEntity()) {
                this.playerEntities.put(entry.getKey(), entry.getValue().getPlayerEntity());
            }
        }

        Collections.sort(players, (playerLeft, playerRight) -> {
            AMCWorldSessionProto leftWorldSession = partialState.getWorldSessionsMap().get(playerLeft.getId());
            AMCWorldSessionProto rightWorldSession = partialState.getWorldSessionsMap().get(playerRight.getId());

            final int playerLeftPoints = leftWorldSession != null ? leftWorldSession.getPoints() : 0;
            final int playerRightPoints = rightWorldSession != null ? rightWorldSession.getPoints() : 0;
            final int playerLeftHealth = leftWorldSession != null ? leftWorldSession.getHealth().getHealth() : 0;
            final int playerRightHealth = rightWorldSession != null ? rightWorldSession.getHealth().getHealth() : 0;

            return playerLeftPoints > playerRightPoints ? -1 :
                   playerLeftPoints < playerRightPoints ? +1 :
                   playerLeftHealth > playerRightHealth ? -1 :
                   playerLeftHealth < playerRightHealth ? +1 :
                           0;
        });

        for(final String activeID : partialState.getActivePlayersList()) {
            playerIDsToStatus.put(activeID, "Active");
        }

        for(final String queuedID : partialState.getQueuedPlayersList()) {
            playerIDsToStatus.put(queuedID, "Queued");
        }

        for(final String waitingID : partialState.getWaitingPlayersList()) {
            playerIDsToStatus.put(waitingID, "Waiting");
        }

    }

    void clear() {
        this.players.clear();
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than
     * one view per item, and you provide access to all the views for a data item in a view holder.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        final CardView playerCardView;
        final TextView playerNameTextView;
        final TextView playerPointsTextView;
        final TextView playerStatusTextView;
        final ProgressBar playerHealthProgressBar;

        AMCPlayerProto player;
        Map<String, AMCWorldSessionProto> worldSessions;
        PlayerEntityProto playerEntity;

        ViewHolder(final View view) {
            super(view);
            this.playerCardView = view.findViewById(R.id.item_online_player_card_view);
            this.playerNameTextView = view.findViewById(R.id.item_online_player_name);
            this.playerPointsTextView = view.findViewById(R.id.item_online_player_points);
            this.playerStatusTextView = view.findViewById(R.id.item_online_player_status);
            this.playerHealthProgressBar = view.findViewById(R.id.item_online_player_health);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public OnlinePlayerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_online_player, parent, false);

        // set the view's size, margins, paddings and layout parameters
        return  new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final AMCPlayerProto player = players.elementAt(position);
        if(currentPlayerName.equals(player.getId())) {
            holder.playerCardView.setBackgroundColor(Color.argb(0.3f, 1f, 1f, 0f));
            holder.playerNameTextView.setText(player.getName() + " (You)");
        } else {
            holder.playerCardView.setBackgroundColor(Color.WHITE);
            holder.playerNameTextView.setText(player.getName());
        }

        final String playerStatus = playerIDsToStatus.get(player.getId());

        if ("Active".equals(playerStatus)) {
            holder.playerStatusTextView.setText(R.string.active);
            holder.playerStatusTextView.setTextColor(Color.parseColor("#006400")); //Dark green
        }
        else if ("Queued".equals(playerStatus)) {
            holder.playerStatusTextView.setText(R.string.queued);
            holder.playerStatusTextView.setTextColor(Color.parseColor("#008b8b")); //Dark cyan
        }
        else {
            holder.playerStatusTextView.setText(R.string.waiting);
            holder.playerStatusTextView.setTextColor(Color.GRAY);
        }
        holder.player = player;


        final int points;
        final int health;
        if (worldSessions.get(player.getId()) != null) {
            points = worldSessions.get(player.getId()).getPoints();
            health = worldSessions.get(player.getId()).getHealth().getHealth();
        }
        else {
            points = -1;
            health = -1;
        }

        holder.playerPointsTextView.setText(Integer.toString(points));
        holder.playerHealthProgressBar.setProgress(health);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return players.size();
    }
}