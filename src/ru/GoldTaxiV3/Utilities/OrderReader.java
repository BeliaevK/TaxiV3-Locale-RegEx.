package ru.GoldTaxiV3.Utilities;

import ru.GoldTaxiV3.Entities.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.regex.Pattern.matches;

/**
 * Created by Scala on 13.11.2016.
 */
public class OrderReader {

    private static OrderReader instance;

    public OrderReader() throws IOException {
    }


    public static OrderReader getInstance() throws IOException {
        if (instance == null) {
            instance = new OrderReader();
        }
        return instance;
    }

    public Order orderRead() throws IOException {
        System.out.println(MyResourseBundle.getBundle().getString("order"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Order order = null;
        boolean isCorrectOrder = false;
        while (!isCorrectOrder) {
            String orderText = reader.readLine();
            String[] orderField = orderText.split("\\|");
            if (checkOrderFieldsIsCorrect(orderField)) {
                try {
                    switch (orderField.length) {
                        case 2:
                            order = new Order(orderField[0], orderField[1], false, false, 0, null);
                            break;
                        case 5:
                            order = new Order(orderField[0], orderField[1], Boolean.parseBoolean(orderField[2]),
                                    Boolean.parseBoolean(orderField[3]), Integer.parseInt(orderField[4]), null);
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(MyResourseBundle.getBundle().getString("incorrect"));
                }
            }
                     else {
                            System.out.println(MyResourseBundle.getBundle().getString("incorrect"));
                        }
                        if (order != null) isCorrectOrder = true;
                    }
                    return order;
                }

    private static boolean checkOrderFieldsIsCorrect(String[] orderText) {
        boolean isCorrect = true;
        String s = "[ул.|\\d]+\\s[а-яА-Я|a-zA-Z]+[\\,\\s]+[дД|sSt]+[\\.|\\s\\d]+";
        try {
            if (orderText.length < 1 || orderText.length == 3 || orderText.length == 4) isCorrect = false;
            if (orderText[0].length() == 0 || orderText[1].length() == 0) isCorrect = false;
            if (!matches(s,orderText[0]) || !matches(s,orderText[1]))isCorrect = false;
        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            isCorrect = false;
        }
        return isCorrect;
    }
}
