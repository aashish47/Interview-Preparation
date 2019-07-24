package Graph2.extra.graph.basicimplementation;

import java.util.ArrayList;

public class Vertex {

	String name;
	ArrayList<Edge> edges;
	
	Vertex(String name){
		this.name = name;
		this.edges = new ArrayList<>();
	}

	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	public ArrayList<Vertex> getAdjacentVertices() {
		ArrayList<Vertex> list = new ArrayList<>();
		for(Edge e :edges){
			if(e.v1.equals(this)){
				list.add(e.v2);
			}else if(e.v2.equals(this)){
				list.add(e.v1);
			}
		}
		return list;
	}

	public void removeEdge(String name) {
		for(Edge e: edges){
			if(e.v1.name.equals(name)||e.v2.name.equals(name)){
				edges.remove(e);
				break;
			}
		}	
	}
}
