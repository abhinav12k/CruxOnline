package CruxOnline.Stack_and_queue;

public class stackUsingArray {

	protected int[] arr;
	protected int top;
	protected int size;

	public static final int DEFAULT_LENGTH = 5;

	public stackUsingArray() {

		this.arr = new int[stackUsingArray.DEFAULT_LENGTH];
		this.top = -1;

	}

	public stackUsingArray(int capacity) {
		this.arr = new int[capacity];
		this.top = -1;
	}

	public void push(int data) throws Exception {

		if (this.top == this.arr.length-1) {
			throw new Exception("Stack is full");
		}
		
		this.top++;
		this.arr[this.top] = data;
		this.size++;

	}

	public int pop() throws Exception {

		if (this.top == -1) {
			throw new Exception("Stack is Empty");
		}

		int topElement = this.arr[this.top];
		this.arr[top] = 0;
		this.top--;
		this.size--;
		return topElement;

	}

	public int peek() throws Exception {

		if (this.top == -1) {
			throw new Exception("Stack is Empty");
		}

		int topElement = this.arr[this.top];
		return topElement;
	}

	public void display() throws Exception {

		if (this.top == -1) {
			throw new Exception("Stack is Empty");
		}

		for (int idx = this.top; idx >= 0; idx--) {

			System.out.print(this.arr[idx] + ", ");

		}
		System.out.println("End");
	}

	public boolean isEmpty() {
		return this.top == -1;
	}
	
	public int size() {
		return this.size;
	}
}
