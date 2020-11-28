package CruxOnline.Dynamic_Stack_and_Queue;

import CruxOnline.Stack_and_queue.stackUsingArray;

public class DynamicStack extends stackUsingArray {

	public DynamicStack() {
		this(DEFAULT_LENGTH);
	}

	public DynamicStack(int capacity) {
		super(capacity);
	}

	@Override
	public void push(int data) throws Exception {

		if (this.size == arr.length) {
			int[] Narr = new int[2 * arr.length];
			for (int i = 0; i < arr.length; i++) {
				Narr[i] = this.arr[i];
			}
			this.arr = Narr;
		}

		super.push(data);
	}

}
