import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountWordsStartEndWithVowelTest {
    @Test
    public void testCountWordsStartEndWithVowel_EmptyInput() {
        String[] input = {};
        assertEquals(0, StringTaskSolver.countWordsStartEndWithVowel(input));
    }

    @Test
    public void testCountWordsStartEndWithVowel_NoWordsStartEndWithVowel() {
        String[] input = {"hello", "world", "java", "programming"};
        assertEquals(0, StringTaskSolver.countWordsStartEndWithVowel(input));
    }

    @Test
    public void testCountWordsStartEndWithVowel_SingleWordStartEndWithVowel() {
        String[] input = {"apple"};
        assertEquals(1, StringTaskSolver.countWordsStartEndWithVowel(input));
    }

    @Test
    public void testCountWordsStartEndWithVowel_MultipleWordsStartEndWithVowel() {
        String[] input = {"And", "the", "apple", "of", "my", "eye", "is", "vowel"};
        assertEquals(2, StringTaskSolver.countWordsStartEndWithVowel(input));
    }

    @Test
    public void testCountWordsStartEndWithVowel_MixedCaseWords() {
        String[] input = {"And", "the", "AppLe", "of", "my", "eye", "is", "a", "Vowel"};
        assertEquals(2, StringTaskSolver.countWordsStartEndWithVowel(input));
    }
}
