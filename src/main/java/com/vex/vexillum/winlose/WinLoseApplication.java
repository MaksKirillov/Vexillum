package com.vex.vexillum.winlose;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.vex.vexillum.model.Model.*;

public class WinLoseApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        backFlag = 1;
        FXMLLoader fxmlLoader = new FXMLLoader(WinLoseApplication.class.getResource("winlose-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 700);
        if (answerFlag) {
            stage.setTitle("Правильно");
        } else {
            stage.setTitle("Неправильно");
        }
        stage.setScene(scene);
        stage.show();
    }
}
