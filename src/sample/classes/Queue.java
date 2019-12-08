package sample.classes;

import java.util.ArrayList;

public class Queue {
    private ConfirmedProcesses confirmedProcesses = new ConfirmedProcesses();
    private RejectedProcesses rejectedProcesses = new RejectedProcesses();
    private Scheduler scheduler;
    private int start;

    public int getStart() {
        return start;
    }

    public Queue(){

    }

    public Queue(Scheduler scheduler){
        this.scheduler=scheduler;
    }

    public ArrayList getConfirmedProcesses(){
        return confirmedProcesses.getConfirmedQueue();
    }

    public void addConfirmedProcess(Process process){
        confirmedProcesses.add(process);
    }

    public void addRejectedProcess(Process process){
        rejectedProcesses.add(process);
    }

    public ArrayList getRejectedProcesses(){
        return rejectedProcesses.getRejectedQueue();
    }

    boolean add(Process process){
        ArrayList<Integer> listResults = new ArrayList<>();
        int min=0;
        for(int i=0; i<scheduler.getMemoryBlocks().size()-1;i++){
            if(MemoryBlock.byEnd.compare(scheduler.getMemoryBlocks().get(i), scheduler.getMemoryBlocks().get(i+1))>=process.getSize()){
                listResults.add(MemoryBlock.byEnd.compare(scheduler.getMemoryBlocks().get(i), scheduler.getMemoryBlocks().get(i+1)));
                min = MemoryBlock.byEnd.compare(scheduler.getMemoryBlocks().get(i), scheduler.getMemoryBlocks().get(i+1));
            }
        }

        for (int i:listResults) {
            if(i<min){
                min=i;
            }
        }

        boolean isConfirmed = false;
        for (int i=0; i<scheduler.getMemoryBlocks().size()-1;i++) {
            if(MemoryBlock.byEnd.compare(scheduler.getMemoryBlocks().get(i), scheduler.getMemoryBlocks().get(i+1))==min){
                this.start = scheduler.getMemoryBlocks().get(i).getEnd();
                process.setTypeState(StateProcess.READY);
                confirmedProcesses.add(process);
                isConfirmed=true;
                break;
            }
        }
        if(!isConfirmed) {
            process.setTypeState(StateProcess.REJECTED);
            rejectedProcesses.add(process);
        }
        return isConfirmed;
    }
}
