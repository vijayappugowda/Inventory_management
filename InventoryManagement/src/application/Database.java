package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/inventory_db";
    private static final String USER = "root";
    private static final String PASSWORD = "2002"; // change to your password

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
