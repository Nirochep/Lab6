package Commands;

import Stuff.CommandWithoutArg;
import Stuff.*;

import java.util.ArrayList;

/**
 * The type History.
 */
public class History implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "history";

    @Override
    public String execute(Object o) {
        ArrayList<String> history = Commands.getHistory();
        if (history.size() == 0) return ("История пустая.");
        else {
            int numOfCommands = history.size();
            String message = "";
            message += ("Последние выполненные команды:");
            try {
                for (int i = numOfCommands; i > numOfCommands - 12; i--) {
                    message += (history.get(i)) + "\n";
                }
                return message;
            } catch (IndexOutOfBoundsException e) {

                message = "";
                for (int i = 0; i < numOfCommands; i++)
                    message += (history.get(i)) + "\n";
                return message;
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }
}