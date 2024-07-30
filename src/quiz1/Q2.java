/*
Put an asterisk between duplicate characters in a string.
Sample output "AAABBBCCC"; // A*A*AB*B*BC*C*C
*/

public class Q2 {
    public static void main(String[] args) {
        String input = "AAABBBCCC"; // Change this value to test different strings
        System.out.println(insertAsteriskForDuplicates(input));
    }

    public static String insertAsteriskForDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            boolean duplicateFound = false;
            
            // Check if this character has already appeared in the string
            for (int j = 0; j < i; j++) {
                if (input.charAt(j) == c) {
                    duplicateFound = true;
                    break;
                }
            }
            
            // If a duplicate is found, insert an asterisk before the character
            if (duplicateFound) {
                result.append("*");
            }
            
            result.append(c);
        }

        return result.toString();
    }
}
