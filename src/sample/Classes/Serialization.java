package sample.Classes;
import java.io.*;
import java.util.ArrayList;

public class Serialization implements Serializable {
    File file;
    public Serialization(){
    }
    public Serialization(String pathname){file = new File(pathname); }
    public String Serialization (Drivers drivers) throws IOException {
        ObjectOutputStream oos = null;
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if(fileOutputStream!=null){
                oos = new ObjectOutputStream(fileOutputStream);
                oos.writeObject(drivers.list);
                return "Запись прошла успешно";
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return "Ошибка записи в файл";
            }
    public String Deserialization(Drivers drivers) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        try {
            drivers.list=(ArrayList)ois.readObject();
            return "Чтение прошло успешно";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Ошибка чтения из файла";
    }
}
