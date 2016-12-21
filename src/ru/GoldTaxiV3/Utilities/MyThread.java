package ru.GoldTaxiV3.Utilities;

/**
 * Created by Scala on 18.12.2016.
 */
public class MyThread implements Runnable {
    Thread thread;

    public MyThread(){
        thread = new Thread();

    }
    @Override
    public void run() {
        if (thread != null) {
            thread.run();
        }
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
