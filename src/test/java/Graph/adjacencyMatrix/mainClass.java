package Graph.adjacencyMatrix;

import Graph.adjacencyMatrix.GraphClass;
import Graph.adjacencyMatrix.GraphNode;

import java.util.ArrayList;

public class mainClass {

    public static void main(String[] args) {
        //adjacencyMatrix
        ArrayList<GraphNode> node = new ArrayList<>();
        node.add(new GraphNode("A", 0));
        node.add(new GraphNode("B", 1));
        node.add(new GraphNode("C", 2));
        node.add(new GraphNode("D", 3));
        node.add(new GraphNode("E", 4));

        GraphClass g = new GraphClass(node);
        g.UndirectedEdge(0, 1);
        g.UndirectedEdge(0, 2);
        g.UndirectedEdge(0, 3);
        g.UndirectedEdge(1, 4);
        g.UndirectedEdge(2, 3);
        g.UndirectedEdge(3, 4);
        System.out.print(g.toStrings());
    }
}
