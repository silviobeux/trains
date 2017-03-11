package trains.graph;

public class Edge {

    private int source;
    private int destination;
    private int weight;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (source != edge.source) return false;
        if (destination != edge.destination) return false;
        return weight == edge.weight;

    }

    @Override
    public int hashCode() {
        int result = source;
        result = 31 * result + destination;
        result = 31 * result + weight;
        return result;
    }
}
