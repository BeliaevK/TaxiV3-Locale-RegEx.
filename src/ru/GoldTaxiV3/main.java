package ru.GoldTaxiV3;

import ru.GoldTaxiV3.Entities.Car;
import ru.GoldTaxiV3.Entities.MyList;
import ru.GoldTaxiV3.Entities.Order;
import ru.GoldTaxiV3.Utilities.*;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Scala on 13.11.2016.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Initialization initialization = Initialization.getInstance();
        MyList<Car> carMyList = initialization.initCarArray();
        LinkedList<Order> queueOrderList = initialization.initQueueOrderList();
        LinkedList<Order> orderList = initialization.initOrderList();
        for (int i = 0; i < 20; i++) {
            Order fakeOrder = initialization.initOrder(i,i);
            Car reservedCar = CarSearch.getInstance().searchFreeCar(carMyList, fakeOrder,queueOrderList);
            CarSearch.reservedCar(reservedCar,fakeOrder,carMyList,orderList);
        }
        ThreadForFreeCar threadForFreeCar =  new ThreadForFreeCar(orderList,queueOrderList,carMyList);
        threadForFreeCar.start();
        while (true) {
            Order order = OrderReader.getInstance().orderRead();
            Car reservedCar = CarSearch.getInstance().searchFreeCar(carMyList, order,queueOrderList);
            CarSearch.reservedCar(reservedCar,order,carMyList,orderList);
        }
    }


}
