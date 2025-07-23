package com.demo.JDBC;

import java.sql.*;
import java.util.Scanner;

public class JDBCINPUT {

    public static void main(String[] args) {
        Connection connection = null;

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver started!!!");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=myFriendDB;user=sa;password=sqlserver;trustServerCertificate=true;";

            connection = DriverManager.getConnection(url);

            System.out.println("Connection established!!");

           // Statement statement = connection.createStatement();
            System.out.println("Enter id, name, hobbies: ");
            int id = sc.nextInt();
            sc.nextLine();

            String name = sc.nextLine();

            String hobbies = sc.nextLine();

            String email = sc.nextLine();

            String sql = "Insert into friends(id, name, hobbies, email) values(?, ?, ?, ?)";

           PreparedStatement ps = connection.prepareStatement(sql);

           ps.setInt(1, id);
           ps.setString(2, name);
           ps.setString(3, hobbies);
           ps.setString(4, email);

           int insertDetails = ps.executeUpdate();

           if(insertDetails > 0) {
               System.out.println("Successfull!");
           }
        }

        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection != null && !connection.isClosed()) {
                    connection.close();
                }
            }catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
