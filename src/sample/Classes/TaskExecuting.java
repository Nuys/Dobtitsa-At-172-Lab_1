package sample.Classes;
import java.util.Date;
import java.util.Timer;

public class TaskExecuting {
    long delay = 5 * 1000;
    CycleTask task = new CycleTask();
    Timer timer = new Timer("BackUp");

    public void start() {
        timer.cancel();
        timer = new Timer("BackUp");
        Date executionDate = new Date();
        timer.scheduleAtFixedRate(task, executionDate, delay);
    }
}
