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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
