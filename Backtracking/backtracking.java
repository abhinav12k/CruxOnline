package CruxOnline.Backtracking;

public class backtracking {

	static int count = 0;

	public static void main(String[] args) {

		boolean[] boxes = new boolean[4];
//		queenPermutation(boxes, 0, 2, "");
//		queenCombination(boxes, 0, 2, "", -1);

		int[] denom = new int[] { 2, 3, 5, 6 };
		int amount = 10;
		choinChangeCombination(denom, amount, "", 0);
//		choinChangePermutation(denom, amount, "");
	}

	private static void queenPermutation(boolean[] boxes, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		for (int box = 0; box < boxes.length; box++) {
			if (boxes[box] == false) {
				boxes[box] = true;
				queenPermutation(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + box + " ");
				boxes[box] = false; // undo
			}
		}

	}

	private static void queenCombination(boolean[] boxes, int qpsf, int tq, String ans, int lastBoxUsed) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		for (int box = lastBoxUsed + 1; box < boxes.length; box++) {
			if (boxes[box] == false) {
				boxes[box] = true;
				queenCombination(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + box + " ", box);
				boxes[box] = false; // undo
			}
		}

	}

	private static void choinChangeCombination(int[] denom, int amount, String ans, int lastCoinIdx) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = lastCoinIdx; i < denom.length; i++) {

			if (amount >= denom[i])
				choinChangeCombination(denom, amount - denom[i], ans + denom[i], i);

		}

	}

	private static void choinChangePermutation(int[] denom, int amount, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < denom.length; i++) {

			if (amount >= denom[i])
				choinChangePermutation(denom, amount - denom[i], ans + denom[i]);

		}

	}

}
