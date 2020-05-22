package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class SceneSwitcher {

    public boolean fsMode = true;

        public void scene(Stage window, String filePath)throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource(filePath));
            window.setTitle("Service App");
            window.setScene(new Scene(root, 1080, 720));
            window.setMinWidth(1080);
            window.setMinHeight(720);
            window.setResizable(true);
            window.setFullScreen(fsMode);
            window.show();
        }

    public void fullscreen(Stage window)throws Exception{

        if (window.isFullScreen()){
            window.setFullScreen(false);
            fsMode = false;
        } else{
            window.setFullScreen(true);
            fsMode = true;
        }

    }

    public static void alert(String message){
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
