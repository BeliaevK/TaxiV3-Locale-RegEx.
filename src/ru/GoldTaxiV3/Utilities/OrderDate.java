package ru.GoldTaxiV3.Utilities;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by k.beliaev on 21.12.2016.
 */
public class OrderDate {

    public static Date getDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND ,5);
        return calendar.getTime();
    }
}
