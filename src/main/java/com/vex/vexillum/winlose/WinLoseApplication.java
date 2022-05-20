package com.vex.vexillum.winlose;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.vex.vexillum.model.Data.*;

public class WinLoseApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        backFlag = 1;
        FXMLLoader fxmlLoader = new FXMLLoader(WinLoseApplication.class.getResource("winlose-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), windowWidth, windowHeight);
        if (answerFlag) {
            stage.setTitle("Правильно, " + currentUser);
        } else {
            stage.setTitle("Неправильно, " + currentUser);
        }
        stage.setScene(scene);
        stage.show();
    }
}
