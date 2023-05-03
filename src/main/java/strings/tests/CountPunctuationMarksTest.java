package strings.tests;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountPunctuationMarksTest {
    @Test
    public void testCountPunctuationMarks_emptyInput_returnsZero() {
        assertEquals(0, StringTaskSolver.countPunctuationMarks(""));
    }

    @Test
    public void testCountPunctuationMarks_nullInput_returnsZero() {
        assertEquals(0, StringTaskSolver.countPunctuationMarks(null));
    }

    @Test
    public void testCountPunctuationMarks_noPunctuationMarks_returnsZero() {
        assertEquals(0, StringTaskSolver.countPunctuationMarks("This text contains no punctuation marks"));
    }

    @Test
    public void testCountPunctuationMarks_multiplePunctuationMarks_returnsCorrectCount() {
        assertEquals(4, StringTaskSolver.countPunctuationMarks("This text contains 2 commas, 1 period. 1 exclamation mark! and 1 question mark?"));
    }

    @Test
    public void testCountPunctuationMarks_onlyPunctuationMarks_returnsCorrectCount() {
        assertEquals(8, StringTaskSolver.countPunctuationMarks(".,;:!??!"));
    }

}
