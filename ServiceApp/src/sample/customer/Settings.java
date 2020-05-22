package sample.customer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;
import sample.SceneSwitcher;
import sample.database.Database;
import sample.login.Login;
import sample.signUp.SignUp;

import java.net.URL;
import java.util.ResourceBundle;

public class Settings implements Initializable {

    @FXML
    Button fullscreenButton = new Button();

    @FXML
    TextField oldPass = new TextField();
    @FXML
    TextField newPass = new TextField();

    public void back()throws Exception{
        Main.switcher.fsMode = Main.stage.isFullScreen();
        Main.switcher.scene(Main.stage,"customer/browse.fxml");
    }

    public void changePass(){
        Database db = new Database();
        if (db.validuser(Login.email,oldPass.getText())){

            db.updateCustomerPassword(Login.email, newPass.getText());
            oldPass.setText("");
            newPass.setText("");
            SceneSwitcher.alert("Password updated successfully!");

        }else{
            SceneSwitcher.alert("Old password incorrect.");
        }

    }

    public void exit(){
        Platform.exit();
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
