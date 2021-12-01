package ru.study.java.andrey;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCMessageDAO implements MessageDAO {

    @Override
    public void add(String message) {
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement smtp = connection.prepareStatement("INSERT INTO chat.archive (message) VALUES (?)");
            smtp.setString(1, message);
            smtp.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getAll() {
        List<String> archive = new ArrayList<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            Statement smtp = connection.createStatement();
            ResultSet resultSet =  smtp.executeQuery("SELECT * FROM chat.archive");
            while (resultSet.next()) {
                String message = resultSet.getString("message");
                archive.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return archive;
    }
}
