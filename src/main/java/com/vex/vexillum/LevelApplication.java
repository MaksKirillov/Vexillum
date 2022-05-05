package com.vex.vexillum;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LevelApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VexApplication.class.getResource("level-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 700);
        switch (Model.levelFlag) {
            case 1 -> stage.setTitle("Флаги");
            case 2 -> stage.setTitle("Факты");
            default -> stage.setTitle("Карты");
        }
        stage.setScene(scene);
        stage.show();
    }
}
