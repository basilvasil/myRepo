package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String url = "jdbc:postgresql://practicedatabase.cyujpfbj7s2c.us-east-2.rds.amazonaws.com:5432/postgres";
    private static final String userName = "postgres";
    private static final String password = "Mav2680178719!";
    private static Connection connection;

    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }
}
