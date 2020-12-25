package CruxOnline.Heap;

import CruxOnline.Interface_and_generics.Generics.Bikes;

public class HeapGClient {

	public static void main(String[] args) {
		
		
		HeapGeneric<Bikes> minHeap = new HeapGeneric<>();
		
		Bikes[] bikes = new Bikes[5];
		bikes[0] = new Bikes(1000, 20000, "Black");
		bikes[1] = new Bikes(500, 25000, "White");
		bikes[2] = new Bikes(800, 18000, "Grey");
		bikes[3] = new Bikes(1200, 30000, "Blue");
		bikes[4] = new Bikes(300, 15000, "Brown");
		
		minHeap.add(bikes[0]);
		minHeap.add(bikes[1]);
		minHeap.add(bikes[2]);
		minHeap.add(bikes[3]);
		minHeap.add(bikes[4]);
		
//		minHeap.display();
		
		while(!minHeap.isEmpty()) {
			System.out.println(minHeap.remove());
		}
		
	}
	
}
