package week11;

public class StackV2 {
	private Node top;
	private int size;
	private int count;
	
	public StackV2() {
		this.top = null;
		this.size = 10;
		this.count = 0;
	}
	
	public StackV2(int size) {
		this.top = null;
		this.size = size;
		this.count = 0;
	}
	
	public boolean isEmpty() {
		
	}
	
	public boolean isFull() {
		
	}
	
	public boolean push(int item) {
		if (isFull()) {
			return false;
		} else {
			Node newNode = new Node(item);
			newNode.setNext(top);
			top = newNode;
			count++;
			return true;
		}
	}
	
	public int pop() {
		if (isEmpty()) {
			return -1;
		} else {
			int item = top.getData();
			top = top.getNext();
			count--;
			return item;
		}
	}
	
	public int getTop() {
		
	}
}
