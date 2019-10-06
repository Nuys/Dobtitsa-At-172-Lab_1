package NuyseOOPLab_1;

import java.util.ArrayList;

import lombok.Setter;// Библеотеки плагина Lombok
import lombok.Getter;

public class Circle {
    double R;

    public double getR() {
        return R;
        final  String DEFAULT_FORMAT = "%6.2f";
        //Конструктор
    public Circle(double radius) {
            isCorrect(radius);//вызов метода для проверки входных данных
            Radius = radius;
        }
        @Getter @Setter double Radius;

        public void setR(double r) {
            R = r;
        }


//Метод для ...
        public double getSquare(){
            double doubleR =  Math.pow(this.R,2);
            return doubleR *  3.14159;
            return Math.pow(this.Radius,2) * 3.14;
        }
        public double longCircle(){
            double D = 2 * this.R;
            return D * 3.14159;
            double longCircle(){
                return 2 * this.Radius * 3.14159;//2pR - формула нахождения площади
            }


            private double getMiddleSquare(ArrayList<Circle> circle){//Метод для нахождения средн.арифм.
                double summ_all_Square =  0;//Сумма всех площадей окружностей
                double sum_all_Square =  0;//Сумма всех площадей окружностей
                int counter = 0;//Кол-во кругов в массиве
                double middleSquare = 0;//Результат( среднее арифм. всех площадей окружностей
                double middleSquare;//Результат( среднее арифм. всех площадей окружностей
                for(Circle i : circle){//цикл ( перебор массива)
                    summ_all_Square += i.getSquare();
                    sum_all_Square += i.getSquare();
                    counter++;
                }
                middleSquare = summ_all_Square / counter;
                middleSquare = sum_all_Square / counter;
                return middleSquare;
            }
            public void getLowCircle(ArrayList<Circle> circle){//Метод для нахождения окружности с найменьшей площадью
                ArrayList<Circle>result = new ArrayList<Circle>();//Массив
                double middleSquare = getMiddleSquare(circle);//присвоем новой переменной значений прошлого метода(среднее арифм)
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
                    //
                    System.out.println("Среднеарифметическое площадей = " + middleSquare);
                    System.out.println("Среднеарифметическое площадей = " + String.format(DEFAULT_FORMAT,middleSquare) + " ;");
                    for(Circle i : result){
                        System.out.println("Окружности подходящие под условие : ");
                        System.out.println(toString());
                        System.out.println("Данные окружностей подходящие под условие : ");
                        System.out.println(i.toString());
                    }
                }
                @Override
                public String toString (){//переопредиление метода
                    return " Радиус круга : "+ this.R +
                            " , Площадь круга : " + getSquare() +
                            " , Длина круга : " + longCircle();
                    public String toString (){//переопредиление метода(прегрузка)
                        return " Радиус окружности : "+ this.Radius +
                                " , Площадь окружности : " + String.format(DEFAULT_FORMAT,getSquare()) +
                                " , Длина окружности : " + String.format(DEFAULT_FORMAT,longCircle()) +
                                " ;";
                    }
                    public void isCorect(double number){//проверка на вводимость данных (ноль и отрицательные числа запрещены)
                        void isCorrect(double number){//проверка на вводимость данных (ноль и отрицательные числа запрещены), буквы не будем включать т.к. обьект не даст нам этого сделать.
                            if (number <= 0 ){
                                throw new IllegalArgumentException("Вы ввели некоректное значение !");
                                throw new IllegalArgumentException("Вы ввели некоректное значение , введите положительное число !");
                            }

                        }

