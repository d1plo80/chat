package ru.study.java.andrey;

import java.util.List;

public interface MessageDAO {
    void add(String message);
    List<String> getAll();
}
