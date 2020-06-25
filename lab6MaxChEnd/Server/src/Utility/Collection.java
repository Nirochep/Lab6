package Utility;

import Stuff.*;
import Commands.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * The type Collection.
 */
public class Collection {
    /**
     * The Collection.
     */
    Hashtable<Long,Worker> collection;

    /**
     * Instantiates a new Collection.
     */
    public Collection() {
        collection = new Hashtable<>();
        WorkerCollection.setCollection(collection);
        WorkerCollection.setDateCreation(LocalDate.now());
        System.out.println("Коллекция создана. ");
    }
    private Thread backgroundReaderThread = null;
    public void checkForSaveCommand() throws IOException {
        backgroundReaderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                    while (!Thread.interrupted()) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.equalsIgnoreCase("save")){
                            Save s = new Save();
                            s.execute(null);
                        }
                        if (line.equalsIgnoreCase("exit")){
                            Save s = new Save();
                            s.execute(null);
                            System.out.println("Завершаю работу.");
                            System.exit(0);
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundReaderThread.start();
    }
    /**
     * Fill collection.
     *
     * @param data the data
     */
    public void fillCollection(String data){
        if (data==null) System.out.println("Коллекция не заполнена.");
        else {
            try {
                WorkerCollection.setCollection(Decoder.decodeIntoCollection(data));

            }catch (NullPointerException e) {
                e.printStackTrace();
            System.out.println("В файле указаны некорретные данные. Коллекция пустая.");
        }

        }
    }
}