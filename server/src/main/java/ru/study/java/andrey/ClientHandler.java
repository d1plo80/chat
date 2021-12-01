package ru.study.java.andrey;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private ClientsBroadcaster broadcaster;
    private MessageDAO messageDAO;
    private ActiveClientsDatabase activeClientsDatabase;

    public ClientHandler(Socket clientSocket, ClientsBroadcaster broadcaster, MessageDAO messageDAO, ActiveClientsDatabase activeClientsDatabase) throws IOException {
        this.clientSocket = clientSocket;
        this.inputStream = new ObjectInputStream(clientSocket.getInputStream());
        this.outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        this.broadcaster = broadcaster;
        this.messageDAO = messageDAO;
        this.activeClientsDatabase = activeClientsDatabase;
    }

    @Override
    public void run() {
        sendMessage(messageDAO.getAll());
        try {
            while (!clientSocket.isInputShutdown()) {
                readMessage();
            }
        } catch (IOException e) {
            closeResources();
        }
    }

    private void closeResources() {
        try {
            clientSocket.close();
            inputStream.close();
            outputStream.close();
            activeClientsDatabase.remove(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Object readMessage() throws IOException {
        Object message = inputStream.readUTF();
        System.out.println(message);
        broadcaster.broadcast((String) message);
        messageDAO.add((String) message);
        return message;
    }

    public void sendMessage(Object message) {
        try {
            outputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
