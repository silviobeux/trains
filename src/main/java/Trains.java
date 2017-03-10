import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trains {

    public static final String ROUTE_ONE = "ABC";
    public static final String ROUTE_TWO = "AD";
    public static final String ROUTE_THREE = "ADC";
    public static final String ROUTE_FOUR = "AEBCD";
    public static final String ROUTE_FIVE = "AED";

    public static void main(String[] args) {

        if (args.length != 1) {
            throw new IllegalArgumentException("Invalid number of input arguments");
        }

        String fileName = args[0];

        try {

            Scanner scanner = new Scanner(new File(fileName));
            String graphInput = scanner.nextLine();
            Graph graph = new Graph(TrainsUtils.createEdgesFromInput(graphInput));

            System.out.println("Output #1: " + graph.outputRouteDistance(TrainsUtils.createRouteFromString(ROUTE_ONE)));
            System.out.println("Output #2: " + graph.outputRouteDistance(TrainsUtils.createRouteFromString(ROUTE_TWO)));
            System.out.println("Output #3: " + graph.outputRouteDistance(TrainsUtils.createRouteFromString(ROUTE_THREE)));
            System.out.println("Output #4: " + graph.outputRouteDistance(TrainsUtils.createRouteFromString(ROUTE_FOUR)));
            System.out.println("Output #5: " + graph.outputRouteDistance(TrainsUtils.createRouteFromString(ROUTE_FIVE)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
