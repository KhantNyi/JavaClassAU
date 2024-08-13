abstract public class Student {
    private String firstName;
    private String lastName;
    private int[] testScores;
    
    public final static int NUM_TEST = 5; // Number of tests
    
    // Default constructor
    public Student() {
        this.firstName = "Unnamed";
        this.lastName = "Unnamed";
        this.testScores = new int[NUM_TEST]; // Initialize scores array
    }
    
    // Constructor with parameters
    public Student(String fName, String lName) {
        this.firstName = fName;
        this.lastName = lName;
        this.testScores = new int[NUM_TEST]; // Initialize scores array
    }

    // Get score for a specific test
    public int getTestScore(int testNumber) {
        return testScores[testNumber - 1];
    }
    
    // Set score for a specific test
    public boolean setTestScore(int testNumber, int score) {
        if (score < 0 || score > 20) { // Check if the score is valid
            return false;
        } else {
            testScores[testNumber - 1] = score; // Set the score
            return true;
        }
    }
    
    // Calculate the total score by summing all test scores
    public int getTotalScore() {
        int total = 0;
        for (int i = 0; i < NUM_TEST; ++i) {
            total += testScores[i];
        }
        return total;
    }
    
    // Abstract method to get the type of student (Graduate or Undergraduate)
    abstract public String getType();

    // Abstract method to calculate the final grade based on total score
    abstract public String calculateGrade();
    
    // Convert student data to a CSV format string
    public String toCSV() {
        return String.format("%s,%s,%s,%d,%d,%d,%d,%d",
                                this.getType(),
                                this.firstName,
                                this.lastName,
                                this.testScores[0],
                                this.testScores[1],
                                this.testScores[2],
                                this.testScores[3],
                                this.testScores[4]);
    }
    
    @Override
    public String toString() {
        return null; // This could be overridden in subclasses if needed
    }
}
