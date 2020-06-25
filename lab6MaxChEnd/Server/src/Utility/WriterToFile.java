package Utility;
import Stuff.Worker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * The type Writer to file.
 */
public class WriterToFile {
    /**
     * The Filename.
     */
    static String filename ;

    /**
     * Sets filename.
     *
     * @param filename the filename
     */
    public static void setFilename(String filename) {
        WriterToFile.filename = filename;
    }

    /**
     * Write to file.
     *
     * @param data the data
     * @throws FileNotFoundException the file not found exception
     */
    public static void writeToFile(String data) throws FileNotFoundException {
        try {
            File file = new File(filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Write lab to file.
     *
     * @param workers the workers
     * @throws FileNotFoundException the file not found exception
     */
    public static void writeLabToFile(Hashtable<Long, Worker> workers) throws IOException {
        try {

            File file = new File(filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            for (Map.Entry<Long, Worker> entry : workers.entrySet()) {
                String out = entry.getValue().getCsvWorker()+"\n";
                fileOutputStream.write(out.getBytes());
            }
            fileOutputStream.close();
        } catch (Exception e) {
            throw  e;
        }
    }
}