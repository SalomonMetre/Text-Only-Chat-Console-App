package main_package;

import java.util.logging.Logger;
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class SimpleServer {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int portNumber = 1310;
        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            OutputStream outputStream = clientSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                
            InputStream inputStream = clientSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream)
        ){
            dataOutputStream.writeUTF("[Other is ready]");
            String message = new String(dataInputStream.readUTF());
            Printer.showMessage(message);
            
            // Start a new thread to handle incoming messages from the client
            Thread clientThread = new Thread(new Runnable() {
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
            clientThread.start();
            while(1<2){
                String serverMessage = inputScanner.nextLine();
                dataOutputStream.writeUTF("[Other] : "+serverMessage);  
            }       
        } catch (IOException exception){
            Printer.showMessage(exception.getMessage());
        }
    }
}