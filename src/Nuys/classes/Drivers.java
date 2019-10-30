package Nuys.classes;
import java.util.ArrayList;
public class Drivers {
    ArrayList<Driver> list;

    public Drivers(){
        this.list = new ArrayList<>();
    }
    public Drivers(int length){
        this.list = new ArrayList<>(length);
    }
    public void add(Driver driver, int position) {
        list.add(driver);
    }
    private String number;
    private String surname;


    /**
     * Function print to display
     */
    @Override
    public String toString(){
        String drivers = "";
        for (Driver driver : this.list){
            drivers += ( "Место на стоянке: " + driver.place_number + "\nИмя: " +  driver.name + "\n Фамилия: " + driver.surname +"\nОтчество: "+ driver.patronymic  + "\nМодель автомобиля: " +  driver.car_model + '\n' + "Наличие автомобиля на стоянке: " +  driver.availability_of_car + '\n' + "Оплачено ли : " +  driver.payment + '\n');
        }
        return drivers;
    }


    /**
     * Метод который покажет нам неоплативших свое место водителей
     */
    String getDataByNotPayment(){
        String drivers = "";
        for(Driver driver : this.list){
            if(driver.payment == null&&driver.name!=null){
                drivers+=  "\nМесто на стоянке: " + driver.place_number + "\nИмя: " +  driver.name + "\n Фамилия: " + driver.surname +"\nОтчество: "+ driver.patronymic  + "\nМодель автомобиля: " +  driver.car_model + '\n' + "Наличие автомобиля на стоянке: " +  driver.availability_of_car +'\n'+"Оплата за текущий месяц: "+ driver.payment+'\n';
            }

        }
        return drivers;
    }

    /**
     * Метод который укажет свободные места на парковке
     */
    public  String listOfAvailableNumbers(){
        String drivers = "";
        for (Driver driver : this.list) {
            if (driver.name == null ) {
                drivers += "Место № " + driver.place_number + " ;";
            }
        }
        return drivers;
    }


    /**
     * Метод который отвечает за удаление водителя из базы данных по фамилии(условие варианта)
     */
    public String removeBySurname(String surname_new){
        boolean isFounded = false;
        System.out.println("Введите фамилию водителя, которго хотите удалить : ");
        for(Driver driver : list) {
            if (surname_new.equals(driver.surname)) {
                isFounded = true;
                driver.name = null;
                driver.surname = null;
                driver.patronymic = null;
                driver.car_model = null;
                driver.payment = null;
                driver.availability_of_car = null;
                return "Удаление выполнено успешно";
            }
        }
        return "Такой фамилии не найдено";
    }

    /**
     * Метод для добавления водителя после указаной фамилии(условие варианта)
     */
    public String addNewDriver(String place_number_new, String name_new , String surname_new, String patronymic_new, String car_model_new, String availability_of_car_new, String payment_new) {
        for (Driver driver : this.list){
            if (place_number_new.equals(driver.place_number )) {
                driver.name = name_new;
                driver.surname = surname_new ;
                driver.patronymic = patronymic_new ;
                driver.car_model = car_model_new;
                driver.payment = payment_new;
                driver.availability_of_car = availability_of_car_new;
                return "Добавление выполнено успешно ";
            }

        }
        return " Что то пошло не так ";
    }

    /**
     *Метод для проверки свободно ли место
     * @param place_number номер парковочного места
     * @return
     */
    public boolean IsInList(String place_number) {
        for (Driver driver:this.list){
            if (driver.name ==null && place_number.equals(driver.place_number))
                return true;
        }
        return false ;
    }
}
