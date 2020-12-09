package CruxOnline.BST;

public class BSTClient {

	public static void main(String[] args) {
		
		int[] in = new int[] {10,20,30,40,50,60,70};
		
		BST bst = new BST(in);
		bst.display();
		
		System.out.println(bst.find(30));
		System.out.println(bst.find(100));
		
		System.out.println(bst.max());
		
		bst.add(55);
		bst.display();
		
		bst.remove(55);
		bst.display();
		
	}
	
}
