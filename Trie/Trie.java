package CruxOnline.Trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Trie {

	private class Node {

		char data;
		HashMap<Character, Node> children;
		boolean isTerminal;

		private Node(char data, boolean isTerminal) {
			this.data = data;
			this.children = new HashMap();
			this.isTerminal = isTerminal;
		}

	}

	private Node root;
	private int numOfWords;

	public Trie() {
		this.root = new Node('\0', false);
		this.numOfWords = 0;
	}

	public int numOfWords() {
		return this.numOfWords;
	}

	public void addWord(String word) {
		addWord(root, word);
	}

	private void addWord(Node parent, String word) {

		if (word.length() == 0) {
			if (parent.isTerminal) {
				// Word is already present
			} else {
				parent.isTerminal = true;
				this.numOfWords++;
			}
			return;
		}

		char cc = word.charAt(0);
		String ros = word.substring(1);

		Node child = parent.children.get(cc);

		if (child == null) {
			child = new Node(cc, false);
			parent.children.put(cc, child);
		}
		addWord(child, ros);

	}

	public void display() {
		display(root, "");
	}

	private void display(Node parent, String osf) {

		if (parent.isTerminal) {
			// Reached a available word
			String ans = osf.substring(1) + parent.data;
			System.out.println(ans);
		}

		Set<Map.Entry<Character, Node>> entries = parent.children.entrySet();

		for (Map.Entry<Character, Node> entry : entries) {

			this.display(entry.getValue(), osf + parent.data);

		}

	}

	public boolean search(String word) {
		return search(root, word);
	}

	private boolean search(Node parent, String word) {

		if (word.length() == 0) {
			if (parent.isTerminal)
				return true;
			else
				return false;
		}

		char cc = word.charAt(0);
		String ros = word.substring(1);

		Node child = parent.children.get(cc);

		if (child == null) {
			return false;

		}
		return search(child, ros);

	}

	public void remove(String word) {
		remove(root, word);
	}
	
	private void remove(Node parent,String word) {
		
		if(word.length()==0) {
			if(parent.isTerminal) {
				parent.isTerminal = false;
				this.numOfWords--;
			}else{
				//Word is a part of some other 
			}
			return;
		}
		
		char cc = word.charAt(0);
		String ros = word.substring(1);
		
		Node child = parent.children.get(cc);
		
		if(child==null)
			return;
		
		this.remove(child, ros);
		
		if(!parent.isTerminal && parent.children.isEmpty()) {
			parent.children.remove(cc);
		}
	}
	
}
