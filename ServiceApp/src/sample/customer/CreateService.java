package sample.customer;

import javafx.event.ActionEvent;
import sample.Main;

public class CreateService {
    public void back(ActionEvent actionEvent) throws Exception {
        Main.switcher.fsMode = Main.stage.isFullScreen();
        Main.switcher.scene(Main.stage,"customer/accountpage.fxml");
    }

    public void createAccount(ActionEvent actionEvent) {
    }
}
