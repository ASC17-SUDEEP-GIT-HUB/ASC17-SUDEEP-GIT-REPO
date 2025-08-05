package com.demo.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connection;

    private DbConnection() {

    }

    public static Connection getInstance() {
        if(connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc.mysql://127.0.0.1/myfriendDB", "root", "mysql");

                return connection;

            }catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}
