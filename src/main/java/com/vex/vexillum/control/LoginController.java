package com.vex.vexillum.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.vex.vexillum.model.Buttons.*;
import static com.vex.vexillum.model.Data.backFlag;
import static com.vex.vexillum.model.Data.currentUser;
import static com.vex.vexillum.util.StringWorker.contains;
import static com.vex.vexillum.model.UserWorker.*;


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
        updateUsers();
    }

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
        backButton(backButton);
        backFlag = 1;
    }

    @FXML
    void handleEnterButtonAction(ActionEvent event) throws IOException {
        if (userCount == 32) {
            label.setText("Слишком много пользователей");
        } else if (loginField.getText().trim().equals("NoUsers")) {
            label.setText("Некоректное имя!");
        } else if (contains(loginField.getText().trim(), users)) {
            label.setText("Такой пользователь уже есть!");
        } else if (loginField.getText().trim().isEmpty()) {
            label.setText("Имя пользователя не введено!");
        } else {
            addUser(loginField.getText().trim());
            currentUser = loginField.getText().trim();
            if (backFlag == 4) {
                backFlag = 1;
                statsButton(enterButton);
            } else {
                menuButton(enterButton);
            }
        }
    }

}
