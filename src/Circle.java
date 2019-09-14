import java.util.ArrayList;//импортируем библиотеку для исп. Эрей листа
import lombok.Setter;// Библеотеки плагина Lombok
import lombok.Getter;

public class Circle {
    private static final  String DEFAULT_FORMAT = "%6.2f";
    //Конструктор
    public Circle(double radius) {
        isCorrect(radius);//вызов метода для проверки входных данных
        Radius = radius;
    }
    @Getter @Setter double Radius;

    public double getSquare(){
        return Math.pow(this.Radius,2) * 3.14;
    }
    double longCircle(){
        return 2 * this.Radius * 3.14159;//2pR - формула нахождения площади
    }


    private double getMiddleSquare(ArrayList<Circle> circle){//Метод для нахождения средн.арифм.
        double sum_all_Square =  0;//Сумма всех площадей окружностей
        int counter = 0;//Кол-во кругов в массиве
        double middleSquare;//Результат( среднее арифм. всех площадей окружностей
        for(Circle i : circle){//цикл ( перебор массива)
        sum_all_Square += i.getSquare();
        counter++;
        }
       middleSquare = sum_all_Square / counter;
        return middleSquare;
    }
    /*
    Метод для нахождения окружности с минимальной площадью
     */
    void getLowCircle(ArrayList<Circle> circle){
        ArrayList<Circle>result = new ArrayList<>();
        double middleSquare = getMiddleSquare(circle);//присвоем новой переменной значений прошлого метода(среднее арифметическое )
        for(Circle i : circle ){
            if (i.getSquare() < middleSquare){//само условие
                result.add(i);
            }
        }
        System.out.println("Среднеарифметическое площадей = " + String.format(DEFAULT_FORMAT,middleSquare) + " ;");
        for(Circle i : result){
            System.out.println("Данные окружностей подходящие под условие : ");
            System.out.println(i.toString());
        }
    }
        @Override
        public String toString (){//переопредиление метода(прегрузка)
                return " Радиус окружности : "+ this.Radius +
                        " , Площадь окружности : " + String.format(DEFAULT_FORMAT,getSquare()) +
                         " , Длина окружности : " + String.format(DEFAULT_FORMAT,longCircle()) +
                        " ;";
    }
    void isCorrect(double number){//проверка на вводимость данных (ноль и отрицательные числа запрещены), буквы не будем включать т.к. обьект не даст нам этого сделать.
            if (number <= 0 ){
                throw new IllegalArgumentException("Вы ввели некоректное значение , введите положительное число !");
            }

    }
}
