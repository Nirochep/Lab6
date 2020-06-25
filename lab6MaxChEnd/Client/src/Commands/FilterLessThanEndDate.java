package Commands;

import Stuff.Commandable;
import Stuff.Worker;
import Stuff.WorkerCollection;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;

/**
 * The type Filter less than end date.
 */
public class FilterLessThanEndDate implements Commandable {
    /**
     * The Name.
     */
    String name = "filter_less_than_end_date";
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();
    @Override
    public String execute(Object o) throws FileNotFoundException {
        try {
            LocalDate maxdate = LocalDate.parse((String) o);
            if (collection.getSize() == 0) return ("Коллекция  пустая.");
            else {
                int i = 0;
                String message ="Эти люди не доработают до заданной даты:\n";
                for (Map.Entry<Long, Worker> entry : collection.getCollection().entrySet()) {
                    if (entry.getValue().getEndDate().toLocalDate().isBefore(maxdate)) {
                        i++;
                         message+=collection.getCollection().get(entry.getKey()).getInfo()+"\n";
                    }
                }
                if (i==0) return ("К счастью все ваши работники будут ещё на месте к заданной дате.");
                else return message;
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
