package sample.customer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class Specification implements Initializable {

    @FXML
    Button fullscreenButton = new Button();




    public void back() throws Exception{
        Main.switcher.fsMode = Main.stage.isFullScreen();
        Main.switcher.scene(Main.stage,"customer/browse.fxml");
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
