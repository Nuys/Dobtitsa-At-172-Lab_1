public class Circle {
    double R;

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }
//Конструктор
    public Circle(double r) {
        R = r;
    }
//Метод для ...
    public double getSquare(){
        double doubleR =  Math.pow(this.R,2);
        return doubleR *  3.14159;
    }
    public double longCircle(){
        double D = 2 * this.R;
        return D * 3.14159;
    }
    public void getinfo(){
        System.out.println("Радиус круга: "+ this.R);
        System.out.println("Площадь круга: "+ getSquare());
        System.out.println("Длина круга: "+ longCircle());
    }
}
