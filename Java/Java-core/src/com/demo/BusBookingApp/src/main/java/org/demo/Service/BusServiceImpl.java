package org.demo.Service;

import org.demo.Model.Bus;
import org.demo.Repository.BusRepository;

import java.util.Collections;
import java.util.List;

public class BusServiceImpl implements BusService {
    private BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository){
        this.busRepository = busRepository;
    }

    @Override
    public boolean addBus(Bus bus) {
        return busRepository.addBus(bus);
    }

    @Override
    public List<Bus> searchBuses(String source, String destination) {
        return busRepository.getBusesByRoute(source, destination);
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.getAllBuses();
    }

    @Override
    public boolean updateSeats(String busId, int bookedSeats) {
        return busRepository.updateAvailableSeats(busId, bookedSeats);
    }
}