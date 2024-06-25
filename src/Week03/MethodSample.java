package Week03;

import java.util.Scanner;

public class MethodSample {
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a sentence: ");
		String text = reader.nextLine();
		
		int result = countDigits(text);
		System.out.println("There are " + result + " digits in the text.");
		
		
		reader.close();
		
	}
	
	public static int countDigits(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); ++i) {
			if (Character.isDigit(str.charAt(i))) {
				count++;
			}
		}		
		return count;
	}
	
}
