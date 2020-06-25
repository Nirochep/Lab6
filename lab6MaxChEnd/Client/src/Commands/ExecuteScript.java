package Commands;

import Stuff.Commandable;
import Stuff.Commands;
import Stuff.WorkerCollection;
import Utility.CreateWorker;
import Utility.ReaderFromFile;

import java.io.FileNotFoundException;

/**
 * The type Execute script.
 */
public class ExecuteScript implements Commandable {
    /**
     * The Name.
     */
    String name = "execute_script";
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();
    /**
     * The Reader.
     */

    /**
     * The Invoker.
     */

    @Override
    public String execute(Object arg) {
        ReaderFromFile reader = new ReaderFromFile();
        String message = "";
        try {
            String data = reader.readFromFile((String) arg);
            Commands command = new Commands();
            if (data != null) {
                String[] commands = data.split("\n|\r\n");
                for (int i = 0; i < commands.length; i++) {
                    if (!(commands[i].equals(""))) {
                        if (!(commands[i].equals("execute_script " + arg))) {
                            try {
                                String[] commandAndName = commands[i].split(" ");
                                if (commandAndName[0].equals("count_by_person")||commandAndName[0].equals("")||commandAndName[0].equals("insert")||commandAndName[0].equals("update")||commandAndName[0].equals("remove_greater")||commandAndName[0].equals("remove_lower")) {
                                    String paramData= "";
                                    try {
                                        for (int j = 0; j <12; j++) {
                                            i++;
                                            paramData+=commands[i]+";";
                                        }
                                        message+=("\nКоманда \"" + commands[i-12] + "\":+\n");
                                        CreateWorker.isFromScript = true;
                                        CreateWorker creater = new CreateWorker();
                                        creater.createFromExecute(paramData);
                                        message+=command.executeCommand(commands[i-12]);
                                        CreateWorker.isFromScript = false;
                                    } catch (IndexOutOfBoundsException e) {
                                        message+=("Недостаточно параметров+\n");
                                    }
                                }
                            } catch (Exception e) {
                                message+=("Команда \"" + commands[i] + "\":+\n");
                                message+=command.executeCommand(commands[i]);
                                message+="\n";
                            }

                        } else message+=("Команда \"" + commands[i] + "\": невыполнима.");
                    }
                }
            } else message+=("Указанный файл не найден.");
            return message;
        } catch (NullPointerException | FileNotFoundException e) {

        }
        return message;
    }

    @Override
    public String getName() {
        return name;
    }
}