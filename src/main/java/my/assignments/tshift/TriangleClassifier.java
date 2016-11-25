package my.assignments.tshift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by chrissekaran on 24/11/16.
 */
public class TriangleClassifier implements PolygonClassifier<TriangleType> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TriangleClassifier.class);

    PolygonSidesValidator triangleFactory = TriangleFactory.instance();

    public TriangleType classify(String[] arguments) {
        try {
            final double[] sidesArray = triangleFactory.convertStringArgumentsToNumericType(arguments);

            Long sidesCount = Arrays.stream(sidesArray).sorted().distinct().count();

            switch (sidesCount.intValue()) {
                case 3:
                    return TriangleType.SCALENE;
                case 2:
                    return TriangleType.ISOSCELES;
                case 1:
                    return TriangleType.EQUILATERAL;
                default:
                    return null;
            }
        } catch (NumberFormatException nfe) {
            LOGGER.error("Something other than a number was entered. Please check.");
            throw nfe;
        }
    }

}
