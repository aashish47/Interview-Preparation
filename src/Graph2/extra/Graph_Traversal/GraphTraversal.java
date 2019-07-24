package Graph2.extra.Graph_Traversal;

import java.util.LinkedList;


import Graph2.extra.Graph_Representation.Graph;



public class GraphTraversal {

	void bfsTraversal(Graph g, int s) {
		boolean visited[] = new boolean[g.getNumVertices()];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			int vertex = queue.remove();
			System.out.print(vertex + " ");
			for (int currentVertex : g.getAdjacentVertices(s)) {
				if (!visited[currentVertex]) {
					visited[currentVertex] = true;
					queue.add(currentVertex);
				}
			}
		}
	}

	void DFSUtil(int s, boolean visited[], Graph g) {
		visited[s] = true;
		System.out.print(s + " ");

		for (int n : g.getAdjacentVertices(s)) {
			if (!visited[n]) {
				DFSUtil(n, visited, g);
			}
		}
	}

	void dfsTraversal(int s, Graph g) {
		boolean visited[] = new boolean[g.getNumVertices()];
		DFSUtil(s, visited, g);
	}

}
