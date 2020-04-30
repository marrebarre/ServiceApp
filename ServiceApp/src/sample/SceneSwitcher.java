package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {

        public void scene(Stage window, String filePath)throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource(filePath));
            window.setTitle("Service App");
            window.setScene(new Scene(root, 610, 500));
            window.setMinWidth(500);
            window.setMinHeight(400);
            window.setResizable(false);
            window.setFullScreen(true);
            window.show();
        }
}
