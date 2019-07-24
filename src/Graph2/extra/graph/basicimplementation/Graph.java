package Graph2.extra.graph.basicimplementation;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	ArrayList<Vertex> vertices;

	Graph() {
		vertices = new ArrayList<>();
	}

	public boolean addVertex(String name) {
		Vertex v = getVertex(name);
		if (v == null) {
			Vertex newVertex = new Vertex(name);
			vertices.add(newVertex);
			return true;
		}
		return false;
	}

	private Vertex getVertex(String name) {
		for (Vertex v : vertices) {
			if (v.name.equals(name)) {
				return v;
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

		if (!areAdjacent(name1, name2)) {
			Edge edge = new Edge(v1, v2);
			v1.addEdge(edge);
			v2.addEdge(edge);
			return true;
		}

		return false;
	}

	public boolean removeVertex(String name) {
		Vertex v = getVertex(name);
		if(v==null){
			return false;
		}
		for(Vertex currentVertex: v.getAdjacentVertices()){
			currentVertex.removeEdge(name);
		}
		vertices.remove(v);
		return true;
	}

//	removeEdge() {
//
//	}
	public boolean hasPath(String name1, String name2) {
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);
		if(v1==null||v2==null){
			return false;
		}
		
		HashMap<Vertex, Boolean> map = new HashMap<>();
		map.put(v1, true);
		return hasPath(v1,v2,map);
		
		
	}

	private boolean hasPath(Vertex src, Vertex dst, HashMap<Vertex, Boolean> map) {
		if(areAdjacent(src.name, dst.name)){
			return true;
		}
		for(Vertex v:src.getAdjacentVertices()){
			if(!map.containsKey(v)){
				map.put(v, true);
				return hasPath(v, dst,map);
			}
		}
		return false;
	}
//	getDistance(String name1, String name2) {
//
//	}

	public boolean areAdjacent(String name1, String name2) {
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);

		if (v1 == null || v2 == null) {
			return false;
		}
		ArrayList<Vertex> adjacentVerticesList = v1.getAdjacentVertices();
		for (Vertex v : adjacentVerticesList) {
			if (v.name.equals(name2)) {
				return true;
			}
		}
		return false;
	}

}
