// trace-the-code question
// simple enough, prolly add comments in this file later


import java.util.Arrays;
import java.util.Scanner;

public class q3 {

    public static final int SIZE = 3;

    public static void main(String[] args){
        int[] numbers = new int[SIZE];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < SIZE; i++){
            numbers[i] = scan.nextInt();
        }
        scan.nextLine();

        String sequence = scan.nextLine();

        Arrays.sort(numbers);

        for (int i = 0; i < SIZE; i++){
            int index = getPosition(sequence.charAt(i));
            System.out.print(numbers[index] + " ");
        }
        scan.close();
    }

    public static int getPosition(char id){
        if (id == 'A'){
            return  0;
        } else if (id == 'B'){
            return 1;
        } else if (id == 'C'){
            return 2;
        }
        return -1;
    }

}

