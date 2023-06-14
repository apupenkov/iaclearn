import book.chapter7.tasks.FunctionSolver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FilterTests {
    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/filterItemsArrayByValueTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void filterItemsArrayByValueTest(
        @ConvertWith(StringArrayConverter.class) String[] input,
        int size,
        @ConvertWith(StringArrayConverter.class) String[] expected
    ) {
        UnaryOperator<String[]> actual = arr -> {
            if (arr.length == 1 && arr[0] == "") return new String[]{};
            else return arr;
        };
        assertArrayEquals(expected, FunctionSolver.filterItemsArrayByValue(actual.apply(input), size));
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/filterByStartLetterAndSizeTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void filterByStartLetterAndSizeTest(
            @ConvertWith(StringArrayConverter.class) String[] input,
            char letter,
            int size,
            @ConvertWith(StringArrayConverter.class) String[] expected
    ) {
        assertArrayEquals(expected, FunctionSolver.filterByStartLetterAndSize(input, letter, size));
    }
}