import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindLongestNonLetterSubstringTest {
    @Test
    public void testFindLongestNonLetterSubstring() {
        String input = "abc123def456ghij";
        String expected = "123";
        String actual = StringTaskSolver.findLongestNonLetterSubstring(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindLongestNonLetterSubstring2() {
        String input = "1a2b3c4d5e6f7g8h9i0j";
        String expected = "1";
        String actual = StringTaskSolver.findLongestNonLetterSubstring(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindLongestNonLetterSubstring3() {
        String input = "aBcDeFgHiJkLmNoPqRsTuVwXyZ";
        String expected = "";
        String actual = StringTaskSolver.findLongestNonLetterSubstring(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindLongestNonLetterSubstring4() {
        String input = "Hello, world! This is a test.";
        String expected = ", ";
        String actual = StringTaskSolver.findLongestNonLetterSubstring(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindLongestNonLetterSubstring5() {
        String input = "This is a test without any non-letter characters.";
        String expected = " ";
        String actual = StringTaskSolver.findLongestNonLetterSubstring(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindLongestNonLetterSubstring_WithNumbers() {
        String input = "12345hello1234567world98765";
        String expected = "1234567";
        String actual = StringTaskSolver.findLongestNonLetterSubstring(input);
        assertEquals(expected, actual);
    }

}
