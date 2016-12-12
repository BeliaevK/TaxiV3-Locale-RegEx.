package ru.GoldTaxiV3;

import ru.GoldTaxiV3.Entities.Car;
import ru.GoldTaxiV3.Entities.MyList;
import ru.GoldTaxiV3.Entities.Order;
import ru.GoldTaxiV3.Utilities.CarSearch;
import ru.GoldTaxiV3.Utilities.Initialization;
import ru.GoldTaxiV3.Utilities.MyResourseBundle;
import ru.GoldTaxiV3.Utilities.OrderReader;

import java.io.IOException;

/**
 * Created by Scala on 13.11.2016.
 */
public class main {
    public static void main(String[] args) throws IOException {
        Initialization initialization = Initialization.getInstance();
        MyList<Car> carMyList = initialization.initCarArray();
        while (true) {
            Order order = OrderReader.getInstance().orderRead();
            Object reservedCar = CarSearch.getInstance().searchFreeCar(carMyList, order);
            if (reservedCar == null){
               System.out.println(MyResourseBundle.getBundle().getString("notfoundcar"));
            } else {
            System.out.println(MyResourseBundle.getBundle().getString("appointed") + ": "+ reservedCar);
            }
        }
    }
}
