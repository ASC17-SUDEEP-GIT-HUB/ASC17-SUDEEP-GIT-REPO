package org.demo.Repository;

import org.demo.Model.Ticket;
import org.demo.Util.DBUtil;
import org.demo.Util.IdGenaratorUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {

    private Connection conn;
    // Scanner sc = new Scanner(System.in);

    public TicketRepositoryImpl(){
        conn = DBUtil.getConnection();
    }

    public String getNextTicketId() {

        return IdGenaratorUtil.generateId(conn ,"T", "ticket", "ticketId");
    }

    @Override
    public boolean bookTicket(Ticket ticket) {
        String ticketId = getNextTicketId();
        ticket.setTicketId(ticketId);

        String sql = "INSERT INTO ticket (ticketId, userId, busId, bookingDate, departureTime, fare, seatCount) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ticket.getTicketId());
            ps.setString(2, ticket.getUserId());
            ps.setString(3, ticket.getBusId());
            ps.setDate(4, Date.valueOf(ticket.getBookingDate()));
            ps.setTimestamp(5, Timestamp.valueOf(ticket.getDepartureTime()));
            ps.setDouble(6, ticket.getFare());
            ps.setInt(7, ticket.getSeatCount());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Ticket bookTicketById(String ticketId) {
        String sql = "SELECT * FROM ticket WHERE ticketId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ticketId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                 Ticket ticket = new Ticket(
                        rs.getString("ticketId"),
                        rs.getString("userId"),
                        rs.getString("busId"),
                        rs.getDate("bookingDate").toLocalDate(),
                        rs.getTimestamp("departureTime").toLocalDateTime(),
                        rs.getDouble("fare")
                        // rs.getInt("seatCount")
                );
                 ticket.setSeatCount(rs.getInt("seatCount"));
                 return ticket;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ticket> getTicketByUser(String userId) {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM ticket WHERE userId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket(
                        rs.getString("ticketId"),
                        rs.getString("userId"),
                        rs.getString("busId"),
                        rs.getDate("bookingDate").toLocalDate(),
                        rs.getTimestamp("departureTime").toLocalDateTime(),
                        rs.getDouble("fare")
                      //  rs.getInt("seatCount")
                );
                ticket.setSeatCount(rs.getInt("seatCount"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public boolean cancelTicket(String ticketId) {
        String sql = "DELETE FROM ticket WHERE ticketId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ticketId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    @Override
//    public String generateNextTicketId() {
//        return "";
//    }
}
