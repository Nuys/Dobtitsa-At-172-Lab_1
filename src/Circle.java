import java.util.ArrayList;

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
        isCorect(r);//вызов метода для проверки входных данных
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


    private double getMiddleSquare(ArrayList<Circle> circle){//Метод для нахождения средн.арифм.
        double summ_all_Square =  0;//Сумма всех площадей окружностей
        int counter = 0;//Кол-во кругов в массиве
        double middleSquare = 0;//Результат( среднее арифм. всех площадей окружностей
        for(Circle i : circle){//цикл ( перебор массива)
        summ_all_Square += i.getSquare();
        counter++;
        }
       middleSquare = summ_all_Square / counter;
        return middleSquare;
    }
    public void getLowCircle(ArrayList<Circle> circle){//Метод для нахождения окружности с найменьшей площадью
        ArrayList<Circle>result = new ArrayList<Circle>();//Массив
        double middleSquare = getMiddleSquare(circle);//присвоем новой переменной значений прошлого метода(среднее арифм)
        for(Circle i : circle ){
            if (i.getSquare() < middleSquare){//само условие
                result.add(i);
            }
        }
        //
        System.out.println("Среднеарифметическое площадей = " + middleSquare);
        for(Circle i : result){
            System.out.println("Окружности подходящие под условие : ");
            System.out.println(toString());
        }
    }
        @Override
        public String toString (){//переопредиление метода
             return " Радиус круга : "+ this.R +
                " , Площадь круга : " + getSquare() +
                    " , Длина круга : " + longCircle();
    }
    public void isCorect(double number){//проверка на вводимость данных (ноль и отрицательные числа запрещены)
            if (number <= 0 ){
                throw new IllegalArgumentException("Вы ввели некоректное значение !");
            }

    }
}
