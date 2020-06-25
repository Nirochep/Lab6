package Utility;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

public class ServerSender {
   public static Socket currentClientSocket;

    public  static void send(Object o,int answer){
        try {
            Map<Object,Integer> answerMap = new HashMap<>();
            answerMap.put(o,answer);
            System.out.println("Отсылаю ответ клиенту.");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(currentClientSocket.getOutputStream());
            objectOutputStream.writeObject(answerMap);
        } catch (IOException e) {
           System.err.println();
        }
    }
}
