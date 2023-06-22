package chapter11;

import book.chapter11.CollectionSolver;
import help_modules.StringArrayConverter;
import help_modules.StringArrayConverterByAnd;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTests {
    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/sortByLengthTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    void sortByLengthTest(
            @ConvertWith(StringArrayConverterByAnd.class) String[] input,
            @ConvertWith(StringArrayConverterByAnd.class) String[] expected) {
        assertArrayEquals(expected, CollectionSolver.sortByLength(input));
    }
}
