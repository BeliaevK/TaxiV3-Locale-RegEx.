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
        ThreadForFreeCar threadForFreeCar =  new ThreadForFreeCar(orderList);
        threadForFreeCar.start();
        while (true) {
            ReleaseAndReserveCarFromQueue.ReserveCarFromQueue(orderList,queueOrderList,carMyList);
            Order order = OrderReader.getInstance().orderRead();
            Car reservedCar = CarSearch.getInstance().searchFreeCar(carMyList, order);
            if (reservedCar != null){
                orderList.add(order);
                System.out.println(MyResourseBundle.getBundle().getString("appointed") + ": "+ reservedCar);
               // System.out.println(queueOrderList.size());
            } else {
                ThreadForCheckCar threadForCheckCar =  new ThreadForCheckCar(carMyList,order);
                threadForCheckCar.start();
/*                queueOrderList.add(order);*/
                System.out.println(MyResourseBundle.getBundle().getString("waitCar"));
               // System.out.println(queueOrderList.size());
            }
        }
    }


}
