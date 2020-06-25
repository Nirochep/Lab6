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
    public String execute(Object o)  {
        try {
            WriterToFile.writeLabToFile(collection.getCollection());
            System.out.println("Коллекция успешно сохранена.");
        }
        catch (Exception e){
            System.out.println("Коллекция не сохранена,изначального файла нет.");
        }
        return null;
    }


    @Override
    public String getName() {
        return name;
    }
}