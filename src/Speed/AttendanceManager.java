package Speed;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class representing a student's attendance record.
 */
class AttendanceRecord {
    private int totalClasses;
    private int classesAttended;

    public AttendanceRecord() {
        totalClasses = 0;
        classesAttended = 0;
    }

    // Marks student present
    public void markPresent() {
        totalClasses++;
        classesAttended++;
    }

    // Marks student absent
    public void markAbsent() {
        totalClasses++;
    }

    // Calculates attendance percentage
    public double calculatePercentage() {
        if (totalClasses == 0) return 0.0;
        return (classesAttended * 100.0) / totalClasses;
    }

    // Returns a summary string
    public String getSummary() {
        return "Classes Attended: " + classesAttended +
                " / " + totalClasses +
                " (" + String.format("%.2f", calculatePercentage()) + "%)";
    }
}

/**
 * Class representing a Student.
 */
class Student {
    private String name;
    private String studentID;
    private AttendanceRecord attendance;

    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.attendance = new AttendanceRecord();
    }

    public String getName() {
        return name;
    }

    public String getStudentID() {
        return studentID;
    }

    public AttendanceRecord getAttendanceRecord() {
        return attendance;
    }

    // Displays student info in a human-readable format
    public void displayInfo() {
        System.out.println("ID: " + studentID + " | Name: " + name + " | " + attendance.getSummary());
    }

    @Override
    public String toString() {
        return "ID: " + studentID + " | Name: " + name + " | " + attendance.getSummary();
    }
}

/**
 * Class that manages all students and attendance operations.
 */
class AttendanceManager {
    private ArrayList<Student> students;

    public AttendanceManager() {
        students = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(String name, String id) {
        for (Student s : students) {
            if (s.getStudentID().equals(id)) {
                System.out.println(" Error: Student with ID " + id + " already exists!");
                return;
            }
        }
        students.add(new Student(name, id));
        System.out.println(" Student added successfully!\n");
    }

    // Record attendance for all students using human-friendly y/n input
    public void recordAttendance() {
        if (students.isEmpty()) {
            System.out.println(" No students found. Add students first.\n");
            return;
        }

        Scanner sc = new Scanner(System.in);
        for (Student s : students) {
            String response = "";
            do {
                System.out.print("Is " + s.getName() + " (ID: " + s.getStudentID() + ") present? (y/n): ");
                response = sc.nextLine().trim().toLowerCase();
                if (!response.equals("y") && !response.equals("n")) {
                    System.out.println(" Invalid input. Please enter 'y' for present or 'n' for absent.");
                }
            } while (!response.equals("y") && !response.equals("n"));

            if (response.equals("y")) {
                s.getAttendanceRecord().markPresent();
            } else {
                s.getAttendanceRecord().markAbsent();
            }
        }
        System.out.println(" Attendance recorded successfully!\n");
    }

    // Search student by ID
    public void searchStudent(String id) {
        for (Student s : students) {
            if (s.getStudentID().equals(id)) {
                System.out.println("\n Student Found:");
                s.displayInfo();
                return;
            }
        }
        System.out.println(" Student not found!\n");
    }

    // Display report for all students
    public void displayReport() {
        if (students.isEmpty()) {
            System.out.println(" No students to display.\n");
            return;
        }
        System.out.println("\n === Attendance Report ===");
        for (Student s : students) {
            s.displayInfo();
        }
    }
}

/**
 * Main class to run the Attendance Management System.
 */


