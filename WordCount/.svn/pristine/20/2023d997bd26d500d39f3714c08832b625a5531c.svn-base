/*-************************************************************************-*\
*             *  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY••)    *
*   #####     *  (!) Mar-2018, Giovanni Squillero <squillero@polito.it>      *
*  ######     *                                                              *
*  ###   \    *  Copying and distributing this file, either with or without  *
*   ##G  c\   *  modification, is permitted in any medium without royalty,   *
*   #     _\  *  provided that this 10-line comment is preserved.            *
*   |  _/     *                                                              *
*             *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  *
\*-************************************************************************-*/

package it.polito.oop.wc_tree;

public class Tree {
	private class Node {
		WordCount.Entry entry;
		Node left, right;
		Node(WordCount.Entry entry) {
			this.entry = entry;
		}
		String getKey() {
			return entry.getWord();
		}
	}

	private Node root = new Node(new WordCount.Entry("", 0));
	private int numNodes = 0;
	
	WordCount.Entry findEntry(String word) {
		Node current = root;
		while(current != null) {
			if(word.equals(current.getKey()))
				return current.entry;
			if(word.compareTo(current.getKey()) > 0)
				current = current.right;
			else
				current = current.left;
		}
		return null;
	}

	void addEntry(String word) {
		Node current = root;
		Node previous = root;
		while(current != null) {
			previous = current;
			if(word.compareTo(current.getKey()) > 0)
				current = current.right;
			else
				current = current.left;
		}
		if(word.compareTo(previous .getKey()) > 0)
			previous.right = new Node(new WordCount.Entry(word, 1));
		else
			previous.left = new Node(new WordCount.Entry(word, 1));
		++numNodes;
	}

	public WordCount.Entry[] visit() {
		WordCount.Entry[] dump = new WordCount.Entry[numNodes];
		visit(root.right, dump, 0);
		return dump;
	}

	private int visit(Node node, WordCount.Entry[] dump, int pos) {		
		if(node.left != null)
			pos = visit(node.left, dump, pos);
		dump[pos++] = node.entry;
		if(node.right != null)
			pos = visit(node.right, dump, pos);
		return pos;
	}
}
