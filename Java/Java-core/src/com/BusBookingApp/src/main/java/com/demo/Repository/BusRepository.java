package com.BusBookingApp.src.main.java.com.demo.Repository;

import com.demo.Model.Bus;

import java.util.List;

public interface BusRepository {
    String addBus(Bus bus);
    Bus getBusById(String busId);
    List<Bus> getAllBuses();
    List<Bus> searchBuses(String source, String destination);
    boolean updateBus(Bus bus);
    boolean deleteBus(String busId);
    boolean updateAvailableSeats(String busId, int seatsBooked);
    String generateBusId();
}
