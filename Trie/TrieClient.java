package CruxOnline.Trie;

public class TrieClient {

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		trie.addWord("apple");
		trie.addWord("mango");
		trie.addWord("apples");
		trie.addWord("mangoes");
		trie.addWord("mapple");
		
//		trie.display();
//		System.out.println(trie.search("apples"));
//		System.out.println(trie.search("orange"));

		trie.remove("apple");
		trie.display();
		System.out.println("**********************************");

		trie.remove("apples");
		trie.display();
		System.out.println("**********************************");
		
	}
	
}
