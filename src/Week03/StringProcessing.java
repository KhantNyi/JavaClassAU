package Week03;

public class StringProcessing {
	public static void main(String[] args) {
		
		String myText = "Hi there";
		String newText = new String("Hi there");
		
		String hiAgain = "hi there";
		String anotherHi = "Hi there";
		
		System.out.println(myText.equals("Hi there"));
		System.out.println((myText == "Hi there"));
		
		System.out.println(myText.equals(newText));
		System.out.println(myText == newText);
		System.out.println(myText == hiAgain);
		System.out.println(newText == anotherHi);
		
		System.out.println(myText.equalsIgnoreCase(hiAgain));
		
		String abcLowercase = "abc";
		String abc = "ABC";
		String happy = new String("Happy");
		String happy2 = new String("Happy ");
		String birthday = "Happy Birthday";
		String birthdayLowercase = "happy birthday";
		
		System.out.println(happy.concat("Holidays"));
		System.out.println(happy);
		
		System.out.println(happy.startsWith("Ha"));
		System.out.println(happy.contains("app"));
		
		System.out.println(abcLowercase.compareTo(abc));
		
	}
}
