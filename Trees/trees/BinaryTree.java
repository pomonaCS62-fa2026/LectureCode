package trees;

import java.util.ArrayList;

public class BinaryTree<E extends Comparable<E>> {
	private Node root;

	public ArrayList<E> findLessThan(E value) {
		ArrayList<E> values = new ArrayList<E>();
		findLessThan(root, value, values);
		return values;
	}
	
	private void findLessThan(Node t, E value, ArrayList<E> list) {
		if( t != null ) {
			if( t.value.compareTo(value) < 0 ) {
				list.add(t.value);
				// need to explore both left and right since
				// values to the right could be also be less than
				findLessThan(t.left, value, list);
				findLessThan(t.right, value, list);
			} else {
				// look for values that are less, which is in the left branch
				findLessThan(t.left, value, list);
			}
		}
	}
	
	private class Node {
		private E value;
		private Node left;
		private Node right;
		
		public Node(Node left, Node right, E value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}
	}
}

