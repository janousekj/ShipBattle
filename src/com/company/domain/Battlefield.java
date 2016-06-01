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

    Battlefield(int size) {
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


        if (!field.get(x).get(y).isFired()) {
            field.get(x).get(y).setFired(true);
            return field.get(x).get(y);
        } else {
            return field.get(x).get(y);
        }
    }

    public void setHit(int x, int y) {
        field.get(x).set(y, FieldType.HIT);
    }

    public void writeShipPart(int x, int y, ShipType shipType) {

        field.get(x).get(y).setShipType(shipType);
    }

    public List<List<FieldType>> getField() {
        return field;
    }

    // TODO Zeptam se zda na x,y lze umistitit lod. funkce počekuje jestli tam je jina loď nebo jestli je to mimo
    // TODO Tu funkci volat v cyklu, pak prijde lod která řekne počet čtverečků a směr

    public boolean shipCheck(int x, int y, ShipType shipType, int direction){
        if(direction == 1){
            int i = 0;
            while(shipSizeComparation(shipType, i) && x+i < this.size && y+i < this.size){
                if (getField().get(x+i).get(y) != FieldType.EMPTY)
                    return false;
                else i++;
            }
            return true;
        }else if (direction == 2){
            int i = 0;
            while(shipSizeComparation(shipType, i)){
                if (getField().get(x).get(y+i) != FieldType.EMPTY)
                    return false;
                else i++;
            }
            return true;
        }
        return false;
    }

    private boolean shipSizeComparation(ShipType shipType, int i) {
        return shipType.size > i;
    }


    public boolean putShip(int x, int y, ShipType shipType, int direction) {
        switch (shipType) {
            case CARRIER:
                if (shipCheck(x, y, shipType, direction)) {
                    getField().get(x).get(y).setShipType(ShipType.CARRIER);
                    getField().get(x).set(y, FieldType.SHIP);
                }else putShipError();
                break;
            case DESTROYER:
                if (shipCheck(x, y, shipType, direction)) {
                    if (direction == 1){
                        int i = 0;
                        while (shipSizeComparation(shipType, i)){
                            getField().get(x+i).get(y).setShipType(ShipType.DESTROYER);
                            getField().get(x+i).set(y, FieldType.SHIP);
                            i++;
                        }
                    }
                    if (direction == 2){
                        int i = 0;
                        while (shipSizeComparation(shipType, i)){
                            getField().get(x).get(y+i).setShipType(ShipType.DESTROYER);
                            getField().get(x).set(y+i, FieldType.SHIP);
                            i++;
                        }
                    }

                }else putShipError();
                break;
            case CRUISER:
                if (shipCheck(x, y, shipType, direction)) {
                    if (direction == 1){
                        int i = 0;
                        while (shipSizeComparation(shipType, i)){
                            getField().get(x+i).get(y).setShipType(ShipType.CRUISER);
                            getField().get(x+i).set(y, FieldType.SHIP);
                            i++;
                        }
                    }
                    if (direction == 2){
                        int i = 0;
                        while (shipSizeComparation(shipType, i)){
                            getField().get(x).get(y+i).setShipType(ShipType.CRUISER);
                            getField().get(x).set(y+i, FieldType.SHIP);
                            i++;
                        }
                    }

                } else{
                    putShipError();
                }
                break;
            default:
                break;



        }
        return false;
    }

    private void putShipError() {
        System.out.println("Na tuto pozici nelze lod umistit");
    }
}
