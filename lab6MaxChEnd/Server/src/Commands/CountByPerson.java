package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Worker;
import Stuff.WorkerCollection;
import Utility.CreateWorker;
import Utility.ServerReceiver;
import Utility.ServerSender;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * The type Count by person.
 */
public class CountByPerson implements CommandWithoutArg {
    String name = "count_by_person";
    WorkerCollection collection = new WorkerCollection();


    public boolean check(Object arg) {
        return collection.isKeyFree((Long) arg);
    }


    /**
     * Gets new worker.
     *
     * @param params the params
     * @return the new worker
     */
    public Worker getNewWorker(Object params) {CreateWorker CreateWorker = new CreateWorker();
        if (!CreateWorker.isFromScript) return (Worker) ServerReceiver.receive();
        else return CreateWorker.workerFromScript;
    }

    @Override
    public String execute(Object o) throws FileNotFoundException {
            try{
                int i;
                ServerSender.send("kek",2);
                Worker Worker = this.getNewWorker(null);
                i = (int) collection.getCollection().entrySet().stream().filter(x -> x.getValue().getPerson().equals(Worker.getPerson())).count();
                return ("Указанных вами людей в коллекции: "+i);
            }catch (NullPointerException e){
                return ("Неверно указаны данные.");
            }
    }

    @Override
    public String getName() {
        return name;
    }
}
