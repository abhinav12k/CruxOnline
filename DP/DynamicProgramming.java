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

		startTimer();
		System.out.println(countBoardPath(0, 30));
		System.out.println("Recursive Solution Count Board Path Time: " + getEsclapedTime() + " millisec");

		startTimer();
		System.out.println(countBoardPathTD(0, 30, new int[30 + 1]));
		System.out.println("Top Down Solution Count Board Path Time: " + getEsclapedTime() + " millisec");

		startTimer();
		System.out.println(countBoardPathBU(0, 30));
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

}
