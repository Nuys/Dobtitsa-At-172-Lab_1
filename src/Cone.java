import java.util.ArrayList;

import lombok.Setter;
import lombok.Getter;

public class Cone extends Circle {
    private static final  String DEFAULT_FORMAT = "%6.2f";//формат
    public Cone(double radius, double height) {
        super(radius);//конструктор родительского класса (класа Circle)
        isCorrect(height);//вызов метода для проверки входных данных( только высоты т.к радиус провериться  в родительском Классе
        this.height = height;
    }

    @Setter @Getter double height;

    /*
    Найдем площадь , обьем и максимальный обьем среди конусов (по условию) соотв. методы
    getSquare, getVolume, getMaxVolume
     */
    @Override
    public double getSquare(){
        double L = Math.pow(Radius,2) + Math.pow(this.height,2);
        return L * Radius * 3.14159;
    }
    private double getVolume(){
        double doubleRadius = Math.pow(Radius,2);
        return (doubleRadius * 3.14159 * this.height)/3;
    }
    void getMaxVolume(ArrayList<Cone> cone){
            double maxStatement = cone.get(0).getVolume();
            for(Cone i : cone) {
                if ( i.getVolume()>maxStatement){
                    maxStatement = i.getVolume();
                }
            }

        System.out.println(" Нйбольший обьем среди конусов  :" + String.format(DEFAULT_FORMAT,maxStatement));
    }
    /*
    Переопределим метод toString , т.к. по дефолту он выводит информацию об обьекте .
     */
    @Override
    public String toString (){
        return
                " Радиус окружности конуса : "+ Radius +
                " , Площадь конуса : " + String.format(DEFAULT_FORMAT, getSquare())+
                " , Длина окружности конуса : " + String.format(DEFAULT_FORMAT,longCircle()) +
                " , Высота конуса : " + this.height +
                " , Обьем конуса : " + String.format(DEFAULT_FORMAT, getVolume()) +
                        " ;";
        }

}
