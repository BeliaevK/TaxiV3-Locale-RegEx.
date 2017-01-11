package ru.GoldTaxiV3.Utilities;

import ru.GoldTaxiV3.Entities.Car;
import ru.GoldTaxiV3.Entities.MyList;
import ru.GoldTaxiV3.Entities.Order;
import ru.GoldTaxiV3.Utilities.Enums.TypeOfStatus;

import java.util.LinkedList;

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
                reservedCar.setCarStatus(TypeOfStatus.RESERVED.getTypeOfStatus());
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

    public static void reservedCar (Car reservedCar, Order order, MyList<Car> carMyList,LinkedList<Order> orderList){
        if (reservedCar != null){
            orderList.add(order);
            System.out.println(MyResourseBundle.getBundle().getString("appointed") + ": "+ reservedCar);
            // System.out.println(queueOrderList.size());
        } else {
            ThreadForCheckCar threadForCheckCar =  new ThreadForCheckCar(carMyList,order);
            threadForCheckCar.start();
/*                queueOrderList.add(order);*/
            System.out.println(MyResourseBundle.getBundle().getString("waitCar"));
            // System.out.println(queueOrderList.size());
        }
    }

    public static boolean compareOrderToCar(Car car, Order order) {
        boolean isSuitCar = true;
        if (TypeOfStatus.RESERVED.getTypeOfStatus().equals(car.getCarStatus()) || !(car.isBabySeat() == order.isNeedBabySeat()) ||
                !(car.isSmoking() == order.isNeedSmoking()) || !(car.getCarClass() == order.getNeedCarClass())) isSuitCar = false;
        return isSuitCar;
    }
}
