package main_package;

import java.util.logging.Logger;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        try(    
            Socket clientSocket = new Socket("localhost",1310);
            InputStream inputStream = clientSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
                
            OutputStream outputStream = clientSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream)
        ){
            dataOutputStream.writeUTF("[Other is ready]");
            String message = new String(dataInputStream.readUTF());
            Printer.showMessage(message);
            
            // Start a new thread to handle incoming messages from the server
            Thread serverThread = new Thread(new Runnable() {
                public void run() {
                    while(1<2) {
                        try {
                            String message = new String(dataInputStream.readUTF());
                            Printer.showMessage(message);
                        } catch(IOException exception) {
                            Printer.showMessage(exception.getMessage());
                            break;
                        }
                    }
                }
            });
            serverThread.start();
            while(1<2){
                String clientMessage = inputScanner.nextLine();
                dataOutputStream.writeUTF("[Other] : "+clientMessage);
            }
        } catch (Exception exception){
            Printer.showMessage(exception.getMessage());
        }
    }
}