package trees;

import java.util.Arrays;

public class BinarySearchTree<E extends Comparable<E>> {
	private Node root;

	public boolean search(E item){
		return search(root, item);
	}

	private boolean search(Node c, E item) {
		if( c == null ) {
			return false;
		} else {
			int cmp = item.compareTo(c.value);

			if( cmp == 0 ){
				return true;
			} else if( cmp < 0 ){
				return search(c.left, item);
			}else {
				return search(c.right, item);
			}

		}
	}

	public void insert(E item){
		if( root == null ) {
			root = new Node(item);
		} else {
			insert(root, item);
		}
	}

	private void insert(Node c, E item) {
		if( item.compareTo(c.value) < 0) {
			if( c.left == null ) {
				c.left = new Node(item);
			} else {
				insert(c.left, item);
			}
		} else {
			if( c.right == null ) {
				c.right = new Node(item);
			} else {
				insert(c.right, item);
			}
		}
	}

	private boolean iterativeSearch(Node c, E item) {
		while( c != null && item.compareTo(c.value) != 0 ) {
			if( item.compareTo(c.value) < 0 ){
				c = c.left;
			}else {
				c = c.right;
			}
		}

		return c != null;
	}

	private class Node {
		private E value;
		private Node left;
		private Node right;

		public Node(E value) {
			this.value = value;
			left = null;
			right = null;
		}

		public Node(Node left, Node right, E value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public E getValue() {
			return value;
		}	

	}
	
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		String f = args[1];
		
		System.out.println(Arrays.toString(args));
		
		
		
	}
}
