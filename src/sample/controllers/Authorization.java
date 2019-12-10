package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.Main;
import sample.classes.*;

import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class Authorization {

    @FXML
    private TextField txtQuantityProxy;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;

    public static String login;
    public static String password;
    public static String token;
    public static long id;
    private static Proxys proxys = new Proxys();

    @FXML
    public void initialize(){
        new Thread(){
            ClassExecutingTask classExecutingTask = new ClassExecutingTask(proxys);
        };
        updateTxtProxy();
    }

    public void onMouseClicked(MouseEvent mouseEvent) throws IOException {
        String login = txtLogin.getText();
        String password = txtPassword.getText();
        String result = null;
        if (!login.equals("") && !password.equals("")) {
            String urlAuthorization = "https://oauth.vk.com/token?grant_type=password&client_id=3697615&client_secret=AlVXZFMUqyrnABp8ncuU&username="+login+"&password="+password+"&v=5.103&2fa_supported=1";
            JSONGetter jsonGetter = new JSONGetter(urlAuthorization, proxys);
            jsonGetter.run();
            result = jsonGetter.jsonIn;
        }
        Object object = null;
        if(!result.equals("")) {
            try {
                object = new JSONParser().parse(result);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        JSONObject jsonObject = (JSONObject)object;
        if(jsonObject!=null) {
            token = (String) jsonObject.get("access_token");
            id = (long) jsonObject.get("user_id");
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.close();
            Main.VKApp();

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка входа");
            alert.setHeaderText("Авторизация");
            alert.setContentText("Неверный логин или пароль");
            alert.showAndWait();
        }
    }

    public void updateTxtProxy(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(!proxys.getListProxyHTTP().isEmpty()) {
                    txtQuantityProxy.setText(String.valueOf(proxys.getListProxyHTTP().size()));
                }
            }
        };
        Timer timer = new Timer("Timer");
        long delay  = 1000L;
        long period = 1000L;
        timer.scheduleAtFixedRate(timerTask, delay, period);
    }
}
