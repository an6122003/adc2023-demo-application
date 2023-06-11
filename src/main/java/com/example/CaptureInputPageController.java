package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CaptureInputPageController {
    @FXML
    private TextArea generatedTextArea;
    @FXML
    private TextArea inputTextArea;
    @FXML 
    private Button seeIdeaButton;
    @FXML
    private Label ideaNumberLabel;
    @FXML
    private Button submitButton;
    @FXML
    private Pane anchorPane;
    @FXML
    private ScrollPane scrollPane;
    @FXML 
    private Button finishButton;

    private Float x = 20.0f;
    private Float y = 767.0f;

    public void initialize(){
        seeIdea();
        updateIdeaCount();
        
    }

    public void seeIdea(){
        generatedTextArea.setText(Data.getCaptureData(0));
        generatedTextArea.setStyle("-fx-background-color: red;");
    }

    public void updateIdeaCount(){
        ideaNumberLabel.setText("Idea Number: "+Data.getCaptureData().size());
    }

    public void addIdeas(){
        String enteredText = inputTextArea.getText();
        Data.addCaptureData(enteredText);
        inputTextArea.clear();
        UpdateIdeaToPane();
        updateIdeaCount();
    }

    public void UpdateIdeaToPane(){
        // anchorPane.getChildren().add(generateTextArea(x, y + 20,Data.getCaptureData(Data.getCaptureData().size()-1)));
        // // x += 175;
        // System.out.println("x: "+x+" y: "+y);
        // y += 579;

        // Set the initial properties of the generatedTextArea
        TextArea newTextArea = new TextArea();
        newTextArea.setEditable(false);
        newTextArea.setLayoutX(x);
        newTextArea.setLayoutY(y+20);
        newTextArea.setPrefHeight(175.0);
        newTextArea.setPrefWidth(559.0);
        newTextArea.setWrapText(true);
        newTextArea.setText("Idea Number: "+(Data.getCaptureData().size()-1)+ " \n"+Data.getCaptureData(Data.getCaptureData().size()-1));
        
        // Set the font size of the newTextArea
        Font font = new Font(20.0);
        newTextArea.setFont(font);

        anchorPane.getChildren().add(newTextArea);

        y += 195;
        anchorPane.setPrefHeight(anchorPane.getPrefHeight()+195);
        // anchorPane.setPrefWidth(anchorPane.getPrefWidth()+559);
        System.out.println(Data.getCaptureData());
    }

    public TextArea generateTextArea(Float x, Float y, String text){
        // Set the initial properties of the generatedTextArea
        TextArea newTextArea = new TextArea();
        newTextArea.setEditable(false);
        newTextArea.setLayoutX(x);
        newTextArea.setLayoutY(y);
        newTextArea.setPrefHeight(175.0);
        newTextArea.setPrefWidth(559.0);
        newTextArea.setWrapText(true);
        newTextArea.setText(text);
        
        // Set the font size of the newTextArea
        Font font = new Font(20.0);
        newTextArea.setFont(font);

        return newTextArea;
    }

    public void nextScene(ActionEvent e){
        try {
                //Swich Scene
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/organisePage.fxml"));
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                System.out.println("Loading organisePage FXML Failed");
                e1.printStackTrace();
            }
    }

}
