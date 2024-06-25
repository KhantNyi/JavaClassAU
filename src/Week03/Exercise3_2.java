//Name - Khant Nyi Thu
//ID - 6632108
//Section - 541

package Week03;

public class Exercise3_2 {
    public static void main(String[] args) {
        System.out.println(removeAll("kitten", 'i')); // "ktten"
        System.out.println(removeAll("kitten", 'k')); // "itten"
        System.out.println(removeAll("kitten", 't')); // "kien"
        System.out.println(removeAll("participant", 'p')); // "articiant"
    }

    public static String removeAll(String str, char ch) {
        return str.replace(Character.toString(ch), "");
    }
}

