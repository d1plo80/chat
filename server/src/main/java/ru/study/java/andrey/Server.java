package ru.study.java.andrey;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;
    private final ActiveClientsDatabase base;
    private final ClientsBroadcaster broadcaster;
    private final MessageDAO messageDAO;


    public Server(ServerConfig config, ActiveClientsDatabase base, ClientsBroadcaster broadcaster, MessageDAO messageDAO) throws IOException {
        serverSocket = new ServerSocket(config.getPort());
        this.base = base;
        this.broadcaster = broadcaster;
        this.messageDAO = messageDAO;
        System.out.println(serverSocket);
    }

    public void run() {
        while (true) {
            try {
                Socket client = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(client, broadcaster, messageDAO, base);
                base.add(clientHandler);
                Thread thread = new Thread(clientHandler);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
