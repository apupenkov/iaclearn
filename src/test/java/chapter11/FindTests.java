package chapter11;

import book.chapter11.CollectionSolver;
import help_modules.IntArrayConverter;
import help_modules.StringArrayConverter;
import help_modules.StringArrayConverterByAnd;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

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

    @Nested
    @DisplayName("Testing problem #16 which includes several different methods")
    public class Task16 {
        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvFileSource(
                resources = "/findStringByKeyMoreValueTest.csv",
                delimiter = ';',
                nullValues = {"NULL"},
                numLinesToSkip = 1
        )
        void findStringByKeyMoreValueTest(
                @ConvertWith(IntArrayConverter.class) int[] inputKeys,
                @ConvertWith(StringArrayConverter.class) String[] inputValues,
                int value,
                @ConvertWith(IntArrayConverter.class) int[] resultKeys,
                @ConvertWith(StringArrayConverter.class) String[] resultValues) {
            Map<Integer, String> input = new HashMap<>();

            for (int i = 0; i < inputKeys.length; i++) {
                input.put(inputKeys[i], inputValues[i]);
            }

            Map<Integer, String> expected = new HashMap<>();

            for (int i = 0; i < resultKeys.length; i++) {
                expected.put(resultKeys[i], resultValues[i]);
            }
            assertEquals(expected, CollectionSolver.findStringByKeyMoreValue(input, value));
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvFileSource(
                resources = "/findStringByKeyTest.csv",
                delimiter = ';',
                nullValues = {"NULL"},
                numLinesToSkip = 1
        )
        void findStringByKeyTest(
                @ConvertWith(IntArrayConverter.class) int[] inputKeys,
                @ConvertWith(StringArrayConverter.class) String[] inputValues,
                int value,
                @ConvertWith(IntArrayConverter.class) int[] resultKeys,
                @ConvertWith(StringArrayConverter.class) String[] resultValues) {
            Map<Integer, String> input = new HashMap<>();

            for (int i = 0; i < inputKeys.length; i++) {
                input.put(inputKeys[i], inputValues[i]);
            }

            Map<Integer, String> expected = new HashMap<>();

            for (int i = 0; i < resultKeys.length; i++) {
                expected.put(resultKeys[i], resultValues[i]);
            }
            assertEquals(expected, CollectionSolver.findStringByKey(input, value));
        }
    }
}
