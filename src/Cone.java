import java.util.ArrayList;

public class Cone extends Circle {
    double h;

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Cone(double r, double h) {
        super(r);//конструктор родительского класса (класа Circle)
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
    @Override
    public void getinfo(){
        System.out.println("Радиус конуса: "+ this.R);
        System.out.println("Высота конуса: "+ this.h);
        System.out.println("Площадь конуса: "+ getSquare());
        System.out.println("Длина основания круга конуса: "+ longCircle());
        System.out.println("Обьем конуса: "+ getVolume());
    }
    public void getMaxVolume(ArrayList<Cone> cone){
        double max = cone.get(0).getVolume();
        for(Cone i : cone) {
            if ( i.getVolume()>max){
                max = i.getVolume();
            }
        }
        System.out.println(max);
    }

}
