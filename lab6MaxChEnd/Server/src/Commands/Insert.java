package Commands;

import Stuff.CommandWithoutArg;
import Stuff.WorkerCollection;
import Utility.CreateWorker;
import Stuff.Worker;
import Utility.ServerReceiver;
import Utility.ServerSender;

import java.util.InputMismatchException;

/**
 * The type Insert.
 */
public class Insert implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "insert";
    /**
     * The Worker collection.
     */
    WorkerCollection WorkerCollection = new WorkerCollection();
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
        return WorkerCollection.isKeyFree((Long) arg);
    }


    /**
     * Gets new worker.
     *
     * @param params the params
     * @return the new worker
     */
    public Worker getNewWorker(Object params) { CreateWorker CreateWorker = new CreateWorker();
        if (!Utility.CreateWorker.isFromScript) return (Worker) ServerReceiver.receive();
        else return Utility.CreateWorker.workerFromScript;
    }

    @Override
    public String execute(Object arg) {
        try {
            if (!Utility.CreateWorker.isFromScript)  ServerSender.send("kek",1);
            Worker Worker = this.getNewWorker(null);
            Worker.setId(WorkerCollection.generateId());
                WorkerCollection.insert(Worker.getId(),Worker);
                return ("Работник добавлен в коллекцию!");

        } catch (NumberFormatException | InputMismatchException e) {
            return ("Аргумент команды должен быть типа \"long\"");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
