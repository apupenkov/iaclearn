package strings.tests;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.*;

public class InsertWordAfterSubstringTest {
    @Test
    void testInsertAfterWord() {
        String input = "The quick brown fox jumps over the lazy dog.";
        String expected = "The quick brown fox jumps over over the lazy dog.";
        String actual = StringTaskSolver.insertWordAfterSubstring(input, "s", "over");
        assertEquals(expected, actual);
    }

    @Test
    void testInsertAfterWordNoMatch() {
        String input = "The quick brown fox jumps over the lazy dog.";
        String expected = "The quick brown fox jumps over the lazy dog.";
        String actual = StringTaskSolver.insertWordAfterSubstring(input, "z", "over");
        assertEquals(expected, actual);
    }

    @Test
    void testInsertAfterWordEmptyInput() {
        String input = "";
        String expected = "";
        String actual = StringTaskSolver.insertWordAfterSubstring(input, "s", "over");
        assertEquals(expected, actual);
    }
}
