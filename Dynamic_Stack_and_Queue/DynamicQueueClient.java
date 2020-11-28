package CruxOnline.Dynamic_Stack_and_Queue;

public class DynamicQueueClient {

	public static void main(String[] args) throws Exception {
		
		DynamicQueue dq = new DynamicQueue();
		
		for(int i=1;i<=10;i++) {
			dq.enqueue(i*10);
			dq.display();
		}
		
		System.out.println(dq.dequeue());
		System.out.println(dq.getFront());
		
	}
	
}
