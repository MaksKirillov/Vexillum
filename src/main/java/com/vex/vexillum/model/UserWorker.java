package com.vex.vexillum.model;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.vex.vexillum.util.Reader.lineReader;
import static com.vex.vexillum.util.Stats.addNewUserInfo;

public class UserWorker {

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
            users = lineReader("src\\main\\resources\\com\\vex\\vexillum\\file\\users.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateUsers() {
        try {
            users = lineReader("src\\main\\resources\\com\\vex\\vexillum\\file\\users.txt");
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
        try (FileWriter writer = new FileWriter("src\\main\\resources\\com\\vex\\vexillum\\file\\users.txt", StandardCharsets.UTF_8, append)) {
            writer.write(user + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        updateUserCount();
    }

    public static void deleteAllUsers() {
        deleter("src\\main\\resources\\com\\vex\\vexillum\\file\\users.txt", "NoUsers");
        deleter("src\\main\\resources\\com\\vex\\vexillum\\file\\stats.txt", "");
        deleter("src\\main\\resources\\com\\vex\\vexillum\\file\\flagStats.txt", "");
        deleter("src\\main\\resources\\com\\vex\\vexillum\\file\\factStats.txt", "");
        deleter("src\\main\\resources\\com\\vex\\vexillum\\file\\mapStats.txt", "");
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
