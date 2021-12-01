package ru.study.java.andrey;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket socket;

    public Client(ClientConfig config) throws IOException {
        socket = new Socket(config.getServerIP(), config.getPort());
    }

    public void run() {
        try {
            ServerHandler serverHandler = new ServerHandler(socket);
            serverHandler.run();
//            Thread thread = new Thread(serverHandler);
//            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

