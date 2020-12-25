package CruxOnline.SegTree;

public class SegmentTree {

	public class Node {

		int data;
		int startInterval;
		int endInterval;
		Node left;
		Node right;

	}

	private Node root;

	public SegmentTree(int[] arr) {
		this.root = constructTree(arr, 0, arr.length - 1);
	}

	private Node constructTree(int[] arr, int si, int ei) {

		if (si == ei) {
			Node leafNode = new Node();
			leafNode.data = arr[si];
			leafNode.startInterval = si;
			leafNode.endInterval = ei;
			return leafNode;
		}

		Node node = new Node();
		node.startInterval = si;
		node.endInterval = ei;

		int mid = (si + ei) / 2;

		node.left = this.constructTree(arr, si, mid);
		node.right = this.constructTree(arr, mid + 1, ei);

		node.data = node.left.data + node.right.data;

		return node;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {

		if (node.left != null) {
			System.out.print("Interval = [" + node.left.startInterval + " - " + node.left.endInterval + " ] " + "Data: "
					+ node.left.data + "=> ");
		} else {
			System.out.print(" NoLeftNode =>");
		}
		System.out.print("Interval [" + node.startInterval + ":" + node.endInterval + " ] " + node.data);

		if (node.right == null) {
			System.out.println("<= NoRightNode");
		} else {
			System.out.println("<= " + "Data: " + node.right.data + " Interval = [" + node.right.startInterval + " - "
					+ node.right.endInterval + " ] ");
		}

		if (node.left != null)
			this.display(node.left);
		if (node.right != null)
			this.display(node.right);

	}

	public int query(int si, int ei) {
		return this.query(this.root, si, ei);
	}

	private int query(Node node, int qsi, int qei) {

		if (node.startInterval >= qsi && node.endInterval <= qei) {
			return node.data;
		} else if (node.startInterval > qei || node.endInterval < qsi) {
			// Out of the bounds provided
			return 0; // return default value
		} else {
			// Partially inside the range
			int leftAns = this.query(node.left, qsi, qei);
			int rightAns = this.query(node.right, qsi, qei);

			return leftAns + rightAns;
		}

	}

	public void update(int index, int value) {
		this.root.data = update(this.root, index, value);
	}

	private int update(Node node, int index, int value) {

		if (index >= node.startInterval && index <= node.endInterval) {

			if (index == node.startInterval && index == node.endInterval) {
				node.data = value;
			} else {
				int leftValue = update(node.left, index, value);
				int rightValue = update(node.right, index, value);
				node.data = leftValue + rightValue;
			}

		}
		return node.data;

	}

}
