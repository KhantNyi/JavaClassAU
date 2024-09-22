//something to do with sorting i think :)

//Trace-the-code type question

import java.util.Arrays;

public class quiz3q2 {
    public static void main(String[] args) {
        int[] array = {148, 60, 534, 1490, 178, 480, 22, 8, 555, 10};

        fireAway(array, 1);

        System.out.print(arrayToString(array));
    }

    public static int getKeyDigit(int value, int position) {
        return getKeyDigit(value, 0, position);
    }

    public static int getKeyDigit(int value, int current, int position) {
        if (current == position) {
            return value % 10;
        } else {
            return getKeyDigit(value / 10, current + 1, position);
        }
    }

    public static void fireAway(int[] arr, int start) {
        for (int i = 0; i < arr.length; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                int currentDigit = getKeyDigit(arr[j], start, j);
                int smallestDigit = getKeyDigit(arr[smallestIndex], start);

                if (currentDigit < smallestDigit) {
                    smallestIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }

    public static String arrayToString(int[] arr) {
        String result = "[";
        if (arr.length > 0) {
            result += arr[0];
        }
        for (int i = 1; i < arr.length; i++) {
            result += ", " + arr[i];
        }
        result += "]";
        return result;
    }
}
