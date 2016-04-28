package com.company.domain;

import java.util.List;

/**
 * Created by semanticer on 31. 3. 2016.
 */
public class Game {
    private final List<Player> players;
    public static final int TOTAL_AMOUNT_OF_SHIPS = 5; //TODO obtain total amount other way


    public int getTOTAL_AMOUNT_OF_SHIPS() {
		return TOTAL_AMOUNT_OF_SHIPS;
	}

	public Game(List<Player> players) {
        if (players == null || players.size() != 2)
            throw new IllegalArgumentException("players must have exactly 2 items");

        this.players = players;

    }

    public List<Player> getPlayers() {
        return players;
    }
}
