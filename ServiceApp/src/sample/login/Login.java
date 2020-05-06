package sample.login;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    Button fullscreenButton = new Button();

    public void signIn()throws Exception{
        Main.switcher.fsMode = Main.stage.isFullScreen();
        Main.switcher.scene(Main.stage,"customer/accountpage.fxml");

    }

    public void exit(){
        Platform.exit();
    }

    public void signUp(ActionEvent event) throws Exception {
        Main.switcher.fsMode = Main.stage.isFullScreen();
        Main.switcher.scene(Main.stage,"signUp/signUp.fxml");
    }

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
    }
}


