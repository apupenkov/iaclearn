import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

public class СountWordOccurrencesTest {
    @Test
    void testCountWordOccurrencesEmptyString() {
        Map<String, Integer> result = StringTaskSolver.countWordOccurrences("");
        assertTrue(result.isEmpty());
    }

    @Test
    void testCountWordOccurrencesSingleWord() {
        Map<String, Integer> result = StringTaskSolver.countWordOccurrences("Hello");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("hello", 1);
        assertEquals(expected, result);
    }

    @Test
    void testCountWordOccurrencesMultipleWords() {
        Map<String, Integer> result = StringTaskSolver.countWordOccurrences("The quick brown fox jumps over the lazy dog");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("the", 2);
        expected.put("quick", 1);
        expected.put("brown", 1);
        expected.put("fox", 1);
        expected.put("jumps", 1);
        expected.put("over", 1);
        expected.put("lazy", 1);
        expected.put("dog", 1);
        assertEquals(expected, result);
    }

    @Test
    void testCountWordOccurrencesRepeatedWords() {
        Map<String, Integer> result = StringTaskSolver.countWordOccurrences("The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog.");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("the", 4);
        expected.put("quick", 2);
        expected.put("brown", 2);
        expected.put("fox", 2);
        expected.put("jumps", 2);
        expected.put("over", 2);
        expected.put("lazy", 2);
        expected.put("dog", 2);
        assertEquals(expected, result);
    }

    @Test
    void testCountWordOccurrencesPunctuation() {
        Map<String, Integer> result = StringTaskSolver.countWordOccurrences("The quick brown fox jumps over the lazy dog!");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("the", 2);
        expected.put("quick", 1);
        expected.put("brown", 1);
        expected.put("fox", 1);
        expected.put("jumps", 1);
        expected.put("over", 1);
        expected.put("lazy", 1);
        expected.put("dog", 1);
        assertEquals(expected, result);
    }
}
