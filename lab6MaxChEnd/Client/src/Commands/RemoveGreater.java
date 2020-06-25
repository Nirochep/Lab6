package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Worker;
import Stuff.WorkerCollection;
import Utility.CreateWorker;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;

/**
 * The type Remove greater.
 */
public class RemoveGreater implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "remove_greater";
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();
    /**
     * The Create worker.
     */


    /**
     * Check boolean.
     *
     * @param arg the arg
     * @return the boolean
     */
    public boolean check(Object arg) {
        return false;
    }

    /**
     * Gets new worker.
     *
     * @param params the params
     * @return the new worker
     */
    public Worker getNewWorker(Object params) { CreateWorker CreateWorker = new CreateWorker();
        if (!CreateWorker.isFromScript) return CreateWorker.create();
        else return CreateWorker.workerFromScript;
    }

    @Override
    public String execute(Object arg) {
        try {
            Worker newWorker = this.getNewWorker(null);
            boolean tumb = false;
            String message = "";
            if (collection.getSize() == 0) return "Коллекция итак пустая.";
            else {
                Hashtable<Long, Worker> workers = collection.getCollection();
                Enumeration keys = workers.keys();
                while (keys.hasMoreElements()) {
                    Long k = (Long) keys.nextElement();
                    Worker v = workers.get(k);
                    if (v.compareTo(newWorker) > 0) {
                        tumb = true;
                        collection.remove(k);
                        message += ("Работник с id:[" + k + "] успешно удален.");
                    }
                }
                if (!tumb) return ("Работников,превышающих заданный не найдено.");
                else return message;
            }
        } catch (NumberFormatException | InputMismatchException e) {
            return ("Аргумент команды должен быть типа \"long\"");
        } catch (NullPointerException e) {
            return ("Неверно указаны данные.");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}

