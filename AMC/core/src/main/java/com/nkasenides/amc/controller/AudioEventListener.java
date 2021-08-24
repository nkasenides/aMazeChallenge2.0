package com.nkasenides.amc.controller;

import com.nkasenides.amc.model.PickableEntity;

public interface AudioEventListener {

    public void onAudioEvent(final PickableEntity pickable);

    public void onGameEndAudioEvent(boolean win);

}