package Commands;

import Stuff.Commandable;
import Stuff.Worker;
import Stuff.WorkerCollection;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Map;

/**
 * The type Remove id.
 */
public class RemoveId implements Commandable {
    /**
     * The Name.
     */
    String name = "remove";
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();
    @Override
    public String execute(Object o) throws FileNotFoundException {
        try{
        boolean tumb = false;
        if (collection.getSize() == 0) return ("Коллекция итак пустая.");
        else {
            for (Map.Entry<Long, Worker> entry : collection.getCollection().entrySet())
            if (entry.getKey() == Long.parseLong((String) o)) {
                tumb = true;
                collection.remove(Long.parseLong((String) o));
                return ("Элемент с id[" + o + "] успешно удален.");
            }
            if (!tumb) return ("Работник с указанным id не найден.");
        }
    } catch (Exception e) {
        return ("Аргумент команды должен быть типа \"long\"");
    }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}
