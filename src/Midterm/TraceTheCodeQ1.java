/*
Given the code, trace step by step and write what the output will be.
*/

public class TraceTheCodeQ1 {
	public static void main(String[] args) {
		int[] array = {3, 7, 10, 0, -2};
		
		funStuff(array); // {3, 2, 5, 3, 3} after calling this method

		//Array remains unchanged because doSomething does nothing
		for (int i = 0; i < array.length; i++) {
			doSomething(array[i]);
		}
		
		doMore(array); //now modifying the {3, 2, 5, 3, 3} => {9, 2, 15, 3, 9}
		
		System.out.print(arrayToString(array)); //Converting to string so final output should be
		//"[9, 2, 15, 3, 9]"
	}

	//Does what the method says
	public static void funStuff(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 3 ==0) {
				arr[i] = 3;
			} else if (arr[i] > 5) {
				arr[i] = arr[i] - 5;
			} else  {
				arr[i] = arr[i] + 5;
			} 
		}
	}


	//Does nothing because in Java, primitive values like int here are pass-by-value
	//Therefore not affecting the original array
	public static void doSomething(int value) {
		value = value * 2;
	}

	//Multiply by 3 for index at 0, 2, 4
	public static void doMore(int[] arr) {
		for (int i = 0; i<arr.length; i = i+2) {
			arr[i] = arr[i] * 3;
		}
	}

	//Converting to string format
	public static String arrayToString(int[] arr) {
		String result = "[";
		if (arr.length > 0) {
			result = result + arr[0];
		}
		for (int i = 1; i < arr.length; i++) {
			result = result + ", " + arr[i];
		}
		result = result + "]";
		return result;
	}
}
