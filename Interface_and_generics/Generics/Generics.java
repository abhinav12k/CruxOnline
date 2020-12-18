package CruxOnline.Interface_and_generics.Generics;

import java.util.Comparator;

public class Generics {

	public static void main(String[] args) {

		Bikes[] bikes = new Bikes[5];
		bikes[0] = new Bikes(1000, 20000, "Black");
		bikes[1] = new Bikes(500, 25000, "White");
		bikes[2] = new Bikes(800, 18000, "Grey");
		bikes[3] = new Bikes(1200, 30000, "Blue");
		bikes[4] = new Bikes(300, 15000, "Brown");

		bubbleSort(bikes,new SpeedComparator());
//		bubbleSort(bikes);
		
		for (Bikes b : bikes) {
			System.out.println(b);
		}

		P<String, Integer> pClass = new P<>();
		pClass.key = "KEY";
		pClass.val = 100;

		System.out.println(pClass);

	}

	/*
	 * Making Bubble Sort Generic!
	 */

	private static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i].compareTo(arr[j]) > 0) {
					// swap
					T temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}

			}
		}

	}

	private static <T> void bubbleSort(T[] arr,Comparator<T> comp) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (comp.compare(arr[i],arr[j]) > 0) {
					// swap
					T temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}

			}
		}

	}
}
