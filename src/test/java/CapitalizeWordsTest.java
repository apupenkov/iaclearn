import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapitalizeWordsTest {
    @Test
    public void testCapitalizeWordsEmptyString() {
        String input = "";
        String expected = "";
        String result = StringTaskSolver.capitalizeWords(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCapitalizeWordsAllCaps() {
        String input = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.";
        String expected = "The Quick Brown Fox Jumps Over The Lazy Dog.";
        String result = StringTaskSolver.capitalizeWords(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCapitalizeWordsMixedCaps() {
        String input = "ThE QuiCk brOwN foX jumPs oVeR thE laZy doG.";
        String expected = "The Quick Brown Fox Jumps Over The Lazy Dog.";
        String result = StringTaskSolver.capitalizeWords(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCapitalizeWordsWithPunctuation() {
        String input = "hello, world! my na-me is j'ohn.";
        String expected = "Hello, World! My na-me Is j'ohn.";
        String result = StringTaskSolver.capitalizeWords(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCapitalizeWordsSingleWord() {
        String input = "hello";
        String expected = "Hello";
        String result = StringTaskSolver.capitalizeWords(input);
        assertEquals(expected, result);
    }

}
