import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordsWithSameFirstAndLastCharacterTest {
    @Test
    public void testWordsWithSameFirstAndLast_NoWords() {
        String input = "";
        String[] expectedOutput = new String[0];
        assertArrayEquals(expectedOutput, StringTaskSolver.wordsWithSameFirstAndLastCharacter(input));
    }

    @Test
    public void testWordsWithSameFirstAndLast_SingleMatch() {
        String input = "This is a test";
        String[] expectedOutput = {"test"};
        assertArrayEquals(expectedOutput, StringTaskSolver.wordsWithSameFirstAndLastCharacter(input));
    }

    @Test
    public void testWordsWithSameFirstAndLast_SingleMatch2() {
        String input = "Anna likes apples";
        String[] expectedOutput = {"Anna"};
        assertArrayEquals(expectedOutput, StringTaskSolver.wordsWithSameFirstAndLastCharacter(input));
    }

    @Test
    public void testPrintWordsWithSameFirstAndLast_NoMatches() {
        String input = "Eva saw a cave and felt awed";
        String[] expectedOutput = new String[0];
        assertArrayEquals(expectedOutput, StringTaskSolver.wordsWithSameFirstAndLastCharacter(input));
    }

    @Test
    public void testPrintWordsWithSameFirstAndLast_MultipleMatchesWithDuplicates() {
        String input = "A man and a Anna ran, and then the Anna bit the man";
        String[] expectedOutput = {"Anna"};
        assertArrayEquals(expectedOutput, StringTaskSolver.wordsWithSameFirstAndLastCharacter(input));
    }
}
