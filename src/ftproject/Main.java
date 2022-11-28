/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package ftproject;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        // set scene configuration
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Scene scene = new Scene(root);
        // configure stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Convertor dB");
        primaryStage.getIcons().add(new Image("/view/Icon.png"));
        primaryStage.centerOnScreen();
        primaryStage.setMinWidth(420);
        primaryStage.setMinHeight(240);
        // show stage
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
