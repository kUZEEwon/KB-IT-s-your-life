package com.multi.web04_mvc2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static void initConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading Successful");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr",
                    "root",
                    "1234");
            System.out.println("MySQL Connection Successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
