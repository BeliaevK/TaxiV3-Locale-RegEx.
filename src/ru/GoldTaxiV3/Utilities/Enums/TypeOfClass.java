package ru.GoldTaxiV3.Utilities.Enums;

/**
 * Created by Scala on 24.12.2016.
 */
public enum TypeOfClass {

    ECONOMIC (0), BUSYNESS (1);

    private int typeOfClass;

    TypeOfClass(int typeOfClass) {
        this.typeOfClass = typeOfClass;
    }

    public int getTypeOfClass() {
        return typeOfClass;
    }

}
