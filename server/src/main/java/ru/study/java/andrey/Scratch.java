package ru.study.java.andrey;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Scratch {
    private final static Logger LOG = LoggerFactory.getLogger(Scratch.class);
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Class.forName("org.postgresql.Driver");
        HikariConfig config = new HikariConfig("/hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        LOG.info("test");

        String message = "hello' ; DELETE FROM chat.archive; --";

        Connection conn = null;
        try {
            conn = ds.getConnection();

            if (conn == null) {
                System.out.println("Нет соединения с БД!");
                System.exit(0);
            }

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO chat.archive (message) VALUES (?)");
            stmt.setString(1, message);
            stmt.execute();

//            while (rs.next()) {
//                System.out.println(rs.getRow() + ". " + rs.getString("firstname")
//                        + "\t" + rs.getString("lastname"));
//            }

            /**
             * stmt.close();
             * При закрытии Statement автоматически закрываются
             * все связанные с ним открытые объекты ResultSet
             */
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if (conn != null){
                conn.close();
                ds.close();
            }
        }

        // реализовать connection pool
        // sql injection (посмореть)
        // prepared statement ()
    }
}