package NuyseOOPLab_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] argc){
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(4);//создание обьекта класса окружность
        Circle circle_1 = new Circle(3);
        Circle circle_2 = new Circle(4);//создание обьекта класса окружность

        Cone cone1 = new Cone(5 ,4);
        Cone cone2 = new Cone(5 ,2);//Создание обьекта класса для конусов
        Cone cone_1 = new Cone(5 ,4);
        Cone cone_2 = new Cone(5 ,2);//Создание обьекта класса для конусов

        System.out.println(circle1.toString());//Вывод всей информации
        System.out.println(circle2.toString());
        System.out.println(circle_1.toString());//Вывод всей информации
        System.out.println(circle_2.toString());

        ArrayList<Circle> arr = new ArrayList<Circle>();//создание массива кругов
        arr.add(circle1);//добавление обьектов в массив
        arr.add(circle2);
        ArrayList<Circle> arraysOfCircles = new ArrayList<>();//создание массива кругов\
        arraysOfCircles.add(circle_1);//добавление обьектов в массив
        arraysOfCircles.add(circle_2);// System.out.println(arraysOfCircles.indexOf(circle1));// попытка пронумеровать каждую окружность , неудачная :(

        circle1.getLowCircle(arr);//метод для поиска кругов по условию
        circle_1.getLowCircle(arraysOfCircles);//метод для поиска кругов по условию

        ArrayList<Cone> arrcone = new ArrayList<Cone>();//создание массива конусов
        arrcone.add(cone1);
        arrcone.add(cone2);

        System.out.println(cone1.toString());
        System.out.println(cone2.toString());
        ArrayList<Cone> arraysOfCones = new ArrayList<>();//создание массива конусов
        arraysOfCones.add(cone_1);
        arraysOfCones.add(cone_2);
        System.out.println(" ");
        System.out.println(" Перейдем к конусам ");
        System.out.println(cone_1.toString());
        System.out.println(cone_2.toString());

        cone1.getMaxVolume(arrcone);//поиск максимального обьема среди имеющихся конусов
        cone_1.getMaxVolume(arraysOfCones);//поиск максимального обьема среди имеющихся конусов
    }
}