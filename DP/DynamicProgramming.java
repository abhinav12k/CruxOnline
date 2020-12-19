package CruxOnline.DP;

public class DynamicProgramming {

	private static long startTime;
	private static long endTime;

	public static void startTimer() {
		startTime = System.currentTimeMillis();
	}

	public static long getEsclapedTime() {
		endTime = System.currentTimeMillis();
		return (endTime - startTime);
	}

	public static void main(String[] args) {

		/**
		 * In general iterative or bottom up approach is better than the top down
		 * approach because in recursion, every call makes it's respective variables
		 * which means that their is somewhat more space consumption in top down
		 * approach
		 */

//		startTimer();
//		System.out.println(fibonacci(45));
//		System.out.println("Recursive Fibonacci Solution Time: " + getEsclapedTime() + " millisec");
//
//		startTimer();
//		System.out.println(fibonacciTD(45, new int[46]));
//		System.out.println("Top Down Fibonacci Solution Time: " + getEsclapedTime() + " millisec");
//
//		startTimer();
//		System.out.println(fibonacciBU(45));
//		System.out.println("Iterative Solution Fibonacci Solution Time: " + getEsclapedTime() + " millisec");

//		startTimer();
//		System.out.println(countBoardPath(0, 30));
//		System.out.println("Recursive Solution Count Board Path Time: " + getEsclapedTime() + " millisec");
//
//		startTimer();
//		System.out.println(countBoardPathTD(0, 30, new int[30 + 1]));
//		System.out.println("Top Down Solution Count Board Path Time: " + getEsclapedTime() + " millisec");
//
//		startTimer();
//		System.out.println(countBoardPathBU(0, 30));
//		System.out.println("Bottom Up Solution Count Board Path Time: " + getEsclapedTime() + " millisec");

//		String s1 = "abbgbdsjcbhas";
//		String s2 = "acbgsdncjslsdmcl";
//
//		startTimer();
//		System.out.println(LCS(s1, s2));
//		System.out.println("Bottom Up Solution Count Board Path Time: " + getEsclapedTime() + " millisec");
//
//		startTimer();
//		System.out.println(LCSTD(s1, s2, new int[s1.length() + 1][s2.length() + 1]));
//		System.out.println("Bottom Up Solution Count Board Path Time: " + getEsclapedTime() + " millisec");
//
//		startTimer();
//		System.out.println(LCSBU(s1, s2));
//		System.out.println("Bottom Up Solution Count Board Path Time: " + getEsclapedTime() + " millisec");

		String s1 = "agbgkjsdjcsdcbd";
		String s2 = "acgbvnkdsvsdncj";
		startTimer();
		System.out.println(EditDistance(s1, s2));
		System.out.println("Bottom Up Solution Count Board Path Time: " + getEsclapedTime() + " millisec");

		startTimer();
		System.out.println(EditDistanceTD(s1, s2, new int[s1.length() + 1][s2.length() + 1]));
		System.out.println("Bottom Up Solution Count Board Path Time: " + getEsclapedTime() + " millisec");

		startTimer();
		System.out.println(EditDistanceBU(s1, s2));
		System.out.println("Bottom Up Solution Count Board Path Time: " + getEsclapedTime() + " millisec");
	}

	public static int fibonacci(int n) {

		if (n <= 1) {
			return n;
		}

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);
		int fn = fnm1 + fnm2;
		return fn;
	}

	public static int fibonacciTD(int n, int[] strg) {

		if (n <= 1)
			return n;

		if (strg[n] != 0)
			return strg[n];

		int fnm1 = fibonacciTD(n - 1, strg);
		int fnm2 = fibonacciTD(n - 2, strg);
		int fn = fnm1 + fnm2;
		strg[n] = fn;

		return fn;
	}

	// Bottom up approach or Iterative approach
	public static int fibonacciBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}
		return strg[n];
	}

	public static int countBoardPath(int curr, int end) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += countBoardPath(curr + dice, end);
		}
		return count;
	}

	public static int countBoardPathTD(int curr, int end, int[] strg) {

		if (curr == end)
			return 1;

		if (curr > end)
			return 0;

		if (strg[curr] != 0)
			return strg[curr];

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += countBoardPathTD(curr + dice, end, strg);
			strg[curr] = count;
		}

		return count;
	}

	public static int countBoardPathBU(int curr, int end) {

		int[] strg = new int[end + 1];

		// fixing the end values
		// There is one way to reach the end if we are on the same number i.e
		strg[end] = 1;

		for (int i = end - 1; i >= 0; i--) {
			for (int dice = 1; dice <= 6 && ((i + dice) <= end); dice++) {
				strg[i] += strg[i + dice];
			}
		}

		return strg[0];
	}

	// Longest common subsequence
	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0)
			return 0;

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = 1 + LCS(ros1, ros2);
		} else {

			int fr = LCS(ros1, s2);
			int sr = LCS(s1, ros2);
			ans += Math.max(fr, sr);
		}

		return ans;
	}

	public static int LCSTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0 || s2.length() == 0)
			return 0;

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (strg[s1.length()][s2.length()] != 0) {
			return strg[s1.length()][s2.length()];
		}

		int ans = 0;

		if (ch1 == ch2) {
			ans = 1 + LCSTD(ros1, ros2, strg);
		} else {

			int fr = LCS(ros1, s2);
			int sr = LCS(s1, ros2);

			ans += Math.max(fr, sr);
		}
		strg[s1.length()][s2.length()] = ans;

		return ans;
	}

	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col >= 0; col--) {
				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = 1 + strg[row + 1][col + 1];
				} else {
					strg[row][col] = Math.max(strg[row + 1][col], strg[row][col + 1]);
				}
			}
		}

		return strg[0][0];
	}

	/**
	 * Edit Distance Problem Least steps required to change string s1 to string s2
	 * or vice versa. Operations Allowed: Add/Remove/Replace
	 */
	public static int EditDistance(String s1, String s2) {

		if (s1.length() == 0)
			return s2.length();

		if (s2.length() == 0)
			return s1.length();

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {
			int removeResult = 1 + EditDistance(s1, ros2);
			int replaceResult = 1 + EditDistance(ros1, ros2);
			int addResult = 1 + EditDistance(ros1, s2);
			ans = Math.min(addResult, Math.min(removeResult, replaceResult));
		}
		return ans;
	}

	public static int EditDistanceTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0)
			return s2.length();

		if (s2.length() == 0)
			return s1.length();

		if (strg[s1.length()][s2.length()] != 0)
			return strg[s1.length()][s2.length()];

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {
			int removeResult = 1 + EditDistance(s1, ros2);
			int replaceResult = 1 + EditDistance(ros1, ros2);
			int addResult = 1 + EditDistance(ros1, s2);
			ans = Math.min(addResult, Math.min(removeResult, replaceResult));
		}
		strg[s1.length()][s2.length()] = ans;

		return ans;

	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		strg[s1.length()][s2.length()] = 0;

		for (int row = s2.length(); row >= 0; row--) {
			for (int col = s1.length(); col >= 0; col--) {
				if (row == s2.length()) {
					strg[row][col] = s1.length() - col;
					continue;
				}

				if (col == s1.length()) {
					strg[row][col] = s2.length() - row;
					continue;
				}

				if (s1.charAt(col) == s2.charAt(row)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {
					strg[row][col] = 1
							+ Math.min(strg[row + 1][col + 1], Math.min(strg[row + 1][col], strg[row][col + 1]));
				}

			}
		}

		return strg[0][0];
	}

}
