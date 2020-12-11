package CruxOnline.HashMap.Generics;

import CruxOnline.HashMap.HashTable;

public class LinkedList<T> {

	private class Node {
		T data;
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
		while (temp != null) {
			System.out.print(temp.data + "=>");
			temp = temp.next;
		}
		System.out.println("End");
	}

	public void addLast(T item) {

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

	public void addFirst(T item) {

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

	public T getFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("LinkedList is Empty");
		return this.head.data;
	}

	public T getLast() throws Exception {
		if (this.size == 0)
			throw new Exception("LinkedList is Empty");
		return this.tail.data;
	}

	public void addAt(T item, int idx) throws Exception {

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

	public T getAt(int idx) throws Exception {

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

	public T removeFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("LinkedList is Empty");
		T rv = this.head.data;

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

	public T removeLast() throws Exception {
		if (this.size == 0)
			throw new Exception("LinkedList is Empty");

		T rv = this.tail.data;

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

	public T removeAt(int idx) throws Exception {

		if (this.size == 0)
			throw new Exception("LinkedList is Empty");

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index!");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {

			Node prevNode = getNodeAt(idx - 1);
			Node removedNode = prevNode.next;
			T rv = removedNode.data;
			Node aheadNode = removedNode.next;

			prevNode.next = aheadNode;
			this.size--;
			return rv;
		}

	}

	public int find(T item) {
		Node temp = this.head;
		int idx = 0;
		while (temp != null) {
			if (temp.data.equals(item))
				return idx;
			temp = temp.next;
			idx++;
		}
		return -1;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

}
