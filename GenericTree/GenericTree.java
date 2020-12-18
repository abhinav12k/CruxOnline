package CruxOnline.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {

	private Node root;
	private int size;

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		private Node(int data) {
			this.data = data;
		}
	}

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		this.root = takeInput(scn, null, 0);
	}

	private Node takeInput(Scanner scn, Node parent, int ithChild) {

		if (parent == null) {
			System.out.println("Enter the data for the root Node: ");
		} else {
			System.out.println("Enter the data for the " + ithChild + "th child of " + parent.data);
		}

		int nodeData = scn.nextInt();
		Node node = new Node(nodeData);
		this.size++;

		System.out.println("Enter the number of children for the " + node.data);
		int children = scn.nextInt();

		for (int i = 0; i < children; i++) {
			Node child = takeInput(scn, node, i);
			node.children.add(child);
		}

		return node;

	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node root) {

		// Node data
		System.out.print(root.data + "=> ");
		for (int i = 0; i < root.children.size(); i++) {
			// Data of children Nodes
			System.out.print(root.children.get(i).data + ", ");
		}
		System.out.println("End");

		//display for all nodes
		for (int i = 0; i < root.children.size(); i++)
			display(root.children.get(i));

	}
}
