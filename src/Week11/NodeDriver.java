package week11;

public class NodeDriver {

	public static void main(String[] args) {
		Node node1 = new Node(5);
		Node node2 = new Node(10);
		Node node3 = new Node(15);

		node3.setNext(node2);
		node2.setNext(node1);
		
		Node head = node3;
		
		Node current = head;
		
		while (current != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
	}

}
