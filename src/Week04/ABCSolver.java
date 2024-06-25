package Week04;

import java.util.Arrays;
import java.util.Scanner;

public class ABCSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter input: ");
        
        // Read the integers
        int[] values = new int[3];
        values[0] = scanner.nextInt();
        values[1] = scanner.nextInt();
        values[2] = scanner.nextInt();
        
        // Read the order
        String order = scanner.next();
        
        // Sort the values
        Arrays.sort(values);
        
        // Create a result array to store the ordered values
        int[] result = new int[3];
        
        // Map the characters in 'order' to the sorted values
        for (int i = 0; i < 3; i++) {
            if (order.charAt(i) == 'A') {
                result[i] = values[0];
            } else if (order.charAt(i) == 'B') {
                result[i] = values[1];
            } else if (order.charAt(i) == 'C') {
                result[i] = values[2];
            }
        }
        
        // Print the result
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
        
        scanner.close();
    }
}
