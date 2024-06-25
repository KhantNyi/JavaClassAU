//Name - Khant Nyi Thu
//ID - 6632108
//Section - 541


package Week03;

public class Exercise3_4 {
    public static void main(String[] args) {
        System.out.println(extractLastDigit("2498")); // 8
        System.out.println(extractLastDigit("Fun Exercise")); // -1
    }

    public static int extractLastDigit(String number) {

        char lastChar = number.charAt(number.length() - 1);

        if (Character.isDigit(lastChar)) {
            return Character.getNumericValue(lastChar);
        } else {
            return -1;
        }
    }
}

