package Graph;

import java.util.ArrayList;

class GraphNode {
    int vertices;
    ArrayList<Integer> adjacencyListArray[];

    public GraphNode(int vertices) {
        this.vertices = vertices;
        adjacencyListArray = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyListArray[i] = new ArrayList<>();
        }
    }
}