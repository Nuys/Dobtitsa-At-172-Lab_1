package sample.classes;

import java.util.ArrayList;

public class ConfirmedProcesses {

    private ArrayList<Process> confirmedQueue;

    public ConfirmedProcesses(){
        confirmedQueue = new ArrayList<>();
    }

    public ArrayList<Process> getConfirmedQueue() {
        return confirmedQueue;
    }

    public void add(Process process){
        confirmedQueue.add(process);
    }
}
