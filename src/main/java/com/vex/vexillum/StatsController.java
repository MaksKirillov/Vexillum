package com.vex.vexillum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.*;

import static com.vex.vexillum.Model.*;

public class StatsController {

    @FXML
    private Button backButton;

    @FXML
    private Button flagResetButton;

    @FXML
    private Button factsResetButton;

    @FXML
    private Button mapsResetButton;

    @FXML
    private Button allResetButton;

    @FXML
    private Text RightFacts;

    @FXML
    private Text RightFlags;

    @FXML
    private Text RightMaps;

    @FXML
    private Text WrongFacts;

    @FXML
    private Text WrongFlags;

    @FXML
    private Text WrongMaps;

    @FXML
    private Text AllRight;

    @FXML
    private Text AllWrong;

    @FXML
    private Text AllAll;

    @FXML
    private Text AllFacts;

    @FXML
    private Text AllFlags;

    @FXML
    private Text AllMaps;

    @FXML
    public void statistic() throws FileNotFoundException {
        AllAll.setText(Integer.toString(getAllAll()));
        AllFacts.setText(Integer.toString(getAllFacts()));
        AllFlags.setText(Integer.toString(getAllFlags()));
        AllMaps.setText(Integer.toString(getAllMaps()));
        RightFacts.setText(Integer.toString(getRightFacts()));
        RightFlags.setText(Integer.toString(getRightFlags()));
        RightMaps.setText(Integer.toString(getRightMaps()));
        AllRight.setText(Integer.toString(getAllRights()));
        WrongFacts.setText(Integer.toString(getWrongFacts()));
        WrongFlags.setText(Integer.toString(getWrongFlags()));
        WrongMaps.setText(Integer.toString(getWrongMaps()));
        AllWrong.setText(Integer.toString(getAllWrongs()));
    }

    @FXML
    public void handleBackButtonAction(ActionEvent event) throws IOException {
        Model.backButton(backButton);
    }

    @FXML
    void handleResetFlagsButtonAction(ActionEvent event) throws IOException {
        changeNum(0, 0);
        changeNum(0, 1);
        statistic();
        Model.resetLevel(1);
    }

    @FXML
    void handleResetFactsButtonAction(ActionEvent event) throws IOException {
        changeNum(0, 2);
        changeNum(0, 3);
        statistic();
        Model.resetLevel(2);
    }

    @FXML
    void handleResetMapsButtonAction(ActionEvent event) throws IOException {
        changeNum(0, 4);
        changeNum(0, 5);
        statistic();
        Model.resetLevel(3);
    }

    @FXML
    void handleResetAllButtonAction(ActionEvent event) throws IOException {
        changeNum(0, 0);
        changeNum(0, 1);
        changeNum(0, 2);
        changeNum(0, 3);
        changeNum(0, 4);
        changeNum(0, 5);
        Model.resetLevel(1);
        Model.resetLevel(2);
        Model.resetLevel(3);
        statistic();
    }

}