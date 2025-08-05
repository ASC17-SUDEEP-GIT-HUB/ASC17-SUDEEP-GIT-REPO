package org.demo.Service;

import org.demo.Model.Bus;

import java.util.List;

public interface BusService {

    boolean addBus(Bus bus);
    List<Bus> searchBuses(String source, String destination);
    List<Bus> getAllBuses();
    boolean updateSeats(String busId, int bookedSeats);
}
