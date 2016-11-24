package my.assignments.tshift;

/**
 * A polygon classifier is designed to take in a set of String[] arg's usually input and return an enumerated type of the Polygon
 *
 * Created by chrissekaran on 24/11/16.
 */
public interface PolygonClassifier<T extends Enum> {

    T classify(String[] arguments);
}
