package com.demo.lab2.Application;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookingManager {

    ArrayList<Booking> bookings = new ArrayList<>();

    public void bookRoom(String employeeId, MeetingRoom room, LocalDate date , java.time.LocalTime time, int duration) {

        Booking booking = new Booking(employeeId, room, date, time, duration);
        bookings.add(booking);

        System.out.println("Booking successfull : " + booking.getDetails());
    }

    public void getBookingByDate(LocalDate date) {
        System.out.println("Booking on " + date + ";");

        boolean found = false;

        for(Booking booking : bookings) {
            if(booking.getDate().equals(date)) {
                System.out.println(booking.getDetails());

                found = true;
            }
        }
//        String a = "abc";
//        String date = "2025-07-08";

        if(found == false) {
            System.out.println("No bookings found.");
        }
    }
}
