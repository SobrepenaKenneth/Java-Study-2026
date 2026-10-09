package FinalsQuiz;

public class BinarySearchTree {

	private Node root;

	// INSERT
	public void insertKey(int key) {
		root = insert(root, key);
	}

	public Node insert(Node node, int key) {
		if (node == null) {
			node = new Node(key);
			return node;
		}

		// Reject duplicate keys
		if (node.getKey() == key) {
			return node;
		}

		// Smaller keys go left
		if (key < node.getKey()) {
			node.setLeft(insert(node.getLeft(), key));
		} else {
			// Larger keys go right
			node.setRight(insert(node.getRight(), key));
		}

		return node;
	}

	// DISPLAY: IN-ORDER
	public void displayInOrder() {
		if (root == null) {
			System.out.println("The BST is empty.");
			return;
		}

		System.out.print("In-order: ");
		inOrderHelper(root);
		System.out.println();
	}

	// Recursive helper
	private void inOrderHelper(Node node) {
		if (node == null) {
			return;
		}

		inOrderHelper(node.getLeft()); // Left
		System.out.print(node.getKey() + " "); // Root
		inOrderHelper(node.getRight()); // Right
	}

	// SEARCH
	public boolean search(int key) {
		return searchHelper(root, key);
	}

	// Recursive helper for searching
	private boolean searchHelper(Node node, int key) {
		if (node == null) {
			return false;
		}

		if (key == node.getKey()) {
			return true;
		}

		if (key < node.getKey()) {
			return searchHelper(node.getLeft(), key);
		}

		return searchHelper(node.getRight(), key);
	}

	// COUNT LEAF NODES
	public int countLeafNodes() {
		return countLeavesHelper(root);
	}

	// Recursive helper for counting leaves
	private int countLeavesHelper(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.getLeft() == null && node.getRight() == null) {
			return 1;
		}

		return countLeavesHelper(node.getLeft()) + countLeavesHelper(node.getRight());
	}

	// FIND MINIMUM
	public Integer findMinimum() {
		if (root == null) {
			return null;
		}

		return findMinimumHelper(root);
	}

	// Recursive helper for finding minimum
	private int findMinimumHelper(Node node) {
		if (node.getLeft() == null) {
			return node.getKey();
		}

		return findMinimumHelper(node.getLeft());
	}

}