package com.BusBookingApp.src.main.java.com.demo.Repository;

import com.demo.Model.Bus;
import com.demo.Util.DBUtil;
import com.demo.Util.IdGeneratorUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusRepositoryImpl implements BusRepository {

    @Override
    public String addBus(Bus bus) {
        String busId = generateBusId();
        bus.setBusId(busId);

        String sql = "INSERT INTO buses (busId, busName, source, destination, departureTime, " +
                "arrivalTime, totalSeats, availableSeats, fare, busType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bus.getBusId());
            stmt.setString(2, bus.getBusName());
            stmt.setString(3, bus.getSource());
            stmt.setString(4, bus.getDestination());
            stmt.setTime(5, Time.valueOf(bus.getDepartureTime()));
            stmt.setTime(6, Time.valueOf(bus.getArrivalTime()));
            stmt.setInt(7, bus.getTotalSeats());
            stmt.setInt(8, bus.getAvailableSeats());
            stmt.setBigDecimal(9, bus.getFare());
            stmt.setString(10, bus.getBusType());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0 ? busId : null;
        }catch (SQLException e) {
            System.err.println("Error adding bus: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Bus getBusById(String busId) {
        String sql = "SELECT * FROM buses WHERE busId = ?";

        try(Connection conn = DBUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, busId);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return mapResultSetToBus(rs);
            }
        }catch(SQLException s) {
            System.err.println("Error getting bus by ID: " + s.getMessage());
        }
        return null;
    }

    @Override
    public List<Bus> getAllBuses() {
        List<Bus> buses = new ArrayList<>();
        String sql = "SELECT * FROM buses";

        try(Connection conn = DBUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()) {
                buses.add(mapResultSetToBus(rs));
            }
        }catch(SQLException e) {
            System.err.println("Error getting all busus: " + e.getMessage());
        }
        return buses;
    }

    @Override
    public List<Bus> searchBuses(String source, String destination) {
        List<Bus> buses = new ArrayList<>();
        String sql = "SELECT * FROM buses WHERE source = ? AND destination = ? AND availableSeats > 0";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, source);
            stmt.setString(2, destination);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                buses.add(mapResultSetToBus(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error searching buses: " + e.getMessage());
        }
        return buses;
    }

    @Override
    public boolean updateBus(Bus bus) {
        String sql = "UPDATE buses SET busName = ?, source = ?, destination = ?, departureTime = ?, " +
                "arrivalTime = ?, totalSeats = ?, availableSeats = ?, fare = ?, busType = ? WHERE busId = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bus.getBusName());
            stmt.setString(2, bus.getSource());
            stmt.setString(3, bus.getDestination());
            stmt.setTime(4, Time.valueOf(bus.getDepartureTime()));
            stmt.setTime(5, Time.valueOf(bus.getArrivalTime()));
            stmt.setInt(6, bus.getTotalSeats());
            stmt.setInt(7, bus.getAvailableSeats());
            stmt.setBigDecimal(8, bus.getFare());
            stmt.setString(9, bus.getBusType());
            stmt.setString(10, bus.getBusId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error updating bus: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteBus(String busId) {
        String sql = "DELETE FROM buses WHERE busId = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, busId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting bus: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateAvailableSeats(String busId, int seatsBooked) {
        String sql = "UPDATE buses SET availableSeats = availableSeats - ? WHERE busId = ? AND availableSeats >= ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, seatsBooked);
            stmt.setString(2, busId);
            stmt.setInt(3, seatsBooked);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error updating available seats: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String generateBusId() {
        String sql = "SELECT busId FROM buses ORDER BY busId DESC LIMIT 1";
        int maxId = 0;

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                String  lastId = rs.getString("busId");
                maxId = IdGeneratorUtil.extractIdNumber(lastId);
            }

        } catch (SQLException e) {
            System.err.println("Error generating bus ID: " + e.getMessage());
        }

        return IdGeneratorUtil.generateBusId(maxId);
    }

    private Bus mapResultSetToBus(ResultSet rs) throws SQLException {
        Bus bus = new Bus();
        bus.setBusId(rs.getString("busId"));
        bus.setBusName(rs.getString("busName"));
        bus.setSource(rs.getString("source"));
        bus.setDestination(rs.getString("destination"));
        bus.setDepartureTime(rs.getTime("departureTime").toLocalTime());
        bus.setArrivalTime(rs.getTime("arrivalTime").toLocalTime());
        bus.setTotalSeats(rs.getInt("totalSeats"));
        bus.setAvailableSeats(rs.getInt("availableSeats"));
        bus.setFare(rs.getBigDecimal("fare"));
        bus.setBusType(rs.getString("busType"));
        return bus;
    }
}
