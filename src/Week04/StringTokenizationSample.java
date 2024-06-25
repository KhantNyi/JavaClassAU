package Week04;

import java.util.StringTokenizer;

public class StringTokenizationSample {

	public static void main(String[] args) {
		String text = "This  is CSX3002  class";
		
		//version 1
		System.out.println("Version 1: Using StringTokenizer");
		StringTokenizer tokenizer = new StringTokenizer(text);
		while (tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken();
			System.out.println(word.toUpperCase());
		}
		
		//version 2 (fail to work with multiple spaces between word)
		System.out.println("Version 2: Using String.split()");
		String[] words = text.split(" ");
		for (String word:words) {
			System.out.println(word);
		}
		
		//version 3 (use a regular expression to specify "one or more spaces" as the delimeter) 
		System.out.println("Version 3: Using String.split() with regex");

		words = text.split("\\s+");		// "\\s" => space, + => at least 1
		for (String word:words) {
			System.out.println(word);
		}
				
		String sampleCSVRecord = "6511037,Eakkasit,S.";
		StringTokenizer tokenizer2 = new StringTokenizer(sampleCSVRecord, ",");
		String id = tokenizer2.nextToken();
		String firstName = tokenizer2.nextToken();
		String lastName = tokenizer2.nextToken();
		System.out.println(firstName + " " + lastName);
	}

}
