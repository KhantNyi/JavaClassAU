public class GraduateStudent extends Student {
    // Default constructor
    public GraduateStudent() {
        super();
    }
    
    // Constructor with parameters
    public GraduateStudent(String fName, String lName) {
        super(fName, lName);
    }
    
    // Return the student type ("G" for Graduate)
    @Override
    public String getType() {
        return "G";
    }
    
    // Calculate the final grade for a graduate student
    @Override
    public String calculateGrade() {
        if (getTotalScore() >= 80) {
            return "S"; // Satisfactory
        } else {
            return "U"; // Unsatisfactory
        }
    }
}
