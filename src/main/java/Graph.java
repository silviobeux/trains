import java.util.List;

/**
 * Represent a Graph as adjacency matrix. Each M(i,j) entry represents
 * the distance between i and j, 0 if there is no edge
 */

public class Graph {

    private int[][] adjacency_matrix = new int[TrainsConstants.GRAPH_SIZE][TrainsConstants.GRAPH_SIZE];

    public Graph() {}

    public Graph(List<Edge> edges) {
        if (edges != null) {
            for (Edge edge : edges) {
                adjacency_matrix[edge.getSource()][edge.getDestination()] = edge.getWeight();
            }
        }
    }

    public int getEdge(int source, int destination) {
        return adjacency_matrix[source][destination];
    }

    public boolean isEmpty(){
        for (int i = 0; i < adjacency_matrix.length; i++) {
            for (int j = 0; j < adjacency_matrix.length; j++) {
                if (adjacency_matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] getAdjacency_matrix() {
        return adjacency_matrix;
    }

    public void setAdjacency_matrix(int[][] adjacency_matrix) {
        this.adjacency_matrix = adjacency_matrix;
    }
}
