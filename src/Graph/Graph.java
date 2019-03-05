package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

        public static void addEdge(GraphNode graph,int src, int dest){
            graph.adjacencyListArray[src].add(dest);
            graph.adjacencyListArray[dest].add(src);
        }

        public static void printGraph(GraphNode graph){
            for(int i = 0; i < graph.vertices; i++){
                System.out.print("head: ->");
                for(Integer vertex : graph.adjacencyListArray[i]){
                    System.out.print(vertex + "->");
                }
                System.out.println();
            }
        }

    public static void main(String[] args) {
        int vertices = 5;
        GraphNode graph = new GraphNode(vertices);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        // print the adjacency list representation of
        // the above graph
        printGraph(graph);
    }
}
