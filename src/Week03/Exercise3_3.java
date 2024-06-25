//Name - Khant Nyi Thu
//ID - 6632108
//Section - 541


package Week03;

public class Exercise3_3 {
    public static void main(String[] args) {
        System.out.println(extractLastDigit(2498));
        System.out.println(extractLastDigit(340));
    }

    public static int extractLastDigit(int number) {
        return Math.abs(number) % 10;
    }
}

