package week08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NonCreditCourseGrading {
    private List<Student> students;

    public NonCreditCourseGrading() {
        students = new ArrayList<>();
    }

    public void readCSV(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");
            if (tokens.length != 5) {
                System.err.println("Invalid line format: " + line);
                continue;
            }

            String type = tokens[0].trim();
            String firstName = tokens[2].trim();
            String lastName = tokens[3].trim();
            int score = Integer.parseInt(tokens[4].trim());

            Student student;
            if (type.equalsIgnoreCase("U")) {
                student = new UndergraduateStudent(firstName, lastName, new int[]{score});
            } else if (type.equalsIgnoreCase("G")) {
                student = new GraduateStudent(firstName, lastName, new int[]{score});
            } else {
                System.err.println("Unknown student type: " + line);
                continue;
            }
            students.add(student);
        }
        br.close();
    }

    public void displayGrades() {
        for (Student student : students) {
            System.out.println(student.firstName + " " + student.lastName + ": " + student.getGrade());
        }
    }

    public static void main(String[] args) throws IOException {
        // Use the relative path to the CSV file
        String csvFilePath = "Enter path";

        NonCreditCourseGrading grading = new NonCreditCourseGrading();
        grading.readCSV(csvFilePath);
        grading.displayGrades();
    }
}
