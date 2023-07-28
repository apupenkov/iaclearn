package projects.colledge.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import projects.colledge.entities.date.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ModelExceptionTests {
    @Nested
    class DateTest {
        @ParameterizedTest(name = "{index} - {displayName}")
        @CsvSource(value = {
                "32,12,2022",
                "15,8,2024",
                "29,2,2023",
                "1,1,1899",
                "1,1,1922",
                "31,2,2000"
        })
        public void dateConstructorIllegalExceptionTest(int day, int month, int year) {
            assertThrows(IllegalArgumentException.class, () -> new Date(day, month, year));
        }
    }
}
