package week11;

public class StackDriver {

	public static void main(String[] args) {
		StackV1 iStack = new StackV1(5);
		iStack.push(2);
		iStack.push(5);
		iStack.push(7);
		iStack.push(4);
		System.out.println(iStack);	// Expect: [ 4 7 5 2 ]
		
		iStack.pop();
		iStack.pop();
		System.out.println(iStack); // Expect: [ 5 2 ]
		
		while (!iStack.isEmpty()) {
			System.out.println(iStack.pop());
		}
		System.out.println(iStack); // Expect: [ ]
		
	}

}
