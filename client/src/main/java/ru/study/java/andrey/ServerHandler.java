package ru.study.java.andrey;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ServerHandler implements Runnable {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public ServerHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.inputStream = new ObjectInputStream(socket.getInputStream());
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            List allMessages = (List) inputStream.readObject();
            for (Object message : allMessages) {
                System.out.println(message);
            }
            initMessageListener();
            boolean b = true;
            while (b) {
                sendMessage(scanner.nextLine());
            }
            closeResources();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) throws IOException {
        outputStream.writeUTF(message);
        outputStream.flush();
    }

    private void initMessageListener() {
        new Thread(() -> {
            while (true) {
                try {
                    Object message = inputStream.readObject();
                    System.out.println(message);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        })
                .start();
    }

    private void closeResources() throws IOException {
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
