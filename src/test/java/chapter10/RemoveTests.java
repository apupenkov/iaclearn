package chapter10;

import book.chapter10.StreamInputOutputUtil;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.fail;

public class RemoveTests {
    @Nested
    class RemoveWordsByLength {
        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ValueSource(
                strings = {
                        "data/remove/file1.txt",
                        "data/remove/file2.txt",
                        "data/remove/file3.txt"
                }
        )
        public void removeWordsOfSpecificLengthTest(String path) {
            try {
                StreamInputOutputUtil.removeWordsOfSpecificLength(path, 3, 5);
            } catch (Exception e) {
                e.printStackTrace();
                fail();
            }
        }
    }
}
