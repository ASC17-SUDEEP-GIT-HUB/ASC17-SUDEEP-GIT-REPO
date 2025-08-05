package org.demo.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

//import java.time.LocalDate;

public class Ticket {

    private String ticketId;
    private int seatCount;
    private LocalDate bookingDate;
    private String userId;
    private String busId;
    private double fare;
    private LocalDateTime departureTime;

    public Ticket(String ticketId, String userId, String busId, LocalDate bookingDate, LocalDateTime departureTime, double fare) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.busId = busId;
        this.bookingDate = bookingDate;
        this.departureTime = departureTime;
        this.fare = fare;
      //  this.seatCount = seatCount;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", seatCount=" + seatCount +
                ", bookingDate=" + bookingDate +
                ", userId='" + userId + '\'' +
                ", busId='" + busId + '\'' +
                ", fare=" + fare +
                ", departureTime=" + departureTime +
                '}';
    }
}
