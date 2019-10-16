package Nuys.classes;
import java.util.Scanner;
import java.util.ArrayList;
public class Drivers {

    Scanner scanner = new Scanner(System.in);

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

    public boolean equalsNew(String str1,String str2) {
        System.out.println("Проверка на совпадение: " + str1.indexOf(str2) + " == " + str1 );
        return str1 ==  str2;
    }

    public void print(){
        for (Driver driver : list) {
            System.out.println( "Место на стоянке: " + driver.place_number + "\nИмя: " +  driver.name + "\n Фамилия: " + driver.surname +"\nОтчество: "+ driver.patronymic  + "\nМодель автомобиля: " +  driver.car_model + '\n' + "Наличие автомобиля на стоянке: " +  driver.availability_of_car + '\n' + "Оплачено ли : " +  driver.payment + '\n');
        }
        backToMenu();
    }

    /**
     * Метод который покажет нам неоплативших свое место водителей
     */
    public void getDataByNotPayment(){
        for(Driver driver : this.list){
            if(driver.payment == null&&driver.name!=null){
                System.out.println("\nМесто на стоянке: " + driver.place_number + "\nИмя: " +  driver.name + "\n Фамилия: " + driver.surname +"\nОтчество: "+ driver.patronymic  + "\nМодель автомобиля: " +  driver.car_model + '\n' + "Наличие автомобиля на стоянке: " +  driver.availability_of_car );
            }
        }
        backToMenu();
    }

    /**
     * Метод который укажет свободные места на парковке
     */
    public void listOfAvailableNumbers(){
        for (Driver driver : this.list) {
            if (driver.name == null && driver.surname == null && driver.payment == null && driver.availability_of_car == null && driver.car_model == null) {
                System.out.println("Свободное место: " + driver.place_number );
            }
        }
        backToMenu();
    }
/**
 * Первый вариант удаления , удаляет не водителя а полностью ячейку массива.
 */
  /* public void removeByName(){      //Изначальный вариант удаления , чуть погодя подумав решил что удалять полностью парковочное место абсурдно.
 было решено создать новый метод , на а этот велосипед оставлю тут , склеивание 2 половинок массива в одно целое та еще .....
       System.out.println("Введите фамилию удаляймого :");
       String fullName = scanner.next();
      for(int i = 0; i<this.list.length;i++){
          if(this.list[i].surname.equals(fullName)){
              System.out.println("work" );
              int index = i;
             newtwomassive(index);
             break;
          }
      }
      backToMenu();
   }
  public void newtwomassive(int index){

      Driver[] list2 = Arrays.copyOfRange(list,0,index);
      Driver[] list3 = Arrays.copyOfRange(list,index+1 , list.length);
      Driver[] array1and2 = new Driver[list2.length + list3.length];
      System.arraycopy(list2, 0, array1and2, 0, list2.length);
      System.arraycopy(list3, 0, array1and2, list2.length, list3.length);
      this.list  = array1and2;
  }*/

    /**
     * Метод который отвечает за удаление водителя из базы данных по фамилии(условие варианта)
     */
    public void removeBySurname(){
        boolean isFounded = false;
        System.out.println("Введите фамилию водителя, которго хотите удалить : ");
        surname = scanner.next();
        scanner.nextLine();
        for(Driver driver : list){
                isFounded = true;
                driver.name = null;
                driver.surname = null;
                driver.patronymic = null;
                driver.car_model = null;
                driver.payment = null;
                driver.availability_of_car = null;
                System.out.println("Удаление выполнено");
                backToMenu();
        }
        System.out.println("Фамилия не найден в базе");
        backToMenu();
    }

    /**
     * Метод для добавления водителя после указаной фамилии(условие варианта)
     */
    public void addNewDriver() {
        boolean isFounded = false;
        System.out.println("Введите фамилию  водителя, после которого хотите добавить нового водителя: ");
        surname = scanner.next();
        scanner.nextLine();
        for (Driver driver : list){
            if (surname.equals(driver.surname )) {
                isFounded = true;
                System.out.println("Введите имя водителя");
                driver.name = scanner.nextLine();
                System.out.println("Введите фамилию водителя");
                driver.surname = scanner.nextLine();
                System.out.println("Введите отчество водителя");
                driver.patronymic = scanner.nextLine();
                System.out.println("Марка автомобиля");
                driver.car_model = scanner.nextLine();
                System.out.println("Наличие машины на стоянке (да,нет)");
                driver.availability_of_car = scanner.nextLine();
                System.out.println("Оплачено ли (да,нет)");
                driver.payment = scanner.nextLine();
                System.out.println("Добавление выполнено успешно");
                backToMenu();
            }

        }
        System.out.println("Такой водитель не найден ! ");
        backToMenu();
    }

    /**
     * Метод backToMenu , возвращение в меню
     */
    public void backToMenu(){
        int result = -1;
        while (result<0||result>1) {
            System.out.println("Вернуться в меню? (1 - да, 0 - нет)");
            result = Integer.parseInt(scanner.next());
            if (result == 1)
                Main.Menu();
        }
    }
}
