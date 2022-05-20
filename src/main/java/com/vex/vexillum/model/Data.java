package com.vex.vexillum.model;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

public class Data {

    public static int levelFlag; // 1 - flags, 2 - facts, 3 - maps

    public static int backFlag; // 1 - menu, 2 - win/lose screen

    public static int continentFlag; // 1 - Africa and Middle East, 2 - Americas, 3 - Asia and Oceania, 4 - Europe

    public static int winningButton;

    public static int chosenCountry;

    public static boolean completeFlag = false;

    public static boolean completeFact = false;

    public static boolean completeMap = false;

    public static boolean answerFlag; // true - right, false - wrong

    public static boolean oneTimeFlag = false;

    public static final int levelCount = 65;

    public static double windowHeight = 700;

    public static double windowWidth = 800;

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

    //Читалки

    public static String[] lineReader(String path) throws IOException {
        return reader(path).trim().split("\n");
    }

    public static String[] factReader(String path) throws IOException {
        String[] result = reader(path).trim().split("EOF");
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i].trim();
        }
        return result;
    }

    private static String reader(String path) throws IOException {
        FileReader reader= new FileReader(path, StandardCharsets.UTF_8);
        Scanner scan = new Scanner(reader);
        StringBuilder builder = new StringBuilder();
        while (scan.hasNextLine()) {
            builder.append(scan.nextLine());
            builder.append("\n");
        }
        reader.close();
        return builder.toString();
    }

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
