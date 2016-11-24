package my.assignments.tshift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * The main class to run. User input is driven by the logger
 *
 * Created by chrissekaran on 24/11/16.
 */
public class Runner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);
    private static LineScanner lineScanner = new LineScanner();

    static class LineScanner    {
        private static final Scanner SCAN = new Scanner(System.in);
        String fetchUserInput()    {
            return SCAN.nextLine();
        }
    }

    public static void main(String[] args) {

        LOGGER.info("Welcome to Triangle checker");

        evaluateTriangleSides();

        LOGGER.info("Thank you!");

        System.exit(0);
    }

    private static void evaluateTriangleSides() {
        while(true) {
            PolygonClassifier classifier = new TriangleClassifier();
            LOGGER.info("Please start by entering 3 lengths of a triangle separated by <space> or 'exit' to exit the program");

            final String next = lineScanner.fetchUserInput();

            String[] argv = next.split(" ");
            if(argv.length == 1 && argv[0].trim().equalsIgnoreCase("exit")) {
                break;
            }
            try {
                TriangleType type = (TriangleType) classifier.classify(argv);
                if(type != null) {
                    LOGGER.info("The type is "+type.name());
                }
            } catch (Exception e) {
                //do Nothing and continue gracefully
            }
        }
    }
}
