package ru.study.java.andrey;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClientConfig {
    private int port;
    private String serverIP;

    public ClientConfig() {
        clientSetup();
    }

    public int getPort() {
        return port;
    }

    public String getServerIP() {
        return serverIP;
    }

    private void clientSetup() {
        try {
            InputStream resourceAsStream = Client.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            String text = properties.getProperty("clientPort");
            port = Integer.parseInt(text);
            serverIP = properties.getProperty("serverIP");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
