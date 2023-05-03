package strings.tests;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindCommonLettersTest {
    @Test
    public void testFindCommonLetters() {
        String poem = "Lorem oem doem fiem";
        char[] expected = {'e', 'm'};
        assertArrayEquals(expected, StringTaskSolver.findCommonLetters(poem));
    }

    @Test
    public void testFindCommonLettersEmpty() {
        String poem = "";
        char[] expected = {};
        assertArrayEquals(expected, StringTaskSolver.findCommonLetters(poem));
    }

    @Test
    public void testFindCommonLettersNoCommon() {
        String poem = "This is a test";
        char[] expected = {};
        assertArrayEquals(expected, StringTaskSolver.findCommonLetters(poem));
    }

}
