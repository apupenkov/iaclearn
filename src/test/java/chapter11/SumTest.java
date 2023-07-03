package chapter11;

import book.chapter11.CollectionSolver;
import help_modules.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {
    @ParameterizedTest(name = "Tested {index} tasks {displayName}")
    @CsvFileSource(
            resources = "/pairwiseSumTest.csv",
            delimiter = ';',
            nullValues = {"NULL"},
            numLinesToSkip = 1
    )
    void pairwiseSumTest(
            @ConvertWith(IntArrayConverter.class) int[] input,
            int expected
    ) {
        assertEquals(new HashSet<>(List.of(expected)),
                CollectionSolver.pairwiseSum(Arrays.stream(input).boxed().collect(Collectors.toSet())));
    }
}
