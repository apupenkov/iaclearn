package chapter9;

        import book.chapter9.ExceptionUtil;
        import org.junit.jupiter.params.ParameterizedTest;
        import org.junit.jupiter.params.provider.CsvFileSource;

        import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTests {
    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/sumNumbersTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    void sumNumbersTest(String file, String sum, String average) {
        assertEquals(Double.parseDouble(sum),
                (double)Math.round(ExceptionUtil.sumNumbers(ExceptionUtil.readNumbersFromFile(file, ":")) * 100d) / 100d);
        assertEquals(Double.parseDouble(average),
                (double)Math.round(ExceptionUtil.averageNumbers(ExceptionUtil.readNumbersFromFile(file, ":")) * 100d) / 100d);
    }
}
