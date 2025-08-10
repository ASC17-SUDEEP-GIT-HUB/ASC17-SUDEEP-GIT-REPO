package com.BusBookingApp.src.main.java.com.demo.Util;

public class IdGeneratorUtil {

    public static String generateBusId(int currentMaxId) {
        return String.format("B%03d", currentMaxId + 1);
    }

    public static String generateUserId(int currentMaxId) {
        return String.format("U%03d", currentMaxId + 1);
    }

    public static String generateTicketId(int currentMaxId) {
        return String.format("T%03d", currentMaxId + 1);
    }

    public static int extractIdNumber(String id) {
        if (id == null || id.length() < 4) {
            return 0;
        }
        try {
            return Integer.parseInt(id.substring(1));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
