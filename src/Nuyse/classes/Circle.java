package Nuyse.classes;
import lombok.Getter;
import lombok.Setter;

import static Nuyse.classes. Utilts.floatFormat;
/**
 * Класс Square для квадрата
 */
public class Circle {

    /**
     * Сторона квадрата
     * @param Radius
     */
    @Getter @Setter private double Radius;



    /**
     * Пустой конструктор для квадрата
     */
    Circle() {
        this.Radius=0;
    }

    /**
     * Конструктор с параметром сторона
     * @param Radius сторона квадрата
     */
    public Circle(final double Radius) {
        this.Radius = Radius>0?Radius:0;
    }

    /**
     * Нахождение площади окружности
     */
    public double getArea(){
        return Math.pow(this.Radius,2) * 3.14;
    }

    /**
     * Нахождение длины окружносоти
     */
    double getLongCircle() {
        return this.Radius * Radius;
    }


    /**
     * Вывод результатов на экран
     */
    @Override
    public String toString() {
        String str;
        str = this.Radius != 0 ?         // Тернарный оператор
                "Сircle:" +
                        "\n\tRadius = " + this.Radius +
                        "\n\tarea = " + floatFormat(getArea()) +
                        "\n\tperimeter = " + floatFormat(getLongCircle())
                :
                "Circle:" +
                        "\n\tRadius = 0";
        return str;
    }
}
