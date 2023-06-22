package chapter11;

import book.chapter11.CollectionSolver;
import help_modules.StringArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifyTests {
    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/reverseArrayTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    void reverseArrayTest(
            @ConvertWith(StringArrayConverter.class) String[] input,
            @ConvertWith(StringArrayConverter.class) String[] expected) {
        assertArrayEquals(expected, CollectionSolver.reverseArray(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/reverseIntNumberTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    void reverseIntNumberTest(int input, int expected) {
        assertEquals(expected, CollectionSolver.reverseIntNumber(input));
    }
}
