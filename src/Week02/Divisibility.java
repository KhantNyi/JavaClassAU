// Name - Khant Nyi Thu
// ID - 6632108
// Section - 541

package Week02;

import java.util.Scanner;

public class Divisibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter a number: ");
            numbers[i] = scanner.nextInt();
        }

        String result = "";
        for (int i = 0; i < 5; i++) {
            if (numbers[i] % divisor == 0) {
                result += numbers[i] + " ";
            }
        }

        if (result.length() == 0) {
            System.out.print("None of the numbers is divisble by " + divisor);
        } else {
            System.out.print(result + "are divisible by " + divisor + ".");
        }
        
        scanner.close();
    }
}
