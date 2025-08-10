package com.BusBookingApp.src.main.java.com.demo.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket {

    private String ticketId;
    private String userId;
    private String busId;
    private String passengerName;
    private int seatNumber;
    private LocalDateTime bookingDate;
    private LocalDate travelDate;
    private BigDecimal totalAmount;
    private String status;

    public Ticket() {
    }

    public Ticket(String ticketId, String userId, String busId, String passengerName,
                  int seatNumber, LocalDateTime bookingDate, LocalDate travelDate,
                  BigDecimal totalAmount, String status) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.busId = busId;
        this.passengerName = passengerName;
        this.seatNumber = seatNumber;
        this.bookingDate = bookingDate;
        this.travelDate = travelDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
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

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", userId='" + userId + '\'' +
                ", busId='" + busId + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", seatNumber=" + seatNumber +
                ", bookingDate=" + bookingDate +
                ", travelDate=" + travelDate +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}