package my.assignments.tshift;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * Created by chrissekaran on 24/11/16.
 */
public class TriangleClassifierTest {

    @Mock
    TriangleFactory triangleFactory;

    @InjectMocks
    TriangleClassifier triangleClassifier = new TriangleClassifier();

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @DataProvider(name = "triangleSides")
    private Object[][] validArguments() {
        return new Object[][] {
                { new String[]{"1", "2", "3.4"},    new double[]{1d, 2d, 3.4d},    TriangleType.SCALENE },
                { new String[]{"1", "3.5", "3.4"},  new double[]{1d, 3.5d, 3.4d},       TriangleType.SCALENE },
                { new String[]{"3.5", "3.45f", "3.4f"}, new double[]{3.5d, 3.45d, 3.4d},   TriangleType.SCALENE },
                { new String[]{"2", "55.4", "55.4"},    new double[]{2d, 55.4d, 55.4d},      TriangleType.ISOSCELES },
                { new String[]{"2.43", "2.43", "55.4"}, new double[]{2.43d, 2.43d, 55.4d},TriangleType.ISOSCELES },
                { new String[]{"1", "1", "55.4"},   new double[]{1d, 1d, 55.4d},             TriangleType.ISOSCELES },
                { new String[]{"3.439", "3.439", "3.439"}, new double[]{3.439d, 3.439d, 3.439d}, TriangleType.EQUILATERAL },
                { new String[]{"6.439", "6.439", "6.439"}, new double[]{6.439d, 6.439d, 6.439d},  TriangleType.EQUILATERAL },
                { new String[]{"39.0001", "39.0001", "39.0001"}, new double[]{39.001d, 39.001d, 39.001d}, TriangleType.EQUILATERAL }
        };
    }

    @Test
    public void classifyTriangleReturnsEnumeratedTriangleType() throws Exception {
        when(triangleFactory.convertStringArgumentsToNumericType(any())).thenReturn(new double[]{2.2, 3.3, 5});
        TriangleType type = triangleClassifier.classify(new String[]{"2.2", "3.3", "5"});
        assertNotNull(type);
    }

    @Test(dataProvider = "triangleSides")
    public void verifyTypeBasedOnTriangleLengthInput(String[] args, double[] sides, TriangleType expectedType) throws Exception {
        when(triangleFactory.convertStringArgumentsToNumericType(any())).thenReturn(sides);
        TriangleType type = triangleClassifier.classify(args);
        assertEquals(expectedType, type);
    }

}
