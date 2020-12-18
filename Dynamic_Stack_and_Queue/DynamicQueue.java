package CruxOnline.Dynamic_Stack_and_Queue;

import CruxOnline.Stack_and_queue.queueUsingArray;

public class DynamicQueue extends queueUsingArray{

	public DynamicQueue() {
		super();
	}
	
	public DynamicQueue(int capacity) {
		super(capacity);
	}
	
	@Override
	public void enqueue(int data) throws Exception {
		
		if(this.size == this.arr.length) {
			
			int[] Narr = new int[2*this.arr.length];
			for(int i =0;i<this.arr.length;i++) {
				Narr[i] = this.arr[i];
			}
			this.arr = Narr;
			this.front = 0;
		}
		
		super.enqueue(data);
	}
	
}
