import Stuff.*;
import Utility.*;
import Commands.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * The type Main.
 */
public class Server {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws FileNotFoundException the file not found exception
     * @author Max
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        ServerSender serverSender = new ServerSender();
        ServerReceiver serverReceiver = new ServerReceiver("localhost",3018);
        Commands commands = new Commands();
        Collection collection = new Collection();
        String filename = System.getenv("file");
        ReaderFromFile readerFromFile = new ReaderFromFile();
       // collection.fillCollection(readerFromFile.readFromFile(filename));
          collection.fillCollection(readerFromFile.readFromFile("collection.txt"));
          collection.checkForSaveCommand();
        commands.regist(new Show(),new Exit(),new Save(),new Info(),new Help(),new Clear(),new Insert(),new UpdateId(),new RemoveGreater(),new RemoveId(),new RemoveLower(),new MaxByEndDate(),new FilterLessThanEndDate(),new CountByPerson(),new ExecuteScript());
        while (true) {
            Map<Commandable, String> commandableStringMap = (Map<Commandable, String>) ServerReceiver.receive();
            ServerReceiver.isBusy = true;

            try {
                System.out.println("Принял команду "+commandableStringMap.entrySet().iterator().next().getKey().getName()+" от клиента.");
                String answer = commandableStringMap.entrySet().iterator().next().getKey().execute(commandableStringMap.entrySet().iterator().next().getValue());
                serverSender.send(answer, 0);
                ServerReceiver.isBusy = false;
            } catch (NullPointerException e) { ;
                ServerSender.currentClientSocket.close();
                System.out.println("Клиент не cтал заполнять поля и отключился :(");
                ServerReceiver.isBusy = false;
            }
        }
    }
}

