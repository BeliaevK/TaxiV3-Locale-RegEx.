package ru.GoldTaxiV3.Entities;

import ru.GoldTaxiV3.Utilities.MyResourseBundle;

/**
 * Created by Scala on 13.11.2016.
 */
public class Car {
    private String carMark;
    private Driver carDriver;
    private String carNumber;
    private boolean babySeat;
    private boolean smoking;
    private int carClass;
    private String carStatus;
    private static final int TYPE_OF_CLASS_ECONOMIC = 0;
    private static final int TYPE_OF_CLASS_BUSYNESS = 1;
    private static final String TYPE_OF_STATUS_FREE = "Свободен";
    private static final String TYPE_OF_STATUS_RESERVED = "Занят";

    public Car(String carMark, Driver carDriver, String carNumber, boolean babySeat, boolean smoking, int carClass, String carStatus) {
        this.carMark = carMark;
        this.carDriver = carDriver;
        this.carNumber = carNumber;
        this.babySeat = babySeat;
        this.smoking = smoking;
        this.carClass = carClass;
        this.setCarStatus(carStatus);
    }


    public static int getTypeOfClassEconomic() {
        return TYPE_OF_CLASS_ECONOMIC;
    }

    public static int getTypeOfClassBusyness() {
        return TYPE_OF_CLASS_BUSYNESS;
    }

    public static String getTypeOfStatusFree() {
        return TYPE_OF_STATUS_FREE;
    }

    public static String getTypeOfStatusReserved() {
        return TYPE_OF_STATUS_RESERVED;
    }

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public Driver getCarDriver() {
        return carDriver;
    }

    public void setCarDriver(Driver carDriver) {
        this.carDriver = carDriver;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public boolean isBabySeat() {
        return babySeat;
    }

    public void setBabySeat(boolean babySeat) {
        this.babySeat = babySeat;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public int getCarClass() {
        return carClass;
    }

    public void setCarClass(int carClass) {
        this.carClass = carClass;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    @Override
    public String toString() {
        return this.carMark  + ", " + MyResourseBundle.getBundle().getString("carnumber") + ": " + this.carNumber+ ", "
                + MyResourseBundle.getBundle().getString("driver") + ": "  + this.carDriver.getName() + ", " +
                MyResourseBundle.getBundle().getString("telephone") + ": " + this.carDriver.getTelephone() + ".";
    }
}