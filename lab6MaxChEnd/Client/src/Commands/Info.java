package Commands;

import Stuff.CommandWithoutArg;
import Stuff.WorkerCollection;

/**
 * The type Info.
 */
public class Info implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "info";
    /**
     * The Worker collection.
     */
    WorkerCollection WorkerCollection = new WorkerCollection();

    @Override
    public String execute(Object o) {
        return (WorkerCollection.getInfo());
    }

    @Override
    public String getName() {
        return name;
    }
}