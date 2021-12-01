package ru.study.java.andrey;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageArchive implements MessageDAO {
    private static final MessageArchive INSTANCE = new MessageArchive();
    private List<String> messages = new CopyOnWriteArrayList<>();

    private MessageArchive() {
    }

    public static MessageArchive getArchive() {
        return INSTANCE;
    }

    @Override
    public void add(String message) {
        messages.add(message);
    }

    @Override
    public List<String> getAll() {
        return new ArrayList<>(messages);
    }

}
