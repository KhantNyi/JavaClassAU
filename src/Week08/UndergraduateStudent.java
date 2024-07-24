// Khant Nyi Thu
// 6632108
// 541

package week08;

public class UndergraduateStudent extends Student {
    public UndergraduateStudent(String firstName, String lastName, int[] testScores) {
        super(firstName, lastName, testScores);
    }

    public char getGrade() {
        return averageScore() >= 80 ? 'S' : 'U';
    }
}
