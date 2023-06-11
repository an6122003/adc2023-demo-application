package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DistilPageController {
    @FXML
    private Button finishButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    Parent root;
    private Float x = 20.0f;
    private Float y = 282.0f;
    private List<TextArea> summaryTextAreaList = new ArrayList<TextArea>();


    public void initialize() {
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

            //Create new text area for summary
            TextArea inputArea = new TextArea();
            inputArea.setEditable(true);
            inputArea.setLayoutX(x);
            inputArea.setLayoutY(y+30+175);
            inputArea.setPrefHeight(175.0);
            inputArea.setPrefWidth(559.0);
            inputArea.setWrapText(true);
            inputArea.setText(Data.getSummaryData(key));
            inputArea.setStyle("-fx-font-size:20px");
            inputArea.setPromptText("Enter your summary here");

            //Add summaryTextArea to a list
            summaryTextAreaList.add(inputArea);
            
            //Add label and text area to pane
            anchorPane.getChildren().add(newLabel);
            anchorPane.getChildren().add(newTextArea);
            anchorPane.getChildren().add(inputArea);
            y+= 201+175;
            
            finishButton.setLayoutY(y+20);

            // Update height of anchorPane
            anchorPane.setPrefHeight(anchorPane.getPrefHeight()+201+175);
        }
    }

    public void saveData(ActionEvent event){
        for (TextArea textArea: summaryTextAreaList){
            Data.addSummaryData(textArea.getText());
        }
        System.out.println(Data.getSummaryData());

        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/expressPage.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
