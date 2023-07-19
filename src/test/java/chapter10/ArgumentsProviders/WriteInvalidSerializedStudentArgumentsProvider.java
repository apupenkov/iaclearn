package chapter10.ArgumentsProviders;

import book.chapter10.model.Student;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.stream.Stream;

public class WriteInvalidSerializedStudentArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("data/invalid_students.dat", List.of(
                        new Student(null, List.of()),
                        new Student(null, List.of()),
                        new Student(null, List.of())
                )),
                Arguments.of("data/invalid_students.dat", List.of(
                        new Student("", List.of()),
                        new Student("", List.of()),
                        new Student("", List.of())
                ))
        );
    }
}
