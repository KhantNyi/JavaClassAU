import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentDriver {

    public static void main(String[] args) {
        File studentFile = new File("students.csv"); // Reference to the CSV file
        try {
            Scanner fileReader = new Scanner(studentFile); // Scanner to read the file
            
            while (fileReader.hasNext()) {
                String buffer = fileReader.nextLine(); // Read a line from the CSV
                StringTokenizer tokenizer = new StringTokenizer(buffer, ","); // Tokenize the line by commas
                
                String type = tokenizer.nextToken(); // First token is the student type
                String firstName = tokenizer.nextToken(); // Second token is the first name
                String lastName = tokenizer.nextToken(); // Third token is the last name

                // Create the correct type of student based on the first token
                Student student;
                if (type.equals("G")) {
                    student = new GraduateStudent(firstName, lastName);
                } else {
                    student = new UndergraduateStudent(firstName, lastName);
                }
                
                // Set the test scores for the student
                for (int i = 1; i <= Student.NUM_TEST; i++) {
                    int testScore = Integer.parseInt(tokenizer.nextToken());
                    student.setTestScore(i, testScore);
                }
                
                // Output the student's details and final grade
                System.out.println(student.getType() + ": " + firstName + " " + lastName);
                System.out.println("Total Score: " + student.getTotalScore());
                System.out.println("Final Grade: " + student.calculateGrade());
                System.out.println();
            }
            
            fileReader.close(); // Close the file reader
        } catch (FileNotFoundException e) {
            System.err.println("File not found!!"); // Handle the case where the file is not found
        }
    }
}
