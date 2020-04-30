package sample.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class Login {




    public void signIn(){


    }

    public void signUp(ActionEvent event) throws Exception {
        Main.switcher.scene(Main.stage,"signUp/signUp.fxml");


    }
    }


