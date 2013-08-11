package edu.neumont.csc380.ds2.client;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 7/14/13
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client_2 {

    Socket socket;
    int socketNumber;

    String[] methods;

    public Client_2(int socketNumber){
        this.socketNumber = socketNumber;
    }

    public void start(){
        try {
            socket = new Socket("127.0.0.1", socketNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String output;

            // 1
            {
                printOutFromServer(in);
                printOutOptions(in, "Method");
            }
            // 2
            {
                int methodChoice = getInt() - 1;
                output = methodChoice + "";
                out.println(output);
            }
            // 3
            {
                System.out.println("Enter Parameters in a list separated by commas: ");
                output = getConsoleInput();
                out.println(output);
            }
            // 4
            {
                printOutFromServer(in);
                printOutFromServer(in);
            }


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    // Prints out the response from the server
    private void printOutFromServer(BufferedReader in) throws IOException {
        String input = in.readLine();
        System.out.println(input);
    }

    // Prints out the given method options
    private void printOutOptions(BufferedReader in, String type) throws IOException {
        String input = in.readLine();
        methods = input.split(";");

        System.out.println("    Select a " + type);
        for(int i = 0; i < methods.length; i++){
            System.out.println("        " + (i+1) + ") " + methods[i].toUpperCase());
        }
    }

    // Get an int from the user.
    private int getInt(){
        Scanner scan = new Scanner(System.in);
        String lineIn = scan.nextLine();
        int input = Integer.parseInt(lineIn);
        return input;
    }

    private String getConsoleInput(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void main(String[] args){
        Client_2 client = new Client_2(2222);
        client.start();
    }
}
