package HW_1.org.example.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimePrinter {
    public static void main(String[] args) {
        printCurrentDateTime();
    }

    public static String printCurrentDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        System.out.println("Current date and time: " + formattedDateTime);
        return formattedDateTime;
    }
}