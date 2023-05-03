package strings.tests;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindMinMaxWordsTest {
    @Test
    void testFindMinMaxWordsWithEmptyInput() {
        String input = "";
        String[] expected = new String[]{};
        String[] actual = StringTaskSolver.findMinMaxWords(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFindMinMaxWordsWithOneWord() {
        String input = "hello";
        String[] expected = new String[]{"hello"};
        String[] actual = StringTaskSolver.findMinMaxWords(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFindMinMaxWordsWithTwoWordsOfSameLength() {
        String input = "hello world";
        String[] expected = new String[]{"hello", "world"};
        String[] actual = StringTaskSolver.findMinMaxWords(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFindMinMaxWordsWithTwoWordsOfDifferentLengths() {
        String input = "hi world";
        String[] expected = new String[]{"hi", "world"};
        String[] actual = StringTaskSolver.findMinMaxWords(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFindMinMaxWordsWithManyWords() {
        String input = "the quick brown fox jumps over the lazy dog";
        String[] expected = new String[]{"the", "fox", "dog", "quick", "brown", "jumps"};
        String[] actual = StringTaskSolver.findMinMaxWords(input);
        assertArrayEquals(expected, actual);
    }

}
