package CruxOnline.BinaryTree;

import java.util.Scanner;

public class BinaryTree {

	private class Node {

		int data;
		Node left;
		Node right;

		private Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	private Node root;
	private int size;

	public BinaryTree() {
		Scanner scn = new Scanner(System.in);
		root = takeInput(scn, root, false);
	}

	private Node takeInput(Scanner scn, Node parent, boolean hasLeftOrRightChild) {

		if (parent == null) {
			System.out.println("Enter the data for the root Node: ");
		} else {
			if (hasLeftOrRightChild)
				System.out.println("Enter the data for the left child of " + parent.data);
			else
				System.out.println("Enter the data for the right child of " + parent.data);
		}

		int nodeData = scn.nextInt();
		Node node = new Node(nodeData, null, null);
		this.size++;

		boolean choice = false;
		System.out.println("Do you have left child of " + node.data + "? ");
		choice = scn.nextBoolean();

		if (choice) {
			node.left = takeInput(scn, node, true);
		}

		choice = false;
		System.out.println("Do you have right child of " + node.data + "? ");
		choice = scn.nextBoolean();

		if (choice) {
			node.right = takeInput(scn, node, false);
		}

		return node;
	}

	public void display() {
		display(root);
	}

	private void display(Node root) {

		if (root.left != null) {
			System.out.print(root.left.data + " =>");
		} else {
			System.out.print("END =>");
		}
		System.out.print(root.data);

		if (root.right != null) {
			System.out.println("<= " + root.right.data);
		} else {
			System.out.println("<= END");
		}

		if (root.left != null)
			display(root.left);
		if (root.right != null)
			display(root.right);

	}

	public int height() {
		return height(root);
	}

	private int height(Node root) {

		if (root == null)
			return -1;

		int lHeight = height(root.left);
		int rHeight = height(root.right);

		int mHeight = Math.max(lHeight, rHeight) + 1;
		return mHeight;
	}

	public void preOrder() {
		preOrder(root);
		System.out.println("END");
	}

	private void preOrder(Node root) {

		if (root == null)
			return;

		System.out.print(root.data + ", ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder() {
		postOrder(root);
		System.out.println("END");
	}

	private void postOrder(Node root) {
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + ", ");

	}

	public void inOrder() {
		inOrder(root);
		System.out.println("END");
	}

	private void inOrder(Node root) {

		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data + ", ");
		inOrder(root.right);

	}

}
