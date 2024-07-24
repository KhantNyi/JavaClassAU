// Khant Nyi Thu
// 6632108
// 541

package Week07;

import java.util.Random;
import java.util.Scanner;

public class HighMediumLowGame {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Random random = new Random();

        int wins = 0;
        int losses = 0;
        boolean continuePlaying = true;

        while (continuePlaying) {
            System.out.println("Game " + (wins + losses + 1) + ":");
            System.out.println("=======");

            int firstDice = rollDice(random);
            int secondDice = rollDice(random);
            System.out.println("The first dice: " + firstDice);
            System.out.println("The second dice: " + secondDice);

            System.out.println("High is between 13 and 18. Medium is between 7 and 12. Low is between 1 and 6.");
            System.out.print("Enter your guess [H, M, L]: ");
            char guess = reader.next().charAt(0);

            int thirdDice = rollDice(random);
            System.out.println("The third dice: " + thirdDice);

            int sum = firstDice + secondDice + thirdDice;
            System.out.println("The sum is " + sum + ".");

            if (isGuessCorrect(sum, guess)) {
                System.out.println("You are correct!");
                wins++;
            } else {
                System.out.println("You are incorrect!");
                losses++;
            }

            System.out.print("Do you want to continue [Y/N]? ");
            char continueResponse = reader.next().charAt(0);
            if (continueResponse == 'N' || continueResponse == 'n') {
                continuePlaying = false;
            }
        }

        printGameStats(wins, losses);

        reader.close();
    }

    private static int rollDice(Random random) {
        return random.nextInt(6) + 1;
    }

    private static boolean isGuessCorrect(int sum, char guess) {
        switch (guess) {
            case 'H':
            case 'h':
                return sum >= 13 && sum <= 18;
            case 'M':
            case 'm':
                return sum >= 7 && sum <= 12;
            case 'L':
            case 'l':
                return sum >= 1 && sum <= 6;
            default:
                return false;
        }
    }

    private static void printGameStats(int wins, int losses) {
        int totalGames = wins + losses;
        double winPercentage = (totalGames > 0) ? (wins * 100.0 / totalGames) : 0;
        double lossPercentage = (totalGames > 0) ? (losses * 100.0 / totalGames) : 0;

        System.out.println("==========");
        System.out.println("Game Stats");
        System.out.println("==========");
        System.out.println("Win: " + wins + " (" + String.format("%.2f", winPercentage) + "%)");
        System.out.println("Loss: " + losses + " (" + String.format("%.2f", lossPercentage) + "%)");
        System.out.println("Thank you for playing!");
    }
}
