package ru.study.java.andrey;

import java.util.ArrayList;
import java.util.List;

public class ActiveClientsDatabase {
    private List<ClientHandler> clients = new ArrayList<>();

    public void add(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public List<ClientHandler> getAll() {
        return new ArrayList<>(clients);
    }

    public void remove(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }
}
