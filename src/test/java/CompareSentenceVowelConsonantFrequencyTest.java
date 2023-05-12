import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CompareSentenceVowelConsonantFrequencyTest {
//    @Test
//    public void print() {
//        String[] input = {"hello, world!", "goodbye...", "testing?"};
//        String[] expectedOutput = {"consonants", "vowels", "consonants"};
//        System.out.println(Arrays.toString(StringTaskSolver.compareSentenceVowelConsonantFrequency(input)));
//    }

    @Test
    public void testCompareSentenceVowelConsonantFrequencyEmptyInput() {
        String[] input = {};
        String[] expectedOutput = {""};
        assertArrayEquals(expectedOutput, StringTaskSolver.compareSentenceVowelConsonantFrequency(input));
    }

    @Test
    public void testCompareSentenceVowelConsonantFrequencySingleWord() {
        String[] input = {"hello"};
        String[] expectedOutput = {"consonants"};
        assertArrayEquals(expectedOutput, StringTaskSolver.compareSentenceVowelConsonantFrequency(input));
    }

    @Test
    public void testCompareSentenceVowelConsonantFrequencyMultipleWords() {
        String[] input = {"hello world", "goodbye", "testing"};
        String[] expectedOutput = {"consonants", "vowels", "consonants"};
        assertArrayEquals(expectedOutput, StringTaskSolver.compareSentenceVowelConsonantFrequency(input));
    }

    @Test
    public void testCompareSentenceVowelConsonantFrequencyCaseInsensitivity() {
        String[] input = {"HelLO WoRLD", "GOOdbYE", "teStinG"};
        String[] expectedOutput = {"consonants", "vowels", "consonants"};
        assertArrayEquals(expectedOutput, StringTaskSolver.compareSentenceVowelConsonantFrequency(input));
    }

    @Test
    public void testCompareSentenceVowelConsonantFrequencyPunctuation() {
        String[] input = {"hello, world!", "goodbye...", "testing?"};
        String[] expectedOutput = {"consonants", "vowels", "consonants"};
        assertArrayEquals(expectedOutput, StringTaskSolver.compareSentenceVowelConsonantFrequency(input));
    }

    @Test
    public void testCompareSentenceVowelConsonantFrequencyEquals() {
        String[] input = {"AAAbbbiiiDDD", "1234asdfzxcv"};
        String[] expectedOutput = {"equals", "consonants"};
        assertArrayEquals(expectedOutput, StringTaskSolver.compareSentenceVowelConsonantFrequency(input));
    }
}
