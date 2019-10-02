package Nuys.classes;
import java.util.Scanner;
public class Main{
    private static Drivers drivers;
    public static void main(String[] argc){
        drivers = new Drivers (10);

        drivers.add(new Driver("1","Евгений","Добрица","Евгениевич","BMW","yes"),1);
        drivers.add(new Driver("2"),2);
        drivers.add(new Driver("3","Александр", "Зиеров"," Романович","Reno","yes","Неоплачено"),3);
        drivers.add(new Driver("4"),4);
        drivers.add(new Driver("5","Денис", "Арешкин", "Игоревич","Mercedes","yes","Оплачено"),5);
        drivers.add(new Driver("6"),6);
        drivers.add(new Driver("7","Борис","Грибанов","Александрович","BMW M5F90","yes","Оплачено"),7);
        drivers.add(new Driver("8"),8);
        drivers.add(new Driver("9"),9);
        drivers.add(new Driver("10","Анатолий","Петров","Васильевич","Vaz 21093","yes"),10);
        Menu();
    }
    static void Menu(){
        int menuNumber = 0;
        Scanner scanner = new Scanner(System.in);
        while(menuNumber==0){
            System.out.println("Выберите нужный пункт: " +
                    "\n1) Сведения о свободных местах на автостоянке" +
                    "\n2) Выдача сведений о неоплате" +
                    "\n3) Удаление с заданой фамилией" +
                    "\n4) Список всех водителей" +
                    "\n5) Добавить водителя" +
                    "\n6) Выход" +
                    "\nВведите цифру нужного пункта и нажмите Enter: ");
            boolean isCorrectly = false;
            String str="";
            while (!isCorrectly) {
                str = scanner.next();
                if (str.equals("1")||str.equals("2")||str.equals("3")||str.equals("4")||str.equals("5")||str.equals("6")) {
                    isCorrectly = true;
                }
                else
                    System.out.println("Введите корректное значение: ");
            }
            menuNumber = Integer.parseInt(str);
            switch (menuNumber){
                case 1: drivers.listOfAvailableNumbers(); break;
                case 2: drivers.getDataByNotPayment(); break;
                case 3: drivers.removeBySurname(); break;
                case 4: drivers.print(); break;
                case 5: drivers.addNewDriver();break;
                case 6: System.exit(0); break;
                default: System.out.println("Введите номер из списка выше!!!"); menuNumber=0;
            }

        }
    }
}
