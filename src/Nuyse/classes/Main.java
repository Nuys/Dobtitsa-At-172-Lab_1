package Nuyse.classes;

import java.util.Locale;
import java.util.Scanner;

/**
 * Основная класс ClassMain
 */
class Main {
    /**
     * Основная статическая функция
     */
    public static void main(final String[] args) {
        Locale.setDefault(Locale.US);
        final Scanner scanner = new Scanner(System.in);
        int quantityCircles = 0;
        boolean isCorrectly = false;
        while (!isCorrectly) {
            System.out.println("Введите кол-во окружностей: ");
            final String str1 = scanner.next();
            isCorrectly = isCorrect(str1, true);
            if (isCorrectly) {
                quantityCircles = Integer.parseInt(str1);
            } else {
                reenterNumber();
            }
        }
        final Circles squares = new Circles(quantityCircles);
        int tempVariable = 0;
        do {
            System.out.println("Введите радиус " + (tempVariable + 1) + ": ");
            final String str2 = scanner.next();
            isCorrectly = isCorrect(str2, false);
            if (isCorrectly) {
                squares.setCircle(new Circle(Double.parseDouble(str2)), tempVariable);
                System.out.println(squares.getCircle(tempVariable) + "\n");
                tempVariable++;
            } else {
                reenterNumber();
            }
        } while (tempVariable < quantityCircles);



        int quantityCones=0;
        isCorrectly=false;
        while(!isCorrectly) {
            System.out.println("Введите кол-во конусов: ");
            final String str3 = scanner.next();
            isCorrectly = isCorrect(str3, true);
            if(isCorrectly) {
                quantityCones = Integer.parseInt(str3);
            }
            else {
                reenterNumber();
            }
        }

        final Cones cones = new Cones(quantityCones);
        tempVariable=0;
        do{
            System.out.println("Введите высоту конуса" + (tempVariable + 1) +": ");
            final String str4 = scanner.next();
            isCorrectly = isCorrect(str4, false);
            if(isCorrectly) {
                System.out.println(cones.getCone(tempVariable) + "\n");
                tempVariable++;
            }
            else {
                reenterNumber();
            }
        }while(tempVariable > quantityCones);

        System.out.println("Конус с наибольшим обьемом: " + cones.getMaxVolume());
    }

    private static void reenterNumber(){
        System.out.println("Введите корректное положительное число!!!");
    }

    private static boolean isCorrect(final String input, final boolean isQuantity){
        boolean isCorrectly = true;
        if (isQuantity) {
            for (final char str : input.toCharArray()) {
                if (!Character.isDigit(str)) {
                    isCorrectly=false;
                }
            }
        }
        else {
            if (input.matches("[^0-9]")){
                isCorrectly = false;
            }
        }
        return isCorrectly;
    }
}
