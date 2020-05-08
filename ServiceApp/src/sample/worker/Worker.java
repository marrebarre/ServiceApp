package sample.worker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.Main;

public class Worker {

    @FXML
    void editProfile(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) throws Exception {
        Main.switcher.fsMode = Main.stage.isFullScreen();
        Main.switcher.scene(Main.stage,"login/login.fxml");
    }
}
