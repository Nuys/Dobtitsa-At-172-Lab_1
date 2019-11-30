package sample.Classes;
import java.io.Serializable;
import sample.Enums.AvailabilityOfCarClass;
import sample.Enums.PaymentClass;


public class Driver implements Serializable
{
    private String placeNumber;
    private String fullName;
    private String carModel;
    private String availabilityOfCar;
    private String payment;

    public String getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(String placeNumber) {
        this.placeNumber = placeNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getAvailabilityOfCar() {
        return availabilityOfCar;
    }

    public void setAvailabilityOfCar(String availabilityOfCar) {
        this.availabilityOfCar = availabilityOfCar;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    public Driver(final String placeNumber, final String fullName, final String carModel,final String availabilityOfCar,final String payment){
        this.setPlaceNumber(placeNumber);
        this.setFullName(fullName);
        this.setCarModel(carModel);
        this.setAvailabilityOfCar(availabilityOfCar.toString());
        this.setPayment(payment.toString());
    }

    public Driver(final String placeNumber) {
        this.setPlaceNumber(placeNumber);
        this.setFullName("Неизвестно");
        this.setCarModel("Неизвестно");
        this.setAvailabilityOfCar("Неизвестно");
        this.setPayment("Неизвестно");
    }
}
