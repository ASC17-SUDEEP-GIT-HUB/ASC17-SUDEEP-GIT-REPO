package com.BusBookingApp.src.main.java.com.demo.Repository;

import com.demo.Model.Ticket;
import com.demo.Util.DBUtil;
import com.demo.Util.IdGeneratorUtil;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {

    @Override
    public String bookTicket(Ticket ticket) {
        String ticketId = generateTicketId();
        ticket.setTicketId(ticketId);
        ticket.setBookingDate(LocalDateTime.now());
        ticket.setStatus("BOOKED");

        String sql = "INSERT INTO tickets (ticketId, userId, busId, passengerName, seatNumber, " +
                "bookingDate, travelDate, totalAmount, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ticket.getTicketId());
            stmt.setString(2, ticket.getUserId());
            stmt.setString(3, ticket.getBusId());
            stmt.setString(4, ticket.getPassengerName());
            stmt.setInt(5, ticket.getSeatNumber());
            stmt.setTimestamp(6, Timestamp.valueOf(ticket.getBookingDate()));
            stmt.setDate(7, Date.valueOf(ticket.getTravelDate()));
            stmt.setBigDecimal(8, ticket.getTotalAmount());
            stmt.setString(9, ticket.getStatus());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0 ? ticketId : null;

        } catch (SQLException e) {
            System.err.println("Error booking ticket: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Ticket getTicketById(String ticketId) {
        String sql = "SELECT * FROM tickets WHERE ticketId = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ticketId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToTicket(rs);
            }

        } catch (SQLException e) {
            System.err.println("Error getting ticket by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ticket> getTicketsByUserId(String userId) {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets WHERE userId = ? ORDER BY bookingDate DESC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                tickets.add(mapResultSetToTicket(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error getting tickets by user ID: " + e.getMessage());
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTicketsByBusId(String busId) {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets WHERE busId = ? AND status = 'BOOKED'";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, busId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                tickets.add(mapResultSetToTicket(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error getting tickets by bus ID: " + e.getMessage());
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTicketsByDate(LocalDate travelDate) {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets WHERE travelDate = ? AND status = 'BOOKED'";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(travelDate));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                tickets.add(mapResultSetToTicket(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error getting tickets by date: " + e.getMessage());
        }
        return tickets;
    }

    @Override
    public boolean cancelTicket(String ticketId) {
        String sql = "UPDATE tickets SET status = 'CANCELLED' WHERE ticketId = ? AND status = 'BOOKED'";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ticketId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error cancelling ticket: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateTicket(Ticket ticket) {
        String sql = "UPDATE tickets SET passengerName = ?, seatNumber = ?, travelDate = ?, " +
                "totalAmount = ?, status = ? WHERE ticketId = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ticket.getPassengerName());
            stmt.setInt(2, ticket.getSeatNumber());
            stmt.setDate(3, Date.valueOf(ticket.getTravelDate()));
            stmt.setBigDecimal(4, ticket.getTotalAmount());
            stmt.setString(5, ticket.getStatus());
            stmt.setString(6, ticket.getTicketId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error updating ticket: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Integer> getBookedSeats(String busId, LocalDate travelDate) {
        List<Integer> bookedSeats = new ArrayList<>();
        String sql = "SELECT seatNumber FROM tickets WHERE busId = ? AND travelDate = ? AND status = 'BOOKED'";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, busId);
            stmt.setDate(2, Date.valueOf(travelDate));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                bookedSeats.add(rs.getInt("seatNumber"));
            }

        } catch (SQLException e) {
            System.err.println("Error getting booked seats: " + e.getMessage());
        }
        return bookedSeats;
    }

    @Override
    public String generateTicketId() {
        String sql = "SELECT ticketId FROM tickets ORDER BY ticketId DESC LIMIT 1";
        int maxId = 0;

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                String lastId = rs.getString("ticketId");
                maxId = IdGeneratorUtil.extractIdNumber(lastId);
            }

        } catch (SQLException e) {
            System.err.println("Error generating ticket ID: " + e.getMessage());
        }

        return IdGeneratorUtil.generateTicketId(maxId);
    }

    private Ticket mapResultSetToTicket(ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setTicketId(rs.getString("ticketId"));
        ticket.setUserId(rs.getString("userId"));
        ticket.setBusId(rs.getString("busId"));
        ticket.setPassengerName(rs.getString("passengerName"));
        ticket.setSeatNumber(rs.getInt("seatNumber"));
        ticket.setBookingDate(rs.getTimestamp("bookingDate").toLocalDateTime());
        ticket.setTravelDate(rs.getDate("travelDate").toLocalDate());
        ticket.setTotalAmount(rs.getBigDecimal("totalAmount"));
        ticket.setStatus(rs.getString("status"));
        return ticket;

    }
}
