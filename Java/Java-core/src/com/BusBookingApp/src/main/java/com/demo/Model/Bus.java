package com.BusBookingApp.src.main.java.com.demo.Model;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Bus {

    private String busId;
    private String busName;
    private String source;
    private String destination;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private BigDecimal fare;
    private String busType;


    public Bus() {
    }

    public Bus(String busId, String busName, String source, String destination,
               LocalTime departureTime, LocalTime arrivalTime, int totalSeats,
               int availableSeats, BigDecimal fare, String busType) {
        this.busId = busId;
        this.busName = busName;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.fare = fare;
        this.busType = busType;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
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

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busId='" + busId + '\'' +
                ", busName='" + busName + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", totalSeats=" + totalSeats +
                ", availableSeats=" + availableSeats +
                ", fare=" + fare +
                ", busType='" + busType + '\'' +
                '}';
    }
}
