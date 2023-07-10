package chapter11;

import book.chapter11.CollectionSolver;
import help_modules.IntArrayConverter;
import help_modules.StringArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountTests {
    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/countWordsTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    void countWordsTest(
            @ConvertWith(StringArrayConverter.class) String[] input,
            @ConvertWith(StringArrayConverter.class) String[] expectedKeys,
            @ConvertWith(IntArrayConverter.class) int[] expectedValues) {
        Map<String, Integer> actual = new HashMap<>();

//        Map<String, Integer> actual = CollectionSolver.countWords(input);

        for (int i = 0; i < expectedKeys.length; i++) {
            actual.put(expectedKeys[i], expectedValues[i]);
        }
//        actual.keySet().forEach(e -> System.out.print(e + ", "));
//        actual.values().forEach(e -> System.out.print(e + ","));
        assertEquals(actual, CollectionSolver.countWords(input));
    }
}
