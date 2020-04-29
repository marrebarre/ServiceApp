package sample.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    public void signUp(ActionEvent event) throws IOException {
            Parent signUp = FXMLLoader.load(getClass().getResource("../signUp/signUp.fxml"));
            Scene signUpScene = new Scene(signUp);
            Stage signUpStage = (Stage)((Node) event.getSource()).getScene().getWindow();
            signUpStage.setScene(signUpScene);
            signUpStage.setTitle("Service App");
            signUpStage.setMinHeight(400);
            signUpStage.setMinWidth(500);
            signUpStage.setFullScreen(true);
            signUpStage.show();


    }
    }


