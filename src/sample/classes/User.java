package sample.classes;

public class User {

    private String city;
    private String country;
    private String username;
    private String sex;
    private String id;
    private String name;
    private String surname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User(){

    }

    public User(String id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public User(String name, String surname, String city, String country, String username, String sex){
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.country = country;
        this.username = username;
        this.sex = sex;
    }

}

