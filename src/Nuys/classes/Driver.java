package Nuys.classes;
public class Driver{
    String place_number;
    String name;
    String surname;
    String patronymic;
    String car_model;
    String availability_of_car;
    String payment;

public Driver(){
}
    /**
     * Конструктор для опредиления элемнтов массива
     * @param place_number место на стоянке
     * @param name имя водителя
     * @param surname фамилия водителя
     * @param patronymic отчество водителя
     * @param car_model марка машины
     * @param availability_of_car наличие машины на автостоянке
     * @param payment     оплата за текущий месяц
     */
    public Driver(String place_number, String name,String surname,String patronymic, String car_model, String availability_of_car, String payment) {
        this.place_number = place_number;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.car_model = car_model;
        this.availability_of_car = availability_of_car;
        this.payment = payment;
    }

    /**
     * Конструктор для пустых мест на парковке
     * @param place_number переменная ответ. за номер места
     */
    public Driver(String place_number) {
        this.place_number = place_number;
        this.name = null;
        this.surname = null;
        this.patronymic = null;
        this.car_model =  null;
        this.availability_of_car = null;
        this.payment = null;
    }

    /**
     * Конструктор для пустого поля неоплаты (условия задания , (неоплатившие))
     * @param place_number
     * @param name
     * @param surname
     * @param patronymic
     * @param car_model
     * @param availability_of_car
     */
    public Driver(String place_number, String name,String surname,String patronymic, String car_model, String availability_of_car){
    this.place_number = place_number;
    this.name = name;
    this.surname = surname;
    this.patronymic = patronymic;
    this.car_model = car_model;
    this.availability_of_car = availability_of_car;
    this.payment = null;
    }
    public Driver( String name,String surname,String patronymic, String car_model, String availability_of_car) {
        this.place_number = null;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.car_model = car_model;
        this.availability_of_car = availability_of_car;
        this.payment = null;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
}
