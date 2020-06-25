package Utility;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Map;

/**
 * The type Client receiver.
 */
public class ClientReceiver {
    ClientSender clientSender;
    public ClientReceiver(ClientSender clientSender){
        this.clientSender = clientSender;
    }
    /**
     * The constant client.
     */
   public static Socket socket;
    private static ByteBuffer buffer = ByteBuffer.allocate(10000);
    public Object receive() throws IOException, ClassNotFoundException, SocketTimeoutException {
        socket.setSoTimeout(2500);
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Object obj = objectInputStream.readObject();CreateWorker createWorker = new CreateWorker();
        Map<Object,Integer> answerMap = (Map<Object, Integer>) obj;
        obj = answerMap.entrySet().iterator().next().getKey();
        int a = answerMap.entrySet().iterator().next().getValue();
        if (a == 0) {
            return obj;
        }
        else if (a == 1){
            System.out.println("Необходимо заполнить доп.данные для выполнения команды");
            clientSender.send(createWorker.create());
            obj =this.receive();
        }
        else if (a == 2){
            System.out.println("Необходимо заполнить доп.данные для выполнения команды");
            clientSender.send(createWorker.createPerson());
            obj = this.receive();
        }
        return obj;
    }
}
