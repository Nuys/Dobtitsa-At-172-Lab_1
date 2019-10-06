public class Utils {
    /**
     * @param DEFAULT_FORMAT
     * Константа содержащая стандартный формат
     */
    String DEFAULT_FORMAT = "%6.2f";

    void isCorrect(double number){
        if (number <= 0 ){
            throw new IllegalArgumentException("Вы ввели некоректное значение , введите положительное число !");
        }

    }
}