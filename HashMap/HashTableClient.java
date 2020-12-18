package CruxOnline.HashMap;

public class HashTableClient {

	public static void main(String[] args) throws Exception {
		
		HashTable<String, Integer> map = new HashTable(4);
		map.put("A", 1);
		map.put("B",2);
		map.put("C", 3);
		map.display();
		System.out.println("**********************************");
		map.put("D", 4);
		map.put("E", 5);
		map.put("F", 6);
		map.put("G", 7);
		map.put("H", 8);
		map.put("I", 9);
		map.display();
		System.out.println("**********************************");
//		
////		map.display();
		System.out.println("**********************************");
//		map.put("A", 100);
//		map.display();
//		
//		System.out.println("***************GET*******************");
//		System.out.println(map.get("A"));
//		System.out.println(map.get("Z"));
//		
//		System.out.println("***************GET*******************");
//		System.out.println(map.remove("C"));
//		System.out.println(map.remove("G"));
//		
	}
	
}
