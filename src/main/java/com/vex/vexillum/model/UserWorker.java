package com.vex.vexillum.model;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.vex.vexillum.util.Reader.lineReader;
import static com.vex.vexillum.util.Stats.addNewUserInfo;

public class UserWorker {

    private static final String pathStart = "src\\main\\resources\\com\\vex\\vexillum\\file\\";

    public static int userCount;

    public static int currentUserInt;

    public static void updateUserCount() {
        updateUsers();
        if (noUsers()) {
            userCount = 0;
        } else {
            userCount = users.length;
        }
    }

    public static String[] users;

    static {
        try {
            users = lineReader(pathStart + "users.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateUsers() {
        try {
            users = lineReader(pathStart + "users.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean noUsers() {
        return users.length == 1 && users[0].equals("NoUsers");
    }

    public static void addUser(String user) {
        addNewUserInfo();
        boolean append = !noUsers();
        try (FileWriter writer = new FileWriter(pathStart + "users.txt", StandardCharsets.UTF_8, append)) {
            writer.write(user + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        updateUserCount();
        currentUserInt = userCount - 1;
    }

    public static void deleteAllUsers() {
        deleter(pathStart + "users.txt", "NoUsers");
        deleter(pathStart + "stats.txt", "");
        deleter(pathStart + "flagStats.txt", "");
        deleter(pathStart + "factStats.txt", "");
        deleter(pathStart + "mapStats.txt", "");
        updateUserCount();
    }

    private static void deleter(String path, String change) {
        try (FileWriter writer = new FileWriter(path, StandardCharsets.UTF_8, false)) {
            writer.write(change);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
