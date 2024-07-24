package Week07;

public class NGramExtractor {

    public static void main(String[] args) {
        String text = "To be or not to be";
        int n = 2; 

        String[] ngrams = extractNGrams(text, n);
        for (String ngram : ngrams) {
            System.out.println(ngram);
        }
    }

    public static String[] extractNGrams(String text, int n) {
        String[] words = text.toLowerCase().split("\\s+");
        if (n > words.length) {
            return new String[0];
        }

        String[] ngrams = new String[words.length - n + 1];
        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    sb.append(" ");
                }
                sb.append(words[i + j]);
            }
            ngrams[i] = sb.toString();
        }
        return ngrams;
    }
}
