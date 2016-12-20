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
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getOrderDate().before(courentDate)) {
                    orderCar = orderList.get(i).getCar();
                    orderCar.setCarStatus(Car.getTypeOfStatusFree());
                    System.out.println("тачка освобожденв");
                    orderList.remove(i);
                    /*Проблема в том, что когда заказы полежат в очереди, то их время уже пройдет, и они занимают тачки лишь до сл. цикла,
         * поидее нужно написать так, что бы дата ставилась в момент занятия заявкой машины, а не в момент создания заявки */
                }
            }

            for (int i = 0; i < queueOrderList.size(); i++) {
                for (int j = 0; j < carMyList.size(); j++) {
                    try {
                        if (CarSearch.compareOrderToCar(carMyList.get(j),queueOrderList.get(i))) {
                            orderCar = carMyList.get(j);
                            orderCar.setCarStatus(Car.getTypeOfStatusReserved());
                            queueOrderList.get(i).setCar(orderCar);
                            orderList.add(queueOrderList.get(i));
                            System.out.println(MyResourseBundle.getBundle().getString("appointedfromqueue") + ": "+ orderCar);
                            System.out.println(queueOrderList.size());
                            queueOrderList.remove(i);
                        }
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Поймал");
                    }
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
               // System.out.println(queueOrderList);
            }
        }
    }


}
