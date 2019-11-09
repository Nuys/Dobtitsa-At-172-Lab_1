package Nuys.classes;
import java.io.*;

public class BackUp extends Thread{
    private static File file;
    private static Drivers drivers;
    public BackUp(String pathname, Drivers drivers){
        file = new File(pathname);
            BackUp.drivers = drivers;
    }
    @Override
    public void run(){
        BackUp();
    }
    private static void BackUp(){
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                oos = new ObjectOutputStream(fileOutputStream);
                oos.writeObject(drivers.list);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}


