package com.nkasenides.amc.algorithms;

import com.nkasenides.amc.model.Challenge;
import com.nkasenides.amc.model.Game;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Nearchos
 *         Created: 16-Aug-17
 */

public interface MazeSolver extends Serializable {

    public void init(final Challenge challenge, final Game game);

    public byte [] getState();

    public void setState(final byte [] bytes);

    PlayerMove getNextMove(final Game game);
}