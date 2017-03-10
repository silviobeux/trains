import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTests {

    @Test
    public void createGraphWithNullEdgesReturnsEmptyGraph() {
        Graph graph = new Graph(null);

        assertTrue(graph.isEmpty());
    }

    @Test
    public void createGraphWithEmptyEdgesReturnsEmptyGraph() {
        Graph graph = new Graph(new ArrayList<>());

        assertTrue(graph.isEmpty());
    }

    @Test
    public void createGraphWithSingleValidEdgeReturnsValidGraph() {
        Edge edge = new Edge(0,1,2);
        List<Edge> edges = new ArrayList<>();
        edges.add(edge);
        Graph graph = new Graph(edges);

        assertFalse(graph.isEmpty());
        assertEquals(2, graph.getEdge(0,1));
    }

    @Test
    public void createGraphWithValidEdgesReturnsValidGraph() {
        Edge edge1 = new Edge(0,1,2);
        Edge edge2 = new Edge(1,3,7);

        List<Edge> edges = new ArrayList<>();
        edges.add(edge1);
        edges.add(edge2);
        Graph graph = new Graph(edges);

        assertFalse(graph.isEmpty());
        assertEquals(2, graph.getEdge(0,1));
        assertEquals(7, graph.getEdge(1,3));
    }

}
