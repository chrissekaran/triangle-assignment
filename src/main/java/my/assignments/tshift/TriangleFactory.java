package my.assignments.tshift;

/**
 * Created by chrissekaran on 24/11/16.
 */
public class TriangleFactory implements PolygonSidesValidator {

    private static final int numberOfSides = 3;
    private static final TriangleFactory instance = new TriangleFactory();

    private TriangleFactory() {}

    public static TriangleFactory instance() {
        return instance;
    }

    @Override
    public int numberOfSides() {
        return numberOfSides;
    }

}
