package Week10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameStatistics statistics = new GameStatistics();

        while (true) {
            Game game = new Game();
            boolean won = game.play();

            // Add the game result to the statistics
            statistics.addResult(game.getCorrectCard().toString(), won);

            System.out.print("Do you want to play again [Y/N]? ");
            String response = scanner.next().trim().toUpperCase();
            if (response.equals("N")) {
                break;
            }
        }

        statistics.printStatistics();
        
        scanner.close();
    }
}
