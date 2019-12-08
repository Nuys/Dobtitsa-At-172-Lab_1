package sample.classes;

import sample.Controller;

import java.util.TimerTask;

public class TimerTaskProcess extends TimerTask {
    private Processes processes;
    private GenerateProcesses generateProcesses = new GenerateProcesses();


    public TimerTaskProcess(Processes processes){
        this.processes = processes;
    }

    @Override
    public void run() {
        generateProcesses.generate(processes);
        Controller.Refresh();
    }
}
