package ru.study.java.andrey;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public Server() {
        try {
            serverSocket = new ServerSocket(new ServerConfig().getPort());
            System.out.println(serverSocket);
            Socket client = serverSocket.accept();
            inputStream = new DataInputStream(client.getInputStream());
            String message = inputStream.readUTF();
            System.out.println(message);

            outputStream = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
