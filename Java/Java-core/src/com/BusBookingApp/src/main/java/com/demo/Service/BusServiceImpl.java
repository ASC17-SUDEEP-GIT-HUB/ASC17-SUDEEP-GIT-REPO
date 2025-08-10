package com.BusBookingApp.src.main.java.com.demo.Service;


import com.demo.Model.Bus;
import com.BusBookingApp.src.main.java.com.demo.Repository.BusRepository;
import com.BusBookingApp.src.main.java.com.demo.Repository.BusRepositoryImpl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BusServiceImpl implements BusService {
    private BusRepository busRepository;

    public BusServiceImpl() {
        this.busRepository = new BusRepositoryImpl();
    }

    @Override
    public String addBus(Bus bus) {
        if (bus == null || !validateBusData(bus)) {
            return null;
        }
        return busRepository.addBus(bus);
    }

    @Override
    public Bus getBusById(String busId) {
        if (busId == null || busId.trim().isEmpty()) {
            return null;
        }
        return busRepository.getBusById(busId);
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.getAllBuses();
    }

    @Override
    public List<Bus> searchBuses(String source, String destination) {
        if (source == null || destination == null || source.trim().isEmpty() || destination.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return busRepository.searchBuses(source.trim(), destination.trim());
    }

    @Override
    public boolean updateBus(Bus bus) {
        if (bus == null || bus.getBusId() == null || !validateBusData(bus)) {
            return false;
        }
        return busRepository.updateBus(bus);
    }

    @Override
    public boolean deleteBus(String busId) {
        if (busId == null || busId.trim().isEmpty()) {
            return false;
        }
        return busRepository.deleteBus(busId);
    }

    @Override
    public List<Bus> getAvailableBuses(String source, String destination) {
        return searchBuses(source, destination).stream()
                .filter(bus -> bus.getAvailableSeats() > 0)
                .collect(Collectors.toList());
    }
    private boolean validateBusData(Bus bus) {
        return bus.getBusName() != null && !bus.getBusName().trim().isEmpty() &&
                bus.getSource() != null && !bus.getSource().trim().isEmpty() &&
                bus.getDestination() != null && !bus.getDestination().trim().isEmpty() &&
                bus.getDepartureTime() != null &&
                bus.getArrivalTime() != null &&
                bus.getTotalSeats() > 0 &&
                bus.getAvailableSeats() >= 0 &&
                bus.getFare() != null && bus.getFare().doubleValue() > 0 &&
                bus.getBusType() != null && !bus.getBusType().trim().isEmpty();
    }
}
