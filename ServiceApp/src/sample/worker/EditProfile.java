package sample.worker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;
import sample.database.Database;
import sample.login.Login;
import sample.signUp.SignUp;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProfile implements Initializable {
    @FXML
    public TextField firstNameFie;

    @FXML
    public TextField lastNameFie;

    @FXML
    public TextField emailFie;

    @FXML
    public TextField SocialNumberFie;

    @FXML
    public TextField addressFie;

    @FXML
    public PasswordField passFie;

    @FXML
    public TextField cityFie;

    @FXML
    public TextField phoneFie;

    @FXML
    public TextArea CV;

    SignUp signUp = new SignUp();

    Database database = new Database();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            CV.setText(database.getCV(Login.email));
            addressFie.setText(database.getuserstreetaddress(Login.email));
            cityFie.setText(database.getusercity(Login.email));
            emailFie.setText(database.getEmail(Login.email));
            firstNameFie.setText(database.getusername(Login.email));
            lastNameFie.setText(database.getuseraftername(Login.email));
            passFie.setText(database.getPassword(Login.email));
            phoneFie.setText(database.getuserphone(Login.email));
            SocialNumberFie.setText(database.getuserSSN(Login.email));
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void getBack()throws Exception{
        Main.switcher.scene(Main.stage, "worker/worker.fxml");
    }
    public void save(){
        if (firstNameFie.getText().isEmpty()){
            System.out.println("Please fill in First Name");
            signUp.alert("Please fill in First Name");
        } else if (lastNameFie.getText().isEmpty()){
            System.out.println("Please fill in Last Name");
            signUp.alert("Please fill in Last Name");
        } else if (emailFie.getText().isEmpty()) {
            System.out.println("Please fill in E-mail");
            signUp.alert("Please fill in E-mail");
        } else if (addressFie.getText().isEmpty()) {
            System.out.println("Please fill in Address");
            signUp.alert("Please fill in Address");
        } else if (SocialNumberFie.getText().isEmpty()) {
            System.out.println("Please fill in Social Security Number");
            signUp.alert("Please fill in Social Security Number");
        } else if (passFie.getText().isEmpty()) {
            System.out.println("Please fill in Password");
            signUp.alert("Please fill in Password");
        } else if (phoneFie.getText().isEmpty()) {
            System.out.println("Please fill in Phone Number");
            signUp.alert("Please fill in Phone Number");
        } else if (cityFie.getText().isEmpty()) {
            System.out.println("Please fill in City");
            signUp.alert("Please fill in City");
        } else {
            database.updateEmployee(firstNameFie.getText(),lastNameFie.getText(),
                    addressFie.getText(),cityFie.getText(),phoneFie.getText(),CV.getText(),
                    SocialNumberFie.getText(),emailFie.getText(),passFie.getText());
            signUp.alert("Information updated");
        }
    }
}
