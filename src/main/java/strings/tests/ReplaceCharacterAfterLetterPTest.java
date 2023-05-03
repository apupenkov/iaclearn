package strings.tests;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplaceCharacterAfterLetterPTest {
    @Test
    public void testReplaceCharacterAfterLetterPWithNullString() {
        String input = null;
        String expected = "";
        String actual = StringTaskSolver.replaceCharacterAfterLetterP(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testReplaceCharacterAfterLetterPWithEmptyString() {
        String input = "";
        String expected = "";
        String actual = StringTaskSolver.replaceCharacterAfterLetterP(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testReplaceCharacterAfterLetterPWithNoLetterP() {
        String input = "hello world";
        String expected = "hello world";
        String actual = StringTaskSolver.replaceCharacterAfterLetterP(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testReplaceCharacterAfterLetterPWithLetterPNotFollowedByA() {
        String input = "happy people jump high";
        String expected = "happy people jump high";
        String actual = StringTaskSolver.replaceCharacterAfterLetterP(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testReplaceCharacterAfterLetterPWithLetterPFollowedByA() {
        String input = "apple paar peach";
        String expected = "apple poar peach";
        String actual = StringTaskSolver.replaceCharacterAfterLetterP(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testReplaceCharacterAfterLetterPWithLetterPAtEndOfWord() {
        String input = "pumpkin stamp loop";
        String expected = "pumpkin stamp loop";
        String actual = StringTaskSolver.replaceCharacterAfterLetterP(input);
        assertEquals(expected, actual);
    }
}
