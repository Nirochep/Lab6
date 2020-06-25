package Commands;

import Stuff.CommandWithoutArg;
import Stuff.WorkerCollection;

import java.io.FileNotFoundException;

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

        Save save = new Save();
        save.execute(null);
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}