package ru.study.java.andrey;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public Client() {
        try {
            socket = new Socket(new ClientConfig().getServerIP(), new ClientConfig().getPort());
            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Test");

            inputStream = new DataInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
