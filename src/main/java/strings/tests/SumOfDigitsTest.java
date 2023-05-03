package strings.tests;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfDigitsTest {
    @Test
    public void testNoDigits() {
        String text = "Hello World!";
        int expectedSum = 0;
        int actualSum = StringTaskSolver.sumOfDigits(text);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSingleDigit() {
        String text = "The answer is 42";
        int expectedSum = 6;
        int actualSum = StringTaskSolver.sumOfDigits(text);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testMultipleDigits() {
        String text = "1, 2, 3, 4, 5, 6, 7, 8, 9";
        int expectedSum = 45;
        int actualSum = StringTaskSolver.sumOfDigits(text);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSpecialCharacters() {
        String text = "1@3#5$7%9";
        int expectedSum = 25;
        int actualSum = StringTaskSolver.sumOfDigits(text);
        assertEquals(expectedSum, actualSum);
    }
}
