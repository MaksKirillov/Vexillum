package com.vex.vexillum.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.vex.vexillum.model.Data.levelCount;

public class Stats {

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
        File file = new File("src\\main\\resources\\com\\vex\\vexillum\\file\\stats.txt");
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
        try (FileWriter writer = new FileWriter("src\\main\\resources\\com\\vex\\vexillum\\file\\stats.txt", false)) {
            for (int l = 0; l < 6; l++) {
                String number = Integer.toString(nums[l]);
                writer.write(number + " ");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        stats = nums;
    }

    //Всё что связано с fac flag map stats

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
        int[] nums = new int[levelCount];
        String path;
        switch (levelFlag) {
            case 1 -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\flagStats.txt";
            case 2 -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\factStats.txt";
            default -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\mapStats.txt";
        }
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < levelCount; i++) {
            nums[i] = scanner.nextInt();
        }
        return nums;
    }

    public static void changeLevelStat(int num, int i, int levelFlag) throws FileNotFoundException {
        int[] nums = getLevelStats(levelFlag);
        nums[i] = num;
        String path;
        switch (levelFlag) {
            case 1 -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\flagStats.txt";
            case 2 -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\factStats.txt";
            default -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\mapStats.txt";
        }
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int l = 0; l < levelCount; l++) {
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
            case 1 -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\flagStats.txt";
            case 2 -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\factStats.txt";
            default -> path = "src\\main\\resources\\com\\vex\\vexillum\\file\\mapStats.txt";
        }
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int l = 0; l < levelCount; l++) {
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

}
