package sample.signUp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main;
import sample.users.User;

import java.io.IOException;

public class SignUp {

    @FXML
    private TextField firstNameFie;

    @FXML
    private TextField emailFie;

    @FXML
    private TextField lastNameFie;

    @FXML
    private TextField addressFie;

    @FXML
    private TextField SocialNumberFie;

    @FXML
    private PasswordField passFie;

    @FXML
    private Button signUpBtn;

    @FXML
    private CheckBox Worker;

    @FXML
    public void createAccount (ActionEvent event) throws IOException {
        if (firstNameFie.getText().isEmpty()){
            System.out.println("Please fill in First Name");
            alert("Please fill in First Name");
        } else if (lastNameFie.getText().isEmpty()){
            System.out.println("Please fill in Last Name");
            alert("Please fill in Last Name");
        } else if (emailFie.getText().isEmpty()) {
            System.out.println("Please fill in E-mail");
            alert("Please fill in E-mail");
        } else if (addressFie.getText().isEmpty()) {
            System.out.println("Please fill in Address");
            alert("Please fill in Address");
        } else if (SocialNumberFie.getText().isEmpty()) {
            System.out.println("Please fill in Social Security Number");
            alert("Please fill in Social Security Number");
        } else if (passFie.getText().isEmpty()) {
            System.out.println("Please fill in Password");
            alert("Please fill in Password");
        } else if (Worker.isSelected()) {
            System.out.println("You are a worker");
        } else {
            System.out.println("You are a customer");
        }
        User user = new User(firstNameFie.getText(), lastNameFie.getText(), emailFie.getText(), addressFie.getText(),
                SocialNumberFie.getText(), passFie.getText(), Worker.isSelected());
        User.users.add(user);
        alert("Success");

        Parent signUp = FXMLLoader.load(getClass().getResource("../login/login.fxml"));
        Scene signUpScene = new Scene(signUp);
        Stage signUpStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        signUpStage.setScene(signUpScene);
        signUpStage.setTitle("Service App");
        signUpStage.setMinHeight(400);
        signUpStage.setMinWidth(500);
        signUpStage.setFullScreen(true);
        signUpStage.show();


    }

    public void alert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(message);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

}
