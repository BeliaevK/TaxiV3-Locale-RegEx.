package ru.GoldTaxiV3;

import ru.GoldTaxiV3.Entities.Car;
import ru.GoldTaxiV3.Entities.MyList;
import ru.GoldTaxiV3.Entities.Order;
import ru.GoldTaxiV3.Utilities.*;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Scala on 13.11.2016.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Car orderCar;
        new MyThread();
        Initialization initialization = Initialization.getInstance();
        MyList<Car> carMyList = initialization.initCarArray();
        LinkedList<Order> queueOrderList = initialization.initQueueOrderList();
        LinkedList<Order> orderList = initialization.initOrderList();
        while (true) {
            Date courentDate = new Date();
            for (Order anOrderList : orderList) {
                if (anOrderList.getOrderDate().before(courentDate)) {
                    orderCar = anOrderList.getCar();
                    orderCar.setCarStatus(Car.getTypeOfStatusFree());
                }
            }
            for (int i = 0; i < queueOrderList.size(); i++) {
                queueOrderList.get(i).getCar();
            }
            Order order = OrderReader.getInstance().orderRead();
            Object reservedCar = CarSearch.getInstance().searchFreeCar(carMyList, order);
            if (reservedCar != null){
                orderList.add(order);
                System.out.println(MyResourseBundle.getBundle().getString("appointed") + ": "+ reservedCar);
            } else {
                queueOrderList.add(order);
                System.out.println(MyResourseBundle.getBundle().getString("waitCar"));
               // System.out.println(queueOrderList);
            }
        }
    }


}
