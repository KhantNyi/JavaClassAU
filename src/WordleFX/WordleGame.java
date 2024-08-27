package application;

public class WordleGame {

    private String secretWord;
    private int attempts;
    private int currentRow;
    private int currentCol;
    private StringBuilder currentGuess;
    private UIManager uiManager;
    private StatisticsManager statisticsManager;
    private WordValidator wordValidator;
    private boolean gameCompleted; // Track whether the game has completed

    public WordleGame(UIManager uiManager, StatisticsManager statisticsManager, WordValidator wordValidator) {
        this.uiManager = uiManager;
        this.statisticsManager = statisticsManager;
        this.wordValidator = wordValidator;
        this.attempts = 0;
        this.currentRow = 0;
        this.currentCol = 0;
        this.currentGuess = new StringBuilder();
        this.gameCompleted = false;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
        this.gameCompleted = false; // Reset game status when new word is set
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void handleKeyPress(String letter) {
        if (!gameCompleted && currentCol < 5 && currentRow < 6) {
            currentGuess.append(letter);
            uiManager.updateGrid(currentRow, currentCol, letter);
            currentCol++;
        }
    }

    public void handleBackspace() {
        if (!gameCompleted && currentCol > 0) {
            currentCol--;
            uiManager.updateGrid(currentRow, currentCol, "");
            currentGuess.deleteCharAt(currentCol);
        }
    }

    public void processGuess() {
        if (!gameCompleted && currentGuess.length() == 5) {
            String guessWord = currentGuess.toString();
            if (wordValidator.isValidWord(guessWord)) {
                attempts++;
                for (int i = 0; i < 5; i++) {
                    char guessChar = currentGuess.charAt(i);
                    char correctChar = secretWord.charAt(i);
                    uiManager.updateGuessFeedback(currentRow, i, guessChar, correctChar);
                }
                uiManager.updateKeyboardFeedback(currentGuess.toString(), secretWord);

                if (currentGuess.toString().equals(secretWord)) {
                    handleGameEnd(true); // Player wins
                } else if (attempts >= 6) {
                    handleGameEnd(false); // Player loses
                } else {
                    currentRow++;
                    currentCol = 0;
                    currentGuess.setLength(0);
                }
            } else {
                uiManager.showAlert("Invalid word! Please enter a valid 5-letter word from the dictionary.");
                // Clear the current guess
                for (int i = 0; i < 5; i++) {
                    uiManager.updateGrid(currentRow, i, "");
                }
                currentGuess.setLength(0);
                currentCol = 0;
            }
        }
    }

    private void handleGameEnd(boolean isWin) {
        if (!gameCompleted) {
            System.out.println("Handling game end. IsWin: " + isWin);
            statisticsManager.incrementGamesPlayed(); // This should be the only place where this is called

            if (isWin) {
                statisticsManager.incrementWins();
                statisticsManager.addGuessesForWin(attempts);
                uiManager.showAlert("Congratulations! You've guessed the word.");
            } else {
                statisticsManager.incrementLosses();
                uiManager.showAlert("Game Over! The word was: " + secretWord);
            }

            gameCompleted = true; // Mark the game as completed
            uiManager.endGame();
        }
    }



    public void resetGameState() {
        this.attempts = 0;
        this.currentRow = 0;
        this.currentCol = 0;
        this.currentGuess = new StringBuilder();
        this.secretWord = null; // Clear the secret word
        this.gameCompleted = false; // Reset the game completion flag
    }
}
