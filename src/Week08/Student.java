// Khant Nyi Thu
// 6632108
// 541

package week08;

public abstract class Student {
    protected String firstName;
    protected String lastName;
    protected int[] testScores;

    public Student(String firstName, String lastName, int[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = testScores;
    }

    public double averageScore() {
        int total = 0;
        for (int score : testScores) {
            total += score;
        }
        return total / (double) testScores.length;
    }

    public abstract char getGrade();
}
