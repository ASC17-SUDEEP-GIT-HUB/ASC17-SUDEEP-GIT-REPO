package org.demo.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String url = "jdbc.mysql:127.0.0.1/busBookingDb";
    private static final String USERNAME = "root";
    private static final String password = "mysql";

    static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection(url, USERNAME, password);

        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(url, USERNAME, password);
            }catch (SQLException s) {
                System.out.println("Error Connecting");
                s.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
                connection = null;
            }catch (SQLException s) {
                s.printStackTrace();
            }
        }
    }
}
