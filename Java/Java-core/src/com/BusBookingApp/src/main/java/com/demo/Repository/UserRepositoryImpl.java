package com.BusBookingApp.src.main.java.com.demo.Repository;

import com.demo.Model.User;
import com.demo.Util.DBUtil;
import com.demo.Util.IdGeneratorUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public String addUser(User user) {
        String userId = generateUserId();
        user.setUserId(userId);
        user.setCreatedDate(LocalDateTime.now());

        String sql = "INSERT INTO users (userId, userName, email, phoneNumber, password, createdDate) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUserId());
            stmt.setString(2, user.getUserName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getPassword());
            stmt.setTimestamp(6, Timestamp.valueOf(user.getCreatedDate()));

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0 ? userId : null;

        } catch (SQLException e) {
            System.err.println("Error adding user: " + e.getMessage());
            return null;
        }
    }

    @Override
    public User getUserById(String userId) {
        String sql = "SELECT * FROM users WHERE userId = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToUser(rs);
            }

        } catch (SQLException e) {
            System.err.println("Error getting user by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToUser(rs);
            }

        } catch (SQLException e) {
            System.err.println("Error getting user by email: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error getting all users: " + e.getMessage());
        }
        return users;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET userName = ?, email = ?, phoneNumber = ?, password = ? WHERE userId = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhoneNumber());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getUserId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteUser(String userId) {
        String sql = "DELETE FROM users WHERE userId = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean validateUser(String email, String password) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.err.println("Error validating user: " + e.getMessage());
        }
        return false;
    }

    @Override
    public String generateUserId() {
        String sql = "SELECT userId FROM users ORDER BY userId DESC LIMIT 1";
        int maxId = 0;

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                String lastId = rs.getString("userId");
                maxId = IdGeneratorUtil.extractIdNumber(lastId);
            }

        } catch (SQLException e) {
            System.err.println("Error generating user ID: " + e.getMessage());
        }

        return IdGeneratorUtil.generateUserId(maxId);
    }

    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getString("userId"));
        user.setUserName(rs.getString("userName"));
        user.setEmail(rs.getString("email"));
        user.setPhoneNumber(rs.getString("phoneNumber"));
        user.setPassword(rs.getString("password"));
        user.setCreatedDate(rs.getTimestamp("createdDate").toLocalDateTime());
        return user;
    }
}
