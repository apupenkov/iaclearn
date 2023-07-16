package chapter10.ArgumentsProviders;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class WriteRandomNumberArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("data", "temp1.txt", 5),
                Arguments.of("data", "temp2.txt", 10),
                Arguments.of("data", "temp3.txt", 300)
        );
    }
}
