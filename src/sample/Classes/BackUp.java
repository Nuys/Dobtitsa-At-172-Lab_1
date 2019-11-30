package sample.Classes;
import java.io.*;

public class BackUp extends Thread {
    private static String pathname;
    private static Drivers drivers;
    public BackUp(String pathname,Drivers drivers){
        this.pathname = pathname;
        this.drivers = drivers;
    }
    @Override
    public void run(){
        try {
            BackUp();
        }catch (IOException e){
           e.printStackTrace();
        }
    }
    public void BackUp() throws IOException{
        Serialization serialization = new Serialization(pathname);
        serialization.Serialization(drivers);
    }
}
