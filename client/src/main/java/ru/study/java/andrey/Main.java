package ru.study.java.andrey;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClientConfig clientConfig = new ClientConfig();
        Client client = new Client(clientConfig);
        client.run();
    }
}
