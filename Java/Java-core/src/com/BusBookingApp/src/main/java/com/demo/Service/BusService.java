package com.BusBookingApp.src.main.java.com.demo.Service;

import com.demo.Model.Bus;

import java.util.List;

public interface BusService {
    String addBus(Bus bus);
    Bus getBusById(String busId);
    List<Bus> getAllBuses();
    List<Bus> searchBuses(String source, String destination);
    boolean updateBus(Bus bus);
    boolean deleteBus(String busId);
    List<Bus> getAvailableBuses(String source, String destination);
}
