package com.company.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by semanticer on 31. 3. 2016.
 */
public class Battlefield {



    List<List<FieldType>> field;



    Battlefield (int size) {
        field = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<FieldType> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(FieldType.EMPTY);
            }
            field.add(row);

        }



    }

    public boolean fire(int x, int y) {


        if (!field.get(x).get(y).isFired()){
            field.get(x).get(y).setFired(true);
            return true;
        }else{
            return false;
        }
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
