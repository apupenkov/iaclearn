package chapter10.ArgumentsProviders;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.stream.Stream;

public class StudentsByGradeArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("data/students.dat", 7, List.of("baiden")),
                Arguments.of("data/students1.dat", 7, List.of("richardson", "jordan", "howard"))
        );
    }
}
