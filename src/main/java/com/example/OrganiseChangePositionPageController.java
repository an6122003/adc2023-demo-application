package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OrganiseChangePositionPageController {
    @FXML
    private TextField oldPositionTextField;
    @FXML
    private TextField newPositionTextField;
    @FXML
    private Button changePositionButton2;

    public void changePosition(ActionEvent e){
        Integer oldPosition = Integer.parseInt(oldPositionTextField.getText());
        Integer newPosition = Integer.parseInt(newPositionTextField.getText());
        if (Data.swapValues(Data.getCaptureData(), oldPosition, newPosition)){
            System.out.println("Changed");
            
        }
        else{
            System.out.println("Not changed");
        }

        // Close the popup page
        Stage stage = (Stage) changePositionButton2.getScene().getWindow();
        stage.close();
        
        OrganisePageController organisePageController = OrganisePageController.getInstance();
        if (organisePageController != null) {
            organisePageController.closeWindow();
        }

        //Reload the page
        try {
                //Swich Scene
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/organisePage.fxml"));
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
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
