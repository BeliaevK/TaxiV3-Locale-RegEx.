package ru.GoldTaxiV3.Utilities;

import ru.GoldTaxiV3.Entities.Car;
import ru.GoldTaxiV3.Entities.MyList;
import ru.GoldTaxiV3.Entities.Order;

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

    public static Car searchFreeCar(MyList<Car> carArrayList, Order order) {
        Car reservedCar = null;
        for (int i = 0; i < carArrayList.size(); i++) {
            if (compareOrderToCar(carArrayList.get(i), order)) {
                reservedCar = carArrayList.get(i);
                reservedCar.setCarStatus(Car.getTypeOfStatusReserved());
                order.setCar(reservedCar);
                order.setOrderDate(OrderDate.getDate());
                break;
            }
        }
        if (reservedCar == null) {
            return null;
        } else {
            return reservedCar;
        }
    }

    public static boolean compareOrderToCar(Car car, Order order) {
        boolean isSuitCar = true;
        if (Car.getTypeOfStatusReserved().equals(car.getCarStatus()) || !(car.isBabySeat() == order.isNeedBabySeat()) ||
                !(car.isSmoking() == order.isNeedSmoking()) || !(car.getCarClass() == order.getNeedCarClass())) isSuitCar = false;
        return isSuitCar;
    }
}
