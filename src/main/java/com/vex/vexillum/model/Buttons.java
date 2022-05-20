package com.vex.vexillum.model;

import com.vex.vexillum.complete.CompleteApplication;
import com.vex.vexillum.level.LevelApplication;
import com.vex.vexillum.menu.MenuApplication;
import com.vex.vexillum.stats.StatsApplication;
import com.vex.vexillum.winlose.WinLoseApplication;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.vex.vexillum.model.Data.*;
import static com.vex.vexillum.model.Stats.*;


public class Buttons {

    //Кнопки

    public static void backButton(Button backButton) throws IOException {
        if (backFlag == 1) {
            Stage stage = (Stage) backButton.getScene().getWindow();
            windowHeight = backButton.getScene().getHeight();
            windowWidth = backButton.getScene().getWidth();
            MenuApplication app = new MenuApplication();
            app.start(stage);
        } else {
            Stage stage = (Stage) backButton.getScene().getWindow();
            windowHeight = backButton.getScene().getHeight();
            windowWidth = backButton.getScene().getWidth();
            WinLoseApplication app = new WinLoseApplication();
            app.start(stage);
        }

    }

    public static void statsButton(Button statsButton) throws IOException {
        Stage stage = (Stage) statsButton.getScene().getWindow();
        windowHeight = statsButton.getScene().getHeight();
        windowWidth = statsButton.getScene().getWidth();
        StatsApplication app = new StatsApplication();
        app.start(stage);
    }

    public static void levelButton(Button levelButton) throws IOException {
        if (getCompleted() == levelCount) {
            Stage stage = (Stage) levelButton.getScene().getWindow();
            windowHeight = levelButton.getScene().getHeight();
            windowWidth = levelButton.getScene().getWidth();
            CompleteApplication app = new CompleteApplication();
            app.start(stage);
        } else {
            Stage stage = (Stage) levelButton.getScene().getWindow();
            windowHeight = levelButton.getScene().getHeight();
            windowWidth = levelButton.getScene().getWidth();
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
        int num = stats[i];
        changeNum(num + 1, i);
        if (getCompleted() == levelCount) {
            Stage stage = (Stage) button.getScene().getWindow();
            windowHeight = button.getScene().getHeight();
            windowWidth = button.getScene().getWidth();
            CompleteApplication app = new CompleteApplication();
            app.start(stage);
        } else {
            Stage stage = (Stage) button.getScene().getWindow();
            windowHeight = button.getScene().getHeight();
            windowWidth = button.getScene().getWidth();
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

}
