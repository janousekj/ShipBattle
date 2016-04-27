package com.company.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by semanticer on 31. 3. 2016.
 */
public class Battlefield {

//test

    List<List<FieldType>> field;
    private final int size;



    public int getSize() {
		return size;
	}

	Battlefield (int size) {
    	this.size = size;
        field = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<FieldType> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(FieldType.EMPTY);
            }
            field.add(row);

        }



    }

    public FieldType fire(int x, int y) {


        if (!field.get(x).get(y).isFired()){
            field.get(x).get(y).setFired(true);
            return field.get(x).get(y);
        }else{
            return field.get(x).get(y);
        }
    }
    public void setHit(int x, int y){
        field.get(x).set(y, FieldType.HIT);
    }

    public void writeShipPart(int x, int y, ShipType shipType) {

        field.get(x).get(y).setShipType(shipType);
    }

    public List<List<FieldType>> getField() {
        return field;
    }

    public boolean putShip(int x, int y){
        if (getField().get(x).get(y) == FieldType.EMPTY){
            // TODO nahradit metodou battlefieldu putShip()
            // TODO setnout policku SHIP
            getField().get(x).get(y).setShipType(ShipType.CARRIER);
            getField().get(x).set(y, FieldType.SHIP);
            return true;
        }else return false;

    }
}
