package chapter11;

import book.chapter11.CollectionSolver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateTests {
    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/validateBracketsTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    void validateBracketsTest(String input, boolean expected) {
        assertEquals(expected, CollectionSolver.validateBrackets(input));
    }
}
