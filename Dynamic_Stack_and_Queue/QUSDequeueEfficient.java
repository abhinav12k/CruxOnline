package CruxOnline.Dynamic_Stack_and_Queue;

public class QUSDequeueEfficient {

	private DynamicStack primary;
	private DynamicStack secondary;
	
	public QUSDequeueEfficient() {
		this.primary = new DynamicStack();
		this.secondary = new DynamicStack();
	}
	
	public int size() {
		return this.primary.size();
	}
	
	public boolean isEmpty() {
		return this.primary.isEmpty();
	}
	
	public void enqueue(int item) throws Exception {
		while(!this.primary.isEmpty()) {
			this.secondary.push(this.primary.pop());
		}
		this.primary.push(item);
		while(!this.secondary.isEmpty()) {
			this.primary.push(this.secondary.pop());
		}
	}
	
	public int dequeue() throws Exception {
		return this.primary.pop();
	}
	
	public int getFront() throws Exception {
		return this.primary.peek();
	}
	
	public void display() throws Exception {
		this.primary.display();
	}
}
