package sample.customer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;
import sample.Order.Order;
import sample.login.Login;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Specification implements Initializable {

    @FXML
    Button fullscreenButton = new Button();
    @FXML
    TextField Tittleid=new TextField();
    @FXML
    TextField addressid=new TextField();
    @FXML
    TextField Phoneid=new TextField();
    @FXML
    TextField noteid=new TextField();
    @FXML
    TextField specid=new TextField();
    @FXML
    Button signUpBtn=new Button();
    public void create() throws SQLException {
        Order order=new Order(Login.email,specid.getText(),Tittleid.getText(),addressid.getText(),Phoneid.getText());
    }



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
