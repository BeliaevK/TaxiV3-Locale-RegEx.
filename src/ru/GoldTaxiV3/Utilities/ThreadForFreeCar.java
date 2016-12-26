package ru.GoldTaxiV3.Utilities;

import ru.GoldTaxiV3.Entities.Order;

import java.util.LinkedList;

/**
 * Created by Scala on 18.12.2016.
 */
public class ThreadForFreeCar extends Thread /*implements Runnable */{
    private Thread thread;
    private LinkedList<Order> orderList;

    public ThreadForFreeCar(LinkedList<Order> orderList){
        this.orderList = orderList;
        thread = new Thread();
    }

    @Override
    public void run() {
        if (thread != null) {
            thread.run();
        }
        while (true){
            try {
                ReleaseAndReserveCarFromQueue.ReleaseCarFromWork(orderList);
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
