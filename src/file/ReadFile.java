package file;

import record.Record;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadFile {
    public static  ArrayList<ArrayList<Record>> readFile(String url) {
        File file = new File(url);
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(file));
            ArrayList<ArrayList<Record>> records = (ArrayList<ArrayList<Record>>) in.readObject();
            return records;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
