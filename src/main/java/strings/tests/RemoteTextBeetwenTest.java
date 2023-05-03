package strings.tests;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.*;

public class RemoteTextBeetwenTest {
    @Test
    void testRemoveTextBetweenWithStartAndEndCharsPresent() {
        String input = "Hello (world)!";
        char startChar = '(';
        char endChar = ')';
        String expected = "Hello !";
        String actual = StringTaskSolver.removeTextBetween(input, startChar, endChar);
        assertEquals(expected, actual);
    }

    @Test
    void testRemoveTextBetweenWithStartCharNotPresent() {
        String input = "Hello world!";
        char startChar = '(';
        char endChar = ')';
        String expected = "Hello world!";
        String actual = StringTaskSolver.removeTextBetween(input, startChar, endChar);
        assertEquals(expected, actual);
    }

    @Test
    void testRemoveTextBetweenWithEndCharNotPresent() {
        String input = "Hello (world!";
        char startChar = '(';
        char endChar = ')';
        String expected = "Hello (world!";
        String actual = StringTaskSolver.removeTextBetween(input, startChar, endChar);
        assertEquals(expected, actual);
    }

    @Test
    void testRemoveTextBetweenWithEmptyString() {
        String input = "";
        char startChar = '(';
        char endChar = ')';
        String expected = "";
        String actual = StringTaskSolver.removeTextBetween(input, startChar, endChar);
        assertEquals(expected, actual);
    }

    @Test
    void testRemoveTextBetweenWithNullString() {
        String input = null;
        char startChar = '(';
        char endChar = ')';
        String expected = "";
        String actual = StringTaskSolver.removeTextBetween(input, startChar, endChar);
        assertEquals(expected, actual);
    }
}
