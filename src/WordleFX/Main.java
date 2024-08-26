package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Wordle With Friends");

        StatisticsManager statisticsManager = new StatisticsManager();
        UIManager uiManager = new UIManager();
        WordleGame wordleGame = new WordleGame(uiManager, statisticsManager);
        
        // Pass the wordleGame reference to the UIManager
        uiManager.setWordleGame(wordleGame);

        VBox root = uiManager.createGameLayout();

        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(1000);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
