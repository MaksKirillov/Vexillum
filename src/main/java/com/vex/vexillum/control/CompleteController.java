package com.vex.vexillum.control;

import com.vex.vexillum.Launcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;

import static com.vex.vexillum.model.Buttons.backButton;
import static com.vex.vexillum.model.Buttons.statsButton;
import static com.vex.vexillum.model.Data.*;

public class CompleteController {

    @FXML
    private Button backButton;

    @FXML
    private Button statsButton;

    @FXML
    private ImageView winLoseImage;

    @FXML
    void initialize() {
        backFlag = 1;
        switch (levelFlag) {
            case 1 -> startFlag();
            case 2 -> startFact();
            default -> startMap();
        }
    }

    private void startFlag() {
        if (!completeFlag) {
            setWinLoseImage();
            completeFlag = true;
        }
    }

    private void startFact() {
        if (!completeFact) {
            setWinLoseImage();
            completeFact = true;
        }
    }

    private void startMap() {
        if (!completeMap) {
            setWinLoseImage();
            completeMap = true;
        }
    }

    private void setWinLoseImage() {
        Image image;
        if (answerFlag) {
            image = new Image(Objects.requireNonNull(Launcher.class.getResourceAsStream("images/titles/rightAnswerImage.png")));
        } else {
            image = new Image(Objects.requireNonNull(Launcher.class.getResourceAsStream("images/titles/wrongAnswerImage.png")));
        }
        winLoseImage.setFitWidth(600);
        winLoseImage.setFitHeight(300);
        winLoseImage.setImage(image);
    }

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
        backButton(backButton);
    }

    @FXML
    void handleStatsButtonAction(ActionEvent event) throws IOException {
        statsButton(statsButton);
    }

}
