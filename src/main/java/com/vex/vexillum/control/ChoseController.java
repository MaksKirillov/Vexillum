package com.vex.vexillum.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;

import static com.vex.vexillum.model.Buttons.*;
import static com.vex.vexillum.model.Data.backFlag;
import static com.vex.vexillum.model.Data.currentUser;
import static com.vex.vexillum.util.StringWorker.increment;
import static com.vex.vexillum.model.UserWorker.*;

public class ChoseController {

    @FXML
    private Button backButton;

    @FXML
    private Button enterButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ComboBox<String> userSelect;

    @FXML
    private Label label;

    @FXML
    void initialize() {
        updateUsers();
        ObservableList<String> userList = FXCollections.observableArrayList(users);
        userSelect.setStyle("-fx-font: 24px \"Calibri\";");
        userSelect.setItems(userList);
    }

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
        backButton(backButton);
        backFlag = 1;
    }

    @FXML
    void handleEnterButtonAction(ActionEvent event) throws IOException {
        if (userSelect.getValue() == null) {
            label.setText("Не выбран пользователь!");
        } else {
            currentUser = userSelect.getValue().trim();
            currentUserInt = increment(currentUser, users);
            if (backFlag == 4) {
                backFlag = 1;
                statsButton(enterButton);
            } else {
                menuButton(enterButton);
            }
        }
    }

    @FXML
    void handleDeleteButtonAction(ActionEvent event) throws IOException {
        deleteAllUsers();
        beginButton(deleteButton);
    }

}

