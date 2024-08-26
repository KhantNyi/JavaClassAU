package application;

public class WordleGame {

    private String secretWord;
    private int attempts;
    private final int maxAttempts = 6;
    private final int wordLength = 5;
    private int currentRow = 0;
    private int currentCol = 0;
    private StringBuilder currentGuess = new StringBuilder();
    private StatisticsManager statisticsManager;
    private UIManager uiManager;

    public WordleGame(UIManager uiManager, StatisticsManager statisticsManager) {
        this.attempts = 0;
        this.statisticsManager = statisticsManager;
        this.uiManager = uiManager;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void handleKeyPress(String letter) {
        if (currentCol < wordLength) {
            uiManager.updateGrid(currentRow, currentCol, letter);
            currentGuess.append(letter);
            currentCol++;
        }
    }

    public void handleBackspace() {
        if (currentCol > 0) {
            currentCol--;
            currentGuess.deleteCharAt(currentCol);
            uiManager.updateGrid(currentRow, currentCol, "");
        }
    }

    public void processGuess() {
        String guess = currentGuess.toString();
        for (int i = 0; i < wordLength; i++) {
            uiManager.updateGuessFeedback(currentRow, i, guess.charAt(i), secretWord.charAt(i));
        }

        uiManager.updateKeyboardFeedback(guess, secretWord);

        attempts++;
        currentRow++;
        currentCol = 0;
        currentGuess.setLength(0);

        if (guess.equals(secretWord)) {
            statisticsManager.incrementWins();
            statisticsManager.addGuessesForWin(attempts);
            uiManager.updateStats(statisticsManager.getStatistics());
            uiManager.showAlert("Congratulations! You solved the Wordle in " + attempts + " tries.");
            uiManager.endGame();
        } else if (attempts >= maxAttempts) {
            statisticsManager.incrementLosses();
            uiManager.updateStats(statisticsManager.getStatistics());
            uiManager.showAlert("Game Over! The word was: " + secretWord);
            uiManager.endGame();
        }
    }
}
