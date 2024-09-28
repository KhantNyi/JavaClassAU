package week11;

public class Stack {
	private int top;
	private int size;
	private int[] array;
	
	// default constructor creates a Stack of size 10
	public Stack() {
		this.size = 10;
		this.top = -1;
		this.array = new int[size];
	}
	
	public Stack(int size) {
		this.size = size;
		this.top = -1;
		this.array = new int[size];
	}
	
	/**
	 * Check whether the stack is empty.
	 * @return true if the stack is empty; false otherwise
	 */
	public boolean isEmpty() {
		return top == -1;
	}
	
	/**
	 * Check whether the stack is full.
	 * @return true if the stack is full; false otherwise
	 */
	public boolean isFull() {
		return top == size - 1; 
	}
	
	/**
	 * Push an item into the stack
	 * @param item
	 * @return true if succeed; false otherwise 
	 */
	public boolean push(int item) {

	}

	/**
	 * Pop an item from the stack (The top item is removed from the stack)
	 * @return the value of top item; -1 if the stack is empty. 
	 */
	public int pop() {

	}
	
	/**
	 * Get the top item of the stack (The stack contents are unchanged)
	 * @return the value of top item; -1 if the stack is empty. 
	 */
	public int getTop() {

	}
	

	/**
	 * return the string representation of the stack from top to bottom 
	 * where the leftmost item is the top of the stack
	 * and the rightmost item is the bottom of the stack
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[ ");
		
		for (int i = top; i >= 0; --i) {
			result.append(array[i]);
			result.append(" ");
		}
		
		result.append("]");
		return result.toString();
	}
}
