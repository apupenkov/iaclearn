import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import strings.StringTaskSolver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class FindTest {

    @Test
    public void countWordOccurrencesEmptyStringTest() {
        Map<String, Integer> result = StringTaskSolver.countWordOccurrences("");
        assertTrue(result.isEmpty());
    }

    @Test
    public void countWordOccurrencesSingleWordTest() {
        Map<String, Integer> result = StringTaskSolver.countWordOccurrences("Hello");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("hello", 1);
        assertEquals(expected, result);
    }

    @Test
    public void countWordOccurrencesMultipleWordsTest() {
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
    public void countWordOccurrencesRepeatedWordsTest() {
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
    public void countWordOccurrencesPunctuationTest() {
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

    @Test
    public void mostFrequentCharactersWithEmptyStringTest() {
        String input = "";
        int top = 5;
        Map<Character, Integer> actual = StringTaskSolver.mostFrequentCharacters(input, top);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void mostFrequentCharactersWithNullStringTest() {
        String input = null;
        int top = 5;
        Map<Character, Integer> actual = StringTaskSolver.mostFrequentCharacters(input, top);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void mostFrequentCharactersWithValidStringTest() {
        String input = "This is a valid string with some characters.";
        int top = 5;
        Map<Character, Integer> actual = StringTaskSolver.mostFrequentCharacters(input, top);
        Map<Character, Integer> expected = new HashMap<>();
        expected.put(' ', 7);
        expected.put('i', 5);
        expected.put('s', 5);
        expected.put('a', 4);
        expected.put('t', 4);
        assertEquals(actual, expected);
    }

    @Test
    public void mostFrequentCharactersWithTopGreaterThanSizeTest() {
        String input = "abcde";
        int top = 10;
        Map<Character, Integer> actual = StringTaskSolver.mostFrequentCharacters(input, top);
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 1);
        expected.put('c', 1);
        expected.put('d', 1);
        expected.put('e', 1);
        assertEquals(actual, expected);
    }

    @Test
    public void mostFrequentCharactersWithSpecialCharactersTest() {
        String originString = "%&#_#$%*##$**@%^_#%%@**_=";
        int top = 7;
        Map<Character, Integer> actual = StringTaskSolver.mostFrequentCharacters(originString, top);
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('#', 5);
        expected.put('%', 5);
        expected.put('*', 5);
        expected.put('_', 3);
        expected.put('@', 2);
        expected.put('$', 2);
        expected.put('&', 1);
        assertEquals(actual, expected);

    }

    @Test
    public void mostFrequentCharactersWithTopLessThanSizeTest() {
        String originString = "aabbbbccc";
        int top = 15;
        Map<Character, Integer> actual = StringTaskSolver.mostFrequentCharacters(originString, top);
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 4);
        expected.put('c', 3);
        assertEquals(actual, expected);
    }

    @ParameterizedTest(name = "Tested {index} tasks 'compareSentenceVowelConsonantFrequencyTest'")
    @CsvFileSource(
            resources = "/compareSentenceVowelConsonantFrequencyTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void compareSentenceVowelConsonantFrequencyTest(
            @ConvertWith(StringArrayConverter.class) String[] input,
            @ConvertWith(StringArrayConverter.class) String[] expected) {
        assertArrayEquals(expected, StringTaskSolver.compareSentenceVowelConsonantFrequency(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks 'countWordsStartEndWithVowelTest'")
    @CsvFileSource(
            resources = "/countWordsStartEndWithVowelTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void countWordsStartEndWithVowelTest(
            @ConvertWith(StringArrayConverter.class) String[] input,
            int expected) {
        assertEquals(expected, StringTaskSolver.countWordsStartEndWithVowel(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks 'countWordsStartEndWithVowelTest'")
    @CsvFileSource(
            resources = "/wordsWithSameFirstAndLastCharacterTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void wordsWithSameFirstAndLastCharacterTest(
            String input,
            @ConvertWith(StringArrayConverter.class) String[] expected) {
        assertArrayEquals(expected, StringTaskSolver.wordsWithSameFirstAndLastCharacter(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks 'countWordsStartEndWithVowelTest'")
    @CsvFileSource(
            resources = "/findMinMaxWordsTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void findMinMaxWordsTest(
            String input,
            @ConvertWith(StringArrayConverter.class) String[] expected) {
        assertArrayEquals(expected, StringTaskSolver.findMinMaxWords(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks 'countWordsStartEndWithVowelTest'")
    @CsvFileSource(
            resources = "/telegramPaymentReceiptTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void telegramPaymentReceiptTest(String input, double price, double expected) {
        if (price < 0.0) {
            assertThrows(IllegalArgumentException.class, () -> StringTaskSolver.telegramPaymentReceipt(input, price));
        } else {
            assertEquals(expected, StringTaskSolver.telegramPaymentReceipt(input, price));
        }
    }

    @ParameterizedTest(name = "Tested {index} tasks 'countWordsStartEndWithVowelTest'")
    @CsvFileSource(
            resources = "/findCommonLettersTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void findCommonLettersTest(
            String input,
            String expected) {
        char[] exp = expected.toCharArray();
        assertArrayEquals(exp, StringTaskSolver.findCommonLetters(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks 'findLongestNonLetterSubstringTest'")
    @CsvFileSource(
            resources = "/findLongestNonLetterSubstringTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void findLongestNonLetterSubstringTest(String input, String expected) {
        assertEquals(expected, StringTaskSolver.findLongestNonLetterSubstring(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks 'findConsonantsTest'")
    @CsvFileSource(
            resources = "/findConsonantsTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void findConsonantsTest(String input, String expected) {
        Set<Character> expectedSet = new HashSet<>();
        for (char c : expected.toCharArray()) {
            expectedSet.add(c);
        }

        Set<Character> actualConsonants = StringTaskSolver.findConsonants(input);
        assertEquals(expectedSet, actualConsonants);
    }

    @ParameterizedTest(name = "Tested {index} tasks 'findOddWordTest'")
    @CsvFileSource(
            resources = "/findOddWordTest.csv",
            delimiter = ';',
            nullValues = {"NULL" },
            numLinesToSkip = 1
    )
    void findOddWordTest(String input, String expected) {
        assertEquals(expected, StringTaskSolver.findOddWord(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks 'getSubstringTest'")
    @CsvFileSource(
            resources = "/getSubstringTest.csv",
            delimiter = ';',
            nullValues = {"NULL" },
            numLinesToSkip = 1
    )
    void getSubstringTest(String input, int n, int m, String expected) {
        assertEquals(expected, StringTaskSolver.getSubstring(input, n, m));
    }
}
