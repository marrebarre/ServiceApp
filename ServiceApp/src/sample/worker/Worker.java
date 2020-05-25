package sample.worker;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import sample.Main;
import sample.Order.Order;
import sample.Order.Tasks;
import sample.database.Database;
import sample.login.Login;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Worker implements Initializable {
    ArrayList<Tasks>arrayList=new ArrayList<>();
    int counter=0;
    @FXML
    Label phoneid=new Label();
    @FXML
    Text addressid=new Text();
    @FXML
    Text jobid=new Text();
    @FXML
    Label Dateid=new Label();

    @FXML
    TextArea specid=new TextArea();

    Database database = new Database();

    @FXML
    void editProfile(ActionEvent event) throws Exception {
            Main.switcher.scene(Main.stage, "worker/editProfile.fxml");

    }
    public void deleteorder(){
        if (counter>=0) {
            if (!arrayList.isEmpty()) {
                database.deletefromorders(arrayList.get(counter).getId());
                arrayList.remove(counter);
                counter = counter - 1;

                next();
            }

        }
        if (counter<0){
            counter=0;
        }

    }
    public void next() {
        if (!arrayList.isEmpty()){
            counter++;
        if (counter == arrayList.size()) {
            counter = 0;
        }
        addressid.setText("Address: " + arrayList.get(counter).getAddress());
        jobid.setText("tittle: " + arrayList.get(counter).getTittle());
        Dateid.setText("Due: " + arrayList.get(counter).getDate());
        specid.setText(arrayList.get(counter).getSpec());
        phoneid.setText(arrayList.get(counter).getPhone());
    }else {
            addressid.setText("Address");
            jobid.setText("tittle");
            Dateid.setText("Due");
            specid.setText("");
            phoneid.setText("");
        }

    }

    public void exit(){
        database.notAvailable();
        Platform.exit();
    }

    public void back()throws Exception{
        Main.switcher.fsMode = Main.stage.isFullScreen();
        Main.switcher.scene(Main.stage,"login/Login.fxml");
    }

    public void fullscreen() throws Exception{
        Main.switcher.fullscreen(Main.stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

           arrayList= database.tasksgetmytasks(database.getemployeeid(Login.email));
            System.out.println(Login.email);
           if (arrayList.size()>0){
               addressid.setText("Address: "+arrayList.get(counter).getAddress());
               jobid.setText("tittle: "+arrayList.get(counter).getTittle());
               Dateid.setText("Due: "+arrayList.get(counter).getDate());
               specid.setText(arrayList.get(counter).getSpec());
               phoneid.setText(arrayList.get(counter).getPhone());
           }
           counter++;
           if (counter==arrayList.size()){
               counter=0;
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
