package CruxOnline.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, Vertex> vtcs;

	public Graph() {
		vtcs = new HashMap<>();
	}

	public int numVertices() {
		return this.vtcs.size();
	}

	public boolean containsVertex(String vname) {
		return this.vtcs.containsKey(vname);
	}

	public void removeVertex(String vname) {

		Vertex vtx = this.vtcs.get(vname);
		ArrayList<String> nbrKeys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : nbrKeys) {
			Vertex nbrVtx = this.vtcs.get(key);
			nbrVtx.nbrs.remove(vname);
		}

		this.vtcs.remove(vname);

	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		this.vtcs.put(vname, vtx);
	}

	public int numEdges() {
		ArrayList<String> vertices = new ArrayList<>(vtcs.keySet());
		int count = 0;
		for (String vtx : vertices) {
			count += this.vtcs.get(vtx).nbrs.size();
		}
		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		// If vname1 contains vname2 as nbr and vname2 contains vname1 as nbr then both
		// contains an edge in between
		Vertex v1 = this.vtcs.get(vname1);
		Vertex v2 = this.vtcs.get(vname2);

		if (v1 == null || v2 == null || !v1.nbrs.containsKey(vname2))
			return false;

		return true;

	}

	public void removeEdge(String vname1, String vname2) {

		Vertex v1 = this.vtcs.get(vname1);
		Vertex v2 = this.vtcs.get(vname2);

		if (v1 == null || v2 == null || !v1.nbrs.containsKey(vname2))
			return;

		v1.nbrs.remove(vname2);
		v2.nbrs.remove(vname1);

	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex v1 = this.vtcs.get(vname1);
		Vertex v2 = this.vtcs.get(vname2);

		if (v1 == null || v2 == null || v1.nbrs.containsKey(vname2))
			return;

		v1.nbrs.put(vname2, cost);
		v2.nbrs.put(vname1, cost);

	}

	public void display() {

		System.out.println("---------------------");

		ArrayList<String> keys = new ArrayList<>(this.vtcs.keySet());

		for (String key : keys) {

			Vertex vtx = this.vtcs.get(key);
			System.out.println(key + " : " + vtx.nbrs);

		}
		System.out.println("---------------------");

	}

	public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) {

		// To avoid returning to the same problem - removing stackoverflow error
		processed.put(vname1, true);

		// check if direct edge is present
		if (containsEdge(vname1, vname2))
			return true;

		Vertex vtx = this.vtcs.get(vname1);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) {

			if (!processed.containsKey(key) && hasPath(key, vname2, processed))
				return true;

		}

		return false;
	}

	/*********** Breadth First Search **********/

	public class Pair {
		String vname;
		String psf;
	}

	public boolean bfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		// Create a new Pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		// Add to the list
		queue.addLast(sp);

		while (!queue.isEmpty()) {

			Pair rp = queue.removeLast();

			if (processed.containsKey(rp.vname))
				continue;

			processed.put(rp.vname, true);

			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs
			ArrayList<String> nbrs = new ArrayList<>(this.vtcs.get(rp.vname).nbrs.keySet());

			for (String nbr : nbrs) {

				// Process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					queue.addLast(np);
				}
			}

		}

		return false;
	}

	public boolean dfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname))
				continue;

			// Add pair to processed hashmap
			processed.put(rp.vname, true);

			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			ArrayList<String> nbrs = new ArrayList<>(this.vtcs.get(rp.vname).nbrs.keySet());

			for (String nbr : nbrs) {

				// Process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					stack.addFirst(np);
				}

			}

		}
		return false;
	}

	public void bft() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(this.vtcs.keySet());

		for (String key : keys) {

			// Create a new Pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			if (processed.containsKey(key))
				continue;

			// Add to the list
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeLast();

				if (processed.containsKey(rp.vname))
					continue;

				processed.put(rp.vname, true);

				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				ArrayList<String> nbrs = new ArrayList<>(this.vtcs.get(rp.vname).nbrs.keySet());

				for (String nbr : nbrs) {

					// Process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}
		}

	}

	public void dft() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(this.vtcs.keySet());

		for (String key : keys) {

			// Create a new Pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			if (processed.containsKey(key))
				continue;

			// Add to the list
			stack.addFirst(sp);

			while (!stack.isEmpty()) {

				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

				processed.put(rp.vname, true);

				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				ArrayList<String> nbrs = new ArrayList<>(this.vtcs.get(rp.vname).nbrs.keySet());

				for (String nbr : nbrs) {

					// Process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}
				}

			}
		}

	}

	public boolean isCyclic() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(this.vtcs.keySet());

		for (String key : keys) {

			// Create a new Pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			if (processed.containsKey(key))
				continue;

			// Add to the list
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeLast();

				if (processed.containsKey(rp.vname))
					return true;

				processed.put(rp.vname, true);

				// nbrs
				ArrayList<String> nbrs = new ArrayList<>(this.vtcs.get(rp.vname).nbrs.keySet());

				for (String nbr : nbrs) {

					// Process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}
		}
		return false;
	}

	public boolean isConnected() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(this.vtcs.keySet());

		int flag = 0;

		for (String key : keys) {

			// Create a new Pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			if (processed.containsKey(key))
				continue;

			flag++;

			// Add to the list
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeLast();

				if (processed.containsKey(rp.vname))
					continue;

				processed.put(rp.vname, true);

				// nbrs
				ArrayList<String> nbrs = new ArrayList<>(this.vtcs.get(rp.vname).nbrs.keySet());

				for (String nbr : nbrs) {

					// Process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}
		}

		if (flag >= 2)
			return false;
		else
			return true;
	}

	public boolean isTree() {
		return !isCyclic() && isConnected();
	}

}
