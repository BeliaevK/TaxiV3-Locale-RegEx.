package ru.GoldTaxiV3.Utilities;

import ru.GoldTaxiV3.Entities.Car;
import ru.GoldTaxiV3.Entities.MyList;
import ru.GoldTaxiV3.Entities.Order;

import java.util.LinkedList;

/**
 * Created by Scala on 18.12.2016.
 */
public class ThreadForFreeCar extends Thread /*implements Runnable */{
    private Thread thread;
    private LinkedList<Order> orderList;
    private LinkedList<Order> queueOrderList;
    private MyList<Car> carMyList;

    public ThreadForFreeCar(LinkedList<Order> orderList, LinkedList<Order> queueOrderList, MyList<Car> carMyList){
        this.orderList = orderList;
        this.queueOrderList = queueOrderList;
        this.carMyList = carMyList;
        thread = new Thread();
    }

    @Override
    public void run() {
        if (thread != null) {
            thread.run();
        }
        while (true){
            try {
               // System.out.println("Проход освобождения");
                ReleaseAndReserveCarFromQueue.ReleaseCarFromWork(orderList);
                ReleaseAndReserveCarFromQueue.ReserveCarFromQueue(orderList,queueOrderList,carMyList);
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
}
