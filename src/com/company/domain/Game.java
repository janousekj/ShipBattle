package com.company.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by semanticer on 31. 3. 2016.
 */
public class Game {
    private final List<Player> players;
    private final Battlefield battlefield;

    public Game(List<Player> players, int size) {
        if (players == null || players.size() != 2)
            throw new IllegalArgumentException("players must have exactly 2 items");

        this.players = players;
        this.battlefield = new Battlefield(size);
    }

}
