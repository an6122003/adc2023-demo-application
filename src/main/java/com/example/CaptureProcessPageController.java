package com.example;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CaptureProcessPageController {
    @FXML
    private TextArea textArea;
    @FXML
    private Button submitButton;

    public void Submit(ActionEvent e){
        String enteredText = textArea.getText();
        try {
            String textAPI = testAPI.chatGPT("Give me the first 1 main ideas of the following paragraph",enteredText);
            System.out.println(textAPI);
            Data.addCaptureData(textAPI.split("\n"));
            System.out.println(Data.getCaptureData(0));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
        nextScene(e);
    }
    
    public void nextScene(ActionEvent e){
        try {
                //Swich Scene
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/captureInputPage.fxml"));
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                System.out.println("Loading CaptureInfoPage FXML Failed");
                e1.printStackTrace();
            }
    }
}
