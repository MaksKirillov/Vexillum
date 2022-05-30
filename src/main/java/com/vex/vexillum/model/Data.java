package com.vex.vexillum.model;

import com.vex.vexillum.util.Reader;

import java.io.IOException;

import static com.vex.vexillum.util.Reader.*;

public class Data {

    private static Data instance;

    private Data() {
        try {
            Reader.getInstance();
            String path = "src\\main\\resources\\com\\vex\\vexillum\\file\\";
            levelCount = oneIntReader(path + "totalNumberOfLevels.txt");
            countries = lineReader(path + "countries.txt");
            countriesAfricaMiddleEast = lineReader(path + "countriesAfricaMiddleEast.txt");
            countriesAmericas = lineReader(path + "countriesAmericas.txt");
            countriesAsiaOceania = lineReader(path + "countriesAsiaOceania.txt");
            countriesEurope = lineReader(path + "countriesEurope.txt");
            pathFlags = lineReader(path + "flagPath.txt");
            pathMaps = lineReader(path + "mapPath.txt");
            facts = factReader(path + "facts.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getInstance() {
        if (instance == null) {
            instance = new Data();
        }
    }

    public static int levelFlag; // 1 - flags, 2 - facts, 3 - maps

    public static int backFlag; // 1 - menu, 2 - win/lose screen, 3 - begin screen, 4 - statistics screen

    public static int continentFlag; // 1 - Africa and Middle East, 2 - Americas, 3 - Asia and Oceania, 4 - Europe

    public static int winningButton;

    public static int chosenCountry;

    public static boolean completeFlag = false;

    public static boolean completeFact = false;

    public static boolean completeMap = false;

    public static boolean answerFlag; // true - right, false - wrong

    public static boolean oneTimeFlag = false;

    public static double windowHeight = 700;

    public static double windowWidth = 800;

    public static String currentUser;

    public static int levelCount;

    public static String[] countries;

    public static String[] countriesAfricaMiddleEast;

    public static String[] countriesAmericas;

    public static String[] countriesAsiaOceania;

    public static String[] countriesEurope;

    public static String[] pathFlags;

    public static String[] pathMaps;

    public static String[] facts;

}
