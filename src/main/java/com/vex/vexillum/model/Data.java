package com.vex.vexillum.model;

import java.io.IOException;

import static com.vex.vexillum.model.Reader.*;

public class Data {

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

    static {
        try {
            levelCount = oneIntReader("src\\main\\resources\\com\\vex\\vexillum\\file\\totalNumberOfLevels.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] countries;

    static {
        try {
            countries = lineReader("src\\main\\resources\\com\\vex\\vexillum\\file\\countries.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] countriesAfricaMiddleEast;

    static {
        try {
            countriesAfricaMiddleEast = lineReader("src\\main\\resources\\com\\vex\\vexillum\\file\\countriesAfricaMiddleEast.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] countriesAmericas;

    static {
        try {
            countriesAmericas = lineReader("src\\main\\resources\\com\\vex\\vexillum\\file\\countriesAmericas.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] countriesAsiaOceania;

    static {
        try {
            countriesAsiaOceania = lineReader("src\\main\\resources\\com\\vex\\vexillum\\file\\countriesAsiaOceania.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] countriesEurope;

    static {
        try {
            countriesEurope = lineReader("src\\main\\resources\\com\\vex\\vexillum\\file\\countriesEurope.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] pathFlags;

    static {
        try {
            pathFlags = lineReader("src\\main\\resources\\com\\vex\\vexillum\\file\\flagPath.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] pathMaps;

    static {
        try {
            pathMaps = lineReader("src\\main\\resources\\com\\vex\\vexillum\\file\\mapPath.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] facts;

    static {
        try {
            facts = factReader("src\\main\\resources\\com\\vex\\vexillum\\file\\facts.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
