package strings.tests;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplaceCharacterInWordsByIndexTest {
    @Test
    public void testReplaceCharInWordsByPositiveIndex() {
        String original = "Much did had call new drew that kept.";
        String output = "MucX did had calX new dreX thaX kepX.";
        String result = StringTaskSolver.replaceCharacterInWordsByIndex(original, 'X', 3);
        assertEquals(output, result);
    }

    @Test
    public void testReplaceCharInWordsByNegativeIndex() {
        String original = "Much did had call new drew that kept.";
        String output = "";
        String result = StringTaskSolver.replaceCharacterInWordsByIndex(original, 'X', -3);
        assertEquals(output, result);
    }

    @Test
    public void testReplaceCharInWordsByIndexWithNullChar() {
        String original = "Much did had call new drew that kept.";
        String output = "";
        String result = StringTaskSolver.replaceCharacterInWordsByIndex(original, '\0', 5);
        assertEquals(output, result);
    }

    @Test
    public void testReplaceCharInWordsByBigIndex() {
        String original = "Much did had call new drew that kept.";
        String output = "Much did had call new drew that kept.";
        String result = StringTaskSolver.replaceCharacterInWordsByIndex(original, 'X', 100);
        assertEquals(output, result);
    }
}
