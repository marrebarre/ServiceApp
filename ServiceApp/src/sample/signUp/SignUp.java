package sample.signUp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.users.User;

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

    public void newUser(){
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
