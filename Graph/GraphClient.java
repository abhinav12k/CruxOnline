package CruxOnline.Graph;

import java.util.HashMap;

public class GraphClient {

	public static void main(String[] args) {

		Graph graph = new Graph();

		graph.addVertex("A");
		graph.addVertex("H");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "H", 2);
		graph.addEdge("A", "D", 15);
		graph.addEdge("H", "C", 1);
		graph.addEdge("C", "D", 6);
		graph.addEdge("D", "E", 9);
		graph.addEdge("E", "F", 16);
		graph.addEdge("E", "G", 12);
		graph.addEdge("F", "G", 8);

		graph.display();

//		System.out.println(graph.numEdges());
//		System.out.println(graph.numVertices());
//		
//		System.out.println(graph.containsEdge("A", "D"));
//		System.out.println(graph.containsEdge("A", "F"));
//		
//		graph.removeEdge("A", "B");
//		graph.display();
//		
//		System.out.println(graph.containsVertex("G"));
//		System.out.println(graph.containsVertex("H"));
//		
//		graph.addEdge("A", "G", 100);
//		graph.display();
//		
//		graph.removeVertex("G");
//		graph.display();
//		
//		System.out.println(graph.hasPath("A", "G", new HashMap<String,Boolean>()));

//		graph.removeEdge("D", "E");
		System.out.println(graph.bfs("A", "F"));

		System.out.println(graph.dfs("A", "F"));

	}

}
