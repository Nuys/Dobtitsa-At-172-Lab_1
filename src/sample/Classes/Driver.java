package sample.Classes;

import java.io.Serializable;
public class Driver implements Serializable {
    public String getPlaceNumber() {
        return place_number;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCarModel() {
        return car_model;
    }

    public String getAvailabilityOfCar() {
        return availability_of_car;
    }

    public String getPayment() {
        return payment;
    }

    public void setPlace_number(String place_number) {
        this.place_number = place_number;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public void setAvailability_of_car(String availability_of_car) {
        this.availability_of_car = availability_of_car;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    private String place_number;
    private String fullName;
    private String car_model;
    private String availability_of_car;
    private String payment;

    public Driver(final String place_number,final String fullName,final String car_model,final String availability_of_car,final String payment ){
    }
    public Driver(final String place_number){
        this.setPlace_number(place_number);
        this.setFullName("Пусто");
        this.setCar_model("Пусто");
        this.setAvailability_of_car("Пусто");
        this.setPayment("Пусто");
    }

}