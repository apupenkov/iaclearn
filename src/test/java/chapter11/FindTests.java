package chapter11;

import book.chapter11.CollectionSolver;
import help_modules.StringArrayConverter;
import help_modules.StringArrayConverterByAnd;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTests {
    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/createListDirectoryElementsTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    void createListDirectoryElementsTest(
            String input,
            @ConvertWith(StringArrayConverter.class) String[] expected) throws IOException {
        List<String> actual = new ArrayList<>();
        CollectionSolver.createListDirectoryElements(input, actual);
        assertArrayEquals(expected, actual.toArray());
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/getUniqueWordsTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    void getUniqueWordsTest(
            @ConvertWith(StringArrayConverter.class) String[] input,
            @ConvertWith(StringArrayConverter.class) String[] expected) {
        assertArrayEquals(expected, CollectionSolver.getUniqueWords(input).toArray());
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/getLastPersonTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    void getLastPersonTest(int count, int expected) {
        long startTimeArrayList = System.currentTimeMillis();
        assertEquals(expected, CollectionSolver.getLastPerson(new ArrayList<>(), count));
        long endTimeArrayList = System.currentTimeMillis();
        long executionTimeArrayList = endTimeArrayList - startTimeArrayList;
        System.out.println("Время выполнения ArrayList: " + executionTimeArrayList + " миллисекунд");

        long startTimeLinkedList = System.currentTimeMillis();
        assertEquals(expected, CollectionSolver.getLastPerson(new LinkedList<>(), count));
        long endTimeLinkedList = System.currentTimeMillis();
        long executionTimeLinkedList = endTimeLinkedList - startTimeLinkedList;
        System.out.println("Время выполнения LinkedList: " + executionTimeLinkedList + " миллисекунд");


    }
}
