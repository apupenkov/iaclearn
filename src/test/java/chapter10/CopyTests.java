package chapter10;

import book.chapter10.StreamInputOutputUtil;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.nio.file.Paths;

public class CopyTests {
    @Nested
    class CopyDirectory {
        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvSource(value = {
                "src,destination"
        })
        public void copyDirectory(String source, String target) {
            StreamInputOutputUtil.copyDirectory(Paths.get(source), Paths.get(target));
        }
    }
}
