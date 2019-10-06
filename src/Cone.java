import java.util.ArrayList;

import lombok.Setter;
import lombok.Getter;

public class Cone extends Circle {
    /**
     * Конструктор
     * @param radius наследуем из Круга
     * @param height высота конуса
     */
    public Cone(double radius, double height) {
        super(radius);
        isCorrect(height);
        this.height = height;
    }

    @Setter @Getter double height;

    /**
     * Метод для нахождения площади боковой поверхности конуса
     * @return формула
     */
    @Override
    public double getArea(){
        return Math.PI*Radius*Math.sqrt(Math.pow(Radius,2)+Math.pow(height,2));
    }

    /**
     * Метод для нахождения обьема конуса
     * @return формула
     */
    private double getVolume(){
        double doubleRadius = Math.pow(Radius,2);
        return (doubleRadius * Math.PI * this.height)/3;
    }

    /**
     * Метод для нахождения максимального обьема
     * @param cone массив конусов
     */
    void getMaxVolume(ArrayList<Cone> cone){
            double maxStatement = cone.get(0).getVolume();
            for(Cone i : cone) {
                if ( i.getVolume()>maxStatement){
                    maxStatement = i.getVolume();
                }
            }

        System.out.println(" Нйбольший обьем среди конусов  :" + String.format(DEFAULT_FORMAT,maxStatement));
    }
    @Override
    public String toString (){
        return
                " Радиус окружности конуса : "+ Radius +
                " , Площадь конуса : " + String.format(DEFAULT_FORMAT, getArea())+
                " , Длина окружности конуса : " + String.format(DEFAULT_FORMAT,circumference()) +
                " , Высота конуса : " + this.height +
                " , Обьем конуса : " + String.format(DEFAULT_FORMAT, getVolume()) +
                        " ;";
        }

}
