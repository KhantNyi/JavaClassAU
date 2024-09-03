package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class WordValidator {
    private Set<String> validWords;

    public WordValidator() {
        validWords = new HashSet<>();
        loadValidWords();
    }

    private void loadValidWords() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("5-letter-words-list.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                validWords.add(line.trim().toUpperCase());
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error loading valid words: " + e.getMessage());
        }
    }

    public boolean isValidWord(String word) {
        return validWords.contains(word.toUpperCase());
    }
}
