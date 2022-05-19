
package com.vex.vexillum.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static com.vex.vexillum.model.Buttons.levelButton;
import static com.vex.vexillum.model.Buttons.statsButton;
import static com.vex.vexillum.model.Data.*;

public class MenuController {

    @FXML
    private Button exitButton;

    @FXML
    private Button statsButton;

    @FXML
    private Button factsButton;

    @FXML
    private Button flagsButton;

    @FXML
    private Button mapsButton;

    @FXML
    void handleFlagsButtonAction(ActionEvent event) throws IOException {
        levelFlag = 1;
        levelButton(flagsButton);
    }

    @FXML
    void handleFactsButtonAction(ActionEvent event) throws IOException {
        levelFlag = 2;
        levelButton(factsButton);
    }

    @FXML
    void handleMapsButtonAction(ActionEvent event) throws IOException {
        levelFlag = 3;
        levelButton(mapsButton);
    }

    @FXML
    public void handleStatsButtonAction(ActionEvent event) throws IOException {
        backFlag = 1;
        statsButton(statsButton);
    }

    @FXML
    public void handleExitButtonAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}