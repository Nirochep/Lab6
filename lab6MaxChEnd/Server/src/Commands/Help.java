package Commands;

import Stuff.CommandWithoutArg;
import Stuff.WorkerCollection;

/**
 * The type Help.
 */
public class Help implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "help";
    /**
     * The Worker collection.
     */
    WorkerCollection WorkerCollection = new WorkerCollection();

    @Override
    public String execute(Object o) {
        return ("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "insert id {element} : добавить новый элемент с заданным ключом\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove id : удалить элемент из коллекции по его ключу\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "history : вывести последние 12 команд (без их аргументов)\n" +
                "max_by_end_date : вывести любой объект из коллекции, значение поля endDate которого является максимальным\n" +
                "count_by_person person : вывести количество элементов, значение поля person которых равно заданному\n" +
                "filter_less_than_end_date endDate : вывести элементы, значение поля endDate которых меньше заданного");
    }

    @Override
    public String getName() {
        return name;
    }
}