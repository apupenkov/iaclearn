import book.chapter7.tasks.FunctionSolver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparisonTests {
    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/isPangramTest.csv",
            delimiter = ';',
            nullValues = {"NULL" },
            numLinesToSkip = 1
    )
    void isPangramTest(String input, boolean expected) {
        assertEquals(expected, FunctionSolver.isPangram(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/isPointInsidePolygonTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void isPointInsidePolygonTest(boolean expected, double... input) {
//        List<Point2D> polygon = Arrays.asList(
//                new Point2D.Double(input[0], input[1]),
//                new Point2D.Double(input[2], input[3]),
//                new Point2D.Double(input[4], input[5]),
//                new Point2D.Double(input[6], input[7])
//        );
//        Point2D point = new Point2D.Double(input[8], input[9]);
//        assertEquals(expected, FunctionSolver.isPointInsidePolygon(polygon, point));
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/ternaryOperatorTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void ternaryOperatorTest(int input, String expected) {
        Predicate<Integer> condition = n -> n > 0;
        Function<Integer, String> ternar = FunctionSolver.ternaryOperator(condition);
        assertEquals(expected, ternar.apply(input));
    }
}
