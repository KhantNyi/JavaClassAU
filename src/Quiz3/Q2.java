//Sorting the numbers based on the position of digit
// Given {148, 60, 534, 1490, 178, 480, 22, 8, 555, 10}
// output [8, 10, 22, 534, 148, 555, 60, 178, 480, 1490]

//Trace-the-code type question

import java.util.Arrays;

public class quiz3q2 {
    public static void main(String[] args) {
        // 1. Initialize an array of integers with different lengths
        int[] array = {148, 60, 534, 1490, 178, 480, 22, 8, 555, 10};

        // 2. Call fireAway method to sort the array based on the digit at position 1 (2nd digit from right)
        fireAway(array, 1);  // Sorting based on the second digit from right

        // 3. Print the array as a string after sorting
        System.out.print(arrayToString(array)); 
    }

    // 4. Overloaded method to get the key digit at the specified position (uses 0 as starting index)
    public static int getKeyDigit(int value, int position) {
        return getKeyDigit(value, 0, position); // Calls the recursive method starting at index 0
    }

    // 5. Recursive method to find the digit at the given position in a number
    public static int getKeyDigit(int value, int current, int position) {
        // If we are at the desired position, return the last digit
        if (current == position) { //for number 148, current is 0 and position is 1
            return value % 10; // now (14, 1, 1) will return 4 because 14 % 10 = 4
        } else if (value == 0) {
            return 0; // If value becomes 0 before reaching position, return 0 (for numbers with fewer digits)
        } else {
            return getKeyDigit(value / 10, current + 1, position); // Move one position left (e.g., 148 / 10 = 14) and current is increased so it will go back to top
        }
    }

    // 6. Method to sort the array based on a specific digit position
    public static void fireAway(int[] arr, int position) {
        // Use a simple selection sort algorithm based on the digit at the specified position
        for (int i = 0; i < arr.length; i++) {
            int smallestIndex = i; // Assume current index as the smallest

            for (int j = i + 1; j < arr.length; j++) {
                // Get the digit at the given position for both current and smallest elements
                int currentDigit = getKeyDigit(arr[j], position); //number at i+1 = 60 so this returns 6 after calling getKeyDigit method
                int smallestDigit = getKeyDigit(arr[smallestIndex], position); //number at smallestindex 0 for now is 148. return 4 after calling method

                // Compare digits at the specified position; update smallestIndex if necessary
                if (currentDigit < smallestDigit) { //6 < 4 false, only updates true
                    smallestIndex = j;              // not updated remains i, updates to j if above condition is true
                }
            }
            // Swap the current element with the smallest element found in this pass
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }

    // 7. Method to convert an integer array to a string representation for printing
    public static String arrayToString(int[] arr) {
        StringBuilder result = new StringBuilder("["); // Use StringBuilder for efficiency
        if (arr.length > 0) {
            result.append(arr[0]); // Add the first element if the array is not empty
        }
        for (int i = 1; i < arr.length; i++) {
            result.append(", ").append(arr[i]);
        }
        result.append("]");
        return result.toString();
    }
}
