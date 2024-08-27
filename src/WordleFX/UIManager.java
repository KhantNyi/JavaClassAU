package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class UIManager {

    private StatisticsManager statisticsManager;
    private GridPane gridPane;
    private GridPane keyboardLayout;
    private Label statsLabel;
    private WordleGame wordleGame;
    private final int wordLength = 5;
    private VBox player1Box;
    private GridPane player1Grid;
    private int currentCol = 0;
    private VBox root;
    private WordValidator wordValidator;

    public UIManager(StatisticsManager statisticsManager) {
        this.statisticsManager = statisticsManager;
        this.wordValidator = new WordValidator();
    }

    public void setWordleGame(WordleGame wordleGame) {
        this.wordleGame = wordleGame;
    }

    public VBox createGameLayout() {
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20; -fx-background-color: #ffffff;");

        Label titleLabel = new Label("WORDLE WITH FRIENDS");
        titleLabel.setFont(new Font("Arial Black", 36));
        titleLabel.setTextFill(Color.BLACK);

        initializeGridPane();
        statsLabel = new Label();
        statsLabel.setFont(new Font("Arial", 16));

        Label playerPrompt = new Label("Player 1: Enter a 5-letter word for Player 2 to guess:");
        playerPrompt.setFont(new Font("Arial", 16));

        initializePlayer1Grid();

        Button submitButton = new Button("Enter");
        submitButton.setStyle("-fx-background-color: #818384; -fx-text-fill: white;");
        submitButton.setOnAction(event -> handleSubmitWord());

        player1Box = new VBox(10, playerPrompt, player1Grid, submitButton);
        player1Box.setAlignment(Pos.CENTER);

        root.getChildren().addAll(titleLabel, player1Box, statsLabel);

        root.setOnKeyPressed(event -> handlePlayer1KeyPress(event.getCode()));

        return root;
    }

    private void initializePlayer1Grid() {
        player1Grid = new GridPane();
        player1Grid.setAlignment(Pos.CENTER);
        player1Grid.setHgap(10);
        player1Grid.setVgap(10);

        for (int i = 0; i < wordLength; i++) {
            Label cell = new Label("");
            cell.setMinSize(60, 60);
            cell.setStyle("-fx-border-color: #d3d6da; -fx-border-width: 2px; -fx-background-color: #ffffff;");
            cell.setAlignment(Pos.CENTER);
            cell.setFont(new Font("Arial Black", 20));

            player1Grid.add(cell, i, 0);
        }
    }

    private void handlePlayer1KeyPress(KeyCode code) {
        if (code.isLetterKey() && currentCol < wordLength) {
            Label cell = (Label) player1Grid.getChildren().get(currentCol);
            cell.setText(code.getName().toUpperCase());
            currentCol++;
        } else if (code == KeyCode.BACK_SPACE && currentCol > 0) {
            currentCol--;
            Label cell = (Label) player1Grid.getChildren().get(currentCol);
            cell.setText("");
        } else if (code == KeyCode.ENTER) {
            handleSubmitWord();
        }
    }

    private String getSecretWordFromGrid() {
        StringBuilder secretWord = new StringBuilder();

        for (int i = 0; i < wordLength; i++) {
            Label cell = (Label) player1Grid.getChildren().get(i);
            secretWord.append(cell.getText());
        }

        return secretWord.toString().toUpperCase();
    }

    private void handleSubmitWord() {
        String secretWord = getSecretWordFromGrid();
        if (secretWord.length() == wordLength && secretWord.chars().allMatch(Character::isLetter)) {
            if (wordValidator.isValidWord(secretWord)) {
                wordleGame.setSecretWord(secretWord);
                initializeKeyboard();
                transitionToPlayer2();
            } else {
                showAlert("Invalid word! Please enter a valid 5-letter word from the dictionary.");
            }
        } else {
            showAlert("Invalid word! Please enter a valid 5-letter word.");
        }
        root.requestFocus();
    }

    private void transitionToPlayer2() {
        statsLabel.setVisible(false);
        statsLabel.setManaged(false);

        root.getChildren().remove(player1Box);

        Label player2Prompt = new Label("Player 2: Try to guess the word:");
        player2Prompt.setFont(new Font("Arial", 16));

        VBox player2Box = new VBox(10, player2Prompt);
        player2Box.setAlignment(Pos.CENTER);

        root.getChildren().addAll(gridPane, player2Box, keyboardLayout);

        root.setOnKeyPressed(event -> {
            if (event.getCode().isLetterKey()) {
                wordleGame.handleKeyPress(event.getText().toUpperCase());
            } else if (event.getCode() == KeyCode.BACK_SPACE) {
                wordleGame.handleBackspace();
            } else if (event.getCode() == KeyCode.ENTER) {
                wordleGame.processGuess();
            }
        });
        root.requestFocus();
    }

    private void initializeGridPane() {
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < wordLength; j++) {
                Label cell = new Label("");
                cell.setMinSize(60, 60);
                cell.setStyle("-fx-border-color: #d3d6da; -fx-border-width: 2px; -fx-background-color: #ffffff;");
                cell.setAlignment(Pos.CENTER);
                cell.setFont(new Font("Arial Black", 20));
                gridPane.add(cell, j, i);
            }
        }
    }

    private void initializeKeyboard() {
        keyboardLayout = new GridPane();
        keyboardLayout.setAlignment(Pos.CENTER);
        keyboardLayout.setHgap(5);
        keyboardLayout.setVgap(10);

        String[] rows = {
            "QWERTYUIOP",
            "ASDFGHJKL",
            "ZXCVBNM"
        };

        for (int i = 0; i < rows.length; i++) {
            HBox rowBox = new HBox(5);
            rowBox.setAlignment(Pos.CENTER);

            for (int j = 0; j < rows[i].length(); j++) {
                String letter = String.valueOf(rows[i].charAt(j));
                Button key = new Button(letter);
                key.setId(letter);
                key.setMinSize(50, 60);
                key.setStyle("-fx-background-color: #d3d6da; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 16px;");
                
                rowBox.getChildren().add(key);
            }

            keyboardLayout.add(rowBox, 0, i);
        }
    }

    public void updateGrid(int row, int col, String letter) {
        Label cell = (Label) gridPane.getChildren().get(row * wordLength + col);
        cell.setText(letter);
    }

    public void updateGuessFeedback(int row, int col, char guessChar, char correctChar) {
        Label cell = (Label) gridPane.getChildren().get(row * wordLength + col);
        String style = "-fx-border-color: #d3d6da; -fx-border-width: 2px;";

        if (guessChar == correctChar) {
            style += " -fx-background-color: #538d4e;"; // Green for correct position
        } else if (secretWordContainsChar(guessChar)) {
            style += " -fx-background-color: #b59f3b;"; // Yellow for correct letter, wrong position
        } else {
            style += " -fx-background-color: #3a3a3c;"; // Gray for incorrect letter
        }

        cell.setStyle(style);
        cell.setTextFill(Color.web("#FFFFFF"));
    }

    public void updateKeyboardFeedback(String guess, String secretWord) {
        for (int i = 0; i < guess.length(); i++) {
            char letter = guess.charAt(i);
            Button key = findKeyButton(letter);
            if (key != null) {
                String style = "-fx-text-fill: white;";
                if (secretWord.charAt(i) == letter) {
                    style += "-fx-background-color: #538d4e;"; // Green
                } else if (secretWord.contains(String.valueOf(letter))) {
                    style += "-fx-background-color: #b59f3b;"; // Yellow
                } else {
                    style += "-fx-background-color: #3a3a3c;"; // Gray
                }
                key.setStyle(style);
            }
        }
    }

    private Button findKeyButton(char letter) {
        for (int i = 0; i < keyboardLayout.getChildren().size(); i++) {
            HBox row = (HBox) keyboardLayout.getChildren().get(i);
            for (javafx.scene.Node node : row.getChildren()) {
                if (node instanceof Button) {
                    Button key = (Button) node;
                    if (key.getText().charAt(0) == letter) {
                        return key;
                    }
                }
            }
        }
        return null;
    }

    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wordle");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void endGame() {
        gridPane.setDisable(true);
        keyboardLayout.setDisable(true);
        showAlert("Game Over! Press OK to start a new game.");

        // Ensure statistics are updated internally

        // Display the updated statistics on the Player 1 screen
        if (statisticsManager != null) {
            updateStats(statisticsManager.getStatistics(), true);
        } else {
            System.err.println("StatisticsManager is null in endGame method");
        }

        statsLabel.setVisible(true);
        statsLabel.setManaged(true);

        newGame();
    }

    public void newGame() {

        updateStatsInternally();
        currentCol = 0;
        player1Grid.getChildren().forEach(node -> ((Label) node).setText(""));

        player1Box.setVisible(true);
        player1Box.setManaged(true);

        gridPane.getChildren().clear();
        initializeGridPane();

        keyboardLayout.getChildren().clear();
        initializeKeyboard();

        wordleGame.resetGameState(); // Reset the game state but do not increment stats

        if (root != null) {
            root.getChildren().clear();

            Label titleLabel = new Label("WORDLE WITH FRIENDS");
            titleLabel.setFont(new Font("Arial Black", 36));
            titleLabel.setTextFill(Color.BLACK);

            statsLabel.setVisible(true);
            statsLabel.setManaged(true);

            root.getChildren().addAll(titleLabel, player1Box, statsLabel);

            root.setOnKeyPressed(event -> handlePlayer1KeyPress(event.getCode()));
            root.requestFocus();

            // Display the latest stats after the game ends
            if (statisticsManager != null) {
                updateStats(statisticsManager.getStatistics(), true);
            }
        } else {
            System.err.println("Error: Root VBox is null, cannot reset game UI properly.");
        }
    }


    
    public void updateStats(String stats, boolean isVisible) {
        if (statsLabel != null) {
            statsLabel.setText(stats);
            statsLabel.setVisible(isVisible);
            statsLabel.setManaged(isVisible);
            System.out.println("Updated stats: " + stats); // Debugging statement
        }
    }



    private void updateStatsInternally() {
        if (statisticsManager != null) {
            // Increment wins or losses depending on game outcome
            // Increment totalGuessesForWins if necessary
        }
    }

    private boolean secretWordContainsChar(char guessChar) {
        return wordleGame.getSecretWord().indexOf(guessChar) >= 0;
    }
}
