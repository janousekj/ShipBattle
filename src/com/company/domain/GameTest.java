package com.company.domain;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by semanticer on 31. 3. 2016.
 */
public class GameTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructor() throws Exception {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pepa"));
        Game game = new Game(players, 10);
    }
}