package CruxOnline.Dynamic_Stack_and_Queue;

//Stack using queue push efficient
public class SUQPushEfficient {

	private DynamicQueue primary;
	private DynamicQueue secondary;

	public SUQPushEfficient() {
		this.primary = new DynamicQueue();
		this.secondary = new DynamicQueue();
	}

	public int size() {
		return this.primary.size();
	}

	public boolean isEmpty() {
		return this.primary.size() == 0;
	}

	public void push(int data) throws Exception {
		this.primary.enqueue(data);
	}

	public int pop() throws Exception {
		while (this.primary.size() != 1) {
			this.secondary.enqueue(this.primary.dequeue());
		}
		int rv = this.primary.dequeue();

		while (!this.secondary.isEmpty()) {
			this.primary.enqueue(this.secondary.dequeue());
		}

		return rv;
	}

	public int top() throws Exception {
		while (this.primary.size() != 1) {
			this.secondary.enqueue(this.primary.dequeue());
		}

		int rv = this.primary.dequeue();
		this.secondary.enqueue(rv);

		while (!this.secondary.isEmpty()) {
			this.primary.enqueue(this.secondary.dequeue());
		}

		return rv;
	}

	private void reverseQueue(DynamicQueue queue) throws Exception {

		if (queue.isEmpty()) {
			return;
		}

		int element = queue.dequeue();
		reverseQueue(queue);
		queue.enqueue(element);
	}

	public void display() throws Exception {
		reverseQueue(this.primary);
		this.primary.display();
		reverseQueue(this.primary);
	}

}
