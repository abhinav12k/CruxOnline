package CruxOnline.Huffman;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

	ArrayList<T> data;

	public Heap() {
		this.data = new ArrayList<T>();
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public void add(T item) {

		data.add(item);
		int ci = data.size() - 1;
		upheapify(ci);

	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;

		if (data.get(ci).compareTo(data.get(pi)) < 0) {
			// swap
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int pi, int ci) {
		T pValue = this.data.get(pi);
		T cValue = this.data.get(ci);

		this.data.set(pi, cValue);
		this.data.set(ci, pValue);
	}

	public T remove() {
		T temp = this.data.get(0);
		swap(0, this.data.size() - 1);
		this.data.remove(this.data.size() - 1);
		downheapify(0);
		return temp;
	}

	private void downheapify(int pi) {

		int mini = pi;

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		if (lci < this.data.size() && this.data.get(lci).compareTo(this.data.get(pi)) > 0) {
			mini = lci;
		}

		if (rci < this.data.size() && this.data.get(rci).compareTo(this.data.get(pi)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}
	}

	public T get() {
		return data.get(0);
	}

}
