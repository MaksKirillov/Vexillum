package com.vex.vexillum.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.vex.vexillum.model.Data.windowHeight;
import static com.vex.vexillum.model.Data.windowWidth;

public class ChoseApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChoseApplication.class.getResource("/com/vex/vexillum/view/chose-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), windowWidth, windowHeight);
        stage.setTitle("Карт-Опрос");
        stage.setScene(scene);
        stage.show();
    }
}
