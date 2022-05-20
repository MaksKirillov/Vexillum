package com.vex.vexillum.model;

import com.vex.vexillum.begin.BeginApplication;
import com.vex.vexillum.chose.ChoseApplication;
import com.vex.vexillum.complete.CompleteApplication;
import com.vex.vexillum.level.LevelApplication;
import com.vex.vexillum.login.LoginApplication;
import com.vex.vexillum.menu.MenuApplication;
import com.vex.vexillum.stats.StatsApplication;
import com.vex.vexillum.winlose.WinLoseApplication;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.vex.vexillum.model.Data.*;
import static com.vex.vexillum.model.Stats.*;
import static com.vex.vexillum.model.Users.currentUserInt;


public class Buttons {

    //Кнопки

    public static void backButton(Button backButton) throws IOException {
        switch (backFlag) {
            case 1 -> menuButton(backButton);
            case 2 -> winLoseButton(backButton);
            case 3 -> beginButton(backButton);
            default -> statsButton(backButton);
        }
    }

    public static void beginButton(Button beginButton) throws IOException {
        Stage stage = (Stage) beginButton.getScene().getWindow();
        windowHeight = beginButton.getScene().getHeight();
        windowWidth = beginButton.getScene().getWidth();
        BeginApplication app = new BeginApplication();
        app.start(stage);
    }

    public static void winLoseButton(Button button) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        windowHeight = button.getScene().getHeight();
        windowWidth = button.getScene().getWidth();
        WinLoseApplication app = new WinLoseApplication();
        app.start(stage);
    }

    public static void levelButton(Button levelButton) throws IOException {
        if (getCompleted() == levelCount) {
            completeButton(levelButton);
        } else {
            Stage stage = (Stage) levelButton.getScene().getWindow();
            windowHeight = levelButton.getScene().getHeight();
            windowWidth = levelButton.getScene().getWidth();
            LevelApplication app = new LevelApplication();
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
        int num = stats[currentUserInt][i];
        changeNum(num + 1, i);
        if (getCompleted() == levelCount) {
            completeButton(button);
        } else {
            Stage stage = (Stage) button.getScene().getWindow();
            windowHeight = button.getScene().getHeight();
            windowWidth = button.getScene().getWidth();
            WinLoseApplication app = new WinLoseApplication();
            app.start(stage);
        }
    }

    public static void completeButton(Button completeButton) throws IOException {
        Stage stage = (Stage) completeButton.getScene().getWindow();
        windowHeight = completeButton.getScene().getHeight();
        windowWidth = completeButton.getScene().getWidth();
        CompleteApplication app = new CompleteApplication();
        app.start(stage);
    }

    public static void loadGameButton(Button button) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        windowHeight = button.getScene().getHeight();
        windowWidth = button.getScene().getWidth();
        ChoseApplication app = new ChoseApplication();
        app.start(stage);
    }

    public static void newGameButton(Button button) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        windowHeight = button.getScene().getHeight();
        windowWidth = button.getScene().getWidth();
        LoginApplication app = new LoginApplication();
        app.start(stage);
    }

    public static void menuButton(Button menuButton) throws IOException {
        Stage stage = (Stage) menuButton.getScene().getWindow();
        windowHeight = menuButton.getScene().getHeight();
        windowWidth = menuButton.getScene().getWidth();
        MenuApplication app = new MenuApplication();
        app.start(stage);
    }

    private static int getCompleted() throws FileNotFoundException {
        return switch (levelFlag) {
            case 1 -> getAllFlags();
            case 2 -> getAllFacts();
            default -> getAllMaps();
        };
    }

}
