package ru.GoldTaxiV3.Utilities;

import ru.GoldTaxiV3.Entities.Car;
import ru.GoldTaxiV3.Entities.MyList;
import ru.GoldTaxiV3.Entities.Order;
import ru.GoldTaxiV3.Utilities.Enums.TypeOfStatus;

/**
 * Created by k.beliaev on 26.12.2016.
 */
public class ThreadForCheckCar extends Thread {
    private Thread thread;
    private Order order;
    private MyList carMyList;
    private Car orderCar;

    public ThreadForCheckCar(MyList<Car> carMyList,Order order){
        this.carMyList = carMyList;
        this.order = order;
        thread = new Thread();
    }

    @Override
    public void run() {

        if (thread != null) {
            thread.run();
        }
            try {
                for (int i = 0; i < 60; i++) {
                    if (order.getCar() != null) {
                        thread.interrupt();
                    } else {
                        System.out.println("Проход:" + i);
                        for (int j = 0; j < carMyList.size(); j++) {
                            if (CarSearch.compareOrderToCar((Car) carMyList.get(j), order)) {
                                orderCar = (Car) carMyList.get(j);
                                orderCar.setCarStatus(TypeOfStatus.RESERVED.getTypeOfStatus());
                                order.setCar(orderCar);
                                order.setOrderDate(OrderDate.getDate());
                                System.out.println("***" + MyResourseBundle.getBundle().getString("appointedfromqueue") + ": " + orderCar + "***");
                                break;
                            }
                            Thread.sleep(100);
                        }
                    }
                }
                if (order.getCar() == null) {
                    System.out.println(MyResourseBundle.getBundle().getString("orderTimeOut") + ": " + order);
                }
            } catch (InterruptedException e) {}
    }
}


