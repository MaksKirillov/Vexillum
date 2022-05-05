package com.vex.vexillum;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WinLoseApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Model.backFlag = 1;
        FXMLLoader fxmlLoader = new FXMLLoader(VexApplication.class.getResource("winlose-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 700);
        if (Model.answerFlag) {
            stage.setTitle("Правильно");
        } else {
            stage.setTitle("Неправильно");
        }
        stage.setScene(scene);
        stage.show();
    }
}
