package Graph2.extra.graph.basicimplementation;

public class GraphUsage {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("K");
		g.addEdge("A", "B");
		g.addEdge("A", "D");
		g.addEdge("B", "D");
		g.addEdge("B", "C");
		g.addEdge("C", "K");

		System.out.println(g.hasPath("A", "K"));
		System.out.println(g.areAdjacent("A", "K"));
		g.removeVertex("B");
		System.out.println(g.areAdjacent("A", "B"));
	}
}
