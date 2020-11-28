package CruxOnline.Stack_and_queue;

public class stackClient {

	public static void main(String[] args) throws Exception {

		stackUsingArray stack = new stackUsingArray();
//		stackUsingArray stack = new stackUsingArray(6);

		System.out.println("Pushing elements on to the stack");
		for (int i = 1; i <= 5; i++) {
			stack.push(10 * i);
//			stack.display();
		}

//		stack.push(60);
		stack.display();
//		System.out.println(stack.peek());
//		System.out.println("Popping Elements from stack");
//		for (int i = 1; i < 5; i++) {
//			stack.pop();
//			System.out.println(stack.peek());
//			stack.display();
//		}

		stackUsingArray helper = new stackUsingArray();

		reverseStack(stack, helper, 0);
		stack.display();

	}

	private static void reverseStack(stackUsingArray stack, stackUsingArray helper, int index) throws Exception {

		if (stack.isEmpty()) {
			return;
		}

		int item = stack.pop();
		reverseStack(stack, helper, index + 1);
		helper.push(item);

		while (index == 0 && !helper.isEmpty()) {
			stack.push(helper.pop());
		}

	}

}
