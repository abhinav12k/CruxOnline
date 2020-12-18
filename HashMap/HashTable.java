package CruxOnline.HashMap;

import CruxOnline.HashMap.Generics.LinkedList;

public class HashTable<K, V> {

	private class HTPair {
		K key;
		V value;

		private HTPair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			HTPair op = (HTPair) obj;
			return this.key.equals(op.key);
		}

		@Override
		public String toString() {
			return "{ " + this.key + "-" + this.value + " }";
		}

	}

	public static final int DEFAULT_CAPACITY = 5;

	private LinkedList<HTPair>[] bucketArray;
	private int size;

	public HashTable() {
		this(DEFAULT_CAPACITY);
	}

	public HashTable(int capacity) {
		bucketArray = (LinkedList<HTPair>[]) new LinkedList[capacity];
		this.size = 0;
	}

	public void put(K key, V value) throws Exception {
		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair pta = new HTPair(key, value);
		if (bucket == null) {
			bucket = new LinkedList<HTPair>();
			bucket.addLast(pta);
			this.bucketArray[bi] = bucket;
			this.size++;
		} else {
			int findAt = bucket.find(pta);
			if (findAt == -1) {
				bucket.addLast(pta);
				this.size++;
			} else {
				HTPair pair = bucket.getAt(findAt);
				pair.value = value;
			}
		}
		
		//For making hash table work as O(1)
		double lambda = (this.size * 1.0 )/this.bucketArray.length;
		if(lambda > 0.75) {
			rehash();
		}
	}

	private void rehash() throws Exception {
		LinkedList<HTPair>[] opa = this.bucketArray;
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[opa.length*2];
		this.size=0;
		
		for(LinkedList<HTPair> op:opa) {
			while(op!=null&&!op.isEmpty()) {
				HTPair pair = op.removeFirst();
				this.put(pair.key,pair.value);
			}
		}
		
	}
	
	private int hashFunction(K key) {
		int hc = key.hashCode();
		hc = Math.abs(hc);
		int bi = hc % this.bucketArray.length;
		return bi;
	}

	public void display() {
		for (LinkedList<HTPair> bucket : this.bucketArray) {
			if (bucket != null && !bucket.isEmpty()) {
				bucket.display();
			} else
				System.out.println("null");
		}
	}

	public V get(K key) throws Exception {
		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair ptf = new HTPair(key, null);

		if (bucket == null) {
			return null;
		} else {

			int findAt = bucket.find(ptf);
			if (findAt == -1) {
				return null;

			} else {
				HTPair pair = bucket.getAt(findAt);
				return pair.value;
			}

		}

	}

	public V remove(K key) throws Exception {

		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair ptf = new HTPair(key, null);

		if (bucket == null) {
			return null;
		} else {
			int findAt = bucket.find(ptf);
			if (findAt == -1) {
				return null;
			} else {
				HTPair p = bucket.getAt(findAt);
				bucket.removeAt(findAt);
				this.size--;
				return p.value;
			}
		}

	}

}
