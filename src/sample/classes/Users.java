package sample.classes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> list;
    private JSONGetter jsonGetter = new JSONGetter();

    public Users(){
        list = new ArrayList<>();
    }


    public void add(User user){
        this.list.add(user);
    }

    public User getUser(String id, String jsonString){
        User user = null;

        String str = jsonGetter.jsonIn;
        Object object = null;
        try {
            object = new JSONParser().parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = (JSONObject)object;
        JSONArray jsonArray = (JSONArray) jsonObject.get("response");
        if(object!=null) {
            for (Object objectResponse : jsonArray) {
                JSONObject current = (JSONObject) objectResponse;
                String name = (String) current.get("first_name");
                String surname = (String) current.get("last_name");
            }
        }
        return user;
    }

    public long setOffline(String jsonString){
        Object object = null;
        try {
            object = new JSONParser().parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = (JSONObject) object;
        long offline = (long)jsonObject.get("response");
        return offline;
    }

    public AccountInfo getCounters(String jsonString){
        long app_requests = 0;
        long friends = 0;
        long friends_recommendations = 0;
        long messages = 0;

        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject)new JSONParser().parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject responseArr = (JSONObject) jsonObject.get("response");
        if(responseArr!=null) {
            friends = (long) responseArr.get("friends");
//            friends_recommendations = (long) responseArr.get("friends_recommendations");
            messages  = (long) responseArr.get("messages");
        }
        return new AccountInfo(app_requests, friends, friends_recommendations, messages);
    }

    public User getProfile(String jsonString) {

        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) new JSONParser().parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject responseArr = (JSONObject) jsonObject.get("response");

        String name = (String) responseArr.get("first_name");
        String surname = (String) responseArr.get("last_name");
        JSONObject cityArr = (JSONObject) responseArr.get("city");
        String city = (String) cityArr.get("title");
        JSONObject countryArr = (JSONObject) responseArr.get("country");
        String country = (String) countryArr.get("title");
        String username = (String) responseArr.get("screen_name");
        long sexNum = (long) responseArr.get("sex");
        String sex = null;
        switch ((int) sexNum){
            case 1: sex = "Женский"; break;
            case 2: sex = "Мужской"; break;
            default: sex = "Не выбрано"; break;
        }
        return new User(name, surname, city, country, username, sex);
    }

    public long getFriends(String jsonString){
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject)new JSONParser().parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject responseArr = (JSONObject) jsonObject.get("response");
        long countFriends = 0;
        countFriends = (long)responseArr.get("count");
        return countFriends;
    }

    public ArrayList<Friend> getAllFriends(String jsonString){
        ArrayList<Friend> list = new ArrayList<>();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject)new JSONParser().parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject responseArr = (JSONObject) jsonObject.get("response");
        JSONObject itemsArr = (JSONObject) responseArr.get("items");
        Object obj = itemsArr;
        JSONArray jsonArray = (JSONArray)obj;

        for (Object friend:jsonArray) {
            JSONObject current = (JSONObject) friend;
            String name = (String) current.get("first_name");
            String surname = (String) current.get("last_name");
            JSONObject cityArr = (JSONObject)current.get("city");
            String city = (String)cityArr.get("title");
            JSONObject countryArr = (JSONObject) current.get("country");
            String country = (String) countryArr.get("title");
            list.add(new Friend(name+" "+surname, city, country));
        }
        return list;
    }
}