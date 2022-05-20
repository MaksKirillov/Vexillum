package com.vex.vexillum.chose;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

import static com.vex.vexillum.model.Buttons.backButton;
import static com.vex.vexillum.model.Buttons.menuButton;

public class ChoseController {

    @FXML
    private Button backButton;

    @FXML
    private Button enterButton;

    @FXML
    private ChoiceBox<?> userSelect;

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
        backButton(backButton);
    }

    @FXML
    void handleEnterButtonAction(ActionEvent event) throws IOException {
        menuButton(enterButton);
    }

}

