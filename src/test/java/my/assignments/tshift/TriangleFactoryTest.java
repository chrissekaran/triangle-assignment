package my.assignments.tshift;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

/**
 * Created by chrissekaran on 24/11/16.
 */
public class TriangleFactoryTest {

    private TriangleFactory factory = TriangleFactory.instance();
    private String[] argumentsAsString = {"3.5", "4", "5"};
    private double[] expectedConversionToFloat = { 3.5d, 4d, 5d};

    @Test
    public void triangleFactoryInstantiatesTriangle() throws Exception {
        assertNotNull(factory);
    }

    @Test
    public void checkArgumentsAndConvertToAcceptableType() throws Exception {
        double[] sides = factory.convertStringArgumentsToNumericType(argumentsAsString);
        assertNotNull(sides);
        assertEquals(3, sides.length);
    }

    @Test
    public void convertValuesConvertsAsExpected() throws Exception {
        double[] sides = factory.convertStringArgumentsToNumericType(argumentsAsString);
        assertArrayEquals(expectedConversionToFloat, sides, 0.00);
    }

}
