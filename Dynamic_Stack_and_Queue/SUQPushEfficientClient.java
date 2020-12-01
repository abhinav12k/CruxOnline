package CruxOnline.Dynamic_Stack_and_Queue;

public class SUQPushEfficientClient {
	
	public static void main(String[] args) throws Exception {
		
		SUQPushEfficient stack = new SUQPushEfficient();
		for(int i=1;i<=6;i++) {
			stack.push(i*10);
		}
		stack.display();
		
		System.out.println(stack.pop());
		stack.display();
		
		System.out.println(stack.top());
	}
	
}
