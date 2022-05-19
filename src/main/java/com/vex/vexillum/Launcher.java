package com.vex.vexillum;

import com.vex.vexillum.menu.MenuApplication;

import java.io.FileNotFoundException;

public class Launcher {
    public static void main(String[] args) throws FileNotFoundException {
        MenuApplication.enter(args);
    }
}