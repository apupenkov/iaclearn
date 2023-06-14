import book.chapter7.tasks.FunctionSolver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Comparison {
    @ParameterizedTest(name = "Tested {index} tasks 'isPangramTest'")
    @CsvFileSource(
            resources = "/isPangramTest.csv",
            delimiter = ';',
            nullValues = {"NULL" },
            numLinesToSkip = 1
    )
    void isPangramTest(String input, boolean expected) {
        assertEquals(expected, FunctionSolver.isPangram(input));
    }
}
