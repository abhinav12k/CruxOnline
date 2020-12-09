package CruxOnline.BST;

public class BST {

	private class Node {

		int data;
		Node left;
		Node right;

		private Node() {

		}

		private Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	private Node root;

	public BST(int[] in) {
		this.root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int lo, int hi) {

		if (lo > hi) {
			return null;
		}

		int mid = (lo + hi) / 2;
		Node parent = new Node(in[mid], null, null);

		parent.left = construct(in, lo, mid - 1);
		parent.right = construct(in, mid + 1, hi);

		return parent;

	}

	public void display() {
		System.out.println("*-------------------------");
		display(this.root);
		System.out.println("--------------------------");
	}

	private void display(Node root) {

		if (root == null) {
			return;
		}

		String str = "";
		if (root.left == null) {
			str += ". =>";
		} else {
			str += root.left.data + " =>";
		}
		str += root.data;
		if (root.right == null) {
			str += "<= .";
		} else {
			str += "<= " + root.right.data;

		}
		System.out.println(str);

		display(root.left);
		display(root.right);
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node root, int item) {

		if (root == null)
			return false;

		if (item > root.data) {
			return find(root.right, item);
		} else if (item < root.data) {
			return find(root.left, item);
		} else {
			return true;
		}

	}

	public int max() {
		return max(root);
	}

	private int max(Node root) {

		if (root.right == null) {
			return root.data;
		}

		return max(root.right);

	}

	public void add(int item) {
		add(root, item);
	}

	private void add(Node root, int item) {

		if (item > root.data) {
			if (root.right == null) {
				Node nn = new Node();
				nn.data = item;
				root.right = nn;
			} else
				add(root.right, item);
		} else if (item <= root.data) {

			if (root.left == null) {
				Node nn = new Node();
				nn.data = item;
				root.left = nn;
			} else
				add(root.left, item);
		}

	}

	public void remove(int item) {
		remove(root, null, false, item);
	}

	private void remove(Node node, Node parent, boolean ilc, int item) {

		if (item > node.data) {

			remove(node.right, node, false, item);

		} else if (item < node.data) {
			remove(node.left, node, true, item);
		} else {

			if (node.left == null && node.right == null) {

				if (ilc)
					parent.left = null;
				else
					parent.right = null;

			} else if (node.left == null && node.right != null) {

				if (ilc) {
					parent.left = node.right;
				} else
					parent.right = node.right;

			} else if (node.left != null && node.right == null) {
				if (ilc)
					parent.left = node.left;
				else
					parent.right = node.right;
			} else {
				
				int max = max(root.left);
				node.data = max;
				
				remove(node.left,node,true,max);
			}

		}

	}

}
