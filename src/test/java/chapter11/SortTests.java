package chapter11;

import book.chapter11.CollectionSolver;
import help_modules.StringArrayConverter;
import help_modules.StringArrayConverterByAnd;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/sortBuCollectionsTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    void sortBuCollectionsTest(
            @ConvertWith(StringArrayConverterByAnd.class) String[] input,
            @ConvertWith(StringArrayConverterByAnd.class) String[] expected) {
        System.out.println(CollectionSolver.sortByCollections(input));
//        assertEquals(Arrays.stream(expected).toList(), CollectionSolver.sortByCollections(input));
    }

}
