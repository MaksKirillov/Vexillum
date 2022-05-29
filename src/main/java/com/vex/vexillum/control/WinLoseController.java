package com.vex.vexillum.control;

import com.vex.vexillum.Launcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;

import static com.vex.vexillum.model.Buttons.*;
import static com.vex.vexillum.model.Data.*;

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
    void initialize() {
        Image image;
        if (answerFlag) {
            image = new Image(Objects.requireNonNull(Launcher.class.getResourceAsStream("images/titles/rightAnswerImage.png")));
        } else {
            image = new Image(Objects.requireNonNull(Launcher.class.getResourceAsStream("images/titles/wrongAnswerImage.png")));
        }
        winLoseImage.setImage(image);
    }

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
        backButton(backButton);
    }

    @FXML
    void handleNextButtonAction(ActionEvent event) throws IOException {
        levelButton(nextButton);
    }

    @FXML
    void handleStatsButtonAction(ActionEvent event) throws IOException {
        backFlag = 2;
        statsButton(statsButton);
    }

}
