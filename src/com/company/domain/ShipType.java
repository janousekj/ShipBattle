package com.company.domain;


public enum ShipType {
    // zatim budeme resit jen jeden typ lode CARRIER ktery zabira jen jedno policko
    CARRIER (1), DESTROYER (2), CRUISER (3);

    int size;

    ShipType(int size) {
        this.size = size;
    }
    // Destroyer zabira dve policka
    // Cruiser tri

}
