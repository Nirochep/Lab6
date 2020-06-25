package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Worker;
import Stuff.WorkerCollection;
import Utility.CreateWorker;
import Utility.ServerReceiver;
import Utility.ServerSender;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;

/**
 * The type Remove lower.
 */
public class RemoveLower implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "remove_lower";
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
    public Worker getNewWorker(Object params) { Utility.CreateWorker CreateWorker = new CreateWorker();
        if (!CreateWorker.isFromScript) return (Worker) ServerReceiver.receive();
        else return CreateWorker.workerFromScript;
    }

    @Override
    public String execute(Object arg) {
        try {
            ServerSender.send("kek",1);
            Worker newWorker = this.getNewWorker(null);
            boolean tumb = false;
            String message = "";
            if (collection.getSize() == 0) return ("Коллекция итак пустая.");
            else {
                Hashtable<Long, Worker> workers = collection.getCollection();
                Enumeration keys = workers.keys();
                while (keys.hasMoreElements()) {
                    Long k = (Long) keys.nextElement();
                    Worker v = workers.get(k);
                    if (v.compareTo(newWorker) < 0 ) {
                        tumb = true;
                        collection.remove(k);
                        message+=("Работник с id:[" + k + "] успешно удален.");
                    }
                }
                if (!tumb) return ("Работников,меньше чем заданный не найдено."); else return message;
            }
        }
        catch (NumberFormatException | InputMismatchException e) {
            return ("Аргумент команды должен быть типа \"long\"");
        }
        catch (NullPointerException e){
            return ("Неверно указаны данные.");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}