import java.util.ArrayList;

public class Cone extends Circle {
    double h;

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Cone(double r, double h) {//обозначение с математики r - радиус , h - высота , будем использовать эти обозначения для вычисления...
        super(r);//конструктор родительского класса (класа Circle)
        isCorect(h);//вызов метода для проверки входных данных( только высоты т.к радиус провериться  в родительском Классе
        this.h = h;
    }
    //переопределение @Override - один из видов анотаций
    @Override
    public double getSquare(){
        double L = Math.pow(this.R,2) + Math.pow(this.h,2);
       double square = L * this.R * 3.14159;
       return square;
    }
    public double getVolume(){
        double doubleR = Math.pow(this.R,2);
        double V = (doubleR * 3.14159 * this.h)/3;
        return V;
    }
    public void getMaxVolume(ArrayList<Cone> cone){
        double max = cone.get(0).getVolume();
        for(Cone i : cone) {
            if ( i.getVolume()>max){
                max = i.getVolume();
            }
        }
        System.out.println(" Нйбольший обьем среди конусов  : " +  max);
    }
    @Override
    public String toString (){
        return " Радиус конуса : "+ this.R +
                " , Площадь конуса : " + getSquare() +
                " , Длина конуса : " + longCircle() +
                " , Высота конуса : " + this.h +
                " , Обьем конуса : " + getVolume();
        }

}
