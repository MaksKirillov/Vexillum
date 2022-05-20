package com.vex.vexillum.model;

import java.util.Objects;

import static com.vex.vexillum.model.Data.*;

public class StringWorker {

    //Для работы со String[]

    public static boolean contains(String lookingFor, String[] list) {
        boolean result = false;
        for (String item : list) {
            if (item.equals(lookingFor)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean contains(String[] countriesList) {
        boolean result = false;
        for (String country : countriesList) {
            if (countries[chosenCountry].equals(country)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static int increment(String country, String[] countriesList) {
        int result = 0;
        for (int i = 0; i < countriesList.length; i++) {
            if (countriesList[i].equals(country)) {
                result = i;
                break;
            }
        }
        return result;
    }

}
