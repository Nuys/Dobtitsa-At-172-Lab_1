import java.util.ArrayList;

public class Main {
    public static void main(String[] argc){
        Circle circle_1 = new Circle(3);
        Circle circle_2 = new Circle(4);//создание обьекта класса окружность

        Cone cone_1 = new Cone(5 ,4);
        Cone cone_2 = new Cone(5 ,2);//Создание обьекта класса для конусов

        System.out.println(circle_1.toString());//Вывод всей информации
        System.out.println(circle_2.toString());

        ArrayList<Circle> arraysOfCircles = new ArrayList<>();//создание массива кругов\
        arraysOfCircles.add(circle_1);//добавление обьектов в массив
        arraysOfCircles.add(circle_2);// System.out.println(arraysOfCircles.indexOf(circle1));// попытка пронумеровать каждую окружность , неудачная :(

        circle_1.getSmallestCircle(arraysOfCircles);


        ArrayList<Cone> arraysOfCones = new ArrayList<>();//создание массива конусов
        arraysOfCones.add(cone_1);
        arraysOfCones.add(cone_2);
        System.out.println(" ");
        System.out.println(" Перейдем к конусам ");
        System.out.println(cone_1.toString());
        System.out.println(cone_2.toString());

        cone_1.getMaxVolume(arraysOfCones);//поиск максимального обьема среди имеющихся конусов
    }
}
