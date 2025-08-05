package org.demo.Ui;

import org.demo.Model.Bus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BusUI {
    private final List<Bus> busList = new ArrayList<>();

    public BusUI() {
        // Add some sample buses  --- dd-MM-yyyy

        // Define the formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

        // Parse the String date
        LocalDateTime journeyDate1 = LocalDateTime.parse("2025/07/30 15:30", formatter);
        LocalDateTime journeyDate2 = LocalDateTime.parse("2025/07/30 01:30", formatter);
        LocalDateTime journeyDate3 = LocalDateTime.parse("2025/08/30 02:00", formatter);
        LocalDateTime journeyDate4 = LocalDateTime.parse("2025/08/30 18:30", formatter);

        busList.add(new Bus("Volvo", "Chennai", 40, 25, journeyDate1, "Bangalore", 777));
        busList.add(new Bus("Airavata", "Mumbai", 50, 30, journeyDate2, "Bangalore", 999));
        busList.add(new Bus("AC Bus", "Hydrabad", 50, 35, journeyDate3, "Chennai", 1199));
        busList.add(new Bus("NON AC", "Chennai", 60, 35, journeyDate4, "Chennai", 1199));
    }

    public void viewAllBuses() {
        System.out.println("\n--- Available Buses ---");
        for (Bus bus : busList) {
            System.out.println(bus);
        }
    }
}
