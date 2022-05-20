package com.vex.vexillum.menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.vex.vexillum.model.Data.*;
import static com.vex.vexillum.model.Stats.*;

public class MenuApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), windowWidth, windowHeight);
        primaryStage.setTitle("Карт-Опрос");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void enter(String[] args) throws FileNotFoundException {
        if (getAllFlags() == levelCount) completeFlag = true;
        if (getAllFacts() == levelCount) completeFact = true;
        if (getAllMaps() == levelCount) completeMap = true;
        launch();
    }

}