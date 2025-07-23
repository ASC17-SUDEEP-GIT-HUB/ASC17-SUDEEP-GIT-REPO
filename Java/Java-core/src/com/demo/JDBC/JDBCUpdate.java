package com.demo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUpdate {
    public static void main(String args[]) {

        Connection connection = null;

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            System.out.println("Connection started!");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=myFriendDB;user=sa;password=sqlserver;trustServerCertificate=true;";

            connection = DriverManager.getConnection(url);

            System.out.println("Connection established!");

            System.out.println("Enter the hobbies and id: ");
            String hobbies = sc.nextLine();

            int id = sc.nextInt();

            String sql = "Update friends set hobbies = (?) where id = (?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, hobbies);
            ps.setInt(2, id);

            int insertDetails = ps.executeUpdate();

            if(insertDetails > 0) {
                System.out.println("success");
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }finally {
            try {
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
