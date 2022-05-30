package com.vex.vexillum.control;

import com.vex.vexillum.model.Data;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.vex.vexillum.model.Data.windowHeight;
import static com.vex.vexillum.model.Data.windowWidth;


public class BeginApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Data.getInstance();
        FXMLLoader fxmlLoader = new FXMLLoader(BeginApplication.class.getResource("/com/vex/vexillum/view/begin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), windowWidth, windowHeight);
        stage.setTitle("Карт-Опрос");
        stage.setScene(scene);
        stage.show();
    }

    public static void enter(String[] args) {
        launch();
    }
}
