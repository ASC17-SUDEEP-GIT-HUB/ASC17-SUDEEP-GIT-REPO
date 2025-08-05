package org.demo.Model;

import org.demo.Util.DBUtil;
import org.demo.Util.IdGenaratorUtil;

import java.sql.Connection;
import java.time.LocalDateTime;

public class Bus {

    private String busId;
    private String busName;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    private LocalDateTime departureTime;
    private String source;
    private double fare;

 //   private Connection conn = null;

    public Bus() {
    }

    public Bus(String busName, String destination, int totalSeats, int availableSeats, LocalDateTime departureTime, String source, double fare) {
     //    this.busId = IdGenaratorUtil.generateId(conn ,"B", "buses", "busId");;
        this.busName = busName;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.departureTime = departureTime;
        this.source = source;
        this.fare = fare;
    }

    public Bus(String busId, String busName, String destination, int totalSeats, int availableSeats, LocalDateTime departureTime, String source, double fare) {
        this.busId = busId;
        this.busName = busName;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.departureTime = departureTime;
        this.source = source;
        this.fare = fare;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public int getBookedSeats() {
        return totalSeats - availableSeats;
    }
}
