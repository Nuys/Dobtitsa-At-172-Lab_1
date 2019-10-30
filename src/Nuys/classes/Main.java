package Nuys.classes;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static Drivers drivers;

    public static void main(String[] argc) throws IOException,ClassNotFoundException {
        drivers = new Drivers(10);

        drivers.add(new Driver("1", "Евгений", "Добрица", "Евгениевич", "BMW", "yes"), 1);
        drivers.add(new Driver("2"), 2);
        drivers.add(new Driver("3", "Александр", "Зиеров", " Романович", "Reno", "yes", "Неоплачено"), 3);
        drivers.add(new Driver("4"), 4);
        drivers.add(new Driver("5", "Денис", "Арешкин", "Игоревич", "Mercedes", "yes", "Оплачено"), 5);
        drivers.add(new Driver("6"), 6);
        drivers.add(new Driver("7", "Борис", "Грибанов", "Александрович", "BMW M5F90", "yes", "Оплачено"), 7);
        drivers.add(new Driver("8"), 8);
        drivers.add(new Driver("9"), 9);
        drivers.add(new Driver("10", "Анатолий", "Петров", "Васильевич", "Vaz 21093", "yes"), 10);
        Menu();
    }

    public static void Menu() throws IOException,ClassNotFoundException {
        int menuNumber;
        Scanner scanner = new Scanner(System.in);
        Driver driver = new Driver();
        Serialization serialization = new Serialization("D://Drivers.txt");
        while (true) {
            System.out.println("Выберите нужный пункт: " +
                    "\n1) Сведения о свободных местах на автостоянке" +
                    "\n2) Выдача сведений о неоплате" +
                    "\n3) Удаление с заданой фамилией" +
                    "\n4) Список всех водителей" +
                    "\n5) Добавить водителя" +
                    "\n6) Записать данные в файл " +
                    "\n7) Считать данные из файла" +
                    "\n8) Очистка списка" +
                    "\n0) Выход" +
                    "\nВведите цифру нужного пункта и нажмите Enter: ");
            boolean isCorrectly = false;
            String tempMenuNumber = "";
            while (!isCorrectly) {
                tempMenuNumber = scanner.next();
                scanner.nextLine();
                if (tempMenuNumber.matches("[1-6,0]{1}")) {
                    isCorrectly = true;
                } else {
                    System.out.println("Введите корректное значение: ");
                }
            }
            menuNumber = Integer.parseInt(tempMenuNumber);
            switch (menuNumber) {
                case 1: {
                    System.out.println(drivers.listOfAvailableNumbers());
                }break;
                case 2: {
                    System.out.println(drivers.getDataByNotPayment());
                }break;
                case 3: {
                    isCorrectly = false;
                    while (!isCorrectly) {
                        String surname_new;
                        System.out.println("Введите фамилию водителя которого хотите удалить ");
                        surname_new = scanner.next();
                        if (surname_new.matches("[А-Я][а-я]{1,15}")) {
                            System.out.println(drivers.removeBySurname(surname_new));
                            isCorrectly = true;
                        } else {
                            System.out.println("Фамилия введена в неправельном формате, проверте список водителей !");
                        }
                    }
                }
                break;
                case 4: {
                    System.out.println(drivers.toString());
                }
                break;
                case 5: {
                    isCorrectly = false;
                    String place_number;
                    while (!isCorrectly) {
                        System.out.println("Введите номер места на которое хотите добавить водителя: ");
                        place_number = scanner.next();
                        if (place_number.matches("[0-9]{1,2}")) {
                            if(drivers.IsInList(place_number)) {
                                System.out.println("Введите данные нового водителя");
                                System.out.println("Введите имя нового водителя:");
                                String name_new = scanner.next();
                                System.out.println("Введите фамилию нового водителя:");
                                String surname_new = scanner.next();
                                System.out.println("Введите отчество ");
                                String patronymic_new = scanner.next();
                                System.out.println("Введите модель автомобиля");
                                String car_model_new = scanner.next();
                                System.out.println("Введите оплату автомобиля");
                                String payment_new = scanner.next();
                                System.out.println("Наличие автомобиля на стоянке");
                                String availability_of_car_new = scanner.next();
                                drivers.addNewDriver(place_number, name_new, surname_new, patronymic_new, car_model_new, payment_new, availability_of_car_new);
                                isCorrectly = true;
                            }
                        } else {
                            System.out.println("Фамилия введена в  неверном формате, повторите ввод: ");
                        }
                    }
                }
                break;
                case 6:
                    System.out.println(serialization.Serialization(drivers));;
                    break;
                case 7:{
                    System.out.println(serialization.Deserialization(drivers));
                }break;
                case 8:{
                    drivers.list.clear();
                }break;
                case 0: System.exit(0);break;
            }
        }
    }
}

