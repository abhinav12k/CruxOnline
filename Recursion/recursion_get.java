package CruxOnline.Recursion;

import java.util.ArrayList;

public class recursion_get {

	public static void main(String[] args) {

		String testString = "abc";
		System.out.println(getSubSequences(testString));
		System.out.println(getSubSequencesASCII("ab"));
		System.out.println(getPermutation(testString));
		System.out.println(getBoardPath(0, 10));
		// 3X3 Matrix
		System.out.println(getMazePath(0, 0, 2, 2));
		System.out.println(getMazePathDiagonal(0, 0, 2, 2));
	}

	public static ArrayList<String> getSubSequences(String str) {

		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<String>();
			baseResult.add("");
			return baseResult;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recurResult = getSubSequences(ros);

		for (String str1 : recurResult) {
			myResult.add(str1);
			myResult.add(cc + str1);
		}

		return myResult;
	}

	public static ArrayList<String> getSubSequencesASCII(String str) {

		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList();
			baseResult.add("");
			return baseResult;
		}

		char cc = str.charAt(0);
		int ccASCII = cc;
		String ros = str.substring(1);

		ArrayList<String> recurResult = getSubSequencesASCII(ros);
		ArrayList<String> myResult = new ArrayList();

		for (String st : recurResult) {

			myResult.add(st);
			myResult.add(cc + st);
			myResult.add(ccASCII + st);

		}

		return myResult;
	}

	public static ArrayList<String> getPermutation(String str) {

		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList();
			baseResult.add("");
			return baseResult;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> myResult = new ArrayList();
		ArrayList<String> recurResult = getPermutation(ros);

		for (String st : recurResult) {

			for (int i = 0; i <= st.length(); i++) {
				// Adding the given element to all the possible positions in the string
				myResult.add(st.substring(0, i) + cc + st.substring(i));
			}

		}

		return myResult;
	}

	public static ArrayList<String> getBoardPath(int start, int end) {

		if (start == end) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}

		if (start > end) {
			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;
		}

		ArrayList<String> myResult = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {

			ArrayList<String> recurResult = getBoardPath(start + dice, end);

			for (String st : recurResult) {

				myResult.add(dice + st);

			}

		}
		return myResult;
	}

	public static ArrayList<String> getMazePath(int cr, int cc, int fr, int fc) {

		if (cr == fr && cc == fc) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}

		if (cr > fr || cc > fc) {
			return new ArrayList<String>();
		}

		ArrayList<String> myResult = new ArrayList<>();

		// Move horizontally
		ArrayList<String> recurResultHorizontal = getMazePath(cr, cc + 1, fr, fc);

		for (String str : recurResultHorizontal) {
			myResult.add("H" + str);
		}

		// Move vertically
		ArrayList<String> recurResultVertical = getMazePath(cr + 1, cc, fr, fc);

		for (String str : recurResultVertical) {
			myResult.add("V" + str);
		}

		return myResult;
	}

	public static ArrayList<String> getMazePathDiagonal(int cr, int cc, int fr, int fc) {

		if (cr == fr && cc == fc) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}

		if (cr > fr || cc > fc) {
			return new ArrayList<String>();
		}

		ArrayList<String> myResult = new ArrayList<>();

		// Move horizontally
		ArrayList<String> recurResultHorizontal = getMazePathDiagonal(cr, cc + 1, fr, fc);

		for (String str : recurResultHorizontal) {
			myResult.add("H" + str);
		}

		// Move vertically
		ArrayList<String> recurResultVertical = getMazePathDiagonal(cr + 1, cc, fr, fc);

		for (String str : recurResultVertical) {
			myResult.add("V" + str);
		}

		// Move Diagonally
		ArrayList<String> recurResultDiagonal = getMazePathDiagonal(cr + 1, cc + 1, fr, fc);
		for (String str : recurResultDiagonal) {
			myResult.add("D" + str);
		}

		return myResult;
	}

}
