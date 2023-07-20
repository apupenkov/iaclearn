package chapter10.ArgumentsProviders;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CalculateCountWordsInFileArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of("src/test/resources/chapter10/file1.txt", 50),
                Arguments.of("src/test/resources/chapter10/file2.txt", 101),
                Arguments.of("src/test/resources/chapter10/file3.txt", 416)
        );
    }
}
