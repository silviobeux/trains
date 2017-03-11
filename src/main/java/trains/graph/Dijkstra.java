package trains.graph;

import trains.utils.PriorityNode;

import java.util.PriorityQueue;

public class Dijkstra {

    private int distances[];
    private int[][] adjacencyMatrix;
    private PriorityQueue<PriorityNode> priorityQueue;
    private int numberOfNodes;

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
                if (adjacencyMatrix[first.getIndex()][i] != 0) {
                    if (distances[i] == 0) {
                        distances[i] = Integer.MAX_VALUE;
                    }
                    int newDistance = distances[first.getIndex()] + adjacencyMatrix[first.getIndex()][i];
                    if (distances[i] > newDistance) {
                        int oldIndex = distances[i];
                        distances[i] = newDistance;
                        priorityQueue.remove(new PriorityNode(i, oldIndex));
                        priorityQueue.add(new PriorityNode(i, distances[i]));
                    }
                }
            }
        }
            return distances;
        }
}
