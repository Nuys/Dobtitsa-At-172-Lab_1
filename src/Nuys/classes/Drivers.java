package Nuys.classes;
import java.util.Scanner;
public class Drivers {

    Scanner scanner = new Scanner(System.in);

    private Driver[] list;

    public Driver[] getList() {
        return list;
    }

    public Drivers() {
        Driver[] driver = new Driver[0];
    }

    public Drivers(int length) {
        this.list = new Driver[length];
    }

    public void add(Driver driver, int position) {
        this.list[position - 1] = driver;
    }

    private String number;
    private String surname;


    public String toString() {
        String drivers = "";
        for (Driver driver : this.list) {
            drivers += "Место на стоянке: " + driver.place_number + "\nИмя: " + driver.name + "\n Фамилия: " + driver.surname + "\nОтчество: " + driver.patronymic + "\nМодель автомобиля: " + driver.car_model + '\n' + "Наличие автомобиля на стоянке: " + driver.availability_of_car + '\n' + "Оплачено ли : " + driver.payment + '\n';

        }
        return drivers;
    }
/*
    public void print(){
        for (int i = 0; i < this.list.length;i++) {
            System.out.println( "Место на стоянке: " + this.list[i].place_number + "\nИмя: " +  this.list[i].name + "\n Фамилия: " + this.list[i].surname +"\nОтчество: "+ this.list[i].patronymic  + "\nМодель автомобиля: " +  this.list[i].car_model + '\n' + "Наличие автомобиля на стоянке: " +  this.list[i].availability_of_car + '\n' + "Оплачено ли : " +  this.list[i].payment + '\n');
        }
        backToMenu();
    }
*/

    /**
     * Метод который покажет нам неоплативших свое место водителей
     */
    String getDataByNotPayment() {
            String drivers = " ";
        for (Driver driver : this.list) {
            if (driver.payment == null && driver.name!= null) {
                drivers+= "\nМесто на стоянке: " + driver.place_number + "\nИмя: " + driver.name + "\nФамилия: " + driver.surname + "\nОтчество: " + driver.patronymic + "\nМодель автомобиля: " + driver.car_model + '\n' + " Оплата за текущий месяц: " + driver.payment + '\n' + "Наличие автомобиля на стоянке: " + driver.availability_of_car + '\n';
            }
        }
        return drivers;
    }

    /**
     * Метод который укажет  кол-во ободных мет на парковке
     */
    String listOfAvailableNumbers() {
        String drivers = "";
        for (Driver driver : this.list) {
            if (driver.name == null) {
                drivers += "Место № " + driver.place_number + " ;";
            }
        }
        return drivers;

    }


    /**
     * Метод который отвечает за удаление водителя из базы данных по фамилии(условие варианта)
     */
    public String removeBySurname(String surname_new) {
        boolean isFounded = false;
        for (int i = 0; i < this.list.length; i++) {
            if (surname_new.equals(this.list[i].surname)) {
                isFounded = true;
                this.list[i].name = null;
                this.list[i].surname = null;
                this.list[i].patronymic = null;
                this.list[i].car_model = null;
                this.list[i].payment = null;
                this.list[i].availability_of_car = null;
                return "Удаление выполнено успешно";
            }
        }
        return "Такой фамили не найдено!";
    }

    /**
     * Метод для добавления водителя на указанное место
     */
    public String addNewDriver(String place_number_new ,String name_new, String surname_new, String patronymic_new, String car_model_new, String availability_of_car_new, String payment_new) {
        for (int i = 0; i < this.list.length; i++) {
            if (place_number_new.equals(this.list[i].place_number)) {
                this.list[i].name = name_new;
                this.list[i].surname = surname_new;
                this.list[i].patronymic = patronymic_new;
                this.list[i].car_model = car_model_new;
                this.list[i].availability_of_car = availability_of_car_new;
                this.list[i].payment = payment_new;
                return "Добавление выполнено успешно";
            }

        }
        return " Место занято";
    }

    /**
     * Проверка на нахождения места в массиве и не занято ли оно
     * @param place_number переменная( место на парковке)
     * @return
     */
    public boolean IsInList(String place_number) {
        for (int i = 0 ; i<this.list.length; i++){
            if (place_number.equals(this.list[i].place_number)&&this.list[i].name == null)
                return true;
        }
        System.out.println("Место занято !");
        return false ;
    }
}