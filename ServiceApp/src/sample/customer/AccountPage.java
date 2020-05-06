package sample.customer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountPage implements Initializable {

    @FXML
    Pane groceryPane = new Pane();
    @FXML
    Pane petPane = new Pane();
    @FXML
    Pane gardenPane = new Pane();

    @FXML
    Button fullscreenButton = new Button();

    public void settings()throws Exception{
        Main.switcher.fsMode = Main.stage.isFullScreen();
        Main.switcher.scene(Main.stage,"customer/settings.fxml");
    }

    public void logOut()throws Exception{
        Main.switcher.fsMode = Main.stage.isFullScreen();
        Main.switcher.scene(Main.stage,"login/login.fxml");
    }

    public void grocery(){

        System.out.println("Yo");

        //TODO - When the button is clicked, refer to new scene "CreateService". Possibly autofill type of service

    }

    public void pet(){

        //TODO - When the button is clicked, refer to new scene "CreateService". Possibly autofill type of service

    }

    public void garden(){

        //TODO - When the button is clicked, refer to new scene "CreateService". Possibly autofill type of service

    }



    //---LAYOUT ONLY---
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fullscreenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Main.switcher.fullscreen(Main.stage);
                }catch (Exception e){

                }
            }
        });


        //SHOPPING
        groceryPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                grocery();
            }
        });
        groceryPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                groceryPane.setStyle("-fx-background-color: grey;");
            }
        });groceryPane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                groceryPane.setStyle("-fx-background-color: transparent;");
            }
        });

        //PET SITTING
        petPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                grocery();
            }
        });
        petPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                petPane.setStyle("-fx-background-color: grey;");
            }
        });petPane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                petPane.setStyle("-fx-background-color: transparent;");
            }
        });

        //GARDENING
        gardenPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                garden();
            }
        });
        gardenPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gardenPane.setStyle("-fx-background-color: grey;");
            }
        });gardenPane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gardenPane.setStyle("-fx-background-color: transparent;");
            }
        });


    }
}
