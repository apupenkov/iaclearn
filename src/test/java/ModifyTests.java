import book.chapter7.tasks.FunctionSolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import strings.StringTaskSolver;

import java.util.Arrays;
import java.util.List;

import static book.chapter7.tasks.FunctionSolver.transformPrices;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifyTests {

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/modifyStringArrayTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void modifyStringArrayTest(
            @ConvertWith(StringArrayConverter.class) String[] input,
            @ConvertWith(StringArrayConverter.class) String[] expected,
            boolean type, String character, int index) {
        assertArrayEquals(expected, StringTaskSolver.modifyStringArray(input, type, character, index));
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/capitalizeWordsTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void capitalizeWordsTest(String input, String expected) {
        assertEquals(expected, StringTaskSolver.capitalizeWords(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/capitalizeSentencesTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void capitalizeSentencesTest(String input, String expected) {
        assertEquals(expected, StringTaskSolver.capitalizeSentences(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/replaceDuplicateCharactersTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void replaceDuplicateCharactersTest(String input, String expected) {
        assertEquals(expected, StringTaskSolver.replaceDuplicateCharacters(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/getWordsInAlphabeticalOrderTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void getWordsInAlphabeticalOrderTest(String input, String expected) {
        assertEquals(expected, StringTaskSolver.getWordsInAlphabeticalOrder(input));
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/transformPricesTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void transformPricesTest(
            @ConvertWith(StringArrayConverter.class) String[] inputPrices,
            double cost,
            @ConvertWith(StringArrayConverter.class) String[] expectedOutputPrices
    ) {
        List<Double> input = Arrays.stream(inputPrices).mapToDouble(Double::parseDouble).boxed().toList();
        List<Double> transformedPrices = transformPrices(input, cost);
        Assertions.assertEquals(Arrays.stream(expectedOutputPrices).mapToDouble(Double::parseDouble).boxed().toList(), transformedPrices);
    }

    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/reverseStringTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    public void reverseStringTest(
            String input,
            String expected
    ) {
        assertEquals(expected, FunctionSolver.reverseString(input));
    }
}
