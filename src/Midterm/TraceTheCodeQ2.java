/*
Given the code, trace step by step and write what the output is.
a) Input is "ABC"
b) Input is "CABAC"
I will only do question a) here.
*/

import java.util.Scanner;

public class TraceTheCodeQ2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String sequence = scan.nextLine();

		//Input is "ABC"
		int position = playTrick(sequence);
		System.out.println(position); // returns 1;
		scan.close();
	}
	
	public static int playTrick(String sequence) {
		//initialize position with value
		int position = 1;

		//Since input is "ABC", length is 3
		//i will be 0, 1, 2
		for (int i = 0; i < sequence.length(); i++) {

			//for i = 0, char is A and position is 1 so this condition is true
			if (sequence.charAt(i) == 'A' && position != 3) {
				//position is now 3 - 1 = 2;
				position = 3 - position;
				//i = 1, char is B, position is not 1 so this condition is true
			} else if (sequence.charAt(i) == 'B' && position != 1) {
				//position is now 5 - 2 = 3;
				position = 5- position;
				//i = 2, char is C and position is not 2 so this condition is true
			} else if (sequence.charAt(i) == 'C' && position != 2) {
				//position is now 4 - 3 = 1;
				position = 4 - position;
			}
		}
		return position;
	}
}
