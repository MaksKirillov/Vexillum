package com.vex.vexillum.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static com.vex.vexillum.model.Buttons.loadGameButton;
import static com.vex.vexillum.model.Buttons.newGameButton;
import static com.vex.vexillum.model.Data.backFlag;
import static com.vex.vexillum.model.Users.noUsers;

public class BeginController {

    @FXML
    private Button loadGameButton;

    @FXML
    private Button newGameButton;

    @FXML
    private Button exitButton;

    @FXML
    private Label label;

    @FXML
    void initialize() {
        backFlag = 3;
    }

    @FXML
    void handleLoadGameButtonAction(ActionEvent event) throws IOException {
        if (noUsers()) {
            label.setText("Нет пользователей!");
        } else {
            loadGameButton(loadGameButton);
        }
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

