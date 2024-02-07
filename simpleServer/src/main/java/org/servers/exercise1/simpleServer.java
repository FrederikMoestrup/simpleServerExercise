package org.servers.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class simpleServer {

    protected ServerSocket serverSocket;
    protected Socket clientSocket;
        protected PrintWriter out;
        protected BufferedReader in;


        public static void main(String[] args) {
            simpleServer server = new simpleServer();
        server.start(8080);
        server.stop();
    }

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String greeting = in.readLine();
            System.out.println(greeting);
            out.println("Hello Fred1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
