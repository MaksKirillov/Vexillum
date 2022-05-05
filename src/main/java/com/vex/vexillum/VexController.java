
package com.vex.vexillum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class VexController {

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
        Model.levelFlag = 1;
        Model.levelButton(flagsButton);
    }

    @FXML
    void handleFactsButtonAction(ActionEvent event) throws IOException {
        Model.levelFlag = 2;
        Model.levelButton(factsButton);
    }

    @FXML
    void handleMapsButtonAction(ActionEvent event) throws IOException {
        Model.levelFlag = 3;
        Model.levelButton(mapsButton);
    }

    @FXML
    public void handleStatsButtonAction(ActionEvent event) throws IOException {
        Model.backFlag = 1;
        Model.statsButton(statsButton);
    }

    @FXML
    public void handleExitButtonAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}