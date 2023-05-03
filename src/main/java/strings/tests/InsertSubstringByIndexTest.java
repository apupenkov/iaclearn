package strings.tests;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertSubstringByIndexTest {
    @Test
    public void testInsertSubstringByIndex() {
        String originString = "Hello, World!";
        int index = 7;
        String substring = "Java ";
        String expectedString = "Hello, Java World!";
        String actualString = StringTaskSolver.insertSubstringByIndex(originString, index, substring);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testInsertSubstringByIndexNegativeIndex() {
        String originString = "Hello, World!";
        int index = -1;
        String substring = "Java ";
        String expectedString = "Hello, World!";
        String actualString = StringTaskSolver.insertSubstringByIndex(originString, index, substring);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testInsertSubstringByIndexIndexEqualLength() {
        String originString = "Hello, World!";
        int index = originString.length();
        String substring = "Java ";
        String expectedString = "Hello, World!Java ";
        String actualString = StringTaskSolver.insertSubstringByIndex(originString, index, substring);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testInsertSubstringByIndexNullString() {
        String originString = null;
        int index = 7;
        String substring = "Java ";
        String expectedString = "";
        String actualString = StringTaskSolver.insertSubstringByIndex(originString, index, substring);
        assertEquals(expectedString, actualString);
    }
}
