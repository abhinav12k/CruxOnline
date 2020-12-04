package CruxOnline.Dynamic_Stack_and_Queue;

public class QUSEnqueueEfficientClient {

	public static void main(String[] args) throws Exception {
		
		QUSEnqueueEfficient queue = new QUSEnqueueEfficient();
		
		for(int i=1;i<6;i++) {
			queue.enqueue(i*10);
		}
		
		queue.display();
		
		System.out.println(queue.dequeue());
		queue.display();
		
		System.out.println(queue.getFront());
	}
	
}
