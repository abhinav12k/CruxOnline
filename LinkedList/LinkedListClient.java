package CruxOnline.LinkedList;

public class LinkedListClient {

	public static void main(String[] args) throws Exception {

		LinkedList ll = new LinkedList();
		for (int i = 1; i <= 10; i++) {
			ll.addLast(10*i);
//			ll.addFirst(2*i);
		}
		ll.display();
		System.out.println(ll.getFirst());
		
		ll.addAt(100, 2);
		ll.display();
//		System.out.println(ll.getAt(2));
		ll.addAt(10, 10);
		ll.display();
		
		System.out.println(ll.getLast());
		
		System.out.println(ll.getSize());
		ll.addAt(500, 12);
		ll.display();
		System.out.println(ll.removeFirst());
		ll.display();
		System.out.println(ll.removeLast());
		ll.display();
		System.out.println(ll.removeAt(5));
		ll.display();
		System.out.println(ll.mid());
		
		ll.reverseLLData();
		ll.display();
		ll.reverseLLPointer();
		ll.display();
	}

}
