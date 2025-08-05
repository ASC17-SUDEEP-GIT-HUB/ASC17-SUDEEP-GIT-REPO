package org.demo.Repository;

import org.demo.Model.Bus;

import java.util.List;

public interface BusRepository {

    boolean addBus(Bus bus);
    Bus getBusById(String busId);
    List<Bus> getBusesByRoute(String source, String destination);
    List<Bus> getAllBuses();
    boolean updateAvailableSeats(String busId, int bookedSeats);

}