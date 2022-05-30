
package com.vex.vexillum.control;

import com.vex.vexillum.util.Stats;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.vex.vexillum.model.Buttons.*;
import static com.vex.vexillum.model.Data.*;
import static com.vex.vexillum.util.Stats.*;

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
    private Button backButton;

    @FXML
    void initialize() throws FileNotFoundException {
        Stats.getInstance();
        backFlag = 3;
        if (getAllFlags() == levelCount) completeFlag = true;
        if (getAllFacts() == levelCount) completeFact = true;
        if (getAllMaps() == levelCount) completeMap = true;
    }

    @FXML
    void handleFlagsButtonAction(ActionEvent event) throws IOException {
        backFlag = 1;
        levelFlag = 1;
        levelButton(flagsButton);
    }

    @FXML
    void handleFactsButtonAction(ActionEvent event) throws IOException {
        backFlag = 1;
        levelFlag = 2;
        levelButton(factsButton);
    }

    @FXML
    void handleMapsButtonAction(ActionEvent event) throws IOException {
        backFlag = 1;
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

    @FXML
    public void handleBackButtonAction(ActionEvent event) throws IOException {
        backButton(backButton);
    }

}