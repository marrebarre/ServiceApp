package sample.worker;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import sample.Main;
import sample.database.Database;
import sample.login.Login;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class Worker {
    Database database = new Database();

    @FXML
    void editProfile(ActionEvent event) throws Exception {
            Main.switcher.scene(Main.stage, "worker/editProfile.fxml");

    }

    public void exit(){
        database.notAvailable();
        Platform.exit();
    }

    public void fullscreen() throws Exception{
        Main.switcher.fullscreen(Main.stage);
    }

}
