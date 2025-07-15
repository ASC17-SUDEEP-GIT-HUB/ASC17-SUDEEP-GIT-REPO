package com.demo.lab2.Application;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        MeetingRoom normalRoom = new MeetingRoom("R101", 20, 2);

        ZoomMeetingRoom zoomRoom = new ZoomMeetingRoom("Z201", 10, 3, "ZD1", "zoomCompany.com");

        BookingManager manager = new BookingManager();

        manager.bookRoom("EMP01", normalRoom, LocalDate.of(2025, 12, 23), LocalTime.of(12,59, 59), 60);

        manager.bookRoom("EMP02", zoomRoom, LocalDate.of(2025, 12, 24), LocalTime.of(12,59, 59), 60);

        manager.getBookingByDate(LocalDate.of(2025, 12, 23));

    }
}
