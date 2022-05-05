package com.vex.vexillum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class CompleteController {

    @FXML
    private Button backButton;

    @FXML
    private Button statsButton;

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
        Model.backButton(backButton);
    }

    @FXML
    void handleStatsButtonAction(ActionEvent event) throws IOException {
        Model.backFlag = 1;
        Model.statsButton(statsButton);
    }

}
