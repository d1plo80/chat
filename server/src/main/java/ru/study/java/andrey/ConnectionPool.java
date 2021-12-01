package ru.study.java.andrey;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static final ConnectionPool INSTANCE = new ConnectionPool();
    private final static Logger LOG = LoggerFactory.getLogger(ConnectionPool.class);
    private final HikariConfig config = new HikariConfig("/hikari.properties");
    private final HikariDataSource ds = new HikariDataSource(config);

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        LOG.info("Выполнено подключение к базе данных");
        return ds.getConnection();
    }
}
