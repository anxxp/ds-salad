package Graph;

import java.util.*;

public class Graph {

    Map<Vertex, LinkedList<Vertex>> adj;

    public Graph(){
        this.adj = new HashMap<>();
    }
    Queue queue = new LinkedList();
    public void addEdge(Edge edge){

        LinkedList<Vertex> adjList = adj.get(edge.src);
        if(adjList == null){
            adjList = new LinkedList<>();
            adj.put(edge.src,adjList);
        }
        adjList.add(edge.dest);
    }

    public LinkedList<Vertex> getAdjList(Vertex vertex){
        return adj.get(vertex);
    }
}
