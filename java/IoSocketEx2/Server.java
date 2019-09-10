package IoSocketEx2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public final static int SERVER_PORT = 9669;
	 
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            while (true) {
                try {
                    System.out.println("Client accepted: ");
                    
                    while (true) {
                    	Socket socket = serverSocket.accept();
                    	OutputStream os = socket.getOutputStream();
                        InputStream is = socket.getInputStream();
                        Thread thread= new ClientHandler(is,os,socket);
        				thread.start();
                        }   
                    }
                 
                 catch (IOException e) {
                    System.err.println(" Connection Error: " + e);
                }
            }
        } catch (IOException e1) {
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

}
