import java.util.List;

/**
 * Represent a Graph as adjacency matrix. Each M(i,j) entry represents
 * the distance between i and j, 0 if there is no edge
 */

public class Graph {

    private int[][] adjacency_matrix = new int[TrainsConstants.NUMBER_OF_NODES][TrainsConstants.NUMBER_OF_NODES];

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

    public boolean existEdge(int source, int destination) {
        return adjacency_matrix[source][destination] > 0;
    }


    public void addEdge(Edge edge) {
        if (edge != null) {
            adjacency_matrix[edge.getSource()][edge.getDestination()] = edge.getWeight();
        }
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

    public int routeDistance(List<Edge> route) {

        int distance = 0;

        if (route == null || route.isEmpty()) {
            return distance;
        }

        for (Edge edge : route) {
            int weight = getEdge(edge.getSource(), edge.getDestination());
            if (weight == 0) {
                distance = 0;
                return distance;
            }
            distance += weight;
        }
        return distance;
    }

    public int numberOfRoutesOfExactlyKStops(int source, int destination, int numberOfStops) {

        if (numberOfStops == 1 && existEdge(source,destination)) {
            return 1;
        }
        else if (numberOfStops <= 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < TrainsConstants.NUMBER_OF_NODES; i++) {
            if (existEdge(source, i)) {
                count += numberOfRoutesOfExactlyKStops(i, destination, numberOfStops - 1);
            }
        }

        return count;
    }

    public int numberOfRoutesOfMaximumKStops(int source, int destination, int numberOfStops){

        int count = 0;

        for(int i = 1; i <= numberOfStops; i++) {
            count += numberOfRoutesOfExactlyKStops(source, destination, i);
        }

        return count;
    }

    public int shortestPathLength(int source, int destination) {

        Dijkstra dijkstra = new Dijkstra(adjacency_matrix);

        int[] distances = dijkstra.shortestPaths(source);
        return distances[destination];

    }

    public String outputRouteDistance(List<Edge> route) {

        int distance = routeDistance(route);

        if (distance > 0) {
            return String.valueOf(distance);
        }
        else {
            return TrainsConstants.NO_SUCH_ROUTE;
        }
    }

    public int[][] getAdjacency_matrix() {
        return adjacency_matrix;
    }

    public void setAdjacency_matrix(int[][] adjacency_matrix) {
        this.adjacency_matrix = adjacency_matrix;
    }
}
