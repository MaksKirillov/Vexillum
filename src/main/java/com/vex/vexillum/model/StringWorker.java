package com.vex.vexillum.model;

import java.util.Objects;

import static com.vex.vexillum.model.Data.*;

public class StringWorker {

    //Для работы со String[]

    public static boolean contains(String[] countriesList) {
        boolean result = false;
        for (String country : countriesList) {
            if (Objects.equals(countries[chosenCountry], country)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static int increment(String countrie, String[] countriesList) {
        int result = 0;
        for (int i = 0; i < countriesList.length; i++) {
            if (Objects.equals(countriesList[i], countrie)) {
                result = i;
                break;
            }
        }
        return result;
    }

}
