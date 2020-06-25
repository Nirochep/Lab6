package Utility;

import Stuff.*;
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