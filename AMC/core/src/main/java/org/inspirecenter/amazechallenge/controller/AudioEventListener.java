package org.inspirecenter.amazechallenge.controller;

import org.inspirecenter.amazechallenge.model.PickableEntity;

public interface AudioEventListener {

    public void onAudioEvent(final PickableEntity pickable);

    public void onGameEndAudioEvent(boolean win);

}