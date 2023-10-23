package HW_1.org.example;

import HW_1.org.example.controller.DateTimePrinter;
import HW_1.org.example.controller.FileWorker;

import java.util.Scanner;

import static HW_1.org.example.controller.DateTimePrinter.printCurrentDateTime;

public class FileMenu {
    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Read from file");
            System.out.println("2. Add line to file");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the file name to read: ");
                    String fileName = scanner.nextLine();
                    FileWorker.readFile(fileName);
                    break;
                case 2:
                    System.out.print("Enter the file name to write: ");
                    fileName = scanner.nextLine();
                    System.out.print("Enter the line to add: ");
                    String line = scanner.nextLine();
                    FileWorker.writeFile(fileName, DateTimePrinter.printCurrentDateTime() + " -> " + line);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }
    }


}