package com.nkasenides.amc.controller;

import org.inspirecenter.amazechallenge.model.Pickable;

public interface AudioEventListener {

    public void onAudioEvent(final Pickable pickable);

    public void onGameEndAudioEvent(boolean win);

}