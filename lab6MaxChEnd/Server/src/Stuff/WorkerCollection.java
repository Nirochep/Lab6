package Stuff;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

/**
 * The type Worker collection.
 */
public class WorkerCollection implements Serializable {
    private static Hashtable<Long, Worker> collection;
    private static LocalDate dateCreation;

    /**
     * Gets collection.
     *
     * @return the collection
     */
    public Hashtable<Long, Worker> getCollection() {
        return collection;
    }

    /**
     * Sets collection.
     *
     * @param collection the collection
     */
    public static void setCollection(Hashtable<Long, Worker> collection) {
        WorkerCollection.collection = collection;
    }


    /**
     * Gets date creation.
     *
     * @return the date creation
     */
    public static LocalDate getDateCreation() {
        return dateCreation;
    }

    /**
     * Sets date creation.
     *
     * @param dateCreation the date creation
     */
    public static void setDateCreation(LocalDate dateCreation) {
        WorkerCollection.dateCreation = dateCreation;
    }

    /**
     * Clear.
     */
    public void clear() {
        collection.clear();
    }

    /**
     * Insert.
     *
     * @param ind    the ind
     * @param worker the worker
     */
    public void insert(Long ind, Worker worker) {
        if (this.isKeyFree(ind))
            collection.put(ind, worker);
    }

    /**
     * Update.
     *
     * @param ind    the ind
     * @param worker the worker
     */
    public void update(Long ind, Worker worker) {
        if (!this.isKeyFree(ind))
            collection.put(ind, worker);
    }

    /**
     * Remove.
     *
     * @param ind the ind
     */
    public void remove(Long ind) {
        collection.remove(ind);
    }


    /**
     * Is key free boolean.
     *
     * @param ind the ind
     * @return the boolean
     */
    public boolean isKeyFree(Long ind) {
        try {
            for (Map.Entry<Long, Worker> entry : collection.entrySet()) {
                if (entry.getKey().equals(ind)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /**
     * Generate id long.
     *
     * @return the long
     */
    public static long generateId() {
        WorkerCollection workerCollection = new WorkerCollection();
        long kek =(long) (Math.random()*100000000);
        while (!workerCollection.isKeyFree((long) kek)) {
            kek = (long) (Math.random() * 1000000000);
        }
        return  kek;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return collection.size();
    }

    /**
     * Gets info.
     *
     * @return the info
     */
    public String getInfo() {
        return "Тип коллекции: Hashtable;\nKоличество элементов коллекции: " + this.getSize() + ";\nДата создания кол"
                + "лекции: " + this.getDateCreation() + ".";
    }


}