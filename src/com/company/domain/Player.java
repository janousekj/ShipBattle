package com.company.domain;

/**
 * Created by semanticer on 31. 3. 2016.
 */
public class Player {
    private final String name;
    private final Battlefield battlefield;

    public Player(String name, int size) {
        this.name = name;
        this.battlefield = new Battlefield(size);

    }

    public String getName() {
        return name;
    }

    public Battlefield getBattlefield() {
        return battlefield;
    }
}
