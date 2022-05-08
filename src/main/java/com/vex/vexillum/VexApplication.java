package com.vex.vexillum;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class VexApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VexApplication.class.getResource("vex-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 700);
        primaryStage.setTitle("Карт-Опрос");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (Model.getAllFlags() == Model.levelCount) Model.completeFlag = true;
        if (Model.getAllFacts() == Model.levelCount) Model.completeFact = true;
        if (Model.getAllMaps() == Model.levelCount) Model.completeMap = true;
        launch();
    }

}