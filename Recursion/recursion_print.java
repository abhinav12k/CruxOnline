package CruxOnline.Recursion;

public class recursion_print {

	public static void main(String[] args) {

		printSubSequences("abc", "");
		System.out.println("---------------------------------------------");
		printPermutation("abc", "");
		System.out.println("---------------------------------------------");
		printBoardPath(0, 10, "");
		System.out.println("---------------------------------------------");
		System.out.println(countBoardPath(0, 10));
		System.out.println("---------------------------------------------");
		printMazePath(0, 0, 2, 2, "");
		System.out.println("---------------------------------------------");
		System.out.println(countMazePath(0, 0, 2, 2));
		System.out.println("---------------------------------------------");
		printMazePathD(0, 0, 2, 2, "");
		System.out.println("---------------------------------------------");
		System.out.println(countMazePathD(0, 0, 2, 2));
		System.out.println("---------------------------------------------");
		boolean[][] board = new boolean[4][4];
		System.out.println(countNQueens(board, 0));
		System.out.println("---------------------------------------------");
		printNQueens(board, 0, "");

	}

	private static void printSubSequences(String ques, String result) {

		if (ques.length() == 0) {
			System.out.println(result);
			return;
		}

		char cc = ques.charAt(0);
		String roq = ques.substring(1);

		printSubSequences(roq, result);
		printSubSequences(roq, result + cc);
	}

	private static void printPermutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char cc = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			printPermutation(roq, ans + cc);
		}

		return;
	}

	private static void printBoardPath(int start, int end, String ans) {

		if (start == end) {
			System.out.println(ans);
			return;
		}

		if (start > end) {
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			printBoardPath(start + dice, end, ans + dice);
		}
	}

	private static int countBoardPath(int start, int end) {

		if (start == end) {
			return 1;
		}

		if (start > end) {
			return 0;
		}

		int cc = 0;
		for (int dice = 1; dice <= 6; dice++) {
			cc += countBoardPath(start + dice, end);
		}
		return cc;
	}

	private static void printMazePath(int cr, int cc, int fr, int fc, String ans) {

		if (cr == fr && cc == fc) {
			System.out.println(ans);
			return;
		}

		if (cr > fr || cc > fc) {
			return;
		}

		printMazePath(cr, cc + 1, fr, fc, ans + "H");
		printMazePath(cr + 1, cc, fr, fc, ans + "V");

	}

	private static int countMazePath(int cr, int cc, int fr, int fc) {

		if (cr == fr && cc == fc) {
			return 1;
		}

		if (cr > fr || cc > fc) {
			return 0;
		}

		int ch = countMazePath(cr, cc + 1, fr, fc);
		int cv = countMazePath(cr + 1, cc, fr, fc);

		return ch + cv;
	}

	private static void printMazePathD(int cr, int cc, int fr, int fc, String ans) {

		if (cr == fr && cc == fc) {
			System.out.println(ans);
			return;
		}

		if (cr > fr || cc > fc) {
			return;
		}

		printMazePathD(cr, cc + 1, fr, fc, ans + "H");
		printMazePathD(cr + 1, cc, fr, fc, ans + "V");
		printMazePathD(cr + 1, cc + 1, fr, fc, ans + "D");

	}

	private static int countMazePathD(int cr, int cc, int fr, int fc) {

		if (cr == fr && cc == fc) {
			return 1;
		}

		if (cr > fr || cc > fc) {
			return 0;
		}

		int ch = countMazePathD(cr, cc + 1, fr, fc);
		int cv = countMazePathD(cr + 1, cc, fr, fc);
		int cd = countMazePathD(cr + 1, cc + 1, fr, fc);

		return ch + cv + cd;
	}

	private static int countNQueens(boolean[][] board, int row) {

		if (row == board.length) {
			return 1;
		}

		int count = 0;
		for (int col = 0; col < board[row].length; col++) {

			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				count += countNQueens(board, row + 1);
				board[row][col] = false;
			}

		}

		return count;
	}

	private static boolean isItSafe(boolean[][] board, int row, int col) {

		// checking in same column
		for (int cr = row; cr >= 0; cr--) {
			if (board[cr][col])
				return false;
		}

		// checking diagonally left
		for (int cr = row, cc = col; cr >= 0 && cc >= 0; cr--, cc--) {
			if (board[cr][cc])
				return false;
		}

		// checking diagonally right
		for (int cr = row, cc = col; cr >= 0 && cc < board[cr].length; cc++, cr--) {
			if (board[cr][cc])
				return false;
		}

		return true;
	}

	private static void printNQueens(boolean[][] board, int row, String ans) {

		if (row == board.length) {
			System.out.println(ans);
			return;
		}

		for (int col = 0; col < board[row].length; col++) {
			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				printNQueens(board, row + 1, ans + "{" + (row + 1) + "-" + (col + 1) + "}");
				board[row][col] = false;
			}
		}

	}
}
