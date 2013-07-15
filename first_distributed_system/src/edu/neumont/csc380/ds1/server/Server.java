package edu.neumont.csc380.ds1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 7/14/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Server {

    ServerSocket socket;
    int socketNumber;

    public Server(int socketNumber){
        this.socketNumber = socketNumber;
    }

    public void spin(){
        try {
            socket = new ServerSocket(socketNumber);
            while(true){
                Socket client = socket.accept();
                new MeThread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void main(String[] args){
        Server server = new Server(2222);
        server.spin();
    }
}
