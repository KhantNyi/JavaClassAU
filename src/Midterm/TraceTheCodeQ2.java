/*
Given the code, trace step by step and write what the output is.
*/

import java.util.Scanner;

public class TraceTheCodeQ2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String sequence = scan.nextLine();
		
		int position = playTrick(sequence);
		System.out.println(position);
		scan.close();
	}
	
	public static int playTrick(String sequence) {
		int position = 1;
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) == 'A' && position != 3) {
				position = 3 - position;
			} else if (sequence.charAt(i) == 'B' && position != 1) {
				position = 5- position;
			} else if (sequence.charAt(i) == 'C' && position != 2) {
				position = 4 - position;
			}
		}
		return position;
	}
}
