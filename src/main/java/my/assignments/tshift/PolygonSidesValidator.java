package my.assignments.tshift;

/**
 *
 * A validation utility that does a dfault validation on a polygon given sides
 * 1. It checks for the number of appropriate sides
 * 2. Post validation it converts the String[] values into double[] and returns the double[]
 *
 * Created by chrissekaran on 24/11/16.
 */
public interface PolygonSidesValidator {

    int numberOfSides();

    /**
     * Checks the validity of the parameters for a certain Polygon. Every type of Polygon will have different constraints on the input parameters.
     * This default implementation checks basic constrains for numeric, non-zero integer values
     * @param argumentsAsString
     * @return the numeric values of the sides converted into double
     */
    default double[] convertStringArgumentsToNumericType(String[] argumentsAsString) throws NumberFormatException {
        if(argumentsAsString.length != numberOfSides()) {
            throw new IllegalArgumentException("The number of passed in arguments is not valid");
        }
        double[] sides = new double[numberOfSides()];
        for (int i = 0; i < numberOfSides(); i++) {
            Double argi = Double.valueOf(argumentsAsString[i]);
            if(argumentsAsString[i] == null || argi.equals(0d)) {
                throw new IllegalArgumentException("The float value of the argument at place "+i+" is not valid");
            }
            sides[i] = Double.valueOf(argumentsAsString[i]);
        }
        return sides;
    }


}
