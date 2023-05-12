import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.*;

public class ModifyStringArrayTest {
    @Test
    void testModifyStringArrayInsert() {
        String[] input = {"hello", "world", "java"};
        String[] expected = {"he+llo", "wo+rld", "ja+va"};
        String[] actual = StringTaskSolver.modifyStringArray(input, false, "+", 2);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testModifyStringArrayDelete() {
        String[] input = {"hello", "world", "java"};
        String[] expected = {"heo", "word", "java"};
        String[] actual = StringTaskSolver.modifyStringArray(input, true, "l", 0);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testModifyStringArrayInvalidIndex() {
        String[] input = {"hello", "world", "java"};
        String[] expected = {"hello", "world", "java"};
        String[] actual = StringTaskSolver.modifyStringArray(input, false, "+", -1);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testModifyStringArrayNullCharacter() {
        String[] input = {"hello", "world", "java"};
        String[] expected = {"hello", "world", "java"};
        String[] actual = StringTaskSolver.modifyStringArray(input, false, null, 3);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testModifyStringArrayEmptyCharacter() {
        String[] input = {"hello", "world", "java"};
        String[] expected = {"hello", "world", "java"};
        String[] actual = StringTaskSolver.modifyStringArray(input, false, "", 4);
        assertArrayEquals(expected, actual);
    }
}
