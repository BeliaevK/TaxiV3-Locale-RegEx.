package ru.GoldTaxiV3.Utilities;

import ru.GoldTaxiV3.Entities.Order;

/**
 * Created by Scala on 18.12.2016.
 */
public class MyThread implements Runnable {
    Thread thread;

    public MyThread(){
        thread = new Thread();
/*        for (int i = 0; i < Order.o; i++) {
            
        }
        if ()*/
    }
    @Override
    public void run() {
        if (thread != null) {
            thread.run();
        }
    }
}
