import org.junit.Test;
import trains.TrainsConstants;
import trains.graph.Graph;
import trains.utils.TrainsUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TrainsTests {

    @Test
    public void trainsSuitTests() throws FileNotFoundException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("testInput.txt").getFile());
        Scanner scanner = new Scanner(file);
        String graphInput = scanner.nextLine();

        Graph graph = new Graph(TrainsUtils.createEdgesFromInput(graphInput));

        assertEquals("9", graph.outputRouteDistance(TrainsUtils.createRouteFromString("ABC")));
        assertEquals("5", graph.outputRouteDistance(TrainsUtils.createRouteFromString("AD")));
        assertEquals("13", graph.outputRouteDistance(TrainsUtils.createRouteFromString("ADC")));
        assertEquals("22", graph.outputRouteDistance(TrainsUtils.createRouteFromString("AEBCD")));
        assertEquals(TrainsConstants.NO_SUCH_ROUTE, graph.outputRouteDistance(TrainsUtils.createRouteFromString("AED")));
        assertEquals(2, graph.numberOfRoutesOfMaximumKStops(TrainsUtils.getNodeIndex('C'),
                TrainsUtils.getNodeIndex('C'), 3));
        assertEquals(3, graph.numberOfRoutesOfExactlyKStops(TrainsUtils.getNodeIndex('A'),
                TrainsUtils.getNodeIndex('C'), 4));
        assertEquals(9, graph.shortestPathLength(TrainsUtils.getNodeIndex('A'), TrainsUtils.getNodeIndex('C')));
        assertEquals(9, graph.shortestPathLength(TrainsUtils.getNodeIndex('B'), TrainsUtils.getNodeIndex('B')));
        assertEquals(7, graph.numberOfRoutesOfMaximumKWeight(TrainsUtils.getNodeIndex('C'),
                TrainsUtils.getNodeIndex('C'), 30));
    }
}
