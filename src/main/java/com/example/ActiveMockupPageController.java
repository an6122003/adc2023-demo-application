package com.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;

public class ActiveMockupPageController {
    @FXML
    Parent root;
    @FXML
    private MediaView mediaView;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button homeButton;
    @FXML
    private Button feedbackButton;
    private Media media;
    private File file;
    private MediaPlayer mediaPlayer;

    public void initialize(){
//         // Create a Media object with the camera video source
        file = new File("src/main/resources/com/example/image/video.mp4");
        media = new Media(file.toURI().toString());
//        media = new Media("webcam://0");
//
//        // Create a MediaPlayer with the Media object
        mediaPlayer = new MediaPlayer(media);
//
//        // Create a MediaView to display the video
        mediaView = new MediaView(mediaPlayer);
        mediaPlayer.play();
        mediaView.setFitHeight(270);
        mediaView.setFitWidth(480);
        mediaView.setLayoutX(60);
        mediaView.setLayoutY(264);

//
//        // Create a StackPane as the root container
        anchorPane.getChildren().add(mediaView);
    }

    public void backToHome(){
        mediaPlayer.stop();
        mediaPlayer.dispose();
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/frontPageAfterCapture.fxml"));
            Stage stage = (Stage) feedbackButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchToFeedbackScene(){
        mediaPlayer.stop();
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/ActiveMockupPages/activeMockupFeedbackPage.fxml"));
            Stage stage = (Stage) feedbackButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

