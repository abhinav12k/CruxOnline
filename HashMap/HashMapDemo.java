package CruxOnline.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {

		String str = "aaabaaccdda";
		System.out.println(getMaxChar(str));

		int[] one = { 5, 1, 4, 3, 7 };
		int[] two = { 2, 4, 3, 5, 7, 10, 15 };
		ArrayList<Integer> answer = getIntersection(one, two);
		System.out.println(answer);
	}

	private static char getMaxChar(String str) {

		HashMap<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (charMap.containsKey(str.charAt(i)))
				charMap.put(str.charAt(i), charMap.get(str.charAt(i)) + 1);
			else
				charMap.put(str.charAt(i), 1);
		}

		int max = 0;
		char maxChar = '\0';
		Set<Map.Entry<Character, Integer>> entries = charMap.entrySet();

		for (Map.Entry<Character, Integer> entry : entries) {

			if (entry.getValue() > max) {
				max = entry.getValue();
				maxChar = entry.getKey();
			}

		}
		return maxChar;
	}

	private static ArrayList<Integer> getIntersection(int[] one, int[] two) {

		HashMap<Integer, Boolean> traverseMap = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			traverseMap.put(one[i], false);
		}

		for (int i = 0; i < two.length; i++) {
			if (traverseMap.containsKey(two[i])) {
				traverseMap.put(two[i], true);
			}
		}

		Set<Map.Entry<Integer, Boolean>> entries = traverseMap.entrySet();
		ArrayList<Integer> answer = new ArrayList<>();
		for (Map.Entry<Integer, Boolean> entry : entries) {
			if (entry.getValue()) {
				answer.add(entry.getKey());
			}
		}
		return answer;
	}
}
