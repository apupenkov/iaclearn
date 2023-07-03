package chapter11;

import book.chapter11.CollectionSolver;
import book.chapter11.entities.Line;
import book.chapter11.entities.Point;
import chapter11.ArgumentsProviders.GetLinesArgumentsProvider;
import chapter11.ArgumentsProviders.GetPointsArgumentsProvider;
import chapter11.ArgumentsProviders.LineArgumentProvider;
import help_modules.IntArrayConverter;
import help_modules.StringArrayConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvFileSource(
                resources = "/getListStringTest.csv",
                delimiter = ';',
                nullValues = {"NULL"},
                numLinesToSkip = 1
        )
        void getListStringTest(
                @ConvertWith(IntArrayConverter.class) int[] inputKeys,
                @ConvertWith(StringArrayConverter.class) String[] inputValues,
                @ConvertWith(StringArrayConverter.class) String[] resultValues) {
            Map<Integer, String> input = new HashMap<>();

            for (int i = 0; i < inputKeys.length; i++) {
                input.put(inputKeys[i], inputValues[i]);
            }
            assertArrayEquals(resultValues, CollectionSolver.getListString(input).toArray());
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvFileSource(
                resources = "/sumKeysByMoreValueTest.csv",
                delimiter = ';',
                nullValues = {"NULL"},
                numLinesToSkip = 1
        )
        void sumKeysByMoreValueTest(
                @ConvertWith(IntArrayConverter.class) int[] inputKeys,
                @ConvertWith(StringArrayConverter.class) String[] inputValues,
                int value,
                int summ) {
            Map<Integer, String> input = new HashMap<>();

            for (int i = 0; i < inputKeys.length; i++) {
                input.put(inputKeys[i], inputValues[i]);
            }
            assertEquals(summ, CollectionSolver.sumKeysByMoreValue(input, value));
        }

    }

    @Nested
    @DisplayName("Testing methods from task A6")
    class SetFind {
        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvFileSource(
                resources = "/findIntersectionTest.csv",
                delimiter = ';',
                nullValues = {"NULL"},
                numLinesToSkip = 1
        )
        void findIntersectionTest(
                @ConvertWith(IntArrayConverter.class) int[] array1,
                @ConvertWith(IntArrayConverter.class) int[] array2,
                @ConvertWith(IntArrayConverter.class) int[] expected
        ) {
            Set<Integer> set = Arrays.stream(expected).boxed().collect(Collectors.toSet());
            if (expected.length > 1 && expected[0] == expected[1]) set = null;
            assertEquals(set, CollectionSolver.findIntersection(
                    Arrays.stream(array1).boxed().collect(Collectors.toSet()),
                    Arrays.stream(array2).boxed().collect(Collectors.toSet())));
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvFileSource(
                resources = "/findUnionTest.csv",
                delimiter = ';',
                nullValues = {"NULL"},
                numLinesToSkip = 1
        )
        void findUnionTest(
                @ConvertWith(IntArrayConverter.class) int[] array1,
                @ConvertWith(IntArrayConverter.class) int[] array2,
                @ConvertWith(IntArrayConverter.class) int[] expected
        ) {
            Set<Integer> set = Arrays.stream(expected).boxed().collect(Collectors.toSet());
            if (expected.length > 1 && expected[0] == expected[1]) set = null;
            assertEquals(set, CollectionSolver.findUnion(
                    Arrays.stream(array1).boxed().collect(Collectors.toSet()),
                    Arrays.stream(array2).boxed().collect(Collectors.toSet())));
        }
    }

    @Nested
    @DisplayName("Testing methods from task B16")
    class LinePoint {
        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ArgumentsSource(GetPointsArgumentsProvider.class)
        void getPointsTest(List<Point> input, List<Point> expected) {
            assertEquals(input, expected);
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ArgumentsSource(GetLinesArgumentsProvider.class)
        void getLinesTest(List<Line> input, List<Line> expected) {
            assertEquals(input, expected);
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ArgumentsSource(LineArgumentProvider.class)
        void getLinesThroughPointsTest(List<Point> points, List<Line> lines, Map<Line, Set<Point>> expected) {
            assertEquals(expected, CollectionSolver.getLinesThroughPoints(lines, new HashSet<>(points)));
        }
    }
}