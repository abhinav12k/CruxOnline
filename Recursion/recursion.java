package CruxOnline.Recursion;

public class recursion {

	public static void main(String[] args) {

//		PD(5);
//		PI(5);
//		PDI(5);
//		PDISkips(5);
//		System.out.println(factorial(5));
//		System.out.println(power(2,5));

		int[] arr = new int[] { 1, 8, 0, 6, 8, 2, 8, 4 };

		System.out.println(firstIndex(arr, 0, 6));
		System.out.println(lastIndex(arr, 0, 8));
		int[] array = allIndexs(arr, 0, 8, 0);

		for (int i : array) {
			System.out.print(i + " ");
		}

	}

	public static void PD(int n) {

		if (n == 0) {
			return;
		}

		System.out.println(n);
		PD(n - 1);
	}

	public static void PI(int n) {

		if (n == 0) {
			return;
		}

		PI(n - 1);
		System.out.println(n);

	}

	public static void PDI(int n) {

		if (n == 0)
			return;

		System.out.println(n);
		PDI(n - 1);
		System.out.println(n);
	}

	public static void PDISkips(int n) {

		if (n == 0)
			return;

		if (n % 2 == 1)
			System.out.println(n);
		PDISkips(n - 1);
		if (n % 2 == 0)
			System.out.println(n);
	}

	public static int factorial(int n) {

		if (n == 1)
			return n;

		return n * factorial(n - 1);

	}

	public static int power(int x, int i) {

		if (i == 0)
			return 1;

		return x * power(x, i - 1);

	}

	public static int firstIndex(int[] arr, int si, int target) {

		if (si == arr.length)
			return -1;

		if (arr[si] == target)
			return si;
		else
			return firstIndex(arr, si + 1, target);
	}

	public static int lastIndex(int[] arr, int si, int target) {

		if (si == arr.length)
			return -1;

		int idx = lastIndex(arr, si + 1, target);

		if (idx == -1) {

			if (arr[si] == target) {
				return si;
			} else
				return -1;
		} else
			return idx;
	}

	public static int[] allIndexs(int[] arr, int si, int target, int count) {

		if (si == arr.length)
			return new int[count];

		int[] idxs;
		if (arr[si] == target) {

			idxs = allIndexs(arr, si + 1, target, count + 1);

		} else {

			idxs = allIndexs(arr, si + 1, target, count);

		}

		if (arr[si] == target) {
			idxs[count] = si;
		}

		return idxs;
	}

}
