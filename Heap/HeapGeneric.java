package CruxOnline.Heap;

import java.util.ArrayList;
import java.util.HashMap;

public class HeapGeneric<T extends Comparable<T>> {

	ArrayList<T> data;
	public HashMap<T, Integer> indexMap;

	public HeapGeneric() {
		this.data = new ArrayList<>();
		this.indexMap = new HashMap<>();
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	public void display() {
		System.out.println(this.data);
	}

	public void add(T item) {

		this.data.add(item);
		int ci = this.data.size() - 1;
		indexMap.put(item, ci);
		upheapify(ci);

	}

	public void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (isLarger(this.data.get(ci), this.data.get(pi)) > 0) {
			// swap
			swap(pi, ci);
			upheapify(pi);
		}

	}

	public void swap(int pi, int ci) {

		T cValue = this.data.get(ci);
		T pValue = this.data.get(pi);

		this.data.set(pi, cValue);
		this.data.set(ci, pValue);

		indexMap.put(cValue, pi);
		indexMap.put(pValue, ci);
	}

	public T remove() {

		// swap
		swap(0, this.data.size() - 1);

		T rv = this.data.remove(this.data.size() - 1);
		indexMap.remove(rv);
		downheapify(0);
		return rv;
	}

	public void downheapify(int pi) {

		int lc = 2 * pi + 1;
		int rc = 2 * pi + 2;

		int mini = pi;

		if (lc < this.data.size() && isLarger(this.data.get(lc), this.data.get(pi)) > 0) {
			mini = lc;
		} else if (rc < this.data.size() && isLarger(this.data.get(rc), this.data.get(pi)) > 0) {
			mini = rc;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}
	}

	public T get() {
		return this.data.get(0);
	}

	// Returns positive value if t has higher priority and returns negative if o has
	// higher priority
	public int isLarger(T t, T o) {
		return t.compareTo(o);
	}

	public void updatePriority(T item) {

		int index = indexMap.get(item);

		upheapify(index);
	}

}
