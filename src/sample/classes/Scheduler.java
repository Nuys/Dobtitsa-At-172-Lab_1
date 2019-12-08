package sample.classes;

import java.util.ArrayList;

public class Scheduler {

    public ArrayList<MemoryBlock> getMemoryBlocks() {
        return memoryBlocks;
    }

    private ArrayList<MemoryBlock> memoryBlocks = new ArrayList<>();

    public Scheduler(){
    }

    public void add(MemoryBlock memoryBlock){
        memoryBlocks.add(memoryBlock);
        memoryBlocks.sort(MemoryBlock.byAsc);
    }

    public void deleteBlock(MemoryBlock memoryBlock) {
        getMemoryBlocks().remove(memoryBlock);
    }
}
