import java.util.PriorityQueue;

public class Dijkstra {

    private int distances[];
    private int[][] adjacencyMatrix;
    private PriorityQueue<PriorityNode> priorityQueue;
    private int numberOfNodes;

    public class PriorityNode implements Comparable<PriorityNode> {
        private int index;
        private int priority;

        public PriorityNode(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        @Override
        public int compareTo(PriorityNode o) {
            return Integer.valueOf(priority).compareTo(o.priority);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PriorityNode that = (PriorityNode) o;

            if (index != that.index) return false;
            return priority == that.priority;

        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + priority;
            return result;
        }
    }

    public Dijkstra(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        numberOfNodes = adjacencyMatrix.length;
        distances = new int[adjacencyMatrix.length];
        priorityQueue = new PriorityQueue<>();
    }

    public int[] shortestPaths(int source) {

        for (int i = 0; i < numberOfNodes; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        priorityQueue.add(new PriorityNode(source, 0));
        distances[source] = 0;

        while (!priorityQueue.isEmpty()) {
            PriorityNode first = priorityQueue.poll();

            for (int i = 0; i < numberOfNodes; i++) {
                if (adjacencyMatrix[first.index][i] != 0) {
                    if (distances[i] == 0) {
                        distances[i] = Integer.MAX_VALUE;
                    }
                    if (distances[i] > distances[first.index] + adjacencyMatrix[first.index][i]) {
                        int oldIndex = distances[i];
                        distances[i] = distances[first.index] + adjacencyMatrix[first.index][i];
                        priorityQueue.remove(new PriorityNode(i, oldIndex));
                        priorityQueue.add(new PriorityNode(i, distances[i]));
                    }
                }
            }
        }
            return distances;
        }
}
