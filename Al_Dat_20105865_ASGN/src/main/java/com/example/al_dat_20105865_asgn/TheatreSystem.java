package com.example.al_dat_20105865_asgn;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.ButtonType;
import java.util.Optional;


public class TheatreSystem extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        stage.setTitle("Theatre Booking System");
        stage.setScene(scene);
        stage.show();
    }
//This section is for buttons on the main section
    @FXML
    protected void onBookingsHubClick(ActionEvent event) {
        try {
            Parent newScene = FXMLLoader.load(getClass().getResource("BookingHub.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScene, 500, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onSystemClearClick(ActionEvent event) {
        // Create a confirmation alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Clear");
        alert.setHeaderText("Are you sure you want to clear the system?");
        alert.setContentText("This action cannot be undone.");

        // Show the alert and wait for the user's response
        Optional<ButtonType> result = alert.showAndWait();

        // Check if the user clicked OK
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // TODO: Clear all lists reset data here
            System.out.println("System cleared.");
        } else {
            // User chose CANCEL or closed the dialog
            System.out.println("Clear operation canceled.");
        }
    }


    @FXML
    protected void onShowsClick(ActionEvent event) {
        //TODO: new shows.FXML for listing all shows
    }

    @FXML
    protected void onAboutUsClick(ActionEvent event) {
        try {
            Parent newScene = FXMLLoader.load(getClass().getResource("AboutUs.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScene, 500, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onCustomerHubClick(ActionEvent event) {
        //TODO: no idea her login maybe for bookings controller by the customer
    }

    @FXML
    protected void onOtherButtonClick(ActionEvent event) {
        //TODO: this is just here no reason probably just delete it
    }

    //this is the section for the booking hub buttons

    @FXML
    protected void onHomeButtonClick(ActionEvent event) {
        try{
            Parent newScene = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScene, 500, 400));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    protected void onAddShowClick(ActionEvent event) {
        try{
            Parent newScene = FXMLLoader.load(getClass().getResource("addShow.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScene, 500, 400));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onRemoveShowClick(ActionEvent event) {
        try{
            Parent newScene = FXMLLoader.load(getClass().getResource("RemoveShow.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScene, 500, 400));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onListShowsClick(ActionEvent event) {
        //TODO: output a list of all the currently available shows
    }

    //this is the section for the buttons in addShow FXML
    @FXML
    protected void onBack1Click(ActionEvent event) {
        try{
            Parent newScene =FXMLLoader.load(getClass().getResource("BookingHub.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScene, 500, 400));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //this is the section for the buttons in RemoveShow FXML

    @FXML
    protected void onBack2Click(ActionEvent event) {
        try{
            Parent newScene = FXMLLoader.load(getClass().getResource("BookingHub.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScene, 500, 400));
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch();
    }
}
