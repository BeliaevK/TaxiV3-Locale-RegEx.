package ru.GoldTaxiV3.Entities;

import ru.GoldTaxiV3.Utilities.MyResourseBundle;

import java.util.Date;

/**
 * Created by Scala on 13.11.2016.
 */
public class Order {
    private String startPoint;
    private String endPoint;
    private boolean needBabySeat;
    private boolean needSmoking;
    private int needCarClass;
    private Car car;
    private Driver driverReserver;
    private Date orderDate;

    @Override
    public String toString() {
        return MyResourseBundle.getBundle().getString("startPoint") + ": " + startPoint + ", " +
                MyResourseBundle.getBundle().getString("endPoint") + ": " + endPoint + ", " +
                MyResourseBundle.getBundle().getString("babySeat") + ": " + needBabySeat + ", " +
                MyResourseBundle.getBundle().getString("smoking") + ": " + needSmoking + ", " +
                MyResourseBundle.getBundle().getString("carClass") + ": " + needCarClass + ", " +
                MyResourseBundle.getBundle().getString("car") + ": " + car + ", " +
                MyResourseBundle.getBundle().getString("driver") + ": " + driverReserver + ", " +
                MyResourseBundle.getBundle().getString("orderDate") + ": " + orderDate + ".";
    }

    public Order(String startPoint, String endPoint, boolean needBabySeat, boolean needSmoking, int needCarClass, Date orderDate) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.needBabySeat = needBabySeat;
        this.needSmoking = needSmoking;
        this.needCarClass = needCarClass;
        this.orderDate = orderDate;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver getDriverReserver() {
        return driverReserver;
    }

    public void setDriverReserver(Driver driverReserver) {
        this.driverReserver = driverReserver;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
