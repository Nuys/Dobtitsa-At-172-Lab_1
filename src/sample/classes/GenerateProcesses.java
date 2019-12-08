package sample.classes;

import sample.Controller;

public class GenerateProcesses {
    private int id=0;

    public void generate(Processes processes) {
        ProcessNames processNames = new ProcessNames();
        processes.getList().add(new Process(processNames.getRandomProcessName(), ++id));
        Controller.Refresh();
    }
}
