package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("authorization.fxml"));
        primaryStage.setTitle("Авторизация");
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    public static void VKApp() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("vkontakte.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("ВКонтакте");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
