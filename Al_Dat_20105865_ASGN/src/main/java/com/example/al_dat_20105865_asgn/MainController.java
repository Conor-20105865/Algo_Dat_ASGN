package com.example.al_dat_20105865_asgn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MainController {

    @FXML
    protected void onBookingsHubClick(ActionEvent event) {
        loadScene(event, "BookingHub.fxml", 500, 400);
    }

    @FXML
    protected void onSystemClearClick(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Clear");
        alert.setHeaderText("Are you sure you want to clear the system?");
        alert.setContentText("This action cannot be undone.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("System cleared.");
        } else {
            System.out.println("Clear operation canceled.");
        }
    }

    @FXML
    protected void onShowsClick(ActionEvent event) {
        loadScene(event, "Seating.fxml", 500, 400);
        // TODO: Add functionality for showing shows.
    }

    @FXML
    protected void onOtherButtonClick(ActionEvent event) {
        System.out.println("Other button clicked.");
    }

    @FXML
    protected void onCustomerHubClick(ActionEvent event) {
        System.out.println("Customer hub clicked.");
    }

    @FXML
    protected void onAboutUsClick(ActionEvent event) {
        loadScene(event, "AboutUs.fxml", 500, 400);
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
