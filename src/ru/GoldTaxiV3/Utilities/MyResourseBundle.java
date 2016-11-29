package ru.GoldTaxiV3.Utilities;

import java.util.ResourceBundle;

/**
 * Created by k.beliaev on 24.11.2016.
 */
public class MyResourseBundle {

    public static ResourceBundle getBundle(){
        return ResourceBundle.getBundle("Bundle", MyLocale.l);
    }
}

