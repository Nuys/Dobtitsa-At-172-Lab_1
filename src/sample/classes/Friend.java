package sample.classes;

public class Friend {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String name;
    private String city;
    private String nickname;

    public Friend(String name, String city, String nickname){
        this.name = name;
        this.city = city;
        this.nickname = nickname;
    }
}
