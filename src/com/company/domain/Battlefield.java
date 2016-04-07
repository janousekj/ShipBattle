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

        // TODO bude potreba vygenerovat tolik rows kolik je size
        List<FieldType> row = new ArrayList<>();

        // TODO do kazdeho row bude potreba dat toli rows kolik je size
        row.add(FieldType.EMPTY);

        field.add(row);

    }

    public boolean fire(int x, int y) {
        // TODO oznaci pole za isFired
        return false;
    }

    public void writeShipPart(int x, int y, ShipType shipType) {
        // TODO zapise na x,y FieldType konkretni shipType
    }




}
