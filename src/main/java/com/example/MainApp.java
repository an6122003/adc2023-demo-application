package com.example;

import java.io.IOException;
import java.net.URISyntaxException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private String enteredText;

    public static void main(String[] args) {
        System.out.println("run");
        launch(args);
        System.out.println("run after");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chat Box");
        VBox vbox = new VBox(10);
        Label label = new Label("This is your AI Companion at Capture Stage:");

        TextArea chatTextArea = new TextArea();
        chatTextArea.setPrefHeight(200);
        chatTextArea.setStyle("-fx-padding: 5px; -fx-font-size: 14px; -fx-font-family: Arial; -fx-wrap-text: true; -fx-border-radius: 5px; -fx-overflow-x: auto; -fx-overflow-y: auto;");
        chatTextArea.setPromptText("Enter your message here");

        TextArea outputTextArea = new TextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setStyle("-fx-padding: 5px; -fx-font-size: 14px; -fx-font-family: Arial; -fx-wrap-text: true; -fx-border-radius: 5px; -fx-overflow-x: auto; -fx-overflow-y: auto;");

        
        Button captureButton = new Button("Capture you Idea!");
        captureButton.setOnAction(event -> {
            enteredText = chatTextArea.getText();
                 try {
                     String textAPI = testAPI.chatGPT("Give me the first 1 main ideas of the following paragraph",enteredText);
                     outputTextArea.appendText("Your AI Companion give you the first 1 main points: \n" + textAPI);
                     Data.addCaptureData(textAPI.split("\n"));
//                    outputTextArea.appendText("Your AI Companion give you the first 1 main points: \n"+enteredText);
//                    Data.addCaptureData(enteredText);
                    System.out.println(Data.getCaptureData(0));
//                     primaryStage.setScene();

                 } catch (IOException e) {
                     outputTextArea.appendText("Error: " + e.getMessage() + "\n");
                     e.printStackTrace();
                 } catch (URISyntaxException e) {
                     outputTextArea.appendText("Error: " + e.getMessage() + "\n");
                     e.printStackTrace();
                 }
            chatTextArea.clear();
            vbox.getChildren().remove(chatTextArea);
            vbox.getChildren().remove(captureButton);
        });

        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(label, chatTextArea, captureButton, outputTextArea);
        
        Scene scene = new Scene(vbox, 300, 400);
        // Image icon = new Image("src/main/resources/com/example/image/1.jpeg");

        // primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


