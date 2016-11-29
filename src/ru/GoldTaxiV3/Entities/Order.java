package ru.GoldTaxiV3.Entities;

/**
 * Created by Scala on 13.11.2016.
 */
public class Order {
    private String startPoint;
    private String endPoint;
    private boolean needBabySeat;
    private boolean needSmoking;
    private int needCarClass;
    private Car carReserver;
    private Driver driverReserver;

    public Order (String startPoint, String endPoint, boolean needBabySeat, boolean needSmoking, int needCarClass) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.needBabySeat = needBabySeat;
        this.needSmoking = needSmoking;
        this.needCarClass = needCarClass;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public boolean isNeedBabySeat() {
        return needBabySeat;
    }

    public void setNeedBabySeat(boolean needBabySeat) {
        this.needBabySeat = needBabySeat;
    }

    public boolean isNeedSmoking() {
        return needSmoking;
    }

    public void setNeedSmoking(boolean needSmoking) {
        this.needSmoking = needSmoking;
    }

    public int getNeedCarClass() {
        return needCarClass;
    }

    public void setNeedCarClass(int needCarClass) {
        this.needCarClass = needCarClass;
    }

    public Car getCarReserver() {
        return carReserver;
    }

    public void setCarReserver(Car carReserver) {
        this.carReserver = carReserver;
    }

    public Driver getDriverReserver() {
        return driverReserver;
    }

    public void setDriverReserver(Driver driverReserver) {
        this.driverReserver = driverReserver;
    }
}
