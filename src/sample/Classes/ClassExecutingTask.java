package sample.Classes;
import java.util.Date;
import java.util.Timer;

public class ClassExecutingTask {
    private LoopTask task = new LoopTask();
    private Timer timer = new Timer("BackUp");
    public void start(){
        timer.cancel();
        timer = new Timer("BackUp");
        Date executionDate = new Date();
        long delay = 60 * 1000;
        timer.scheduleAtFixedRate(task, executionDate, delay);
    }
}
