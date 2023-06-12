package com.example;

import java.io.IOException;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChatBuddyPageController {
    @FXML
    Parent root;
    
    @FXML
    private Button homeButton;

    @FXML
    private TextField inputTextField;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private Button submitButton;
    private String returned_text;

    public void initialize(){
        outputTextArea.appendText("Chat Buddy:\nHi, how are you?\n\n");
    }

    @FXML
    void Submit(ActionEvent event) {
        String userInput = inputTextField.getText();
        outputTextArea.appendText("You: \n");
        // Append the bolded text using HTML tags
        outputTextArea.appendText(userInput + "\n\n");

        // outputTextArea.appendText("You: "+ inputTextField.getText() +"\n");
        try {
                returned_text = testAPI.chatGPT("I am a stutterer and I am panicking. You are a helpful buddy, trying to calm me down",inputTextField.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        // outputTextArea.appendText("Chat Buddy: "+ returned_text + "\n"); 
        
        outputTextArea.appendText("Chat Buddy: \n");
        // Append the bolded text using HTML tags
        outputTextArea.appendText(returned_text + "\n\n");
        inputTextField.clear();
    }

    public void backToHome() {
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/frontPageAfterCapture.fxml"));
            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
