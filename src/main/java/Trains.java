import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trains {

    public static void main(String[] args) {

        if (args.length != 1) {
            throw new IllegalArgumentException("Invalid number of input arguments");
        }

        String fileName = args[0];

        try {

            Scanner scanner = new Scanner(new File(fileName));
            String graphInput = scanner.nextLine();
            Graph graph = new Graph(TrainsUtils.createEdgesFromInput(graphInput));

            System.out.println("Output #1: " + graph.outputRouteDistance(TrainsUtils.createRouteFromString("ABC")));
            System.out.println("Output #2: " + graph.outputRouteDistance(TrainsUtils.createRouteFromString("AD")));
            System.out.println("Output #3: " + graph.outputRouteDistance(TrainsUtils.createRouteFromString("ADC")));
            System.out.println("Output #4: " + graph.outputRouteDistance(TrainsUtils.createRouteFromString("AEBCD")));
            System.out.println("Output #5: " + graph.outputRouteDistance(TrainsUtils.createRouteFromString("AED")));
            System.out.println("Output #6: " + graph.
                    numberOfRoutesOfMaximumKStops(TrainsUtils.getNodeIndex('C'), TrainsUtils.getNodeIndex('C'), 3));
            System.out.println("Output #7: " + graph.
                    numberOfRoutesOfExactlyKStops(TrainsUtils.getNodeIndex('A'), TrainsUtils.getNodeIndex('C'), 4));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
