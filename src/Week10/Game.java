package Week10;

import java.util.Scanner;

import java.util.InputMismatchException;

public class Game {
    private Deck deck;
    private int tries;
    private Card correctCard;
    private Scanner scanner;

    public Game() {
        deck = new Deck();
        scanner = new Scanner(System.in);
        tries = 5;
    }

    public boolean play() {
        correctCard = deck.dealCard();
        System.out.println(":: Game Start ::");
        boolean won = false;

        for (int i = 0; i < tries; i++) {
            System.out.println("\nAttempt " + (i + 1) + ":");

            Card guessedCard = getUserGuess();

            if (guessedCard.equals(correctCard)) {
                System.out.println("You won!! You picked the right card.");
                won = true;
                break;
            } else {
                giveHint(guessedCard);
            }
        }

        if (!won) {
            System.out.println("You've run out of tries. You lost!! I chose " + correctCard);
        }

        return won;
    }

    public Card getCorrectCard() {
        return correctCard;
    }

    private Card getUserGuess() {
        String rank = getRankFromUser();
        String suit = getSuitFromUser();

        return new Card(suit, rank);
    }

    private String getRankFromUser() {
        int rankChoice = 0;
        while (true) {
            System.out.print("Please select the rank of the card (1=Ace, 2=Two,…, 13=King): ");
            try {
                rankChoice = scanner.nextInt();
                if (rankChoice < 1 || rankChoice > 13) {
                    System.out.println("Invalid input. Please enter a number between 1 and 13.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 13.");
                scanner.next(); // Clear the invalid input
            }
        }

        String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        return ranks[rankChoice - 1];
    }

    private String getSuitFromUser() {
        int suitChoice = 0;
        while (true) {
            System.out.print("Please select the suit of the card (1=Spades, 2=Hearts, 3=Diamonds, 4=Clubs): ");
            try {
                suitChoice = scanner.nextInt();
                if (suitChoice < 1 || suitChoice > 4) {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // Clear the invalid input
            }
        }

        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        return suits[suitChoice - 1];
    }

    private void giveHint(Card guessedCard) {
        if (!guessedCard.getSuit().equals(correctCard.getSuit()) && !guessedCard.getRank().equals(correctCard.getRank())) {
            System.out.println("Wrong suit, wrong rank!! Pick again.");
        } else if (!guessedCard.getSuit().equals(correctCard.getSuit())) {
            System.out.println("Right rank, wrong suit!! Pick again.");
        } else {
            System.out.println("Right suit, wrong rank!! Pick again.");
        }
    }
}
