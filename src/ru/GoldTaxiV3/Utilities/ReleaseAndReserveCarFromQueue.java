package ru.GoldTaxiV3.Utilities;

import ru.GoldTaxiV3.Entities.Car;
import ru.GoldTaxiV3.Entities.MyList;
import ru.GoldTaxiV3.Entities.Order;
import ru.GoldTaxiV3.Utilities.Enums.TypeOfStatus;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by k.beliaev on 21.12.2016.
 */
public class ReleaseAndReserveCarFromQueue {
    static Car orderCar;

        public static void ReleaseCarFromWork(LinkedList<Order> orderList) {
            Date courentDate = new Date();
/*            if(orderList.size() == 0){
                System.out.println("Нет занятых машин");
            }*/
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getOrderDate().before(courentDate)) {
                    orderCar = orderList.get(i).getCar();
                    orderCar.setCarStatus(TypeOfStatus.FREE.getTypeOfStatus());
                    System.out.println("***" + MyResourseBundle.getBundle().getString("free") + ": " + orderCar + "***");
                    orderList.remove(i);
                }
            }
        }

    public static void ReserveCarFromQueue(LinkedList<Order> orderList, LinkedList<Order> queueOrderList,  MyList<Car> carMyList) {
        for (int i = 0; i < queueOrderList.size(); i++) {
            if (queueOrderList.get(i).getStartPoint() == null){
                queueOrderList.remove(i);
            }else
            for (int j = 0; j < carMyList.size(); j++) {
                    if (CarSearch.compareOrderToCar(carMyList.get(j), queueOrderList.get(i))) {
                        orderCar = carMyList.get(j);
                        orderCar.setCarStatus(TypeOfStatus.RESERVED.getTypeOfStatus());
                        queueOrderList.get(i).setCar(orderCar);
                        orderList.add(queueOrderList.get(i));
                        queueOrderList.get(i).setOrderDate(OrderDate.getDate());
                        System.out.println("***" + MyResourseBundle.getBundle().getString("appointedfromqueue") + ": " + orderCar + "***");
                        queueOrderList.remove(i);
                        System.out.println("Длина очереди: " + queueOrderList.size());
                    }
            }
        }
    }
}
