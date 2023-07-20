package chapter10;

import book.chapter10.StreamInputOutputUtil;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ComparisonTests {
    @Nested
    class ComparisonFiles {
        @ParameterizedTest(name = "Tested {index} {displayName}")
        @CsvSource(value =
                {
                        "src/test/resources/chapter10/file1.txt,src/test/resources/chapter10/file2.txt,false",
                        "src/test/resources/chapter10/file2.txt,src/test/resources/chapter10/file3.txt,false",
                        "src/test/resources/chapter10/file1.txt,src/test/resources/chapter10/file1.txt,true",
                }
        )
        public void fileEqualsTest(String path1, String path2, boolean actual) {
            try {
                assertEquals(StreamInputOutputUtil.fileEquals(Paths.get(path1), Paths.get(path2)), actual);
            } catch (IOException e) {
                e.printStackTrace();
                fail();
            }
        }
    }
}
