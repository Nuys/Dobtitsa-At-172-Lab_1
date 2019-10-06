import java.util.ArrayList;
import lombok.Setter;
import lombok.Getter;

public class Circle extends Utils {
    /**
     * Конструктор
     * @param radius - радиус круга
     */
    public Circle(double radius) {
        isCorrect(radius);//вызов метода для проверки входных данных
        Radius = radius;
    }
    @Getter @Setter double Radius;

    /**
     * Метод для нахождения площади окружности
     * @return возвращаем радиус в квадрате на число П
     */
    public double getArea(){
        return Math.pow(this.Radius,2) * Math.PI;
    }

    /**
     * Метод для нахождения длины круга
     * @return 2*R^2
     */
    double circumference(){
        return 2 * this.Radius * Math.PI;
    }

    /**
     * Метод для нахождения среднего арифметического площадей всех окружностей
     * @param circle массив кругов
     * @return среднее арифметическое
     */
    private double getAverageArea(ArrayList<Circle> circle){
        double sum_all_Area =  0;
        int counter = 0;//
        double averageArea;
        for(Circle i : circle){
        sum_all_Area += i.getArea();
        counter++;
        }
       averageArea = sum_all_Area / counter;
        return averageArea;
    }

    /**
     * Метод для нахождения круга с найменьшей площадью
     * @param circle массив кругов
     */
    void getSmallestCircle(ArrayList<Circle> circle){
        ArrayList<Circle>result = new ArrayList<>();
        double averageArea = getAverageArea(circle);
        for(Circle i : circle ){
            if (i.getArea() < averageArea){//само условие
                result.add(i);
            }
        }
        System.out.println("Среднеарифметическое площадей = " + String.format(DEFAULT_FORMAT,averageArea) + " ;");
        for(Circle i : result){
            System.out.println("Данные окружностей подходящие под условие : ");
            System.out.println(i.toString());
        }
    }
        @Override
        public String toString (){
                return " Радиус окружности : "+ this.Radius +
                        " , Площадь окружности : " + String.format(DEFAULT_FORMAT,getArea()) +
                         " , Длина окружности : " + String.format(DEFAULT_FORMAT,circumference()) +
                        " ;";
    }

}
