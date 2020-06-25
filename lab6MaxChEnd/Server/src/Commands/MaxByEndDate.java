package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Commandable;
import Stuff.Worker;
import Stuff.WorkerCollection;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Map;

/**
 * The type Max by end date.
 */
public class MaxByEndDate implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "max_by_end_date";
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();
    @Override
    public String execute(Object o) throws FileNotFoundException {
        try {
            if (collection.getSize() == 0) return ("Коллекция  пустая.");
            else {
            LocalDate maxDate = collection.getCollection().entrySet().iterator().next().getValue().getEndDate().toLocalDate();
            Long maxId =  collection.getCollection().entrySet().iterator().next().getKey();
                for (Map.Entry<Long, Worker> entry : collection.getCollection().entrySet()) {
                    if (entry.getValue().getEndDate().toLocalDate().isAfter(maxDate)) {
                        maxId = entry.getKey();
                        maxDate = entry.getValue().getEndDate().toLocalDate();
                    }
                }
                String message= "";
                message+= "Работник,который будет работать больше всех,аж до этой даты: "+maxDate+"\n";
                message+=(collection.getCollection().get(maxId).getInfo());
                return message;
            }
        } catch (DateTimeParseException e) {
            return ("Неверно указан формат даты.Попробуйте ввести команду ещё раз.(Формат даты YYYY-MM-HH");
        }
    }
    @Override
    public String getName() {
        return name;
    }
}
