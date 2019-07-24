package Graph2.extra.Graph_Representation.adjacencylist;

import java.util.ArrayList;
import java.util.List;

import Graph2.extra.Graph_Representation.Graph;




public class AdjacencyList implements Graph {
	private List<Node> vertexList = new ArrayList<>();
	private GraphType graphType;
	private int numVertices = 0;

	AdjacencyList(GraphType type) {
		this.vertexList = new ArrayList<>();
		graphType = type;
	}

	@Override
	public GraphType TypeofGraph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEdge(int v1, int v2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEdge(int v1, int v2, int weight) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getWeightedEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> getAdjacentVertices(int v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndegree(int v) {
		// TODO Auto-generated method stub
		return 0;
	}
}
