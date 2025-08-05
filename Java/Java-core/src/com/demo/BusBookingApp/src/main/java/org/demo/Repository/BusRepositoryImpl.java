package org.demo.Repository;

import org.demo.Model.Bus;
import org.demo.Model.User;
import org.demo.Util.DBUtil;
import org.demo.Util.IdGenaratorUtil;

import java.sql.*;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class BusRepositoryImpl implements BusRepository{

    private Connection conn = null;

    public BusRepositoryImpl(){
        conn = DBUtil.getConnection();
    }

    public String getNextBusId() {

        return IdGenaratorUtil.generateId(conn ,"B", "buses", "busId");
    }

    @Override
    public boolean addBus(Bus bus) {
        try {
            String busId = getNextBusId();
            bus.setBusId(busId);

            String sql = "INSERT INTO buses (busId, busName, source, destination, totalSeats, availableSeats, departureTime, fare) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, busId);
            ps.setString(2, bus.getBusName());
            ps.setString(3, bus.getSource());
            ps.setString(4, bus.getDestination());
            ps.setInt(5, bus.getTotalSeats());
            ps.setInt(6, bus.getAvailableSeats());
            ps.setTimestamp(7, Timestamp.valueOf(bus.getDepartureTime()));
            ps.setDouble(8, bus.getFare());

            int insertedRows = ps.executeUpdate();

            return insertedRows > 0;

        }catch (SQLException s) {
            s.printStackTrace();
        }
        return false;
    }

    @Override
    public Bus getBusById(String busId) {
        Bus bus = null;

        try {
//            System.out.println("Enter the email id to get User: ");
//            String emailid = sc.nextLine();

            String sql = "SELECT * FROM buses WHERE busId = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, busId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                bus = new Bus();

                bus.setBusId(rs.getString("busId"));
                bus.setBusName(rs.getString("busName"));
                bus.setSource(rs.getString("source"));
                bus.setDestination(rs.getString("destination"));
                bus.setTotalSeats(rs.getInt("totalSeats"));
                bus.setDepartureTime(rs.getTimestamp("departureTime").toLocalDateTime());
                bus.setFare(rs.getDouble("fare"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return bus;
    }

    @Override
    public List<Bus> getBusesByRoute(String source, String destination) {
        List<Bus> busList = new ArrayList<>();

        String sql = "SELECT * FROM buses WHERE source = ? AND destination = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, source);
            ps.setString(2, destination);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Bus bus = new Bus();
                bus.setBusId(rs.getString("busId"));
                bus.setBusName(rs.getString("busName"));
                bus.setSource(rs.getString("source"));
                bus.setDestination(rs.getString("destination"));
                bus.setDepartureTime(rs.getTimestamp("departureTime").toLocalDateTime());
                bus.setTotalSeats(rs.getInt("totalSeats"));
                bus.setAvailableSeats(rs.getInt("availableSeats"));
                bus.setFare(rs.getDouble("fare"));

                busList.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return busList;
    }

    @Override
    public List<Bus> getAllBuses() {
        List<Bus> busList = new ArrayList<>();
        String sql = "SELECT * FROM buses";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Bus bus = new Bus();
                bus.setBusId(rs.getString("busId"));
                bus.setBusName(rs.getString("busName"));
                bus.setSource(rs.getString("source"));
                bus.setDestination(rs.getString("destination"));
                bus.setTotalSeats(rs.getInt("totalSeats"));
                bus.setAvailableSeats(rs.getInt("availableSeats"));
                bus.setDepartureTime(rs.getTimestamp("departureTime").toLocalDateTime());
                bus.setFare(rs.getDouble("fare"));

                busList.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return busList;
    }

    @Override
    public boolean updateAvailableSeats(String busId, int bookedSeats) {
        String sql = "UPDATE buses SET availableSeats = availableSeats - ? WHERE busId = ? AND availableSeats >= ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, bookedSeats);
            ps.setString(2, busId);
            ps.setInt(3, bookedSeats); // To ensure enough seats available

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
