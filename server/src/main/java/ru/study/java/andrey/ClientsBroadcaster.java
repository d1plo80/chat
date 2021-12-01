package ru.study.java.andrey;

import java.util.List;

public class ClientsBroadcaster {
    private final ActiveClientsDatabase base;

    public ClientsBroadcaster(ActiveClientsDatabase base) {
        this.base = base;
    }

    public void broadcast(String message) {
        List<ClientHandler> all = base.getAll();
        for (ClientHandler clientHandler : all) {
            clientHandler.sendMessage(message);
        }
    }
}
