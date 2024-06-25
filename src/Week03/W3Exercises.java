//Name - Khant Nyi Thu
//ID - 6632108
//Section - 541


package Week03;

public class W3Exercises {

	//Exercises 3.1
	 public static String removeCharacter(String str, int n) {
	        String before = str.substring(0, n);
	        String after = str.substring(n + 1);
	        String result = before.concat(after);
	        return result;
	    }
	 
	 //Exercise 3.2
	 public static String removeAll(String str, char ch) {
	        return str.replace(Character.toString(ch), "");
	    }
	 
	 //Exercise 3.3
	 public static int extractLastDigit(int number) {
	        return Math.abs(number) % 10;
	    }
	 
	 //Exercise 3.4
	 public static int extractLastDigit(String number) {

	        char lastChar = number.charAt(number.length() - 1);

	        if (Character.isDigit(lastChar)) {
	            return Character.getNumericValue(lastChar);
	        } else {
	            return -1;
	        }
	    }
}
