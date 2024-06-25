package Week04;

import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();
        
        reverseWordsAndRemoveSymbols(input);
        
        scanner.close();
    }
    
    public static void reverseWordsAndRemoveSymbols(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split("\\s+");
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // Remove special symbols from the word
            word = word.replaceAll("[^a-zA-Z]", "");
            
            // Reverse the word manually and convert to uppercase
            String reversedWord = reverseString(word).toUpperCase();
            
            // Print each reversed word on a new line
            System.out.println(reversedWord);
        }
    }

    public static String reverseString(String input) {
        // Convert the string to a character array
        char[] charArray = input.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        
        // Swap characters from both ends of the array
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        
        // Convert the character array back to a string
        return new String(charArray);
    }
}
