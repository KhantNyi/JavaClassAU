// Khant Nyi Thu
// 6632108
// 541

package week08;

public class GraduateStudent extends Student {
    public GraduateStudent(String firstName, String lastName, int[] testScores) {
        super(firstName, lastName, testScores);
    }

    public char getGrade() {
        return averageScore() >= 90 ? 'S' : 'U';
    }
}
