package Graph_IB;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    public class Vertex{
        HashMap<String, Integer> neighbours = new HashMap<>();
    }
    HashMap<String, Vertex> vertices = new HashMap<>();

    public int numOfVertices(){
        return vertices.size();
    }

    public boolean hasVertex(String vertex){
        return vertices.containsKey(vertex);
    }

    public void addVertex(String vName){
        Vertex vertex = new Vertex();
        vertices.put(vName, vertex);
    }

    public void addEdge(String name1, String name2, int weight){
        Vertex v1 = vertices.get(name1);
        Vertex v2 = vertices.get(name2);

        if(v1 == null || v2 == null || v1.neighbours.containsKey(name2)){
            return;
        }

        v1.neighbours.put(name2,weight);
        v2.neighbours.put(name1,weight);
    }

    public boolean containsEdge(String name1, String name2){
        Vertex v1 = vertices.get(name1);
        Vertex v2 = vertices.get(name2);
        if(v1 == null || v2 == null || !v1.neighbours.containsKey(name2)){
            return false;
        }
        return true;
    }

    class Pair{
        String vName;
        String psf;
    }

    public void bft(){
        HashMap<String, Boolean> processed = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        for(String key : vertices.keySet()){

            if(processed.containsKey(key)){
                continue;
            }

            Pair sp = new Pair();
            sp.vName = key;
            sp.psf = key;
            queue.add(sp);

            while(!queue.isEmpty()){
                Pair rp = queue.poll();
                if(processed.containsKey(rp.vName)){
                    continue;
                }

                processed.put(rp.vName, true);

                System.out.println(rp.vName + " via " + rp.psf);

                for(String nbr : vertices.get(rp.vName).neighbours.keySet()){
                    if(processed.containsKey(nbr)){
                        continue;
                    }
                    Pair np = new Pair();
                    np.vName = nbr;
                    np.psf = rp.psf + nbr;
                    queue.add(np);
                }
            }
        }
    }

    public void dft() {

        HashMap<String, Boolean> processed = new HashMap<>();

        Stack<Pair> stack = new Stack<>();

        for (String key : vertices.keySet()) {

            if (processed.containsKey(key)) {
                continue;
            }

            Pair sp = new Pair();
            sp.vName = key;
            sp.psf = key;

            stack.push(sp);
            // work till queue is not empty
            while (!stack.isEmpty()) {

                // remove the pair from queue
                Pair rp = stack.pop();

                // ignore the second C
                if (processed.containsKey(rp.vName)) {
                    continue;
                }
                // processed put
                processed.put(rp.vName, true);
                // syso
                System.out.println(rp.vName + " via " + rp.psf);
                // nbrs
                for (String nbr : vertices.get(rp.vName).neighbours.keySet()) {
                    // process only unprocessed nbrs
                    if (!processed.containsKey(nbr)) {

                        Pair np = new Pair();
                        np.vName = nbr;
                        np.psf = rp.psf + nbr;
                        stack.push(np);
                    }
                }
            }
        }
    }

}
