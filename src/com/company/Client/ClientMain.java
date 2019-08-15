package com.company.Client;

import com.company.Server.Command;
import com.company.Server.Message;
import com.company.util.JSONParser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) throws InterruptedException {
        String clientName = "";

        try (Socket socket = new Socket("localhost", 45777);
            Scanner console_in = new Scanner(System.in);
            DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
            DataInputStream ois = new DataInputStream(socket.getInputStream()); )
        {

            System.out.println("You connected to Server.");
            System.out.println();

            while(!socket.isOutputShutdown()){
                    if(clientName.isEmpty()) {
                        System.out.println("Please enter your login. It should only contain lower case latin letters and have 4 symbols at most");
                        clientName = console_in.nextLine();
                    }
                    oos.writeUTF(clientName);
                    oos.flush();
                    if(clientName.equalsIgnoreCase(":quit")){
                        System.out.println("Killing connection...");
                        oos.close();
                        ois.close();
                        break;
                    }
                    if(clientName.equalsIgnoreCase(":changeLogin")) {clientName = ""; continue;}
                    String loginAnswer = ois.readUTF();
                    System.out.println(loginAnswer);
                    if(loginAnswer.equals("Failed to login")) {clientName = ""; continue;}
                    String command = "";
                    do{
                        command = console_in.nextLine().trim();
                        Command cm = Command.MESSAGE;
                        int argument;
                        if (command.startsWith(":delete")) cm = Command.DELETE;
                        else if (command.startsWith(":changeLogin")) cm = Command.CHANGE_LOGIN;
                        else if (command.startsWith(":quit")) cm = Command.CHANGE_LOGIN;
                        else if (command.startsWith(":show")) cm = Command.SHOW;
                        else cm = Command.MESSAGE;
                        Message ms = new Message(clientName, command, cm);
                        oos.writeUTF(JSONParser.toJson(ms));
                        System.out.println(ois.readUTF());
                    } while(!(command.trim().equals(":changeLogin") || command.trim().equals(":quit")));
                    if(command.equalsIgnoreCase(":quit")){
                        System.out.println("Killing connection...");
                        oos.close();
                        ois.close();
                        break;
                    } else clientName = "";

            }
            System.out.println("Goodbye!");

        } catch (UnknownHostException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Input or output troubles");
            e.printStackTrace();
        }
    }
}
