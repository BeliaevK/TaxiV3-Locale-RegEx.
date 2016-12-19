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
        Car freeCar;
        new MyThread();
        Date courentDate = new Date();
        Initialization initialization = Initialization.getInstance();
        MyList<Car> carMyList = initialization.initCarArray();
        LinkedList<Order> queueOrderList = initialization.initQueueOrderList();
        LinkedList<Order> orderList = initialization.initOrderList();
        while (true) {
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getOrderDate().after(courentDate)){
                    freeCar = queueOrderList.get(i);
                    /*Нужно добавить инфу о машине в заказ*/
                }
            }
            Order order = OrderReader.getInstance().orderRead();
            Object reservedCar = CarSearch.getInstance().searchFreeCar(carMyList, order);
            if (reservedCar != null){
                orderList.add(order);
                System.out.println(MyResourseBundle.getBundle().getString("appointed") + ": "+ reservedCar);
            } else {
                queueOrderList.add(order);
                System.out.println(MyResourseBundle.getBundle().getString("waitCar"));
                System.out.println(queueOrderList);
            }
        }
    }


}
