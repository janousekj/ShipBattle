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

    public boolean putShip(int x, int y, ShipType shipType, int direction) {
        switch (shipType) {
            case CARRIER:
                if (getField().get(x).get(y) == FieldType.EMPTY) {
                    getField().get(x).get(y).setShipType(ShipType.CARRIER);
                    getField().get(x).set(y, FieldType.SHIP);
                    return true;
                } else return false;
            case CRUISER:
                if (direction == 1 && x >= 2) {
                    if (getField().get(x).get(y) == FieldType.EMPTY
                            && getField().get(x - 1).get(y) == FieldType.EMPTY
                            && getField().get(x - 2).get(y) == FieldType.EMPTY) {
                        for (int i = 0; i < 3; i++) {
                            getField().get(x - i).get(y).setShipType(ShipType.CRUISER);
                            getField().get(x - i).set(y, FieldType.SHIP);
                        }
                        return true;
                    }
                } else if (direction == 2 && y < size - 2) {
                    if (getField().get(x).get(y) == FieldType.EMPTY
                            && getField().get(x).get(y + 1) == FieldType.EMPTY
                            && getField().get(x).get(y + 2) == FieldType.EMPTY) {
                        for (int i = 0; i < 3; i++) {
                            getField().get(x).get(y + i).setShipType(ShipType.CRUISER);
                            getField().get(x).set(y + i, FieldType.SHIP);
                        }
                        return true;
                    }
                } else if (direction == 3 && x < size - 2) {
                    if (getField().get(x).get(y) == FieldType.EMPTY
                            && getField().get(x + 1).get(y) == FieldType.EMPTY
                            && getField().get(x + 2).get(y) == FieldType.EMPTY) {
                        for (int i = 0; i < 3; i++) {
                            getField().get(x + i).get(y).setShipType(ShipType.CRUISER);
                            getField().get(x + i).set(y, FieldType.SHIP);
                        }
                        return true;
                    }
                } else if (direction == 4 && y >= 2) {
                    if (getField().get(x).get(y) == FieldType.EMPTY
                            && getField().get(x).get(y - 1) == FieldType.EMPTY
                            && getField().get(x).get(y - 2) == FieldType.EMPTY) {
                        for (int i = 0; i < 3; i++) {
                            getField().get(x).get(y - i).setShipType(ShipType.CRUISER);
                            getField().get(x).set(y - i, FieldType.SHIP);
                        }
                        return true;
                    }

                } else return false; //TODO dodelat chybovou hlasku
                break;
            case DESTROYER:
                if (direction == 1 && x >= 1) {
                    if (getField().get(x).get(y) == FieldType.EMPTY
                            && getField().get(x - 1).get(y) == FieldType.EMPTY) {
                        for (int i = 0; i < 2; i++) {
                            getField().get(x - i).get(y).setShipType(ShipType.DESTROYER);
                            getField().get(x - i).set(y, FieldType.SHIP);
                        }
                        return true;
                    }
                } else if (direction == 2 && y < size - 1) {
                    if (getField().get(x).get(y) == FieldType.EMPTY
                            && getField().get(x).get(y + 1) == FieldType.EMPTY) {
                        for (int i = 0; i < 2; i++) {
                            getField().get(x).get(y + i).setShipType(ShipType.DESTROYER);
                            getField().get(x).set(y + i, FieldType.SHIP);
                        }
                        return true;
                    }

                } else if (direction == 3 && x < size - 1) {
                    if (getField().get(x).get(y) == FieldType.EMPTY
                            && getField().get(x + 1).get(y) == FieldType.EMPTY) {
                        for (int i = 0; i < 2; i++) {
                            getField().get(x + i).get(y).setShipType(ShipType.DESTROYER);
                            getField().get(x + i).set(y, FieldType.SHIP);
                        }
                        return true;
                    }
                } else if (direction == 4 && y >= 1) {
                    if (getField().get(x).get(y) == FieldType.EMPTY
                            && getField().get(x).get(y - 1) == FieldType.EMPTY) {
                        for (int i = 0; i < 2; i++) {
                            getField().get(x).get(y - i).setShipType(ShipType.DESTROYER);
                            getField().get(x).set(y - i, FieldType.SHIP);
                        }
                        return true;
                    }

                } else return false; //TODO dodelat chybovou hlasku
                break;
            default:
                break;
        }
    return false;
    }
}
