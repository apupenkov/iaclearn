package chapter10;

import chapter10.ArgumentsProviders.CalculateCountWordsInFileArgumentsProvider;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static book.chapter10.StreamInputOutputUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTests {
    @Nested
    class CalculateCountWords {
        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ArgumentsSource(CalculateCountWordsInFileArgumentsProvider.class)
        public void calculateCountWordsInFileTest(String path, long count) {
            assertEquals(calculateCountWordsInFileNIO(path), count);
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ArgumentsSource(CalculateCountWordsInFileArgumentsProvider.class)
        public void calculateCountWordsInFileNIOReadAllLinesTest(String path, long count) {
            assertEquals(calculateCountWordsInFileNIOReadAllLines(path), count);
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ArgumentsSource(CalculateCountWordsInFileArgumentsProvider.class)
        public void calculateCountWordsInFileNIOStreamTest(String path, long count) {
            assertEquals(calculateCountWordsInFileNIOStream(path), count);
        }
    }
}
