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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.database.Database;
import sample.signUp.SignUp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {


    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    Button fullscreenButton = new Button();
    Database database = new Database();
    SignUp signUp = new SignUp();

    public void signIn()throws Exception{
        if (database.validemployee(username.getText(),password.getText())){
            Main.switcher.fsMode = Main.stage.isFullScreen();
            Main.switcher.scene(Main.stage,"customer/browse.fxml");
            signUp.alert("Success");

        } else if (database.validuser(username.getText(),password.getText())){
            Main.switcher.fsMode = Main.stage.isFullScreen();
            Main.switcher.scene(Main.stage,"customer/browse.fxml");
            signUp.alert("Success");

        } else {
            signUp.alert("Username and Password does not match");
        }



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


