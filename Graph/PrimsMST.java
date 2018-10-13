package Graph;

public class PrimsMST {

    public static void main(String args[]){
        Graph graph = new Graph();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        graph.addEdge(new Edge(a,b));
        graph.addEdge(new Edge(a,c));
        graph.addEdge(new Edge(c,d));
        graph.addEdge(new Edge(b,e));
        graph.addEdge(new Edge(d,e));

    }
}
