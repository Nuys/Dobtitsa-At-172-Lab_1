package sample.Classes;
import java.awt.event.ActionEvent;
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
    public ArrayList getNewDriver(String placeNumber,String fullName, String carModel, String availabilityOfCar, String payment){
        for(Driver driver:this.list){
            if(placeNumber.equals(driver.getPlaceNumber()) && driver.getFullName().equals("Неизвестно")){
                driver.setFullName(fullName);
                driver.setCarModel(carModel);
                driver.setAvailabilityOfCar(availabilityOfCar);
                driver.setPayment(payment);
            }
        }
        return this.list;
    }
    public ArrayList getDaraByFreePlace(){
        ArrayList<Driver> listOfAvailablePlace = new ArrayList<>();
      for(int i = 0 ; i < this.getList().size();i++){
          if(this.getList().get(i).getFullName().equals("Неизвестно")){
              listOfAvailablePlace.add(this.getList().get(i));
          }
      }
      return listOfAvailablePlace;
    }
public ArrayList getDataBySurname(String surname){
        ArrayList<Driver> listFindBySurname = new ArrayList<>();
        for(Driver driver:this.list)
        {
            if(driver.getFullName().contains(surname)){
                listFindBySurname.add(driver);
            }
        }
        return listFindBySurname;
}
public Driver deleteDriver(String surname){
        for(Driver driver : getList()){
            if(driver.getFullName().contains(surname)){
                getList().remove(driver);
                return driver;
            }
        }
        return null;
}

}
