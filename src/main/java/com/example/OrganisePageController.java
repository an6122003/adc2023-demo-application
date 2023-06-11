package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OrganisePageController {
    @FXML
    AnchorPane anchorPane;
    @FXML
    private Button finishButton;
    @FXML
    private Button changePositionButton;
    @FXML
    Parent root;
    private static OrganisePageController instance;
    @FXML
    private ScrollPane scrollPane;

    public OrganisePageController() {
        instance = this;
    }

    public static OrganisePageController getInstance() {
        return instance;
    }


    private Float x = 20.0f;
    private Float y = 282.0f;


    public void initialize(){
        scrollPane.layout();
        scrollPane.requestLayout();
        scrollPane.setMaxHeight(790);
        scrollPane.setMaxWidth(600);
        // Loop through the entries of the HashMap
        for (Map.Entry<Integer, String> entry : Data.getCaptureData().entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            
            //Create new label
            Label newLabel = new Label();
            newLabel.setLayoutX(x);
            newLabel.setLayoutY(y);
            newLabel.setPrefHeight(26.0);
            newLabel.setPrefWidth(352.0);
            newLabel.setText("Idea Number: "+key);
            newLabel.setStyle("-fx-font-size:20px");

            //Create new text area
            TextArea newTextArea = new TextArea();
            newTextArea.setEditable(false);
            newTextArea.setLayoutX(x);
            newTextArea.setLayoutY(y+30);
            newTextArea.setPrefHeight(175.0);
            newTextArea.setPrefWidth(559.0);
            newTextArea.setWrapText(true);
            newTextArea.setText(value);
            newTextArea.setStyle("-fx-font-size:20px");
            
            //Add label and text area to pane
            anchorPane.getChildren().add(newLabel);
            anchorPane.getChildren().add(newTextArea);
            y+= 201;
            
            finishButton.setLayoutY(y+20);
            changePositionButton.setLayoutY(y+20);

            // Update height of anchorPane
            anchorPane.setPrefHeight(anchorPane.getPrefHeight()+201);
        }
    }

    public void ChangeIdeaPosition() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/organiseChangePositionPage.fxml")); // Load scene from FXML file
        Scene scene = new Scene(root);
        InputStream stream = new FileInputStream("src/main/resources/com/example/image/icon.png");
        Image icon = new Image(stream);

        Stage stage = new Stage();
        stage.getIcons().add(icon);
        stage.setTitle("AI Companion\u00AE");
        stage.setScene(scene);
        stage.show();
    }

    public void closeWindow(){
        Stage stage = (Stage) finishButton.getScene().getWindow();
        stage.close();
    }

    public void switchToDistilScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/com/example/distilPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
