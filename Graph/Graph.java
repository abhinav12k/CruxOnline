package CruxOnline.Graph;

import java.util.ArrayList;
import java.util.HashMap;

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

		//To avoid returning to the same problem - removing stackoverflow error
		processed.put(vname1, true);
		
		//check if direct edge is present
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

}
