package application;

public class StatisticsManager {

    private int gamesPlayed;
    private int wins;
    private int losses;
    private int totalGuessesForWins;

    public StatisticsManager() {
        this.gamesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
        this.totalGuessesForWins = 0;
    }

    public void incrementGamesPlayed() {
        gamesPlayed++;
        System.out.println("Games Played: " + gamesPlayed); // Debugging statement
    }

    public void incrementWins() {
        wins++;
        System.out.println("Wins: " + wins); // Debugging statement
    }

    public void incrementLosses() {
        losses++;
        System.out.println("Losses: " + losses); // Debugging statement
    }

    public void addGuessesForWin(int guesses) {
        totalGuessesForWins += guesses;
        System.out.println("Total Guesses for Wins: " + totalGuessesForWins); // Debugging statement
    }

    public String getStatistics() {
        double averageGuesses = wins > 0 ? (double) totalGuessesForWins / wins : 0;
        return String.format(
            "Statistics:\n" +
            "------------\n" +
            "Games Played: %d\n" +
            "Wins: %d\n" +
            "Losses: %d\n" +
            "Average Guesses per Win: %.2f\n",
            gamesPlayed, wins, losses, averageGuesses
        );
    }
}
