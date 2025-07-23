package com.demo.JDBC;

import java.sql.*;

public class JDBCSelectStatement {

    public static void main(String[] args) throws ClassNotFoundException {

        Connection connection = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver Loaded!!");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=myFriendDB;user=sa;password=sqlserver;trustServerCertificate=true;";


            connection = DriverManager.getConnection(url);
            System.out.println("Connection established!!");

            Statement statement = connection.createStatement();

            System.out.println("Statment is created");
            System.out.println("---------//----------");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM friends");
            resultSet.next();
//             int frndId = resultSet.getInt("id");
//          //  System.out.println(resultSet.getInt("id"));
//            System.out.println("ID : " + frndId);

//            String frndName = resultSet.getString("name");
//            System.out.println("Name : " + frndName);
//
//            String frndHobbies = resultSet.getString("hobbies");
//            System.out.println("Hobbies are : " + frndHobbies);

            while(resultSet.next()) {
                int frndId = resultSet.getInt("id");
                String frnd = resultSet.getString("name");
                String frndHobbie = resultSet.getString("hobbies");

                System.out.println("Id is : " + frndId);
                System.out.println("Name is : " + frnd);
                System.out.println("Hobbie is : " + frndHobbie);
                System.out.println("-------------------");
            }

            //for()



        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (SQLException se){
            throw new RuntimeException(se);
        }
    }
}