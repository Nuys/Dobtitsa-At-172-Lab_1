package sample.Classes;
import sample.Controller;
import java.util.TimerTask;

public class LoopTask extends TimerTask {
    public void run(){
        Controller.BackUp();
    }
}
