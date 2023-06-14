import book.chapter7.tasks.FunctionSolver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatingTest {
    @ParameterizedTest(name = "Tested {index} tasks 'addTest'")
    @CsvFileSource(
            resources = "/addTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void addTest(int a, int b, int result) {
        Function<Integer, Function<Integer, Integer>> add = FunctionSolver.add();
        assertEquals(add.apply(a).apply(b), result);
    }

    @ParameterizedTest(name = "Tested {index} tasks 'factorialTest'")
    @CsvFileSource(
            resources = "/factorialTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void factorialTest(int input, int expected) {
        assertEquals(expected, FunctionSolver.factorial(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks 'inscribedCircleRadiusTest'")
    @CsvFileSource(
            resources = "/inscribedCircleRadiusTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void inscribedCircleRadiusTest(double a, double b, double expected) {
        assertEquals(expected, FunctionSolver.inscribedCircleRadius(a, b));
    }
}
