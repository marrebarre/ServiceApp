package sample.worker;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import sample.Main;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class Worker {

    @FXML
    void editProfile(ActionEvent event) throws Exception {
        Main.switcher.scene(Main.stage,"worker/editProfile.fxml");

    }

    public void exit(){
        Platform.exit();
    }

    public void fullscreen() throws Exception{
        Main.switcher.fullscreen(Main.stage);
    }

}
