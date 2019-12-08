package sample.classes;

import java.util.ArrayList;
import java.util.Random;

public class ProcessNames {
    private ArrayList<String> processNames = new ArrayList<>();
    private Random random = new Random();

    public ProcessNames(){
        processNames.add("Удаление");
        processNames.add("Копирование");
        processNames.add("Перемещение");
        processNames.add("Открытие");
        processNames.add("Включение");
        processNames.add("Выключение");
        processNames.add("Перетаскивание");
        processNames.add("Очистка");
        processNames.add("Запись");
        processNames.add("Скачивание");
        processNames.add("Отправление");
        processNames.add("Воспроизведение");
        processNames.add("Закрытие");
    }

    public String getRandomProcessName(){
        int index = random.nextInt(processNames.size()-1);
        return this.processNames.get(index);
    }
}
