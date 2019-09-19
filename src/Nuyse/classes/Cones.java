package Nuyse.classes;

/**
 * Класс для инициализации кубов
 */
public class Cones {

    /**
     * Индекс конусов в массиве
     * @param index индекс куба
     */
    public Cone getCone(final int index) {
        return classCones[index];
    }

    /**
     * Куб с индексом
     * @param cones это наш Cone в котором
     * @param index индекс куба
     */
    public void setCone(final Cone cones, final int index) {
        this.classCones[index] = cones;
    }

    /**
     * Массив кубов
     */
    private final Cone[] classCones;

    /**
     * @param quantity кол-во кубов
     */
    public Cones(final int quantity){
        classCones = new Cone[quantity];
    }

    /**
     * Кол-во конусов с наибольшим обьемом
     */
    public double getMaxVolume(){
        double maxVolume = 0;
        for (final Cone classCone : classCones){
            if(maxVolume > classCone.getArea()){
                maxVolume = classCone.getArea();
            }
        }
        return maxVolume;
    }
}