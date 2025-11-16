package Speed;

import java.util.Scanner;

public class Flash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();
        int choice = 0;

        do {
            System.out.println("\n===== Attendance Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Record Attendance");
            System.out.println("3. Search Student");
            System.out.println("4. Display Attendance Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Validate menu input
            if (!scanner.hasNextInt()) {
                System.out.println(" Invalid input. Please enter a number from 1 to 5.");
                scanner.nextLine(); // clear invalid input
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    manager.addStudent(name, id);
                    break;

                case 2:
                    manager.recordAttendance();
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    String searchID = scanner.nextLine();
                    manager.searchStudent(searchID);
                    break;

                case 4:
                    manager.displayReport();
                    break;

                case 5:
                    System.out.println(" Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println(" Invalid choice. Please select 1–5.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
