package week_3;

public class Node {
	private Word value;
	private Node left;
	private Node right;
	
	public Node(Word word) {
		value = word;
		left = null;
		right = null;
	}
	public String getKey() {
		return this.getValue().toString();
	}
	public Word getValue() {
		return value;
	}
	public void setValue(Word value) {
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
}
