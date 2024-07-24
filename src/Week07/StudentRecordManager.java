// Khant Nyi Thu
// 6632108
// 541

package Week07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    int id;
    String firstName;
    String lastName;
    double score;

    Student(int id, String firstName, String lastName, double score) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName + ", Score: " + score;
    }
}

public class StudentRecordManager {
    private static final List<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add a new student");
            System.out.println("2. Modify student's information");
            System.out.println("3. Delete a student");
            System.out.println("4. Display the list of students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (findStudentIndexById(id) != -1) {
            System.out.println("Student ID already exists. Try again.");
            return;
        }

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter score: ");
        double score = scanner.nextDouble();

        students.add(new Student(id, firstName, lastName, score));
        System.out.println("Student added successfully.");
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        int index = findStudentIndexById(id);
        if (index == -1) {
            System.out.println("Student ID not found.");
            return;
        }

        System.out.print("Enter new first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter new last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter new score: ");
        double score = scanner.nextDouble();

        students.set(index, new Student(id, firstName, lastName, score));
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();

        int index = findStudentIndexById(id);
        if (index == -1) {
            System.out.println("Student ID not found.");
            return;
        }

        students.get(index).id = 9999999;
        System.out.println("Student deleted successfully.");
    }

    private static void displayStudents() {
        System.out.println("List of students:");
        for (Student student : students) {
            if (student.id != 9999999) {
                System.out.println(student);
            }
        }
    }

    private static int findStudentIndexById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                return i;
            }
        }
        return -1;
    }
}
