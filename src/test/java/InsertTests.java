import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertTests {

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvSource( value ={
            "'':'':1:a",
            "     :'':1:a",
            "Hello, World!:Hello, Java World!:7:'Java '",
            "Hello, World!:Hello, World!:-1:Java ",
            "Hello, World!:Hello, World!Java :13:Java ",
            "NULL:'':7:Java ",
    }, delimiter = ':', nullValues = {"NULL"})
    void insertSubstringByIndexTest(String input, String expected, int index, String substring) {
        assertEquals(expected, StringTaskSolver.insertSubstringByIndex(input, index, substring));
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvSource( value ={
            "'':'':a:a",
            "     :'':a:a",
            "The quick brown fox jumps over the lazy dog.:The quick brown fox jumpsover over the lazy dog.:s:over",
            "Hello world:Hello world:ing:blablabla",
            "Hello world:Hello world:'':over",
            "Hello world:Hello world:llo:''"
    }, delimiter = ':', nullValues = {"NULl"})
    void insertWordAfterSubstringTest(String input, String expected, String substring, String word) {
        assertEquals(expected, StringTaskSolver.insertWordAfterSubstring(input, substring, word));
    }


}
