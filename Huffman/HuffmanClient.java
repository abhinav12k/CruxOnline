package CruxOnline.Huffman;

public class HuffmanClient {

	public static void main(String[] args) {

		String str = "abbccda";
		HuffmanEncoder hf = new HuffmanEncoder(str);
		String encodedString = hf.encode(str);
		System.out.println(encodedString);
		String decodedString = hf.decode(encodedString);
		System.out.println(decodedString);
		
		System.out.println("*****************");
		System.out.println(hf.encoder);
	}

}
