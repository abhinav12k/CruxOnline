package CruxOnline.Sorting;

public class sorting {

	public static void main(String[] args) {

		int[] arr = new int[] { 50,60,-5,40,45};
//		int[] sortedArray = mergeSort(arr, 0, arr.length - 1);
//		for (int n : sortedArray) {
//			System.out.println(n); 
//		}

//		quickSort(arr, 0, arr.length - 1);

//		bubbleSort(arr);
//		insertionSort(arr);
		binaryInsertionSort(arr);
//		selectionSort(arr);
		for (int n : arr) {
			System.out.println(n);
		}

	}

	private static void bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] > arr[j]) {

					// swap
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

				}

			}

		}

	}

	private static void insertionSort(int[] arr) {

		for (int counter = 1; counter <= arr.length - 1; counter++) {

			int val = arr[counter];

			int j = counter - 1;

			while (j >= 0 && arr[j] > val) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = val;
		}

	}

	private static void binaryInsertionSort(int[] arr) {

		for (int counter = 1; counter < arr.length; counter++) {

			int val = arr[counter];

			//O(logn)
			int updateIdx = getIndex(arr,counter-1, val);
			
			int shiftAmount = counter - updateIdx;
			int j = counter;
			while(shiftAmount>0) {
				arr[j] = arr[j-1];
				j--;
				shiftAmount--;
			}
			arr[updateIdx] = val;
		}

	}

	//Using binary search to get index
	private static int getIndex(int[] arr,int sIdx, int val) {
		
		int lo = 0;
		int hi = sIdx;

		while (lo <= hi) {
			int mid = lo - (lo - hi) / 2;

			if (arr[mid] == val) {
				return mid;
			} else if (arr[mid] > val) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}

		return lo;
	}

	private static void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {

			int minIdx = i;

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[j] < arr[minIdx])
					minIdx = j;

			}

			// swap
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;

		}

	}

	private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {

		int[] mergedArray = new int[arr1.length + arr2.length];

		int i = 0, j = 0, k = 0;

		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] <= arr2[j]) {
				mergedArray[k] = arr1[i];
				i++;
				k++;
			} else {
				mergedArray[k] = arr2[j];
				j++;
				k++;
			}

		}

		if (i == arr1.length) {
			while (j < arr2.length) {
				mergedArray[k] = arr2[j];
				j++;
				k++;
			}
		}

		if (j == arr2.length) {
			while (i < arr1.length) {
				mergedArray[k] = arr1[i];
				i++;
				k++;
			}
		}
		return mergedArray;

	}

	private static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] baseArray = new int[1];
			baseArray[0] = arr[lo];
			return baseArray;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);

		return mergeSortedArrays(fh, sh);
	}

	private static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		int left = lo;
		int right = hi;

		while (left <= right) {

			while (arr[left] < pivot)
				left++;

			while (arr[right] > pivot)
				right--;

			if (left <= right) {

				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

		}

		quickSort(arr, lo, right);
		quickSort(arr, left, hi);

	}

}
