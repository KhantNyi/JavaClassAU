public class UndergraduateStudent extends Student {

    // Default constructor
    public UndergraduateStudent() {
        super();
    }

    // Constructor with parameters
    public UndergraduateStudent(String fName, String lName) {
        super(fName, lName);
    }
    
    // Return the student type ("U" for Undergraduate)
    @Override
    public String getType() {
        return "U";
    }
    
    // Calculate the final grade for an undergraduate student
    @Override
    public String calculateGrade() {
        int totalScore = getTotalScore();
        
        if (totalScore >= 85) {
            return "A";
        } else if (totalScore >= 75) {
            return "B";
        } else if (totalScore >= 60) {
            return "C";
        } else if (totalScore >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
