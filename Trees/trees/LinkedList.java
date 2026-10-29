package trees;

public class LinkedList<E> {
	private Node head;
	
	private class Node {
		private E value;
		private Node next;
		
		public Node(Node next, E value) {
			this.next = next;
			this.value = value;
		}
	}
}
