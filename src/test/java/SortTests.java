import book.chapter7.tasks.FunctionSolver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTests {
    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/sortVowelsAndConsonantsTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void sortVowelsAndConsonantsTest(String input, String expected) {
        assertEquals(expected, FunctionSolver.sortVowelsAndConsonants(input));
    }
}
