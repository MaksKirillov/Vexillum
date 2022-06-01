package com.vex.vexillum.util;

import com.vex.vexillum.model.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.vex.vexillum.model.Data.levelCount;
import static com.vex.vexillum.model.UserWorker.*;

public class Stats {

    private static Stats instance;

    private Stats() {
        try {
            Data.getInstance();
            updateUserCount();
            if (userCount == 0) {
                flagStats = new int[levelCount];
                factStats = new int[levelCount];
                mapStats = new int[levelCount];
            } else {
                flagStats = getLevelStats(1)[currentUserInt];
                factStats = getLevelStats(2)[currentUserInt];
                mapStats = getLevelStats(3)[currentUserInt];
            }
            stats = getStats();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getInstance() {
        if (instance == null) {
            instance = new Stats();
        }
    }

    public static void updateStats() {
        instance = new Stats();
    }

    private static final String pathStart = "src\\main\\resources\\com\\vex\\vexillum\\file\\";

    //Всё что связано с stats.txt

    public static int[][] stats; // right flags, wrong flags, right facts, wrong facts, right maps, wrong maps

    public static int[][] getStats() throws FileNotFoundException {
        updateUserCount();
        int[][] nums = new int[userCount][6];
        File file = new File(pathStart + "stats.txt");
        Scanner scanner = new Scanner(file);
        for (int j = 0; j < userCount; j++) {
            for (int i = 0; i < 6; i++) {
                nums[j][i] = scanner.nextInt();
            }
        }
        return nums;
    }

    public static int getRightFlags() throws FileNotFoundException {
        return getStats()[currentUserInt][0];
    }

    public static int getWrongFlags() throws FileNotFoundException {
        return getStats()[currentUserInt][1];
    }

    public static int getAllFlags() throws FileNotFoundException {
        return getRightFlags() + getWrongFlags();
    }

    public static int getRightFacts() throws FileNotFoundException {
        return getStats()[currentUserInt][2];
    }

    public static int getWrongFacts() throws FileNotFoundException {
        return getStats()[currentUserInt][3];
    }

    public static int getAllFacts() throws FileNotFoundException {
        return getRightFacts() + getWrongFacts();
    }

    public static int getRightMaps() throws FileNotFoundException {
        return getStats()[currentUserInt][4];
    }

    public static int getWrongMaps() throws FileNotFoundException {
        return getStats()[currentUserInt][5];
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
        int[][] nums = stats;
        nums[currentUserInt][i] = num;
        try (FileWriter writer = new FileWriter(pathStart + "stats.txt", false)) {
            for (int j = 0; j < userCount; j++) {
                for (int l = 0; l < 6; l++) {
                    String number = Integer.toString(nums[j][l]);
                    writer.write(number + " ");
                }
                writer.write("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        stats = nums;
    }

    //Всё что связано с fac flag map stats

    public static int[] flagStats;

    public static int[] factStats;

    public static int[] mapStats;

    public static int[][] getLevelStats(int levelFlag) throws FileNotFoundException {
        int[][] nums = new int[userCount][levelCount];
        String path;
        switch (levelFlag) {
            case 1 -> path = pathStart + "flagStats.txt";
            case 2 -> path = pathStart + "factStats.txt";
            default -> path = pathStart + "mapStats.txt";
        }
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        for (int j = 0; j < userCount; j++) {
            for (int i = 0; i < levelCount; i++) {
                nums[j][i] = scanner.nextInt();
            }
        }
        return nums;
    }

    public static void changeLevelStat(int num, int i, int levelFlag) throws FileNotFoundException {
        int[][] nums = getLevelStats(levelFlag);
        nums[currentUserInt][i] = num;
        writer(levelFlag, nums);
    }

    public static void resetLevel(int levelFlag) throws FileNotFoundException {
        int[][] nums = getLevelStats(levelFlag);
        for (int i = 0; i < levelCount; i++) {
            nums[currentUserInt][i] = 0;
        }
        writer(levelFlag, nums);
    }

    private static void writer(int levelFlag, int[][] nums) {
        String path;
        switch (levelFlag) {
            case 1 -> path = pathStart + "flagStats.txt";
            case 2 -> path = pathStart + "factStats.txt";
            default -> path = pathStart + "mapStats.txt";
        }
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int j = 0; j < userCount; j++) {
                for (int l = 0; l < levelCount; l++) {
                    String number = Integer.toString(nums[j][l]);
                    writer.write(number + " ");
                }
                writer.write("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        switch (levelFlag) {
            case 1 -> flagStats = nums[currentUserInt];
            case 2 -> factStats = nums[currentUserInt];
            default -> mapStats = nums[currentUserInt];
        }
    }

    public static void addNewUserInfo() {
        addNewLevels(pathStart + "flagStats.txt");
        addNewLevels(pathStart + "factStats.txt");
        addNewLevels(pathStart + "mapStats.txt");
        addNewStats();
    }

    private static void addNewLevels(String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            for (int l = 0; l < levelCount; l++) {
                writer.write(0 + " ");
            }
            writer.write("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static void addNewStats() {
        try (FileWriter writer = new FileWriter(pathStart + "stats.txt", true)) {
            for (int l = 0; l < 6; l++) {
                writer.write(0 + " ");
            }
            writer.write("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
