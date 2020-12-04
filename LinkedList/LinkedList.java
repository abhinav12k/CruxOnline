package CruxOnline.LinkedList;

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int getSize() {
		return this.size;
	}
	
	public void display() {
		Node temp = this.head;
		System.out.println("**********************************************");
		while (temp != null) {
			System.out.print(temp.data + "=>");
			temp = temp.next;
		}
		System.out.println("End");
	}

	public void addLast(int item) {

		// create new Node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size >= 1) {
			this.tail.next = nn;
		}

		// Summary Object
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}

	}

	public void addFirst(int item) {

		// Create a node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size >= 1) {
			nn.next = this.head;
		}

		// summary Object
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}

	}

	public int getFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("LinkedList is Empty");
		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0)
			throw new Exception("LinkedList is Empty");
		return this.tail.data;
	}

	public void addAt(int item, int idx) throws Exception {

		if (idx < 0 || idx > this.size) {
			throw new Exception("Index out of Range!");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		} else {

			// create a node
			Node nn = new Node();
			nn.data = item;

			// attach
			Node prevNode = getNodeAt(idx - 1);
			Node aheadNode = prevNode.next;
			prevNode.next = nn;
			nn.next = aheadNode;

			// summary object
			this.size++;
		}

	}

	public int getAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of Range!");
		}

		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	private Node getNodeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of Range!");
		}

		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public int removeFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("LinkedList is Empty");
		int rv = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.head = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return rv;
	}

	public int removeLast() throws Exception {
		if (this.size == 0)
			throw new Exception("LinkedList is Empty");

		int rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			Node prevNode = getNodeAt(this.size - 2);
			this.tail = prevNode;
			this.tail.next = null;
			this.size--;
		}

		return rv;
	}

	public int removeAt(int idx) throws Exception {

		if (this.size == 0)
			throw new Exception("LinkedList is Empty");

		if(idx<0||idx>=this.size) {
			throw new Exception("Invalid Index!");
		}
		
		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {

			Node prevNode = getNodeAt(idx - 1);
			Node removedNode = prevNode.next;
			int rv = removedNode.data;
			Node aheadNode = removedNode.next;

			prevNode.next = aheadNode;
			this.size--;
			return rv;
		}

	}
}
