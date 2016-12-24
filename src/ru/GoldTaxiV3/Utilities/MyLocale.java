package ru.GoldTaxiV3.Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by k.beliaev on 24.11.2016.
 */
public class MyLocale {

    public static Locale getLocale() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Locale locale = null;
        boolean isCorrectLocale = false;
        while (!isCorrectLocale) {
            System.out.println("Select your language: 'en' or 'ru'");
        String s = reader.readLine();
            if (!checkIsCorrectLocale(s)) {
                switch (s) {
                    case "ru":
                        locale = new Locale("ru", "Ru");
                        break;
                    case "en":
                        locale = new Locale("en", "Us");
                        break;
                }
            }
                if (locale != null) isCorrectLocale = true;
        }
        return locale;
    }

    public static Locale l;

    static {
        try {
            l = getLocale();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkIsCorrectLocale(String s) {
        boolean isCorrectLocale = true;
        if (s.equals("ru") || s.equals("en")) isCorrectLocale = false;
        return isCorrectLocale;
    }
    }

