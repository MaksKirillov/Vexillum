package com.vex.vexillum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class CompleteController {

    @FXML
    private Button backButton;

    @FXML
    private Button statsButton;

    @FXML
    private ImageView winLoseImage;

    @FXML
    void initialize() throws FileNotFoundException {
        Model.backFlag = 1;
        switch (Model.levelFlag) {
            case 1 -> startFlag();
            case 2 -> startFact();
            default -> startMap();
        }
    }

    private void startFlag() throws FileNotFoundException {
        if (!Model.completeFlag) {
            setWinLoseImage();
            Model.completeFlag = true;
        }
    }

    private void startFact() throws FileNotFoundException {
        if (!Model.completeFact) {
            setWinLoseImage();
            Model.completeFact = true;
        }
    }

    private void startMap() throws FileNotFoundException {
        if (!Model.completeMap) {
            setWinLoseImage();
            Model.completeMap = true;
        }
    }

    private void setWinLoseImage() {
        Image image;
        if (Model.answerFlag) {
            image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/titles/rightAnswerImage.png")));
        } else {
            image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/titles/wrongAnswerImage.png")));
        }
        winLoseImage.setFitWidth(600);
        winLoseImage.setFitHeight(300);
        winLoseImage.setImage(image);
    }

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
