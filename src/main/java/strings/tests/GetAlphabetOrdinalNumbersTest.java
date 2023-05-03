package strings.tests;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class GetAlphabetOrdinalNumbersTest {
    @Test
    public void testGetAlphabetOrdinalNumbersWithSingleCharacter() {
        String input = "a";
        String expected = "1";
        String actual = StringTaskSolver.getAlphabetOrdinalNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAlphabetOrdinalNumbers() {
        String input = "Hello World";
        String expected = "8 5 12 12 15 23 15 18 12 4";
        String actual = StringTaskSolver.getAlphabetOrdinalNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAlphabetOrdinalNumbersEmptyInput() {
        String input = "";
        String expected = "";
        String actual = StringTaskSolver.getAlphabetOrdinalNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAlphabetOrdinalNumbersWithUppercaseLetters() {
        String input = "Testing Function with UPPERCASE Letters";
        String expected = "20 5 19 20 9 14 7 6 21 14 3 20 9 15 14 23 9 20 8 21 16 16 5 18 3 1 19 5 12 5 20 20 5 18 19";
        String actual = StringTaskSolver.getAlphabetOrdinalNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAlphabetOrdinalNumbersWithNumbersAndSpecialChars() {
        String input = "Testing Function with Numbers 123 and Special Ch@racters";
        String expected = "20 5 19 20 9 14 7 6 21 14 3 20 9 15 14 23 9 20 8 14 21 13 2 5 18 19 1 14 4 19 16 5 3 9 1 12 3 8 18 1 3 20 5 18 19";
        String actual = StringTaskSolver.getAlphabetOrdinalNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAlphabetOrdinalNumbersWithWhitespaceOnly() {
        String input = "     ";
        String expected = "";
        String actual = StringTaskSolver.getAlphabetOrdinalNumbers(input);
        assertEquals(expected, actual);
    }
}
