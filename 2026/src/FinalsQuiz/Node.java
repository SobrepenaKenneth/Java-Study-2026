package FinalsQuiz;

public class Node {

	// Node class
	private int key;
	private Node left;
	private Node right;

	public Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}

	// Getters
	public int getKey() {
		return key;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	// Setters
	public void setKey(int key) {
		this.key = key;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
