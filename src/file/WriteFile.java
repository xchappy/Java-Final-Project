package file;

import main.Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteFile {
    public  int fileNum = 0;
    public  void wirteFile() {
        try {
            File file = new File("output.ser");
            if(!file.exists())
                file.createNewFile();
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(Main.getGod().getFrameRecord());
                out.flush();
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                out.close();

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
