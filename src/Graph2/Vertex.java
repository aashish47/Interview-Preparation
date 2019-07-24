package Graph2;

import java.util.ArrayList;

public class Vertex {

	String name;
	ArrayList<Edge> edgeList;
	
	Vertex(String name){
		this.name = name;
		edgeList = new ArrayList<>();
	}

	public void addEdge(Edge newEdge) {
		this.edgeList.add(newEdge);
	}

	public ArrayList<Vertex> getAdjacentVertices() {
		ArrayList<Vertex> list = new ArrayList<>();
		for(Edge e:edgeList){
			if(e.v1.equals(this)){
				list.add(e.v2);
			}else{
				list.add(e.v1);
			}
		}
		return list;
	}

	public void removeEdge(Vertex v) {
		
		for(Edge e:edgeList){
			if(e.v1.equals(v)||e.v2.equals(v)){
				edgeList.remove(v);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
}
