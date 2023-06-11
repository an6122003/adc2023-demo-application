package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToCaptureInfoScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/com/example/CaptureInfoPage/captureInfoPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToOrganiseInfoScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/com/example/CaptureInfoPage/organiseInfoPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDistilInfoScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/com/example/CaptureInfoPage/distilInfoPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToExpressInfoScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/com/example/CaptureInfoPage/expressInfoPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCaptureProcessScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/com/example/captureProcessPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCaptureInputScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/com/example/captureInputPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToOrganisecene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/com/example/organisePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
}