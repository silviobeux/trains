import java.util.ArrayList;
import java.util.List;

public class TrainsUtils {

    /**
     * Returns the corresponding index of the given char
     * using the specification mapping (A = 0, B = 1, etc.), -1 if the char is invalid
     * (i.e. not contained in the valid set of node)
     */
    public static int getNodeIndex(char letter) {
        return TrainsConstants.VALID_NODE_SET.indexOf(letter);
    }

    /**
     * Returns a list of weighted edges built from input string
     */
    public static List<Edge> createEdgesFromInput(String input) {
        List<Edge> edgeList = new ArrayList<>();

        if (input != null && !input.isEmpty()) {
            input = input.toUpperCase();
            String[] edges = input.split(",");

            for (String edge : edges) {
                edge = edge.trim();
                if (isValidEdge(edge)) {
                    int source = TrainsUtils.getNodeIndex(edge.charAt(0));
                    int destination = TrainsUtils.getNodeIndex(edge.charAt(1));
                    int weight = Integer.valueOf(edge.substring(2));
                    edgeList.add(new Edge(source, destination, weight));
                }
                else {
                    throw new IllegalArgumentException("Invalid graph input provided");
                }
            }
        }
        return edgeList;
    }

    /**
     * Returns a list of edges corresponding to rhe route built from input string
     */
    public static List<Edge> createRouteFromString(String route) {
        if (route == null || route.length() < 2) {
            throw new IllegalArgumentException("Invalid route provided");
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < route.length() - 1; i++) {
            char source = route.charAt(i);
            char destination = route.charAt(i + 1);
            if (isValidNode(source) && isValidNode(destination)) {
                edges.add(new Edge(TrainsUtils.getNodeIndex(source), TrainsUtils.getNodeIndex(destination)));
            }
            else {
                throw new IllegalArgumentException("Invalid route provided");
            }
        }

        return edges;
    }

    public static boolean isValidEdge(String edge) {
        return edge.length() > 2 && isValidNode(edge.charAt(0))
                && isValidNode(edge.charAt(1))
                && isValidWeight(edge.substring(2));
    }

    public static boolean isValidNode(char node) {
        return TrainsUtils.getNodeIndex(node) != -1;
    }

    public static boolean isValidWeight(String weight) {
        try {
            return Integer.valueOf(weight) > 0;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

}
