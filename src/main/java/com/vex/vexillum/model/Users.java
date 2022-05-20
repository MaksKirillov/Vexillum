package com.vex.vexillum.model;

import java.io.FileWriter;
import java.io.IOException;

import static com.vex.vexillum.model.Reader.lineReader;

public class Users {

    public static String[] users;

    static {
        try {
            users = lineReader("src\\main\\resources\\com\\vex\\vexillum\\file\\users.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void resetUsers() {
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
        boolean append = !noUsers();
        try (FileWriter writer = new FileWriter("src\\main\\resources\\com\\vex\\vexillum\\file\\users.txt", append)) {
            writer.write(user + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteAllUsers() {
        try (FileWriter writer = new FileWriter("src\\main\\resources\\com\\vex\\vexillum\\file\\users.txt", false)) {
            writer.write("NoUsers");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
