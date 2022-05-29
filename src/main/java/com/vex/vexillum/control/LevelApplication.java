package com.vex.vexillum.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.vex.vexillum.model.Data.*;

public class LevelApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LevelApplication.class.getResource("/com/vex/vexillum/view/level-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), windowWidth, windowHeight);
        switch (levelFlag) {
            case 1 -> stage.setTitle("Флаги (" + currentUser + ")");
            case 2 -> stage.setTitle("Факты (" + currentUser + ")");
            default -> stage.setTitle("Карты (" + currentUser + ")");
        }
        stage.setScene(scene);
        stage.show();
    }

}
