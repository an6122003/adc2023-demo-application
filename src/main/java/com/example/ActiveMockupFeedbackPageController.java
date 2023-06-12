package com.example;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class ActiveMockupFeedbackPageController {
    @FXML
    Parent root;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button homeButton;

    public void backToHome(){
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/frontPageAfterCapture.fxml"));
            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
