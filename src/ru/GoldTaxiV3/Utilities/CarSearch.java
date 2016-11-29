package ru.GoldTaxiV3.Utilities;

import ru.GoldTaxiV3.Entities.Car;
import ru.GoldTaxiV3.Entities.Order;

import java.util.ArrayList;

/**
 * Created by Scala on 13.11.2016.
 */
public class CarSearch {

    private static CarSearch instance;

    public static CarSearch getInstance() {
        if (instance == null) {
            instance = new CarSearch();
        }
        return instance;
    }

    public static Car searchFreeCar(ArrayList<Car> carArrayList, Order order) {
        Car reservedCar = null;
        for (Car car : carArrayList) {
            if (CarSearch.compareOrderToCar(car, order)) {
                reservedCar = car;
                reservedCar.setCarStatus(Car.getTypeOfStatusReserved());
                order.setCarReserver(reservedCar);
                break;
            }
        }
        if (reservedCar == null) {
            return null;
        } else {
            return reservedCar;
        }
    }

    private static boolean compareOrderToCar(Car car, Order order) {
        boolean isSuitCar = true;
        if (Car.getTypeOfStatusReserved().equals(car.getCarStatus()) | !(car.isBabySeat() == order.isNeedBabySeat()) |
                !(car.isSmoking() == order.isNeedSmoking()) | !(car.getCarClass() == order.getNeedCarClass())) isSuitCar = false;
        return isSuitCar;
    }
}
