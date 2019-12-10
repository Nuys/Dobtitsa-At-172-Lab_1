package sample.classes;

import java.util.Date;
import java.util.Timer;

public class ClassExecutingTask {

    public ClassExecutingTask(Proxys proxys){
        schedule(proxys);
    }


    public void schedule(Proxys proxys){
        Timer timer = new Timer("Work");
        TimerTaskCheck timerTaskCheck = new TimerTaskCheck(proxys);
        Date date = new Date();
        long delay = 300 * 1000;
        timer.scheduleAtFixedRate(timerTaskCheck, date, delay);
    }
}
