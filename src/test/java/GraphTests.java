import trains.graph.Edge;
import trains.graph.Graph;
import org.junit.Test;
import trains.TrainsConstants;

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

    @Test
    public void routeDistanceReturnsZeroWhenRouteIsNull() {
        Graph graph = new Graph();
        assertEquals(0, graph.routeDistance(null));
    }

    @Test
    public void routeDistanceReturnsZeroWhenRouteIsEmpty() {
        Graph graph = new Graph();
        assertEquals(0, graph.routeDistance(new ArrayList<>()));
    }

    @Test
    public void routeDistanceReturnsZeroWhenRouteDoesNotExist() {
        Graph graph = new Graph();
        Edge edge = new Edge(0,1);
        List<Edge> route = new ArrayList<>();
        route.add(edge);
        assertEquals(0, graph.routeDistance(route));
    }

    @Test
    public void routeDistanceReturnsDistanceWhenSingleRouteExist() {
        Graph graph = new Graph();
        Edge graphEdge = new Edge(0,1,5);
        graph.addEdge(graphEdge);

        Edge edge = new Edge(0,1);
        List<Edge> route = new ArrayList<>();
        route.add(edge);

        assertEquals(5, graph.routeDistance(route));
    }

    @Test
    public void routeDistanceReturnsDistanceWhenMultipleRouteExist() {
        Edge edge1 = new Edge(0,1,5);
        Edge edge2 = new Edge(1,2,4);
        List<Edge> edges = new ArrayList<>();
        edges.add(edge1);
        edges.add(edge2);
        Graph graph = new Graph(edges);

        Edge routeEdge1 = new Edge(0,1);
        Edge routeEdge2 = new Edge(1,2);
        List<Edge> route = new ArrayList<>();
        route.add(routeEdge1);
        route.add(routeEdge2);

        assertEquals(9, graph.routeDistance(route));
    }

    @Test
    public void outputRouteDistanceReturnsStringRepresentationOfDistanceIfItIsGreaterThanZero(){
        Graph graph = new Graph();
        Edge graphEdge = new Edge(0,1,5);
        graph.addEdge(graphEdge);

        Edge edge = new Edge(0,1);
        List<Edge> route = new ArrayList<>();
        route.add(edge);

        assertEquals("5", graph.outputRouteDistance(route));
    }

    @Test
    public void outputRouteDistanceReturnsNoSuchRouteIfDistanceIsLessOrEqualThanZero(){
        Graph graph = new Graph();
        assertEquals(TrainsConstants.NO_SUCH_ROUTE, graph.outputRouteDistance(new ArrayList<>()));
    }

    @Test
    public void numberOfRoutesOfExactlyOneStopBetweenNodesReturnsOneIfConnected() {
        Graph graph = new Graph();
        Edge graphEdge = new Edge(0,1,5);
        graph.addEdge(graphEdge);

        assertEquals(1, graph.numberOfRoutesOfExactlyKStops(0,1,1));
    }

    @Test
    public void numberOfRoutesOfExactlyOneStopBetweenNodesReturnsZeroIfNotConnected() {
        Graph graph = new Graph();
        assertEquals(0, graph.numberOfRoutesOfExactlyKStops(0,0,1));
    }

    @Test
    public void numberOfRoutesOfExactly0StopBetweenNodesReturnsZero() {
        Graph graph = new Graph();
        Edge graphEdge = new Edge(0,1,5);
        graph.addEdge(graphEdge);

        assertEquals(0, graph.numberOfRoutesOfExactlyKStops(0,1,0));
    }

    @Test
    public void shortestPathBetweenTwoConnectedNodesReturnsTheShortestPath() {
        Edge edge1 = new Edge(0,1,5);
        Edge edge2 = new Edge(1,2,4);
        Edge edge3 = new Edge(0,2,6);
        List<Edge> edges = new ArrayList<>();
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);

        Graph graph = new Graph(edges);

        assertEquals(6, graph.shortestPathLength(0,2));
    }

    @Test
    public void shortestPathBetweenSameSourceAndDestinationNodesReturnsTheShortestPath() {
        Edge edge1 = new Edge(0,1,5);
        Edge edge2 = new Edge(1,2,4);
        Edge edge3 = new Edge(2,0,1);
        Edge edge4 = new Edge(1,0,2);
        List<Edge> edges = new ArrayList<>();
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);

        Graph graph = new Graph(edges);

        assertEquals(7, graph.shortestPathLength(0,0));
    }

    @Test
    public void shortestPathBetweenTwoNotConnectedNodesReturnsInfinite() {
        Graph graph = new Graph();
        assertEquals(Integer.MAX_VALUE, graph.shortestPathLength(0,3));
    }

    @Test
    public void numberOfRoutesOfMaximumZeroWeightReturnsZero() {
        Edge edge1 = new Edge(0,1,5);
        Edge edge2 = new Edge(1,2,4);
        Edge edge3 = new Edge(0,2,6);
        List<Edge> edges = new ArrayList<>();
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);

        Graph graph = new Graph(edges);

        assertEquals(0, graph.numberOfRoutesOfMaximumKWeight(0,2,0));
    }

    @Test
    public void numberOfRoutesOfMaximumKWeightBetweenTwoNotConnectedNodesReturnsZero() {
        Graph graph = new Graph();

        assertEquals(0, graph.numberOfRoutesOfMaximumKWeight(0,2,5));
    }

    @Test
    public void numberOfRoutesOfMaximumKWeightBetweenTwoConnectedNodesReturnsNumberRouterWithSizeLessThanK() {
        Edge edge1 = new Edge(0,1,5);
        Edge edge2 = new Edge(1,2,4);
        Edge edge3 = new Edge(2,0,1);
        Edge edge4 = new Edge(1,0,2);
        List<Edge> edges = new ArrayList<>();
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);

        Graph graph = new Graph(edges);

        assertEquals(5, graph.numberOfRoutesOfMaximumKWeight(0,0, 20));
    }
}
