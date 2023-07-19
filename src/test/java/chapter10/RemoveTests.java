package chapter10;

import book.chapter10.StreamInputOutputUtil;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class RemoveTests {
    @Nested
    class RemoveWordsByLength {
        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ValueSource(
                strings = {
                        "data/remove/file1.txt",
                        "data/remove/file2.txt",
                        "data/remove/file3.txt",
                        "data/remove/file4.txt"
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

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ValueSource(
                strings = {
                        "data/remove/file5.txt",
                }
        )
        public void removeWordsOfSpecificLengthThrowFileNotFoundTest(String path) {
            assertThrows(FileNotFoundException.class, () -> StreamInputOutputUtil.removeWordsOfSpecificLength(path, 7, 10));
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvSource(
                {"file1,-15,5", "data/remove/file1,15,5"}
        )
        public void removeWordsOfSpecificLengthThrowIllegalArgumentTest(String path, int start, int end) {
            assertThrows(IllegalArgumentException.class, () -> StreamInputOutputUtil.removeWordsOfSpecificLength(path, start, end));
        }
    }
}
