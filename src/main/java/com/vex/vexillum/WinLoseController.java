package com.vex.vexillum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;

public class WinLoseController {

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button statsButton;

    @FXML
    private ImageView winLoseImage;

    @FXML
    public void start() {
        Image image;
        if (Model.answerFlag) {
            image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/titles/rightAnswerImage.png")));
        } else {
            image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/titles/wrongAnswerImage.png")));
        }
        winLoseImage.setImage(image);
    }

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
        Model.backButton(backButton);
    }

    @FXML
    void handleNextButtonAction(ActionEvent event) throws IOException {
        Model.levelButton(nextButton);
    }

    @FXML
    void handleStatsButtonAction(ActionEvent event) throws IOException {
        Model.backFlag = 2;
        Model.statsButton(statsButton);
    }

}
