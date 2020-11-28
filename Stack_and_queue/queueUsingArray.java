package CruxOnline.Stack_and_queue;

public class queueUsingArray {

	protected int[] arr;
	protected int front;
	protected int size;

	private static final int DEFAULT_LENGTH = 5;

	public queueUsingArray() {

		this.arr = new int[this.DEFAULT_LENGTH];
		this.front = 0;
		this.size = 0;

	}

	public queueUsingArray(int capacity) {

		this.arr = new int[capacity];
		this.front = 0;
		this.size = 0;

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void enqueue(int data) throws Exception {

		if (this.front == this.arr.length) {
			throw new Exception("Queue is Full");
		}

		int ai = (this.front + this.size) % this.arr.length;
		this.arr[ai] = data;
		this.size++;

	}

	public int dequeue() throws Exception {

		if (isEmpty()) {
			throw new Exception("Queue is Empty");
		}

		int frontElement = this.arr[front];
		this.arr[this.front] = 0;
		this.front = (this.front + 1) % this.arr.length;
		this.size--;
		return frontElement;

	}

	public int getFront() throws Exception {

		if (isEmpty()) {
			throw new Exception("Queue is Empty");
		}

		int frontElement = this.arr[front];
		return frontElement;

	}
	
	public void display() throws Exception {
		
		if(isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		
		for(int i=0;i<this.size;i++) {
			System.out.print(this.arr[(i+this.front)%this.arr.length]+", ");
		}
		System.out.println("End");
	}
	
}
