package Graph2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph {

	ArrayList<Vertex> verticesList;

	Graph() {
		this.verticesList = new ArrayList<>();
	}

	boolean addVertex(String name) {
		Vertex v = getVertex(name);
		if (v != null) {
			return false;
		}
		verticesList.add(new Vertex(name));
		return true;
	}

	private Vertex getVertex(String name) {
		for (Vertex currentVertex : this.verticesList) {
			if (currentVertex.name.equals(name)) {
				return currentVertex;
			}
		}
		return null;
	}

	public boolean addEdge(String name1, String name2) {
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);
		if (v1 == null || v2 == null) {
			return false;
		}
		if (areAdjacent(v1, v2)) {
			return false;
		}
		Edge newEdge = new Edge(v1, v2);
		v1.addEdge(newEdge);
		v2.addEdge(newEdge);
		return true;
	}

	private boolean areAdjacent(Vertex v1, Vertex v2) {
		if (v1.getAdjacentVertices().contains(v2)) {
			return true;
		}
		return false;
	}

	//
	// addEdge(String name1, String name2, int wight){
	//
	// }

	public boolean removeEdge(String name1, String name2) {
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);
		if (v1 == null || v2 == null) {
			return false;
		}
		if (!areAdjacent(v1, v2)) {
			return false;
		}
		v1.removeEdge(v2);
		v2.removeEdge(v1);
		return true;

	}

	boolean areConnected(String name1, String name2) {
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);
		Set<Vertex> set = new HashSet<>();
		set.add(v1);
		return areVerticesConnected(v1, v2, set);
	}

	boolean areVerticesConnected(Vertex src, Vertex dst, Set<Vertex> set) {
		if (areAdjacent(src, dst)) {
			return true;
		}
		for (Vertex currentVertex : src.getAdjacentVertices()) {
			if (!set.contains(currentVertex)) {
				set.add(currentVertex);
				if (areVerticesConnected(currentVertex, dst, set)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean removeVertex(String name) {
		Vertex v = getVertex(name);
		if (v == null) {
			return false;
		}
		for (Vertex currentvertex : v.getAdjacentVertices()) {
			currentvertex.removeEdge(v);
		}
		verticesList.remove(v);
		return true;
	}

	// isVertexAvaiable() {
	//
	// }
}
