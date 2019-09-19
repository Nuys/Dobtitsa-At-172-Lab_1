package Nuyse.classes;

import java.util.ArrayList;

/**
 * Класс для инициализации квадратов
 */
public class Circles {

    /**
     * @param index индекс квадрата
     */
    public Circle getCircle(final int index) {
        return circles[index];
    }

    /**
     * @param circle класс Circle
     * @param index  индекс окружности
     */
    public void setCircle(final Circle circle, final int index) {
        this.circles[index] = circle;
    }

    /**
     * Массив окружностей
     */
    private final Circle[] circles;

    /**
     * Кол-во окружностей
     *
     * @param quantity кол-во окружностей
     */
    public Circles(final int quantity) {
        circles = new Circle[quantity];
    }

    /**
     * Средняя площадь окружностей
     */
    public void  getLowCircle() {
        double area = 0;
        for (Circle circle : circles) {
            area += circle.getArea();
        }
        ArrayList<Circle> allcircles = new ArrayList<>();
        double AverageArea = area / circles.length;
        for (Circle circle : circles) {
            if (circle.getArea() < AverageArea) {
                allcircles.add(circle);
            }
        }
            for (Circle circle : allcircles) {
                System.out.println("Окружности с площадью меньше чем среднее арифметическое всех площадей " + circle);
            }
        }
}
