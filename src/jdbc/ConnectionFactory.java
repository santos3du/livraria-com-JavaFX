package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
        String url = "jdbc:mysql://localhost/livraria";
        try {
            return DriverManager.getConnection(url, "root", "223580");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
