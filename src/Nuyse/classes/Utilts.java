package Nuyse.classes;

import java.util.Locale;

/**
 * Функция форматирования чисел
 */
public class Utilts {
    /**
     * @param DEFAULT_FORMAT
     * Константа содержащая стандартный формат
     */
    private static final String DEFAULT_FORMAT = "%6.2f";

    /**
     * Форматирование по стандартному формату
     * @param number число для форматирования
     */
    public static String floatFormat(final double number){
        return format(number, DEFAULT_FORMAT);
    }

    /**
     * Форматирование по определённому формату
     * @param number число для форматирования
     * @param format формат в который форматируем
     */
    public static String floatFormat(final double number, final String format){
        return format(number, format);
    }

    private static String format(final double number, final String format) {
        final Locale locale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        final String result = String.format(format, number);
        Locale.setDefault(locale);
        return result;
    }
}