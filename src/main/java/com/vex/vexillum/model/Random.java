package com.vex.vexillum.model;

import static com.vex.vexillum.model.Stats.*;
import static com.vex.vexillum.model.Data.*;

public class Random {

    //Рандомайзер

    public static int randomizer(int min, int max) {
        java.util.Random random = new java.util.Random();
        return random.nextInt(max - min + 1) + min;
    }

    //Рандомайзер уровней

    public static int levelRandomizer() {
        int i = randomizer(0, levelCount - 1);
        int[] levels = switch (levelFlag) {
            case 1 -> flagStats;
            case 2 -> factStats;
            default -> mapStats;
        };
        if (levels[i] == 1) {
            for (int l = i; l < levelCount; l++) {
                if (levels[l] == 0) {
                    i = l;
                    break;
                }
            }
            for (int l = i; l > 0; l--) {
                if (levels[l] == 0) {
                    i = l;
                    break;
                }
            }
        }
        return i;
    }

    //Рандомайзер кнопок

    public static int[] buttonsRandomizer() {
        String[] countriesList;
        int[] nums;
        switch (continentFlag) {
            case 1 -> {
                nums = new int[countriesAfricaMiddleEast.length];
                countriesList = countriesAfricaMiddleEast;
            }
            case 2 -> {
                nums = new int[countriesAmericas.length];
                countriesList = countriesAmericas;
            }
            case 3 -> {
                nums = new int[countriesAsiaOceania.length];
                countriesList = countriesAsiaOceania;
            }
            default -> {
                nums = new int[countriesEurope.length];
                countriesList = countriesEurope;
            }
        }
        int i = increment(countries[chosenCountry], countriesList);
        nums[i] = 1;
        for (int l = 0; l < nums.length - 5; l++) {
            int randomNum = randomizer(0, nums.length - 1);
            nums[randomNum] = 1;
        }
        int[] buttons = new int[3];
        buttons[0] = buttonRandomizer(i, nums);
        nums[buttons[0]] = 1;
        buttons[1] = buttonRandomizer(i, nums);
        nums[buttons[1]] = 1;
        buttons[2] = buttonRandomizer(i, nums);

        buttons[0] = increment(countriesList[buttons[0]], countries);
        buttons[1] = increment(countriesList[buttons[1]], countries);
        buttons[2] = increment(countriesList[buttons[2]], countries);

        return buttons;
    }

    private static int buttonRandomizer(int i, int[] nums) {
        int button = 0;
        for (int l = i; l < nums.length; l++) {
            if (nums[l] == 0) {
                button = l;
                break;
            }
        }
        if (button == 0) {
            for (int l = i; l > 0; l--) {
                if (nums[l] == 0) {
                    button = l;
                    break;
                }
            }
        }
        return button;
    }

}
