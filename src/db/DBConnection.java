package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static final String URL = "jdbc:mysql://localhost:3306/inventory_management";
    static final String USER = "root";
    static final String PASSWORD = "Rajitha333@";

    public static Connection getConnection() {

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully");

            return con;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public static void main(String[] args) {
        getConnection();
    }
}