package week_3;

public class Tree {
	private Node root;
	public Tree() {
		root = new Node(new Word("<root>"));
	}
	public Word search(String key) { //make recursive
		Node current = root;
		if(root == null) {
			System.err.println("Empty list!");
			return null;
		}
		while(current != null) {
			if(current.getValue().getWord().equals(key)) return current.getValue();
			else if(current.getValue().getWord().compareTo(key) > 0) current = current.getLeft();
			else current = current.getRight();
		}
		return null;
	}
	public void add(String key) {
		Node current = root, parent = null;
		//if first element init root
		if(root == null) {
			root = new Node(new Word(key));
			return;
		}
		while(current != null) {//find the right place for value
			parent = current;
			if(current.getValue().getWord().compareTo(key) > 0) current = current.getLeft();
			else current = current.getRight();
		}
		Node newNode = new Node(new Word(key));
		if(parent.getValue().getWord().compareTo(key) > 0) {
			parent.setLeft(newNode);
			//System.out.println(newNode.getValue().getWord());
		}
		else {
			parent.setRight(newNode);
			//System.err.println(newNode);
		}
		
	}
	public void inOrderVisit() {
		//inOrder(root.getRight());
	}
	public void inOrder(Node node) {
		if(node.getLeft()!= null) inOrder(node.getLeft());
		System.out.println(node.getValue()+":");
		if(node.getRight()!=null) inOrder(node.getRight());
		System.out.println(node.getValue()+";");
	}
}
