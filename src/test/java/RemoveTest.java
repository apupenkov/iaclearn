import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveTest {

    @ParameterizedTest(name = "Tested {index} tasks 'modifyStringArray'")
    @CsvFileSource(
            resources = "/sanitizeTextTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void sanitizeTextTest(String input, String expected) {
        assertEquals(expected, StringTaskSolver.sanitizeText(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks 'modifyStringArray'")
    @CsvFileSource(
            resources = "/removeTextBetween.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void removeTextBetweenTest(String input, String expected, Character startChar, Character endChar) {
        assertEquals(expected, StringTaskSolver.removeTextBetween(input, startChar, endChar));
    }

    @Test
    public void removeCommentsTest() {
        String code = "public class Example {\n" +
                "    // This is a single-line comment\n" +
                "    /* This is a\n" +
                "       multi-line comment */\n" +
                "    /**\n" +
                "     * This is a Javadoc comment\n" +
                "     */\n" +
                "    public static void main(String[] args) {\n" +
                "        // Print 'Hello, World!'\n" +
                "        System.out.println(\"Hello, World!\");\n" +
                "    }\n" +
                "}";
        String expected = "public class Example {\n" +
                "    \n" +
                "    \n" +
                "    \n" +
                "    public static void main(String[] args) {\n" +
                "        \n" +
                "        System.out.println(\"Hello, World!\");\n" +
                "    }\n" +
                "}";
        String codeWithoutComments = StringTaskSolver.removeComments(code);
        assertEquals(expected, codeWithoutComments);
//        System.out.println(code);
//        System.out.println(codeWithoutComments);
    }
}
