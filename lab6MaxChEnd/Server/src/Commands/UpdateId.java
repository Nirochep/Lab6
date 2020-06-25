package Commands;

import Stuff.*;
import Utility.CreateWorker;
import Utility.ServerReceiver;
import Utility.ServerSender;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 * The type Update id.
 */
public class UpdateId implements Commandable {
    /**
     * The Name.
     */
    String name = "update";
    /**
     * The Create worker.
     */

    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();

    /**
     * Check boolean.
     *
     * @param arg the arg
     * @return the boolean
     */
    public boolean check(Object arg) {
        return !collection.isKeyFree((Long) arg);
    }

    /**
     * Gets new worker.
     *
     * @param params the params
     * @return the new worker
     */
    public Worker getNewWorker(Object params) { CreateWorker CreateWorker = new CreateWorker();
        if (!CreateWorker.isFromScript) return (Worker) ServerReceiver.receive();
        else return CreateWorker.workerFromScript;
    }

    @Override
    public String execute(Object arg) throws FileNotFoundException {
        try {
            long id = Long.parseLong((String) arg);
            if (this.check(id)) {
                ServerSender.send("kek",1);
                Worker Worker = this.getNewWorker(null);
                if (Worker != null) {
                    Worker.setId(id);
                    collection.update( id, Worker);
                    return ("Работник с id[" + arg + "] успешно обновлен.");
                }
            } else return ("Работник с указанным id не найден.");
        } catch (NumberFormatException | InputMismatchException e) {
            return ("Аргумент команды должен быть типа \"long\"");
        }
        catch (NullPointerException e){
            return ("Неверно указаны данные.");
        }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}
