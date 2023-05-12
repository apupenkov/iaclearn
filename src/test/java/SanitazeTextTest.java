import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.*;

public class SanitazeTextTest {
    @Test
    void testSanitizeTextWithPunctuation() {
        String input = "Hello, World!";
        String expected = "Hel lo World";
        String actual = StringTaskSolver.sanitizeText(input);
        assertEquals(expected, actual);
    }

    @Test
    void testSanitizeTextWithConsecutiveCharacters() {
        String input = "aabbcc";
        String expected = "a ab bc c";
        String actual = StringTaskSolver.sanitizeText(input);
        assertEquals(expected, actual);
    }

    @Test
    void testSanitizeTextWithNumbers() {
        String input = "1a2b3c4d";
        String expected = "abcd";
        String actual = StringTaskSolver.sanitizeText(input);
        assertEquals(expected, actual);
    }

    @Test
    void testSanitizeTextWithEmptyString() {
        String input = "";
        String expected = "";
        String actual = StringTaskSolver.sanitizeText(input);
        assertEquals(expected, actual);
    }

    @Test
    void testSanitizeTextWithNullString() {
        String input = null;
        String expected = "";
        String actual = StringTaskSolver.sanitizeText(input);
        assertEquals(expected, actual);
    }
}
