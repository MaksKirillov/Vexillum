package com.vex.vexillum.model;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Reader {

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
        FileReader reader = new FileReader(path, StandardCharsets.UTF_8);
        Scanner scan = new Scanner(reader);
        StringBuilder builder = new StringBuilder();
        while (scan.hasNextLine()) {
            builder.append(scan.nextLine());
            builder.append("\n");
        }
        reader.close();
        return builder.toString();
    }

    static int oneIntReader(String path) throws IOException {
        FileReader reader = new FileReader(path, StandardCharsets.UTF_8);
        Scanner scan = new Scanner(reader);
        int result = scan.nextInt();
        reader.close();
        return result;
    }

}
