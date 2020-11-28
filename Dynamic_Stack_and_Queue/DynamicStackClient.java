package CruxOnline.Dynamic_Stack_and_Queue;

public class DynamicStackClient {

	public static void main(String[] args) throws Exception {
		
		DynamicStack ds = new DynamicStack();
		
		for(int i=1;i<=10;i++) {
			ds.push(i*10);
			ds.display();
		}
		
		System.out.println(ds.pop());
		System.out.println(ds.peek());
		
	}
	
}
