package chapter11;

import book.chapter11.CollectionSolver;
import book.chapter11.entities.Line;
import book.chapter11.entities.Point;
import help_modules.IntArrayConverter;
import help_modules.StringArrayConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

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

    @Nested
    @DisplayName("Testing methods from task B16")
    class LinePoint {
        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ArgumentsSource(LineArgumentProvider.class)
        void getLinesThroughPointsTest(List<Point> points, List<Line> lines, Map<Line, Set<Point>> expected) {
            assertEquals(expected, CollectionSolver.getLinesThroughPoints(lines, new HashSet<>(points)));
        }
//        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
//        @CsvFileSource(
//                resources = "/getLinesThroughPointsTest.csv",
//                delimiter = ';',
//                nullValues = {"NULL"},
//                numLinesToSkip = 1
//        )
//        void getLinesThroughPointsTest(
//                @ConvertWith(StringArrayConverter.class) String[] inputPoints,
//                @ConvertWith(StringArrayConverter.class) String[] inputLines,
//                @ConvertWith(StringArrayConverter.class) String[] expectedLines) {
//            List<Point> points = new ArrayList<>();
//            for (String point : inputPoints) {
//                points.add(new Point(Integer.parseInt(point.split("\\|")[0]), Integer.parseInt(point.split("\\|")[1])));
//            }
//
//            List<Line> lines = new ArrayList<>();
//            for (String line : inputLines) {
//                lines.add(new Line(
//                        new Point(Integer.parseInt(line.split("\\/")[0].split("\\|")[0]),
//                                Integer.parseInt(line.split("\\/")[0].split("\\|")[1])),
//                        new Point(Integer.parseInt(line.split("\\/")[1].split("\\|")[0]),
//                                Integer.parseInt(line.split("\\/")[1].split("\\|")[1]))));
//            }
//
//            points.forEach(System.out::println);
//            lines.forEach(System.out::println);
//        }
    }
}

class LineArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
            Arguments.of(
                    Arrays.asList(
                            new Point(1, 1),
                            new Point(1, 2),
                            new Point(1, 3),
                            new Point(1, 4),
                            new Point(2, 1),
                            new Point(2, 2),
                            new Point(2, 3),
                            new Point(2, 4),
                            new Point(3, 1),
                            new Point(3, 2),
                            new Point(3, 3),
                            new Point(3, 4),
                            new Point(4, 1),
                            new Point(4, 2),
                            new Point(4, 3),
                            new Point(4, 4)
                    ),
                    Arrays.asList(
                            new Line(
                                    new Point(1, 1),
                                    new Point(1, 4)
                            ),
                            new Line(
                                    new Point(1, 1),
                                    new Point(4, 4)
                            ),
                            new Line(
                                    new Point(1, 2),
                                    new Point(4, 2)
                            ),
                            new Line(
                                    new Point(1, 1),
                                    new Point(1, 2)
                            )
                    ),
                    new HashMap<Line, Set<Point>>() {{
                        put(
                                new Line(new Point(1, 1), new Point(1, 4)),
                                new HashSet<>(Arrays.asList(
                                        new Point(1, 2),
                                        new Point(1, 3)
                                )));
                        put(
                                new Line(new Point(1, 1), new Point(4, 1)),
                                new HashSet<>(Arrays.asList(
                                        new Point(2, 1),
                                        new Point(3, 1)
                                )));
                        put(
                                new Line(new Point(1, 2), new Point(4, 2)),
                                new HashSet<>(Arrays.asList(
                                        new Point(2, 2),
                                        new Point(3, 2)
                                )));
                    }}
            )
        );
    }
}