package Week03;

public class CharacterProcessing {
	public static void main(String[] args) {
		
		System.out.println((Character.isDigit('7') ? "7 is " : "7 is not ") + "a digit");
		System.out.println((Character.isDigit('#') ? "# is " : "# is not ") + "a digit");
		
		System.out.println((Character.isDigit('d') ? "d is " : "d is not ") + "a digit");
		System.out.println((Character.isDigit('w') ? "w is " : "w is not ") + "a digit");
		
		System.out.println(Character.isLetterOrDigit('a'));
		
		System.out.println(Character.toUpperCase('g'));
		System.out.println(Character.toUpperCase('H'));
		System.out.println(Character.toUpperCase('9'));
		System.out.println(Character.toUpperCase('!'));
	}
}
