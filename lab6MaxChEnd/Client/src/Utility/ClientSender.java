package Utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * The type Client sender.
 */
public class ClientSender {
    /**
     * The Socket.
     */
    private static boolean serverisconnected = false;
    /**
     * The Port.
     */
   public static SocketAddress socketAddress;
   public static SocketChannel socketChannel;
    /**
     * Instantiates a new Client sender.
     *
     * @param port the port
     */
    public ClientSender(int port){
        socketAddress = new InetSocketAddress("localhost",port);
    }

    /**
     * Send.
     *
     */
    public static void connect() throws InterruptedException {
        boolean connected = false;
        while (!connected) {
        try {
                socketChannel = SocketChannel.open(ClientSender.socketAddress);
                ClientReceiver.socket = socketChannel.socket();
                connected = true;
            }catch (ConnectException e){
            System.out.println("Не удаётся подключится к серверу,пробую переподключится.");
            Thread.sleep(2000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    }
    public void send(Object o){
        try {

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(o);
            objectOutputStream.flush();
            objectOutputStream.close();
            byte[] buff = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            socketChannel.write(ByteBuffer.wrap(buff));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
