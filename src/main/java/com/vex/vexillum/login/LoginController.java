package com.vex.vexillum.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.vex.vexillum.model.Buttons.backButton;
import static com.vex.vexillum.model.Buttons.menuButton;
import static com.vex.vexillum.model.Data.currentUser;
import static com.vex.vexillum.model.StringWorker.contains;
import static com.vex.vexillum.model.Users.*;


public class LoginController {

    @FXML
    private Button enterButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField loginField;

    @FXML
    private Label label;

    @FXML
    void initialize() {
        resetUsers();
    }

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
        backButton(backButton);
    }

    @FXML
    void handleEnterButtonAction(ActionEvent event) throws IOException {
        if (contains(loginField.getText().trim(), users)) {
            label.setText("Такой пользователь уже есть!");
        } else if (loginField.getText().trim().equals("NoUsers")) {
            label.setText("Некоректное имя!");
        } else if (loginField.getText().trim().isEmpty()) {
            label.setText("Имя пользователя не введено!");
        } else {
            currentUser = loginField.getText().trim();
            addUser(loginField.getText().trim());
            menuButton(enterButton);
        }
    }

}
