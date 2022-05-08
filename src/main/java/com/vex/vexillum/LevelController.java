package com.vex.vexillum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;

public class LevelController {

    @FXML
    private Button answerButton1;

    @FXML
    private Button answerButton2;

    @FXML
    private Button answerButton3;

    @FXML
    private Button answerButton4;

    @FXML
    private Button backButton;

    @FXML
    private Label label;

    @FXML
    private void start() {
        if (!Model.oneTimeFlag) level();
        Model.oneTimeFlag = true;
    }

    private void level() {
        Model.backFlag = 1;
        Model.winningButton = Model.randomizer(1, 4);
        int i = Model.levelRandomizer();
        Model.chosenCountry = i;
        int[] buttons = Model.buttonsRandomizer(i);
        switch (Model.winningButton) {
            case 1 -> {
                answerButton1.setText(Model.countries[i]);
                answerButton2.setText(Model.countries[buttons[0]]);
                answerButton3.setText(Model.countries[buttons[1]]);
                answerButton4.setText(Model.countries[buttons[2]]);
            }
            case 2 -> {
                answerButton1.setText(Model.countries[buttons[0]]);
                answerButton2.setText(Model.countries[i]);
                answerButton3.setText(Model.countries[buttons[1]]);
                answerButton4.setText(Model.countries[buttons[2]]);
            }
            case 3 -> {
                answerButton1.setText(Model.countries[buttons[0]]);
                answerButton2.setText(Model.countries[buttons[1]]);
                answerButton3.setText(Model.countries[i]);
                answerButton4.setText(Model.countries[buttons[2]]);
            }
            default -> {
                answerButton1.setText(Model.countries[buttons[0]]);
                answerButton2.setText(Model.countries[buttons[1]]);
                answerButton3.setText(Model.countries[buttons[2]]);
                answerButton4.setText(Model.countries[i]);
            }
        }
        switch (Model.levelFlag) {
            case 1 -> flagStart(i);
            case 2 -> factStart(i);
            default -> mapStart(i);
        }
    }

    private void flagStart(int i) {
        String path = Model.pathFlags[i];
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(480);
        imageView.setFitHeight(280);
        label.setGraphic(imageView);
    }

    private void factStart(int i) {
        String fact = Model.facts[i];
        label.setText(fact);
    }

    private void mapStart(int i) {
        String path = Model.pathMaps[i];
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        ImageView imageView = new ImageView(image);
        label.setGraphic(imageView);
    }

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
        Model.backButton(backButton);
        Model.oneTimeFlag = false;
    }

    @FXML
    void handleAnswerButton1Action(ActionEvent event) throws IOException {
        if (Model.winningButton == 1) {
            Model.rightButton(answerButton1);
        } else {
            Model.wrongButton(answerButton1);
        }
        Model.oneTimeFlag = false;
    }

    @FXML
    void handleAnswerButton2Action(ActionEvent event) throws IOException {
        if (Model.winningButton == 2) {
            Model.rightButton(answerButton2);
        } else {
            Model.wrongButton(answerButton2);
        }
        Model.oneTimeFlag = false;
    }

    @FXML
    void handleAnswerButton3Action(ActionEvent event) throws IOException {
        if (Model.winningButton == 3) {
            Model.rightButton(answerButton3);
        } else {
            Model.wrongButton(answerButton3);
        }
        Model.oneTimeFlag = false;
    }

    @FXML
    void handleAnswerButton4Action(ActionEvent event) throws IOException {
        if (Model.winningButton == 4) {
            Model.rightButton(answerButton4);
        } else {
            Model.wrongButton(answerButton4);
        }
        Model.oneTimeFlag = false;
    }

}
