package com.vex.vexillum;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Model {

    public static int levelFlag; // 1 - flags, 2 - facts, 3 - maps

    public static int backFlag; // 1 - menu, 2 - win/lose screen

    public static int winningButton;

    public static int chosenCountry;

    public static boolean answerFlag; // true - right, false - wrong

    public static final String[] countries = new String[]{
            "Бразилия",
            "Британия",
            "Китай",
            "Франция",
            "Германия",
            "Индия",
            "Япония",
            "Россия",
            "ЮАР",
            "США"
    };

    public static final String[] pathFlags = new String[]{
            "images/flags/BrazilFlagImage.png",
            "images/flags/BritainFlagImage.png",
            "images/flags/ChinaFlagImage.png",
            "images/flags/FranceFlagImage.png",
            "images/flags/GermanyFlagImage.png",
            "images/flags/IndiaFlagImage.png",
            "images/flags/JapanFlagImage.png",
            "images/flags/RussiaFlagImage.png",
            "images/flags/SARFlagImage.png",
            "images/flags/USAFlagImage.png"
    };

    public static final String[] pathMaps = new String[]{
            "images/maps/BrazilMapImage.png",
            "images/maps/BritainMapImage.png",
            "images/maps/ChinaMapImage.png",
            "images/maps/FranceMapImage.png",
            "images/maps/GermanyMapImage.png",
            "images/maps/IndiaMapImage.png",
            "images/maps/JapanMapImage.png",
            "images/maps/RussiaMapImage.png",
            "images/maps/SARMapImage.png",
            "images/maps/USAMapImage.png"
    };

    public static final String[] facts = new String[]{
            "Факт о Бразилии",
            "Факт о Британии",
            "Факт о Китае",
            "Факт о Францие",
            "Факт о Германии",
            "Факт об Индии",
            "Факт об Японии",
            "Факт о России",
            "Факт об ЮАР",
            "Факт о США"
    };

    public Model() {
    }

    //Всё что связано с stats.txt

    public static int[] stats; // right flags, wrong flags, right facts, wrong facts, right maps, wrong maps

    static {
        try {
            stats = getStats();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[] getStats() throws FileNotFoundException {
        int[] nums = new int[6];
        File file = new File("src\\main\\resources\\com\\vex\\vexillum\\stats.txt");
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < 6; i++) {
            nums[i] = scanner.nextInt();
        }
        return nums;
    }

    public static int getRightFlags() throws FileNotFoundException {
        return getStats()[0];
    }

    public static int getWrongFlags() throws FileNotFoundException {
        return getStats()[1];
    }

    public static int getAllFlags() throws FileNotFoundException {
        return getRightFlags() + getWrongFlags();
    }

    public static int getRightFacts() throws FileNotFoundException {
        return getStats()[2];
    }

    public static int getWrongFacts() throws FileNotFoundException {
        return getStats()[3];
    }

    public static int getAllFacts() throws FileNotFoundException {
        return getRightFacts() + getWrongFacts();
    }

    public static int getRightMaps() throws FileNotFoundException {
        return getStats()[4];
    }

    public static int getWrongMaps() throws FileNotFoundException {
        return getStats()[5];
    }

    public static int getAllMaps() throws FileNotFoundException {
        return getRightMaps() + getWrongMaps();
    }

    public static int getAllRights() throws FileNotFoundException {
        return getRightMaps() + getRightFlags() + getRightFacts();
    }

    public static int getAllWrongs() throws FileNotFoundException {
        return getWrongMaps() + getWrongFlags() + getWrongFacts();
    }

    public static int getAllAll() throws FileNotFoundException {
        return getAllRights() + getAllWrongs();
    }

    public static void changeNum(int num, int i) {
        int[] nums = stats;
        nums[i] = num;
        try (FileWriter writer = new FileWriter("src\\main\\resources\\com\\vex\\vexillum\\stats.txt", false)) {
            for (int l = 0; l < 6; l++) {
                String number = Integer.toString(nums[l]);
                writer.write(number + " ");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        stats = nums;
    }

    //Всё что связано с map/flag/facStats.txt

    public static int[] flagStats;

    static {
        try {
            flagStats = getLevelStats(1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[] factStats;

    static {
        try {
            factStats = getLevelStats(2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[] mapStats;

    static {
        try {
            mapStats = getLevelStats(3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[] getLevelStats(int levelFlag) throws FileNotFoundException {
        int[] nums = new int[10];
        String path;
        switch (levelFlag) {
            case 1 -> path = "src\\main\\resources\\com\\vex\\vexillum\\flagStats.txt";
            case 2 -> path = "src\\main\\resources\\com\\vex\\vexillum\\factStats.txt";
            default -> path = "src\\main\\resources\\com\\vex\\vexillum\\mapStats.txt";
        }
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < 10; i++) {
            nums[i] = scanner.nextInt();
        }
        return nums;
    }

    public static void changeLevelStat(int num, int i, int levelFlag) throws FileNotFoundException {
        int[] nums = getLevelStats(levelFlag);
        nums[i] = num;
        String path;
        switch (levelFlag) {
            case 1 -> path = "src\\main\\resources\\com\\vex\\vexillum\\flagStats.txt";
            case 2 -> path = "src\\main\\resources\\com\\vex\\vexillum\\factStats.txt";
            default -> path = "src\\main\\resources\\com\\vex\\vexillum\\mapStats.txt";
        }
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int l = 0; l < 10; l++) {
                String number = Integer.toString(nums[l]);
                writer.write(number + " ");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        switch (levelFlag) {
            case 1 -> flagStats = nums;
            case 2 -> factStats = nums;
            default -> mapStats = nums;
        }
    }

    public static void resetLevel(int levelFlag) throws FileNotFoundException {
        int[] nums = getLevelStats(levelFlag);
        String path;
        switch (levelFlag) {
            case 1 -> path = "src\\main\\resources\\com\\vex\\vexillum\\flagStats.txt";
            case 2 -> path = "src\\main\\resources\\com\\vex\\vexillum\\factStats.txt";
            default -> path = "src\\main\\resources\\com\\vex\\vexillum\\mapStats.txt";
        }
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int l = 0; l < 10; l++) {
                writer.write(0 + " ");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        switch (levelFlag) {
            case 1 -> flagStats = nums;
            case 2 -> factStats = nums;
            default -> mapStats = nums;
        }
    }

    //Кнопки

    public static void backButton(Button backButton) throws IOException {
        if (backFlag == 1) {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            VexApplication app = new VexApplication();
            app.start(stage);
        } else {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            WinLoseApplication app = new WinLoseApplication();
            app.start(stage);
        }

    }

    public static void statsButton(Button statsButton) throws IOException {
        Stage stage = (Stage) statsButton.getScene().getWindow();
        StatsApplication app = new StatsApplication();
        app.start(stage);
    }

    public static void levelButton(Button levelButton) throws IOException {
        if (getCompleted() == 10) {
            Stage stage = (Stage) levelButton.getScene().getWindow();
            CompleteApplication app = new CompleteApplication();
            app.start(stage);
        } else {
            Stage stage = (Stage) levelButton.getScene().getWindow();
            LevelApplication app = new LevelApplication();
            app.start(stage);
        }
    }

    public static void rightButton(Button rightButton) throws IOException {
        answerFlag = true;
        int i = switch (levelFlag) {
            case 1 -> 0;
            case 2 -> 2;
            default -> 4;
        };
        rightWrongButton(rightButton, i);
    }

    public static void wrongButton(Button wrongButton) throws IOException {
        answerFlag = false;
        int i = switch (levelFlag) {
            case 1 -> 1;
            case 2 -> 3;
            default -> 5;
        };
        rightWrongButton(wrongButton, i);
    }

    private static void rightWrongButton(Button button, int i) throws IOException {
        switch (levelFlag) {
            case 1 -> changeLevelStat(1, chosenCountry, 1);
            case 2 -> changeLevelStat(1, chosenCountry, 2);
            default -> changeLevelStat(1, chosenCountry, 3);
        }
        int num = Model.stats[i];
        changeNum(num + 1, i);
        if (getCompleted() == 10) {
            Stage stage = (Stage) button.getScene().getWindow();
            CompleteApplication app = new CompleteApplication();
            app.start(stage);
        } else {
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
            WinLoseApplication app = new WinLoseApplication();
            app.start(stage);
        }
    }

    private static int getCompleted() throws FileNotFoundException {
        return switch (levelFlag) {
            case 1 -> getAllFlags();
            case 2 -> getAllFacts();
            default -> getAllMaps();
        };
    }

    //Рандомайзер

    public static int randomizer(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    //Рандомайзер уровней

    public static int levelRandomizer() {
        int i = randomizer(0, 9);
        int[] levels = switch (levelFlag) {
            case 1 -> flagStats;
            case 2 -> factStats;
            default -> mapStats;
        };
        if (levels[i] == 1) {
            for (int l = i; l < 10; l++) {
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

    public static int[] buttonsRandomizer(int i) {
        int[] nums = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        nums[i] = 1;
        int[] buttons = new int[3];
        buttons[0] = buttonRandomizer(i, nums);
        nums[buttons[0]] = 1;
        buttons[1] = buttonRandomizer(i, nums);
        nums[buttons[1]] = 1;
        buttons[2] = buttonRandomizer(i, nums);
        return buttons;
    }

    private static int buttonRandomizer(int i, int[] nums) {
        int button = 0;
        for (int l = i; l < 10; l++) {
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
