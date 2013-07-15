package edu.neumont.csc380.ds2.server;

import edu.neumont.csc380.ds1.server.MathLogic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 7/14/13
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class MeThread_2 extends Thread {

    Socket socket;
    public MeThread_2(Socket s){
        socket = s;
    }

    @Override
    public void run() {
        MathLogic_1 logic = new MathLogic_1();
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input, output;

            output = "Welcome to Math Server";
            out.println(output);

            input = in.readLine();
            String[] inputs = input.split(";");
            if(Integer.parseInt(inputs[0]) == 1)
                output = logic.add(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2])) + "";
            else
                output = logic.subtract(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2])) + "";
            out.println(output);

            out.println("Goodbye!");

            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
