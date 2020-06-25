package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Worker;
import Stuff.WorkerCollection;

import java.util.Hashtable;
import java.util.Map;

/**
 * The type Show.
 */
public class Show implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "show";
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();

    @Override
    public String execute(Object o) {
        String m ="";
        if (collection.getSize() == 0) return ("Коллекция пустая.");
        else for (Map.Entry<Long, Worker> entry : collection.getCollection().entrySet())
            m+=(entry.getValue().getInfo()+"\n");
        return m;
            }


    @Override
    public String getName() {
        return name;
    }
}