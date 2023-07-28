package chapter10;

import chapter10.ArgumentsProviders.FindFilesByKeyWordArgumentsProvider;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.Map;

import static book.chapter10.StreamInputOutputUtil.findListFilesByWordContent;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FindTests {
    @Nested
    class FindFilesByKeyWord {
        @ParameterizedTest(name = "{index} - {displayName}")
        @ArgumentsSource(FindFilesByKeyWordArgumentsProvider.class)
        public void findListFilesByWordContentTest(String path, String keyword, Map<String, Integer> result) {
            try {
                assertEquals(result, findListFilesByWordContent(path, keyword));
            } catch (IOException e) {
                e.printStackTrace();
                fail();
            }
        }

    }
}
