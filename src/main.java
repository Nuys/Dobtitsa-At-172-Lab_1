import java.util.ArrayList;

public class main {
    public static void main(String[] argc){
        Circle test = new Circle(2);
        Circle test_3 = new Circle(4);
        Cone test_4 = new Cone(5 ,4);
        Cone test_2 = new Cone(3 ,2);//Создание обьекта
       /* ArrayList<Circle> arr = new ArrayList<Circle>();
        arr.add(test);
        arr.add(test_3);
        test.getLowCircle(arr);*/
        ArrayList<Cone> arrcone = new ArrayList<Cone>();
        arrcone.add(test_4);
        arrcone.add(test_2);
        test_2.getMaxVolume(arrcone);
        System.out.println(test_2.getVolume());
    }
}
