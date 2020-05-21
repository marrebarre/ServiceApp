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
import sample.database.Database;
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
    private TextField cityFie;

    @FXML
    private TextField phoneFie;

    @FXML
    private TextArea CV;

    @FXML
    private CheckBox Worker;

    Database database = new Database();

    @FXML
    public void createAccount (ActionEvent event) throws Exception {
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
        } else if (phoneFie.getText().isEmpty()) {
            System.out.println("Please fill in Phone Number");
            alert("Please fill in Phone Number");
        } else if (cityFie.getText().isEmpty()) {
            System.out.println("Please fill in City");
            alert("Please fill in City");
        } else if (Worker.isSelected()) {
            System.out.println("You are a worker");
            addUser(firstNameFie.getText(),lastNameFie.getText(),emailFie.getText(),cityFie.getText(),
                    CV.getText(),addressFie.getText(),SocialNumberFie.getText(),passFie.getText(),phoneFie.getText(),true);
        } else {
            System.out.println("You are a customer");
            addUser(firstNameFie.getText(),lastNameFie.getText(),emailFie.getText(),
                    cityFie.getText(),CV.getText(),addressFie.getText(),SocialNumberFie.getText(),passFie.getText(),phoneFie.getText(),false);
        }

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

    public void addUser(String firstName, String lastName, String email,String city, String cv ,
                        String address, String SocialNumber, String password, String phone, boolean worker) throws Exception{
        if (worker) {
            database.insertemployee(firstName, lastName,address,city,phone,cv, SocialNumber,email,password);
        } else {
            database.insertnewuser(firstName,lastName,address,city,phone,SocialNumber,password,email);
        }
        alert("Success");
        Main.switcher.fsMode = Main.stage.isFullScreen();
        Main.switcher.scene(Main.stage,"login/login.fxml");

    }

    public void back()throws Exception{
        Main.switcher.fsMode = Main.stage.isFullScreen();
        Main.switcher.scene(Main.stage,"login/login.fxml");

    }

}
