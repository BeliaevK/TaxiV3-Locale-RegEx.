package ru.GoldTaxiV3.Utilities.Enums;

/**
 * Created by Scala on 24.12.2016.
 */
public enum TypeOfStatus {
    FREE ("Свободен"), RESERVED ("Занят");

    private String typeOfStatus;

    public String getTypeOfStatus() {
        return typeOfStatus;
    }

    TypeOfStatus(String typeOfStatus) {
        this.typeOfStatus = typeOfStatus;
    }
}
