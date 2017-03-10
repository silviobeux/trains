import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrainsUtilTests {

    @Test
    public void getNodeIndexOfAValidNodeReturnsTheCorrespondingIndex() {
        assertEquals(0, TrainsUtils.getNodeIndex('A'));
    }

    @Test
    public void getNodeIndexOfAnInValidNodeReturnsNegativeIndex() {
        assertEquals(-1, TrainsUtils.getNodeIndex('0'));
    }

    @Test
    public void createEdgesFromNullInputCreatesEmptyListOfEdges(){
        assertTrue(TrainsUtils.createEdgesFromInput(null).isEmpty());
    }

    @Test
    public void createEdgesFromEmptyInputCreatesEmptyListOfEdges(){
        assertTrue(TrainsUtils.createEdgesFromInput("").isEmpty());
    }

    @Test
    public void createEdgesFromSingleEdgeInputCreatesValidListOfEdges() {
        List<Edge> edges = TrainsUtils.createEdgesFromInput("AD5");

        assertEquals(1, edges.size());

        Edge edge = edges.get(0);

        assertEquals(0, edge.getSource());
        assertEquals(3, edge.getDestination());
        assertEquals(5, edge.getWeight());
    }

    @Test
    public void createEdgesFromSingleEdgeInputCaseInsensitiveCreatesValidListOfEdges() {
        List<Edge> edges = TrainsUtils.createEdgesFromInput("bE1");

        assertEquals(1, edges.size());

        Edge edge = edges.get(0);

        assertEquals(1, edge.getSource());
        assertEquals(4, edge.getDestination());
        assertEquals(1, edge.getWeight());
    }

    @Test
    public void createEdgesFromMultipleEdgesInputCreatesValidListOfEdges() {
        List<Edge> edges = TrainsUtils.createEdgesFromInput("AB5, BC4");

        assertEquals(2, edges.size());

        Edge edge1 = edges.get(0);
        Edge edge2 = edges.get(1);

        assertEquals(0, edge1.getSource());
        assertEquals(1, edge1.getDestination());
        assertEquals(5, edge1.getWeight());
        assertEquals(1, edge2.getSource());
        assertEquals(2, edge2.getDestination());
        assertEquals(4, edge2.getWeight());
    }

    @Test
    public void createEdgesFromSingleEdgeInputWithWeightGreaterThanOneDigitCreatesValidListOfEdges() {
        List<Edge> edges = TrainsUtils.createEdgesFromInput("AD50");

        assertEquals(1, edges.size());

        Edge edge = edges.get(0);

        assertEquals(0, edge.getSource());
        assertEquals(3, edge.getDestination());
        assertEquals(50, edge.getWeight());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createEdgesWithInvalidSourceNodeThrowsException() {
        TrainsUtils.createEdgesFromInput("XA5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createEdgesWithInvalidDestinationNodeThrowsException() {
        TrainsUtils.createEdgesFromInput("Ax5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createEdgesWithInvalidWeightThrowsException() {
        TrainsUtils.createEdgesFromInput("ABa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createEdgesWithZeroWeightThrowsException() {
        TrainsUtils.createEdgesFromInput("AB0");
    }

}
