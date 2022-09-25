package Graph.adjacencyList;

import java.util.ArrayList;

public class mainClass {

    public static void main(String[] args) {
        //adjacencyList
        ArrayList<GraphNode> node = new ArrayList<>();
        node.add(new GraphNode("A", 0));
        node.add(new GraphNode("B", 1));
        node.add(new GraphNode("C", 2));
        node.add(new GraphNode("D", 3));
        node.add(new GraphNode("E", 4));

        Graphclass g = new Graphclass(node);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);
        System.out.print(g.toString());
        //g.bfs();
        g.dfs();
    }
}
