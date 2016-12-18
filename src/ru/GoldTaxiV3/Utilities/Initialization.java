package ru.GoldTaxiV3.Utilities;

import ru.GoldTaxiV3.Entities.Car;
import ru.GoldTaxiV3.Entities.Driver;
import ru.GoldTaxiV3.Entities.MyList;
import ru.GoldTaxiV3.Entities.Order;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Scala on 13.11.2016.
 */
public class Initialization {

    private static Initialization instance;

    public Initialization() throws IOException {
    }

    public static Initialization getInstance() throws IOException {
        if (instance == null) {
            instance = new Initialization();
        }
        return instance;
    }

    public MyList<Car> initCarArray() throws IOException {
        Random rdm = new Random();
       // ArrayList<Driver> driverArray = new ArrayList<Driver>();
        MyList<Driver> driverMyList = new MyList<Driver>();
        for (int i = 0; i < 10; i++) {
            driverMyList.add(new Driver(MyResourseBundle.getBundle().getString("driver") + " " + (i+1), "884825050" + i));
            //driverArray.add(new Driver(MyResourseBundle.getBundle().getString("driver") + " " + (i+1), "884825050" + i));
        }
        //ArrayList<Car> carArray = new ArrayList<Car>();
        MyList<Car> carMyList  = new MyList<Car>();
        for (int i = 0; i < 10; i++) {
            carMyList.add(new Car(MyResourseBundle.getBundle().getString("car") + " " + (i+1), driverMyList.get(i), "AA " + rdm.nextInt(999) + " A 163",
                    rdm.nextBoolean(), rdm.nextBoolean(), Car.getTypeOfClassEconomic(),
                    Car.getTypeOfStatusFree()));
/*            carArray.add(new Car(MyResourseBundle.getBundle().getString("car") + " " + (i+1), driverMyList.get(i), "AA " + rdm.nextInt(999) + " A 163",
                    rdm.nextBoolean(), rdm.nextBoolean(), Car.getTypeOfClassEconomic(),
                    Car.getTypeOfStatusFree()));*/
        }
        return carMyList;
    }

    public LinkedList<Order> initQueueOrderList(){
        LinkedList<Order> queueOrderList = new LinkedList<>();
        return queueOrderList;
    }


}
