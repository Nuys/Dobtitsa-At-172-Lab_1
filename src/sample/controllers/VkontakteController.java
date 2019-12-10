package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.classes.*;

import java.util.Timer;
import java.util.TimerTask;

public class VkontakteController {

    @FXML
    private TableColumn<Friend, String> name;
    @FXML
    private TableColumn<Friend, String> city;
    @FXML
    private TableColumn<Friend, String> country;
    @FXML
    private ImageView imgAvatar;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtNickname;
    @FXML
    private TextField txtFriends;
    @FXML
    private TextField txtMessages;
    @FXML
    private Button btnOffline;
    @FXML
    private TextField txtStateOnline;
    @FXML
    private TableView tableFriends;

    private Users users;
    private JSONGetter jsonGetter;
    private String token;
    private long id;
    private Proxys proxys = new Proxys();
    private ObservableList<Friend> list = FXCollections.observableArrayList();
    private Friends friends;

    @FXML
    public void initialize(){
        friends = new Friends();
        name.setCellValueFactory(new PropertyValueFactory<Friend, String>("name"));
        city.setCellValueFactory(new PropertyValueFactory<Friend, String>("city"));
        country.setCellValueFactory(new PropertyValueFactory<Friend, String>("country"));
        tableFriends.setItems(list);
        new Thread(){
            ClassExecutingTask classExecutingTask = new ClassExecutingTask(proxys);
        };
        token = Authorization.token;
        id = Authorization.id;
        users = new Users();

        updateTxtProxy();
        list.addAll(friends.getListFriends());
    }

    public void getInfo(){
        String response = "";
        String jsonString = "";

        response = "https://api.vk.com/method/account.getProfileInfo?v=5.62&access_token="+token;
        jsonString  = responseData(response);
        User user = users.getProfile(jsonString);

        response = "https://api.vk.com/method/account.getCounters?v=5.103&access_token="+token;
        jsonString = responseData(response);
        AccountInfo accountInfo = users.getCounters(jsonString);

        response = "https://api.vk.com/method/friends.get?user_id="+id+"&count=0&offset=0&v=5.103&access_token=" + token;
        jsonString = responseData(response);
        long countFriends = users.getFriends(jsonString);

        response = "https://api.vk.com/method/friends.get?user_id="+id+"&count="+countFriends+"&fields=city,country&offset=0&v=5.103&access_token="+token;
        jsonString = responseData(response);
        friends.getListFriends().addAll(users.getAllFriends(jsonString));
        list.addAll(friends.getListFriends());

        txtName.setText(user.getName()+" "+user.getSurname());
        txtNickname.setText("@"+user.getUsername());
        txtFriends.setText("Друзей: "+ countFriends);
        txtMessages.setText("Сообщений: " + accountInfo.getMessages());
    }

    private void updateTxtProxy() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(!proxys.getListProxyHTTP().isEmpty()) {
                    getInfo();
                }
            }
        };
        Timer timer = new Timer("Timer");
        long delay  = 1000L;
        long period = 1000L;
        timer.scheduleAtFixedRate(timerTask, delay, period);
    }

    private String responseData(String response){
        jsonGetter = new JSONGetter(response, proxys);
        jsonGetter.run();
        return jsonGetter.jsonIn;
    }

    public void setOffline(MouseEvent mouseEvent) {
        String response = "https://api.vk.com/method/account.setOffline?v=5.103&access_token="+token;
        String jsonString = responseData(response);
        if(users.setOffline(jsonString)==1) {
            txtStateOnline.setText("Offline");
        }
    }
}
