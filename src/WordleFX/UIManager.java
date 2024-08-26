package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class UIManager {

    private GridPane gridPane;
    private GridPane keyboardLayout;
    private Label statsLabel;
    private WordleGame wordleGame;  // This will be set using the setWordleGame method
    private final int wordLength = 5;

    // Add a setter to allow setting the WordleGame instance
    public void setWordleGame(WordleGame wordleGame) {
        this.wordleGame = wordleGame;
    }

    public VBox createGameLayout() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20; -fx-background-color: #ffffff;");

        Label titleLabel = new Label("WORDLE WITH FRIENDS");
        titleLabel.setFont(new Font("Arial Black", 36));
        titleLabel.setTextFill(Color.BLACK);

        initializeGridPane();
        statsLabel = new Label();
        statsLabel.setFont(new Font("Arial", 16));
        updateStats("");

        Label playerPrompt = new Label("Player 1: Enter a 5-letter word for Player 2 to guess:");
        playerPrompt.setFont(new Font("Arial", 16));

        PasswordField player1Input = new PasswordField();
        player1Input.setPromptText("Enter a 5-letter word");
        player1Input.setMaxWidth(300);
        
        // Handle the Enter key press
        player1Input.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String secretWord = player1Input.getText().trim().toUpperCase();
                if (secretWord.length() == wordLength) {
                    wordleGame.setSecretWord(secretWord);
                    initializeKeyboard();
                    transitionToPlayer2(root, playerPrompt, player1Input, null);
                } else {
                    showAlert("Invalid word! Please enter a valid 5-letter word.");
                }
            }
        });

        Button startButton = new Button("Start Game");
        startButton.setStyle("-fx-background-color: #818384; -fx-text-fill: white;");
        startButton.setOnAction(event -> {
            String secretWord = player1Input.getText().trim().toUpperCase();
            if (secretWord.length() == wordLength) {
                wordleGame.setSecretWord(secretWord);
                initializeKeyboard();
                transitionToPlayer2(root, playerPrompt, player1Input, startButton);
            } else {
                showAlert("Invalid word! Please enter a valid 5-letter word.");
            }
        });

        Button viewStatsButton = new Button("View Stats");
        viewStatsButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        viewStatsButton.setOnAction(event -> showStats());

        VBox player1Box = new VBox(10, playerPrompt, player1Input, startButton, viewStatsButton);
        player1Box.setAlignment(Pos.CENTER);

        root.getChildren().addAll(titleLabel, player1Box, statsLabel);

        return root;
    }


    private void transitionToPlayer2(VBox root, Label playerPrompt, PasswordField player1Input, Button startButton) {
        root.getChildren().removeAll(playerPrompt, player1Input, startButton);
        Label player2Prompt = new Label("Player 2: Try to guess the word:");
        player2Prompt.setFont(new Font("Arial", 16));
        root.getChildren().addAll(gridPane, player2Prompt, keyboardLayout);

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

    public void updateStats(String stats) {
        statsLabel.setText(stats);
    }

    public void showStats() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Statistics");
        alert.setHeaderText("Current Statistics");
        alert.setContentText(statsLabel.getText());
        alert.showAndWait();
    }

    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wordle");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void endGame() {
        gridPane.setDisable(true); // Disable further input
        keyboardLayout.setDisable(true); // Disable keyboard
        showAlert("Game Over! Press OK to start a new game.");
        resetGame();
    }

    private void resetGame() {
        gridPane.getChildren().clear();
        initializeGridPane();
        gridPane.setDisable(false); // Re-enable gridPane for new game

        keyboardLayout.getChildren().clear();
        initializeKeyboard();
        keyboardLayout.setDisable(false);
    }

    private boolean secretWordContainsChar(char guessChar) {
        return wordleGame.getSecretWord().indexOf(guessChar) >= 0;
    }
}
