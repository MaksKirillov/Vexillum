package com.vex.vexillum.control;

import com.vex.vexillum.Launcher;
import com.vex.vexillum.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;

import static com.vex.vexillum.model.Buttons.*;
import static com.vex.vexillum.model.Data.*;
import static com.vex.vexillum.util.Random.*;
import static com.vex.vexillum.util.StringWorker.contains;

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
    void initialize() {
        Random.getInstance();
        if (!oneTimeFlag) level();
        oneTimeFlag = true;
    }

    private void level() {
        backFlag = 1;
        winningButton = randomizer(1, 4);
        int i = levelRandomizer();
        chosenCountry = i;
        if (contains(countriesAfricaMiddleEast)) continentFlag = 1;
        if (contains(countriesAmericas)) continentFlag = 2;
        if (contains(countriesAsiaOceania)) continentFlag = 3;
        if (contains(countriesEurope)) continentFlag = 4;
        int[] buttons = buttonsRandomizer();
        switch (winningButton) {
            case 1 -> {
                answerButton1.setText(countries[i]);
                answerButton2.setText(countries[buttons[0]]);
                answerButton3.setText(countries[buttons[1]]);
                answerButton4.setText(countries[buttons[2]]);
            }
            case 2 -> {
                answerButton1.setText(countries[buttons[0]]);
                answerButton2.setText(countries[i]);
                answerButton3.setText(countries[buttons[1]]);
                answerButton4.setText(countries[buttons[2]]);
            }
            case 3 -> {
                answerButton1.setText(countries[buttons[0]]);
                answerButton2.setText(countries[buttons[1]]);
                answerButton3.setText(countries[i]);
                answerButton4.setText(countries[buttons[2]]);
            }
            default -> {
                answerButton1.setText(countries[buttons[0]]);
                answerButton2.setText(countries[buttons[1]]);
                answerButton3.setText(countries[buttons[2]]);
                answerButton4.setText(countries[i]);
            }
        }
        switch (levelFlag) {
            case 1 -> flagStart(i);
            case 2 -> factStart(i);
            default -> mapStart(i);
        }
    }

    private void flagStart(int i) {
        String path = pathFlags[i];
        Image image = new Image(Objects.requireNonNull(Launcher.class.getResourceAsStream(path)));
        ImageView imageView = new ImageView(image);
        imageView.setScaleX(1.5);
        imageView.setScaleY(1.5);
        label.setGraphic(imageView);
    }

    private void factStart(int i) {
        String fact = facts[i];
        label.setStyle("-fx-background-color: #B8B3C8");
        label.setText(fact);
    }

    private void mapStart(int i) {
        String path = pathMaps[i];
        Image image = new Image(Objects.requireNonNull(Launcher.class.getResourceAsStream(path)));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);
        label.setGraphic(imageView);
    }

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
        backButton(backButton);
        oneTimeFlag = false;
    }

    @FXML
    void handleAnswerButton1Action(ActionEvent event) throws IOException {
        if (winningButton == 1) {
            rightButton(answerButton1);
        } else {
            wrongButton(answerButton1);
        }
        oneTimeFlag = false;
    }

    @FXML
    void handleAnswerButton2Action(ActionEvent event) throws IOException {
        if (winningButton == 2) {
            rightButton(answerButton2);
        } else {
            wrongButton(answerButton2);
        }
        oneTimeFlag = false;
    }

    @FXML
    void handleAnswerButton3Action(ActionEvent event) throws IOException {
        if (winningButton == 3) {
            rightButton(answerButton3);
        } else {
            wrongButton(answerButton3);
        }
        oneTimeFlag = false;
    }

    @FXML
    void handleAnswerButton4Action(ActionEvent event) throws IOException {
        if (winningButton == 4) {
            rightButton(answerButton4);
        } else {
            wrongButton(answerButton4);
        }
        oneTimeFlag = false;
    }

}
