package com.vex.vexillum.begin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static com.vex.vexillum.model.Buttons.loadGameButton;
import static com.vex.vexillum.model.Buttons.newGameButton;
import static com.vex.vexillum.model.Data.backFlag;

public class BeginController {

    @FXML
    private Button loadGameButton;

    @FXML
    private Button newGameButton;

    @FXML
    private Button exitButton;

    @FXML
    void initialize() {
        backFlag = 3;
    }

    @FXML
    void handleLoadGameButtonAction(ActionEvent event) throws IOException {
        loadGameButton(loadGameButton);
    }

    @FXML
    void handleNewGameButtonAction(ActionEvent event) throws IOException {
        newGameButton(newGameButton);
    }

    @FXML
    void handleExitButtonAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}

