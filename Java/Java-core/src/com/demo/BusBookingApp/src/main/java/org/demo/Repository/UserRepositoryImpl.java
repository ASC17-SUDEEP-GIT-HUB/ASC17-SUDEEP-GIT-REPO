package org.demo.Repository;
import org.demo.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.demo.Util.DBUtil;
import org.demo.Util.IdGenaratorUtil;

public class UserRepositoryImpl implements UserRepository {

    private Connection conn;
   // Scanner sc = new Scanner(System.in);

    public UserRepositoryImpl(){
        conn = DBUtil.getConnection();

    }

    public String getNextUserId() {

        return IdGenaratorUtil.generateId(conn ,"U", "users", "userId");
    }

    @Override
    public boolean addUser(User user) {
        try {
            String userId = getNextUserId();

//            System.out.println("Enter the Name: ");
//            String name = sc.nextLine();
//
//            System.out.println("Enter the email: ");
//            String email = sc.nextLine();
//
//            System.out.println("Enter the Phone Number: ");
//            double phoneNumber = sc.nextInt();
//            sc.nextLine();
//
//            System.out.println("Enter the password: ");
//            String password = sc.nextLine();

            String sql = "Insert into users(userId, name, email, phoneNumber, password) values(?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhoneNumber());
            ps.setString(5, user.getPassword());

            int insertedRows = ps.executeUpdate();

            if(insertedRows > 0) {
                user.setUserId(userId);
                System.out.println("User added!!! No of rows affected: " + insertedRows);
                return true;
            }else {
                System.out.println("User not added!");
                return false;
            }
        }catch (SQLException s) {
            s.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
//            System.out.println("Enter the email id to get User: ");
//            String emailid = sc.nextLine();

            String sql = "SELECT * FROM users WHERE email = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                 user = new User();

                user.setUserId(rs.getString("userId"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setPassword(rs.getString("password"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
    public User getUserById(String userId) {
        User user = null;
        try {
//            System.out.println("Enter the email id to get User: ");
//            String emailid = sc.nextLine();

            String sql = "SELECT * FROM users WHERE userId = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, userId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                user = new User();

                user.setUserId(rs.getString("userId"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setPassword(rs.getString("password"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
    public List<User> getAllusers() {

        List<User> list = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                User user = new User();

                user.setUserId(rs.getString("userId"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setPassword(rs.getString("password"));

                list.add(user);
            }

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
}
