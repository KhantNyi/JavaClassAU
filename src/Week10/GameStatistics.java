package Week10;

import java.util.ArrayList;

public class GameStatistics {
    private ArrayList<String> gameResults;
    private int wins;
    private int losses;

    public GameStatistics() {
        gameResults = new ArrayList<>();
        wins = 0;
        losses = 0;
    }

    public void addResult(String card, boolean won) {
        gameResults.add(card + (won ? " (You won)" : " (You lost)"));
        if (won) {
            wins++;
        } else {
            losses++;
        }
    }

    public void printStatistics() {
        int totalGames = wins + losses;
        
        System.out.println("\nCard                      Result");
        System.out.println("----                      ------");

        for (String result : gameResults) {
            String[] parts = result.split(" ");
            String card = parts[0] + " of " + parts[2];
            String status = parts[3] + " " + parts[4];
            System.out.printf("%-25s%s%n", card, status);
        }

        System.out.println("Total games played: " + totalGames);
        System.out.println("Win : " + wins + " (" + (wins * 100 / totalGames) + "%)");
        System.out.println("Loss: " + losses + " (" + (losses * 100 / totalGames) + "%)");
    }
}
