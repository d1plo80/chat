package ru.study.java.andrey;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerConfig serverConfig = new ServerConfig();
        ActiveClientsDatabase database = new ActiveClientsDatabase();
        ClientsBroadcaster broadcaster = new ClientsBroadcaster(database);
        MessageDAO messageDAO = new JDBCMessageDAO();
        Server server = new Server(serverConfig, database, broadcaster, messageDAO);
        server.run();
    }
}
