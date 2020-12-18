package CruxOnline.Dynamic_Stack_and_Queue;

public class SUQPopEfficientClient {
	
	public static void main(String[] args) throws Exception {
		
		SUQPopEfficient stack = new SUQPopEfficient();
		for(int i=1;i<=6;i++) {
			stack.push(i*10);
		}
		stack.display();
		
		System.out.println(stack.pop());
		stack.display();
		
		System.out.println(stack.top());
		
	}
}
