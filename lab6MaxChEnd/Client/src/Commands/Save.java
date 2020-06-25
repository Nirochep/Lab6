package Commands;

import Stuff.CommandWithoutArg;
import Stuff.WorkerCollection;
import Utility.WriterToFile;

import java.io.FileNotFoundException;

/**
 * The type Save.
 */
public class Save implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "save";
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();

    @Override
    public String execute(Object o) throws FileNotFoundException {
        try {
            WriterToFile.writeLabToFile(collection.getCollection());
           return ("Коллекция успешно сохранена.");
        }
        catch (Exception e){
            return ("Коллекция не сохранена,изначального файла нет.");
        }
    }


    @Override
    public String getName() {
        return name;
    }
}