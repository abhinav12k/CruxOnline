package CruxOnline.BinaryTree;

public class BinaryTreeClient {

	public static void main(String[] args) {
		
		//50 true 25 true 38 false false true 48 true 18 false false false true 45 true 35 false false true 60 false false
		BinaryTree bt = new BinaryTree();
//		bt.display();

		bt.preOrder();
		System.out.println("*************************************");
		bt.postOrder();
		System.out.println("*************************************");
		bt.inOrder();
		System.out.println("*************************************");
		
		System.out.println(bt.height());
		
	}
	
}
