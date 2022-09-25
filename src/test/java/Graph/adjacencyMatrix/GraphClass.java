package Graph.adjacencyMatrix;

import java.util.ArrayList;

public class GraphClass {

    ArrayList<GraphNode> node = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;

    public GraphClass(ArrayList<GraphNode> node) {
        this.node = node;
        adjacencyMatrix = new int[node.size()][node.size()];
    }

    public void UndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public String toStrings() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < node.size(); i++) {
            s.append(node.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < node.size(); i++) {
            s.append(node.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
