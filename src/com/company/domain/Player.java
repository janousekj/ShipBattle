package com.company.domain;

/**
 * Created by semanticer on 31. 3. 2016.
 */
public class Player {
    private final String name;
    private final Battlefield battlefield;
    private int hits = 0;
    // TODO informaci mohu zjistit v battlefieldu


    //TODO spise do konzole
    public void printBattlefield()
    {
    	for(int i = 0; i < battlefield.getSize(); i++)
    	{System.out.println();
    		for(int j =0 ; j < battlefield.getSize();j++)
    		{
    		System.out.print(battlefield.getField().get(i).get(j) + "   ");
    		}
    } 
    	}
   

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
