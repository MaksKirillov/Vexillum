package com.vex.vexillum.util;

import com.vex.vexillum.model.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StringWorkerTest {

    @Test
    public void contains() {
        Data.getInstance();
        StringWorker.getInstance();
        String[] list = new String[]{"abc", "abcd", "abcde"};
        Assertions.assertTrue(StringWorker.contains("abcde", list));
        Assertions.assertFalse(StringWorker.contains("ab", list));

        Data.chosenCountry = 28; //Ирак
        Assertions.assertTrue(StringWorker.contains(Data.countriesAfricaMiddleEast));
        Data.chosenCountry = 0; //Албания
        Assertions.assertTrue(StringWorker.contains(Data.countriesEurope));
        Data.chosenCountry = 14; //Китай
        Assertions.assertTrue(StringWorker.contains(Data.countriesAsiaOceania));
        Data.chosenCountry = 15; //Колумбия
        Assertions.assertTrue(StringWorker.contains(Data.countriesAmericas));
    }

    @Test
    public void increment() {
        String[] list = new String[]{"abc", "abcd", "abcde"};
        Assertions.assertEquals(1, StringWorker.increment("abcd", list));
    }

}
