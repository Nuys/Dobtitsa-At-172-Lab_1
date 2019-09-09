import java.util.ArrayList;

public class Main {
    public static void main(String[] argc){
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(4);//создание обьекта класса окружность

        Cone cone1 = new Cone(5 ,4);
        Cone cone2 = new Cone(5 ,2);//Создание обьекта класса для конусов

        System.out.println(circle1.toString());//Вывод всей информации
        System.out.println(circle2.toString());

        ArrayList<Circle> arr = new ArrayList<Circle>();//создание массива кругов
        arr.add(circle1);//добавление обьектов в массив
        arr.add(circle2);

        circle1.getLowCircle(arr);//метод для поиска кругов по условию

        ArrayList<Cone> arrcone = new ArrayList<Cone>();//создание массива конусов
        arrcone.add(cone1);
        arrcone.add(cone2);

        System.out.println(cone1.toString());
        System.out.println(cone2.toString());

        cone1.getMaxVolume(arrcone);//поиск максимального обьема среди имеющихся конусов
    }
}
