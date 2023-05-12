import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplaceTest {

    @Test
    public void isSpaceTest() {
        assertEquals(true, StringTaskSolver.isSpaces("    "));
    }

    @ParameterizedTest(name = "Test getLengthWords")
    @CsvSource( value = {
            "asdf:4",
            "Hello, world:5 5",
//            ",.,., hi:2"
    }, delimiter = ':', nullValues = {"NULL"})
    public void getLengthWordsTest(String input, String output) {
        assertEquals(output, StringTaskSolver.getLengthWords(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks 'replaceCharacterInWordsByIndex'")
    @CsvSource( value = {
            "      :'':3:X",
            "'':'':5:x",
            "NULL:'':1:a",
            "a:a:1:a",
            "Much did had call new drew that kept.:MucX did had calX new dreX thaX kepX.:3:X",
            "Much did had call new drew that kept.:MXch dXd hXd cXll nXw dXew tXat kXpt.:1:X",
            "Much did had call new drew that kept.:Much did had call new drew that kept.:-3:X",
            "Much did had call new drew that kept.:Much did had call new drew that kept.:100:X",
    }, delimiter = ':', nullValues = {"NULL"})
    public void replaceCharInWordsByIndexTest(String input, String output, int index, char replaceChar) {
        assertEquals(output, StringTaskSolver.replaceCharacterInWordsByIndex(input, replaceChar, index));
    }

    @ParameterizedTest(name = "Tested {index} tasks 'getAlphabetOrdinalNumbers'")
    @CsvSource( value = {
            "      :''",
            "'':''",
            "NULL:''",
            "a:1",
            "Hello World:8 5 12 12 15 23 15 18 12 4",
            "Testing Function with UPPERCASE Letters:20 5 19 20 9 14 7 6 21 14 3 20 9 15 14 23 9 20 8 21 16 16 5 18 3 1 19 5 12 5 20 20 5 18 19",
            "Testing Function with Numbers 123 and Special Ch@racters:20 5 19 20 9 14 7 6 21 14 3 20 9 15 14 23 9 20 8 14 21 13 2 5 18 19 1 14 4 19 16 5 3 9 1 12 3 8 18 1 3 20 5 18 19"
    }, delimiter = ':', nullValues = {"NULL"})
    public void getAlphabetOrdinalNumbersTest(String input, String output) {
        assertEquals(output, StringTaskSolver.getAlphabetOrdinalNumbers(input));
    }

    @Test
    public void getAlphabetOrdinalNumbersEmptyInputTest() {
        String input = "";
        String expected = "";
        String actual = StringTaskSolver.getAlphabetOrdinalNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void getAlphabetOrdinalNumbersWithWhitespaceOnlyTest() {
        String input = "     ";
        String expected = "";
        String actual = StringTaskSolver.getAlphabetOrdinalNumbers(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "Tested {index} tasks 'replaceCharacterAfterLetterP'")
    @CsvSource( value = {
            "hello world:hello world",
            "apple paar peach:apple poar peach",
            "PAPA popo PIPI pAPa:POPO popo PIPI pOPo",
            "P@A2PO,Pa3,poP4APA2PO5POpapa/pepapo:P@A2PO,Po3,poP4APO2PO5POpopo/pepopo"
    }, delimiter = ':')
    public void replaceCharacterAfterLetterPTest(String input, String expected) {
        assertEquals(expected, StringTaskSolver.replaceCharacterAfterLetterP(input));
    }

    @Test
    public void replaceCharacterAfterLetterPWithNullStringTest() {
        String input = null;
        String expected = "";
        String actual = StringTaskSolver.replaceCharacterAfterLetterP(input);
        assertEquals(expected, actual);
    }

    @Test
    public void replaceCharacterAfterLetterPWithEmptyStringTest() {
        String input = "";
        String expected = "";
        String actual = StringTaskSolver.replaceCharacterAfterLetterP(input);
        assertEquals(expected, actual);
    }


}
