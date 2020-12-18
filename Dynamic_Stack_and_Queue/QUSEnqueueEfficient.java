package CruxOnline.Dynamic_Stack_and_Queue;

public class QUSEnqueueEfficient {

	private DynamicStack primary;
	private DynamicStack secondary;

	public QUSEnqueueEfficient() {
		primary = new DynamicStack();
		secondary = new DynamicStack();
	}

	public int size() {
		return this.primary.size();
	}

	public void enqueue(int data) throws Exception {
		this.primary.push(data);
	}

	public int dequeue() throws Exception {
		while (this.primary.size() != 1) {
			this.secondary.push(this.primary.pop());
		}
		int rv = this.primary.pop();
		while (!this.secondary.isEmpty()) {
			this.primary.push(this.secondary.pop());
		}
		return rv;
	}

	public int getFront() throws Exception {
		while (this.primary.size() != 1) {
			this.secondary.push(this.primary.pop());
		}
		int rv = this.primary.peek();
		while (!this.secondary.isEmpty()) {
			this.primary.push(this.secondary.pop());
		}
		return rv;
	}

	public void display() throws Exception {

		reverseStack(this.primary, this.secondary, 0);
		this.primary.display();
		reverseStack(this.primary, this.secondary, 0);
	}

	private void reverseStack(DynamicStack stack, DynamicStack helper, int idx) throws Exception {

		while (stack.isEmpty()) {
			return;
		}

		int item = stack.pop();
		reverseStack(stack, helper, idx + 1);
		helper.push(item);

		while (idx == 0 && !helper.isEmpty()) {
			stack.push(helper.pop());
		}
	}

}
