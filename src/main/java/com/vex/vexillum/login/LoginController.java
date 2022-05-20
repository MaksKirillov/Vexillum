package com.vex.vexillum.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.vex.vexillum.model.Buttons.backButton;
import static com.vex.vexillum.model.Buttons.menuButton;

public class LoginController {

    @FXML
    private Button enterButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField loginField;

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
        backButton(backButton);
    }

    @FXML
    void handleEnterButtonAction(ActionEvent event) throws IOException {
        menuButton(enterButton);
    }

}