package sample.Classes;
import java.util.ArrayList;
public class Drivers {
    public ArrayList<Driver> getList(){return list;}

    private ArrayList<Driver> list;

    public Drivers(){this.list = new ArrayList<>();}

    public Drivers(int length) {this.list = new ArrayList<>(length);}

    public ArrayList addToList(String placeNumber){
        if(!IsInList(placeNumber)){
            this.list.add(new Driver(placeNumber));
            return getList();
        }
        return null;
    }

    public boolean IsInList(String placeNumber) {
        for (Driver driver : this.list) {
            if (placeNumber.equals(driver.getPlaceNumber())) {
                return true;
            }
        }
        return false;
    }
    public void getNewDriver(String placeNumber,String fullName, String carModel, String availabilityOfCar, String payment){
        for(Driver driver:this.list){
            if(placeNumber.equals(driver.getPlaceNumber()) && driver.getFullName().equals("Неизвестно")){
                driver.setFullName(fullName);
                driver.setCarModel(carModel);
                driver.setAvailabilityOfCar(availabilityOfCar);
                driver.setPayment(payment);
            }
        }
    }

}
