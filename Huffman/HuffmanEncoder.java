package CruxOnline.Huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanEncoder {

	HashMap<Character, String> encoder;
	HashMap<String, Character> decoder;

	public HuffmanEncoder(String feeder) {

		// 1. Prepare a frequency map
		HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();

		for (int i = 0; i < feeder.length(); i++) {

			char cc = feeder.charAt(i);

			if (freqMap.containsKey(cc)) {
				int val = freqMap.get(cc);
				val = val + 1;
				freqMap.put(cc, val);
			} else {
				freqMap.put(cc, 1);
			}

		}

		// 2. Prepare a minHeap of freqMap
		Heap<Node> minHeap = new Heap<>();
		Set<Map.Entry<Character, Integer>> entries = freqMap.entrySet();

		for (Map.Entry<Character, Integer> entry : entries) {
			Node nn = new Node(entry.getKey(), entry.getValue());
			minHeap.add(nn);
		}

		// 3. Make the heap empty until there is only one element left which is the tree
		while (minHeap.size() != 1) {
			Node n1 = minHeap.remove();
			Node n2 = minHeap.remove();

			Node combined = new Node(n1,n2);
			combined.data = '-';
			combined.cost = n1.cost + n2.cost;

			minHeap.add(combined);
		}

		Node finalTree = minHeap.remove();

		encoder = new HashMap<Character, String>();
		decoder = new HashMap<String, Character>();
		initEncoderDecoder(finalTree, "");

	}

	private void initEncoderDecoder(Node parent, String osf) {

		if (parent == null) {
			return;
		}
		
		if (parent.left == null && parent.right == null) {
			encoder.put(parent.data, osf);
			decoder.put(osf, parent.data);
			return;
		}

		initEncoderDecoder(parent.left, osf + "0");
		initEncoderDecoder(parent.right, osf + "1");

	}

	public String encode(String source) {

		String rv = "";

		for (int i = 0; i < source.length(); i++) {
			String code = this.encoder.get(source.charAt(i));
			rv = rv + code;
		}
		return rv;
	}

	public String decode(String codedString) {

		String rv = "";
		String key = "";

		for (int i = 0; i < codedString.length(); i++) {
			key += codedString.charAt(i);
			if (this.decoder.containsKey(key)) {
				rv = rv + this.decoder.get(key);
				key = "";
			}
		}

		return rv;
	}

	private class Node implements Comparable<Node> {

		char data;
		int cost;
		Node left;
		Node right;

		private Node(char data, int cost) {
			this.data = data;
			this.cost = cost;
			this.left = null;
			this.right = null;
		}

		private Node(Node left, Node right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node o) {
			// To make sure that min value leaves the heap first
			return o.cost - this.cost;
		}

		@Override
		public String toString() {
			return "Char: " + data + ", cost: " + cost + "\n";
		}
	}

}
