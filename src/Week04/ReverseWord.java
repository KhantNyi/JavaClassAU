//Name - Khant Nyi Thu
//ID - 6632108
//Section - 541

package Week04;

public class ReverseWord {

    public static String removeSpecialSymbols(String word) {
        return word.replaceAll("[^a-zA-Z]", "");
    }

    public static String reverse(String word) {
        StringBuilder reversed = new StringBuilder(word);
        return reversed.reverse().toString();
    }

    public static String processString(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String removedSymbols = removeSpecialSymbols(word);
            String reversedWord = reverse(removedSymbols);
            result.append(reversedWord.toUpperCase()).append("\n");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String input1 = "How are you?";
        String input2 = "Roger Federer";

        String output1 = processString(input1);
        String output2 = processString(input2);

        System.out.println(input1 + "\n" + output1);
        System.out.println(input2 + "\n" + output2);
    }
}
