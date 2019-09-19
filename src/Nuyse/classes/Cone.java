package Nuyse.classes;

import lombok.Getter;
import lombok.Setter;

import static Nuyse.classes.Utilts.floatFormat;

/**
 * Класс Cone для призм
 */
public class Cone extends Circle {
    /**
     * height - высота конуса
     */
    @Getter @Setter private double height , Radius;


    /**
     * Конструктор на 1 параметр
     */
    public Cone( double height, double Radius){
        super(Radius>0?Radius:0);
        this.height=height>0?height:0;
    }

    /**
     * Пустой конструктор
     */
    public Cone(){
        super(0);
        this.height = 0;
    }

    /**
     * Нахождение площади конуса
     */
    @Override
    public double getArea() {
        double L = Math.pow(Radius, 2) + Math.pow(this.height, 2);
        return L * Radius * 3.14159;
    }

    /**
     *
     * Нахождение обьема конуса
     */
    private double getVolume(){
        double doubleRadius = Math.pow(Radius,2);
        return (doubleRadius * 3.14159 * this.height)/3;
    }

    @Override
    public String toString() {
        String str;
        str = this.height!=0 ?                     // тернарный оператор
                "Cone:" + "\n\tRadius = " + Radius +
                        "\n\theight = " + height +
                        "\n\tarea = " + floatFormat(getArea()) +
                        "\n\tvolume = " + floatFormat(getVolume())
                :
                "Cone: \n\tRadius = 0";
        return str;
    }
}