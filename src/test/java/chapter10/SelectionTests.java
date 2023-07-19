package chapter10;

import book.chapter10.StreamInputOutputUtil;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class SelectionTests {
    @Nested
    class SelectionWordsInRows {
        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvSource(
                {
                        "data/remove/file1.txt,data/remove/file1.txt.tmp,-1,5",
                        "data/remove/file1.txt,data/remove/file1.txt.tmp,5,-4"
                }
        )
        public void saveLastMWordsThrowIllegalArgumentTest(String inputPath, String outputPath, int n, int m) {
            assertThrows(IllegalArgumentException.class, () -> StreamInputOutputUtil.saveLastMWords(inputPath, outputPath + ".tmp1", n, m));
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvSource(
                {
                        "lajfkljasldkf,data/remove/file1.txt.tmp,5,5",
                        "data/remove/file15324.txt,data/remove/file1.txt.tmp,5,5"
                }
        )
        public void saveLastMWordsThrowFileNotFoundTest(String inputPath, String outputPath, int n, int m) {
            assertThrows(FileNotFoundException.class, () -> StreamInputOutputUtil.saveLastMWords(inputPath, outputPath + ".tmp1", n, m));
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvSource(
                {
                        "data/remove/file1.txt,data/remove/file1.txt.tmp,2,2",
                        "data/remove/file2.txt,data/remove/file2.txt.tmp,3,3",
                        "data/remove/file3.txt,data/remove/file3.txt.tmp,3,3",
                        "data/remove/file4.txt,data/remove/file4.txt.tmp,3,3",
                }
        )
        public void saveLastMWordsTest(String inputPath, String outputPath, int n, int m) {
            try {
                StreamInputOutputUtil.saveLastMWords(inputPath, outputPath + ".tmp1", n, m);
            } catch (Exception e) {
                e.printStackTrace();
                fail();
            }
        }
    }
}
