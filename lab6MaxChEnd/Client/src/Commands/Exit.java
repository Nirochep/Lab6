package Commands;

import Stuff.CommandWithoutArg;
import Stuff.WorkerCollection;

/**
 * The type Exit.
 */
public class Exit implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "exit";
    /**
     * The Worker collection.
     */
    WorkerCollection WorkerCollection = new WorkerCollection();

    @Override
    public String execute(Object o) {
        System.exit(0);return null;
    }

    @Override
    public String getName() {
        return name;
    }
}