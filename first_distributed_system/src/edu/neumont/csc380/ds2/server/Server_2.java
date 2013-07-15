package edu.neumont.csc380.ds2.server;

import edu.neumont.csc380.ds1.server.MeThread_1;

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
public class Server_2 {

    ServerSocket socket;
    int socketNumber;

    public Server_2(int socketNumber){
        this.socketNumber = socketNumber;
    }

    public void spin(){
        try {
            socket = new ServerSocket(socketNumber);
            while(true){
                Socket client = socket.accept();
                new MeThread_1(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void main(String[] args){
        Server_2 server = new Server_2(2222);
        server.spin();
    }
}
