package com.example.al_dat_20105865_asgn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RemoveShowController {

    @FXML
    protected void onBack2Click(ActionEvent event) {
        loadScene(event, "BookingHub.fxml", 500, 400);
    }

    @FXML
    protected void onHomeButtonClick(ActionEvent event) {
        loadScene(event, "Main.fxml", 500, 400);
    }

    private void loadScene(ActionEvent event, String fxmlFile, int width, int height) {
        try {
            Parent newScene = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScene, width, height));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
