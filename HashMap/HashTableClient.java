package CruxOnline.HashMap;

public class HashTableClient {

	public static void main(String[] args) throws Exception {
		
		HashTable<String, Integer> map = new HashTable();
		map.put("A", 1);
		map.put("B",2);
		map.put("C", 3);
		map.put("D", 4);
		map.put("E", 5);
		map.put("F", 6);
		
		map.display();
		System.out.println("**********************************");
		map.put("A", 100);
		map.display();
	}
	
}
