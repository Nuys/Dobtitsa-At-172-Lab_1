package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Авто-стоянка");
        primaryStage.setScene(new Scene(root, 752, 405));
        primaryStage.setResizable(false);
        primaryStage.show();


        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });
    }
 public static void inputPlaceNumber(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/inputPlaceNumber.fxml"));
           Parent inputPlaceNumber = fxmlLoader.load();
           Stage stage = new Stage();
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.initStyle(StageStyle.UNDECORATED);
           stage.setTitle("Окно ввода мест");
           stage.setScene(new Scene(inputPlaceNumber));
           stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
 }
 public static void inputDriver(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/inputDriver.fxml"));
            Parent inputDriver = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Окно добавление водителя");
            stage.setScene(new Scene(inputDriver));
            stage.showAndWait();
        } catch (IOException e){
            e.printStackTrace();
        }
 }
    public static void inputSurname(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/inputSurname.fxml"));
            Parent inputSurname = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Окно ввода");
            stage.setScene(new Scene(inputSurname));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
