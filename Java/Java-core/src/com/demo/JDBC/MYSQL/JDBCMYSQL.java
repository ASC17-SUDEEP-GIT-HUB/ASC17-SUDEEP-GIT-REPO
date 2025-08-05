package com.demo.JDBC.MYSQL;

import java.sql.*;

public class JDBCMYSQL {

    public static void main(String[] args) throws ClassNotFoundException {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded!!");

            String url = ("jdbc:mysql://127.0.0.1:3306/myfriendDB?user=root&password=mysql");

            //     connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/myfriendDB", "root", "mysql");

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
            throw new RuntimeException(e.getMessage());
        }
        catch (SQLException se){
            throw new RuntimeException(se);
        }
    }
}