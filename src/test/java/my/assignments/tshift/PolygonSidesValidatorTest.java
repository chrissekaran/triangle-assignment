package my.assignments.tshift;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

/**
 * Created by chrissekaran on 24/11/16.
 */
public class PolygonSidesValidatorTest {

    PolygonSidesValidator factory = () -> 4; //Testing a case of a 4 sided polygon.

    @DataProvider(name = "validArgumentsConvertedFromStringToDouble")
    private Object[][] validArguments() {
        return new Object[][] {
                {new String[]{"1", "2f", "3.4f", "4.3"}, new double[]{1d, 2, 3.4d, 4.3d}},
                {new String[]{"2", "55.4", "4", "4.5"},  new double[]{2d, 55.4d, 4, 4.5}},
                {new String[]{"3.439", "2d", "5d", "5.3"}, new double[]{3.439d, 2, 5.0, 5.3}}
        };
    }

    @Test(dataProvider = "validArgumentsConvertedFromStringToDouble")
    public void passesWhenValidArgumentsAreSupplied(String[] args, double[] convertedArgs) throws Exception {
        double[] sides = factory.convertStringArgumentsToNumericType(args);
        assertArrayEquals(convertedArgs, sides, 0);
    }

    @DataProvider(name = "invalidArgumentsThatFail")
    private Object[][] invalidArguments() {
        return new Object[][] {
                {new String[]{"1", "2", "0", "2"}},
                {new String[]{"2", "0", "4", "6"}},
                {new String[]{"0", "2", "0", "4"}},
                {new String[]{"1", "2", "3", ""}},
                {new String[]{"2", "2", ""}}
        };
    }

    @Test(dataProvider = "invalidArgumentsThatFail", expectedExceptions = IllegalArgumentException.class)
    public void failsWhenValidArgumentsAreSupplied(String[] args) throws Exception {
        factory.convertStringArgumentsToNumericType(args);
    }
}
