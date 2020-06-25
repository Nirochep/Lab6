package Stuff;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * The type Commands.
 */
public class Commands {
    private static Map<String, Commandable> commands = new TreeMap<>();
    private static ArrayList<String> history = new ArrayList<>();
    public static  Boolean timeTostop = false;

    /**
     * Gets history.
     *
     * @return the history
     */
    public static ArrayList<String> getHistory() {
        return history;
    }

    /**
     * Gets command.
     *
     * @param commandname the commandname
     * @return the command
     */
    public Commandable getCommand(String commandname) {
        return commands.get(commandname);
    }

    /**
     * Regist.
     *
     * @param commands the commands
     */
    public void regist(Commandable... commands) {
        for (Commandable command : commands) {
            Commands.commands.put(command.getName(), command);
        }
    }

    /**
     * Add to history.
     *
     * @param commandName the command name
     */
    public void addToHistory(String commandName){
        if (!commandName.equals("history")) {
            history.add(commandName);
        }
    }

    /**
     * Execute command.
     *
     * @param commandName the command name
     */
    public Map<Commandable,String> executeCommand(String commandName) throws FileNotFoundException {
        String[] nameAndArgument = commandName.split(" ");
        Map<Commandable,String> comandAndParam = new HashMap();
        if (!commandName.equals("")) {
            if (nameAndArgument[0].equals("exit")) {
                comandAndParam.put(commands.get(nameAndArgument[0]), null);
                timeTostop = true;
                return comandAndParam;
            } else
            if (nameAndArgument[0].equals("history")) {
                System.out.println(commands.get(nameAndArgument[0]).execute(null));
                return null;
            } else
            if (nameAndArgument[0].equals("help")) {
                System.out.println(commands.get(nameAndArgument[0]).execute(null));
                addToHistory(nameAndArgument[0]);
                return null;
            } else {
                if (commands.get(nameAndArgument[0]) == null) {
                    System.out.println("Такой команды не существует, введите \"help\", чтобы ознакомиться со всем перечнем команд.");
                } else {
                    try {
                        CommandWithoutArg commandWithoutArg = (CommandWithoutArg) commands.get(nameAndArgument[0]);
                        try {
                            String s = nameAndArgument[1];
                            System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        } catch (Exception e) {
                            comandAndParam.put(commands.get(nameAndArgument[0]), null);
                            addToHistory(nameAndArgument[0]);
                            return comandAndParam;
                        }
                    } catch (Exception e) {
                        try {
                            String s = nameAndArgument[2];
                            System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        } catch (IndexOutOfBoundsException e1) {
                            try {
                                comandAndParam.put(commands.get(nameAndArgument[0]), nameAndArgument[1]);
                                addToHistory(nameAndArgument[0]);
                                return comandAndParam;
                            } catch (IndexOutOfBoundsException e2) {
                                System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                            }
                        }
                    }
                }
            }
        }
    return null;}
}