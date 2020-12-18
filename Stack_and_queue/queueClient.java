package CruxOnline.Stack_and_queue;

public class queueClient {

	public static void main(String[] args) throws Exception {

		queueUsingArray queue = new queueUsingArray();

		for (int i = 1; i <= 5; i++) {
			queue.enqueue(10*i);
			queue.display();
		}
		
		System.out.println(queue.dequeue());
		queue.display();

		System.out.println(queue.dequeue());
		queue.display();
		
		System.out.println(queue.getFront());
		
		reverseQueue();
		
	}

	private static void reverseQueue() {
		// TODO Auto-generated method stub
		
	}

}
