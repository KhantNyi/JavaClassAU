//Name - Khant Nyi Thu
//ID - 6632108
//Section - 541


package Week03;

public class Exercise3_1 {
    public static void main(String[] args) {
        System.out.println(removeCharacter("kitten", 1)); // "ktten"
        System.out.println(removeCharacter("kitten", 0)); // "itten"
        System.out.println(removeCharacter("kitten", 4)); // "kittn"
    }

    public static String removeCharacter(String str, int n) {
        String before = str.substring(0, n);
        String after = str.substring(n + 1);
        String result = before.concat(after);
        return result;
    }
}

