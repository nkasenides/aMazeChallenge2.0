package org.inspirecenter.amazechallenge.ui;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nkasenides.amc.model.Challenge;
import com.nkasenides.amc.proto.ChallengeProto;

import org.inspirecenter.amazechallenge.R;

import java.util.Collection;
import java.util.Vector;

/**
 * @author Nearchos
 *         Created: 19-Aug-17
 */

class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ViewHolder> {

    interface OnChallengeSelectedListener {
        void onChallengeSelected(final ChallengeProto challenge);
    }

    interface OnChallengeLongSelectionListener {
        void onChallengeLongSelect(final ChallengeProto challenge);
    }

    private final Vector<ChallengeProto> challenges;

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than
     * one view per item, and you provide access to all the views for a data item in a view holder.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        final TextView challengeNameTextView;
        final TextView challengeDescriptionTextView;
        final TextView challengeDimensionsTextView;
        final TextView challengeDifficultyTextView;
        ChallengeProto challenge;

        ViewHolder(final View view, final OnChallengeSelectedListener onChallengeSelectedListener, final OnChallengeLongSelectionListener onChallengeLongSelectionListener) {
            super(view);
            this.challengeNameTextView = view.findViewById(R.id.item_challenge_name);
            this.challengeDescriptionTextView = view.findViewById(R.id.item_challenge_description);
            this.challengeDimensionsTextView = view.findViewById(R.id.item_challenge_dimensions);
            this.challengeDifficultyTextView = view.findViewById(R.id.item_challenge_difficulty);
            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {
                    onChallengeSelectedListener.onChallengeSelected(challenge);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onChallengeLongSelectionListener.onChallengeLongSelect(challenge);
                    return true;
                }
            });
        }
    }

    private final OnChallengeSelectedListener onChallengeSelectedListener;
    private final OnChallengeLongSelectionListener onChallengeLongSelectionListener;

    ChallengeAdapter(final OnChallengeSelectedListener onChallengeSelectedListener, OnChallengeLongSelectionListener onChallengeLongSelectionListener) {
        this.challenges = new Vector<>();
        this.onChallengeSelectedListener = onChallengeSelectedListener;
        this.onChallengeLongSelectionListener = onChallengeLongSelectionListener;
    }

    void add(final ChallengeProto challenge) {
        challenges.add(challenge);
    }

    void addAll(final Collection<ChallengeProto> challenges) {
        this.challenges.addAll(challenges);
    }

    void clear() {
        this.challenges.clear();
    }

    Vector<ChallengeProto> getChallenges() {
        return new Vector<>(challenges);
    }

    int getSize() {
        return challenges.size();
    }

    boolean isEmpty() {
        return challenges.isEmpty();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ChallengeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_challenge, parent, false);

        // set the view's size, margins, paddings and layout parameters

        return  new ViewHolder(view, onChallengeSelectedListener, onChallengeLongSelectionListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final ChallengeProto challenge = challenges.elementAt(position);
        holder.challenge = challenge;
        holder.challengeNameTextView.setText(challenge.getName());
        holder.challengeDescriptionTextView.setText(challenge.getDescription());
        holder.challengeDimensionsTextView.setText(challenge.getGrid().getWidth() + " x " + challenge.getGrid().getHeight());
        switch(challenge.getDifficulty()) {
            case VERY_EASY_Difficulty:
                holder.challengeDifficultyTextView.setText(R.string.very_easy);
                holder.challengeDifficultyTextView.setTextColor(Color.parseColor("#299e29")); // todo parameterize colors
                break;
            case EASY_Difficulty:
                holder.challengeDifficultyTextView.setText(R.string.easy);
                holder.challengeDifficultyTextView.setTextColor(Color.parseColor("#299e29"));
                break;
            case MEDIUM_Difficulty:
                holder.challengeDifficultyTextView.setText(R.string.medium);
                holder.challengeDifficultyTextView.setTextColor(Color.parseColor("#989e29"));
                break;
            case HARD_Difficulty:
                holder.challengeDifficultyTextView.setText(R.string.hard);
                holder.challengeDifficultyTextView.setTextColor(Color.parseColor("#9e2929"));
                break;
            case VERY_HARD_Difficulty:
                holder.challengeDifficultyTextView.setText(R.string.very_hard);
                holder.challengeDifficultyTextView.setTextColor(Color.parseColor("#9e295f"));
                break;
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return challenges.size();
    }
}