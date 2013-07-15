package edu.neumont.csc380.ds1.client;

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
public class Client {

    Socket socket;
    int socketNumber;

    public Client(int socketNumber){
        this.socketNumber = socketNumber;
    }

    public void start(){
        try {
            socket = new Socket("127.0.0.1", socketNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input, output;

            printOutFromServer(in);

            System.out.println("Would you like to add or subtract?" + '\n' + "1) Add" + '\n' + "2) Subtract");

            Scanner scan = new Scanner(System.in);
            int selection = getInput(scan);
            String type;
            if(selection == 1){
                type = "add";
            }else{
                type = "subtract";
            }
            int[] values = getValues(scan, type);
            output = selection + ";" + values[0] + ";" + values[1];
            out.println(output);

            printOutFromServer(in);
            printOutFromServer(in);

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void printOutFromServer(BufferedReader in) throws IOException {
        String input = in.readLine();
        System.out.println(input);
    }

    public int[] getValues(Scanner scan, String type){
        System.out.println("Enter the two values you would like to " + type + ": " + '\n' + "One: ");
        int one = getInput(scan);
        System.out.println("Two: ");
        int two = getInput(scan);
        int[] results = new int[2];
        results[0] = one;
        results[1] = two;
        return results;
    }

    public int getInput(Scanner scan){
        String lineIn = scan.nextLine();
        int input = Integer.parseInt(lineIn);
        return input;
    }

    public static void main(String[] args){
        Client client = new Client(2222);
        client.start();
    }
}
