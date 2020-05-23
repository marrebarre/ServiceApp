package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.database.Database;
import sample.database.TestAvailability;

public class Main extends Application {

    public static Stage stage;
    public static SceneSwitcher switcher = new SceneSwitcher();


    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("login/login.fxml"));
        primaryStage.setTitle("Service App");
        Scene scene = new Scene(root, 1080, 720);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setMinWidth(1080);
        primaryStage.setMinHeight(720);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        /*TestAvailability testAvailability=new TestAvailability();
        testAvailability.insert();
        testAvailability.putasavailable("mo@hotmail.com");

         */
    }


    public static void main(String[] args) {
        launch(args);
    }
}
