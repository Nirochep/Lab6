package Commands;

import Stuff.Commandable;
import Stuff.Worker;
import Stuff.WorkerCollection;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

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
        AtomicBoolean tumb = new AtomicBoolean(false);
        if (collection.getSize() == 0) return ("Коллекция итак пустая.");
        else {
            collection.getCollection().entrySet()
                    .stream()
                    .filter(x->x.getKey()==Long.parseLong((String) o))
                    .forEach(x->{
                        tumb.set(true);
                        collection.remove(Long.parseLong((String) o));
                        });
            if (!tumb.get()) return ("Работник с указанным id не найден.");
            else return ("Элемент с id[" + o + "] успешно удален.");
        }
    } catch (Exception e) {
        return ("Аргумент команды должен быть типа \"long\"");
    }
    }

    @Override
    public String getName() {
        return name;
    }
}
