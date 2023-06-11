package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CaptureScene extends Scene{
    

    public CaptureScene(Parent arg0) {
        super(arg0);
        Label label = new Label("Capturing In Progress");
        Label generatedLabel = new Label("AI generated first idea for you: "+ Data.getCaptureData(0));
        
        TextArea chatTextArea = new TextArea();
        chatTextArea.setPrefHeight(200);
        chatTextArea.setStyle("-fx-padding: 5px; -fx-font-size: 14px; -fx-font-family: Arial; -fx-wrap-text: true; -fx-border-radius: 5px; -fx-overflow-x: auto; -fx-overflow-y: auto;");
        chatTextArea.setPromptText("Enter your next main idea here");

        Button captureButton = new Button("Capture you Idea!");
        captureButton.setOnAction(event -> {
            String enteredText = chatTextArea.getText();
            Data.addCaptureData(enteredText);
            System.out.println(Data.getCaptureData(0));
            chatTextArea.clear();
        });

        // VBox vbox = new VBox(10);
        // vbox.setPadding(new Insets(10));
        // vbox.getChildren().addAll(label, generatedLabel, chatTextArea, captureButton);
    }
}
