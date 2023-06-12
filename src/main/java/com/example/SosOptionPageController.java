package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SosOptionPageController {
    @FXML
    private Parent root;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button beArtistButton;

    @FXML
    private Button chatBuddyButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button musicUpButton;

    @FXML
    private ScrollPane scrollPane;

    public void initialize() {
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
    }

    @FXML
    void backToHome(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/frontPageAfterCapture.fxml"));
            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchToBeArtistScene(ActionEvent event) {
        
    }

    @FXML
    void switchToChatBuddyScene(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/SosPages/ChatBuddyPage.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToMusicUpScene(ActionEvent event) {

    }

}
