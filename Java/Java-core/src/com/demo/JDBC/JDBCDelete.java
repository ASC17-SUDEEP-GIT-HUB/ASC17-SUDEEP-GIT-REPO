package com.demo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDelete {
    public static void main(String[] args) {
        Connection connection = null;

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            System.out.println("Connection started");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=myFriendDB;user=sa;password=sqlserver;trustServerCertificate=true;";

            connection = DriverManager.getConnection(url);

            System.out.println("Connection established");

            System.out.println("Enter the id");

            int id = sc.nextInt();
            sc.nextLine();

            String sql = "Delete from friends where id = (?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            int insertedDetails = ps.executeUpdate();

            if(insertedDetails > 0) {
                System.out.println("success");
            }

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection != null) {
                    connection.close();
                }
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
