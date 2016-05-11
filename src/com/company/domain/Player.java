package com.company.domain;

/**
 * Created by semanticer on 31. 3. 2016.
 */
public class Player {
    private final String name;
    private final Battlefield battlefield;
    private int hits = 0;


   

    public void setHits(int hits) {
		this.hits = hits;
	}

	public int getHits() {
		return hits;
	}

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
