package com.company.domain;


/**
 * Created by semanticer on 31. 3. 2016.
 */
public enum  FieldType {
    EMPTY, SHIP;

    private boolean fired;
    private ShipType shipType;


    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;

    }
}
