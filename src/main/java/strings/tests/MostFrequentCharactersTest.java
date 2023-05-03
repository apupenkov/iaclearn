package strings.tests;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MostFrequentCharactersTest {
//    @Test
//    void testMostFrequentCharacterPrint() {
//        String input = "%&#_#$%*##$**@%^_#%%@**_=";
//        int top = 7;
//        Map<Character, Integer> actual = StringTaskSolver.mostFrequentCharacters(input, top);
//        for (Map.Entry<Character, Integer> entry : actual.entrySet()) {
//            System.out.println("'" + entry.getKey() + ":" + entry.getValue().toString());
//        }
//        Map<Character, Integer> expected = new HashMap<>();
//        expected.put(' ', 7);
//        expected.put('i', 5);
//        expected.put('s', 5);
//        expected.put('a', 4);
//        expected.put('t', 4);
//    }

    @Test
    void testMostFrequentCharactersWithEmptyString() {
        String input = "";
        int top = 5;
        Map<Character, Integer> actual = StringTaskSolver.mostFrequentCharacters(input, top);
        assertTrue(actual.isEmpty());
    }

    @Test
    void testMostFrequentCharactersWithNullString() {
        String input = null;
        int top = 5;
        Map<Character, Integer> actual = StringTaskSolver.mostFrequentCharacters(input, top);
        assertTrue(actual.isEmpty());
    }

    @Test
    void testMostFrequentCharactersWithValidString() {
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
    void testMostFrequentCharactersWithTopGreaterThanSize() {
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
    void testMostFrequentCharactersWithSpecialCharacters() {
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
    void testMostFrequentCharactersWithTopLessThanSize() {
        String originString = "aabbbbccc";
        int top = 15;
        Map<Character, Integer> actual = StringTaskSolver.mostFrequentCharacters(originString, top);
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 4);
        expected.put('c', 3);
        assertEquals(actual, expected);
    }
}
