package Week08;

public class Golfer {
    private int id;
    private String firstName;
    private String lastName;
    private int[] scores;

    public Golfer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.scores = new int[4];
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getScore(int round) {
        return scores[round - 1];
    }

    public void setScore(int round, int score) {
        scores[round - 1] = score;
    }

    public int getTotalScore() {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    public String getFormattedScore() {
        int totalScore = getTotalScore();
        int par = 72 * 4;
        int relativeScore = totalScore - par;
        if (relativeScore == 0) {
            return "even";
        } else if (relativeScore > 0) {
            return relativeScore + " over";
        } else {
            return Math.abs(relativeScore) + " under";
        }
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + ": " + getFormattedScore();
    }
}
