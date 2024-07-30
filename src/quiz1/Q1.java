/* 
sequenceThisPattern method generates its sequence for an input value n.
Sample output for where n = 5
[1]
[1, 2, 1]
[1, 2, 3, 1, 2, 1]
[1, 2, 3, 4, 1, 2, 3, 1, 2, 1]
[1, 2, 3, 4, 5, 1, 2, 3, 4, 1, 2, 3, 1, 2, 1]
*/

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            printArray(sequenceThisPattern(i));
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] sequenceThisPattern(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                list.add(j);
            }
        }

        // Convert the list to an array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
